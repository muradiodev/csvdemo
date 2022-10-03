package com.csvtask.demo.service.impl;

import com.csvtask.demo.config.ApplicationConfig;
import com.csvtask.demo.entities.Product;
import com.csvtask.demo.repository.FileUploadRepository;
import com.csvtask.demo.service.FileUploadingService;
import com.csvtask.demo.utils.FileStorageUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUploadingServiceImpl implements FileUploadingService {

    private final FileStorageUtils fileStorageUtils;

    private final ApplicationConfig config;

    private final FileUploadRepository fileUploadRepository;


    @Override
    public String fileUploading(MultipartFile file) {

        Pair<Boolean, String> storedPair = fileStorageUtils.storeFile(file);

        if (storedPair.getFirst()) {
            try (Reader reader = new FileReader(config.getUploadDir() + File.separator + storedPair.getSecond())) {
                CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
                        .withType(Product.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                        .build();

                List<Product> prod_csv = csvToBean.parse();

                for (Product prod : prod_csv) {
                    this.fileUploadRepository.save(prod);

                }
            } catch (Exception e) {
                return "error occured while reading and writing the file";
            }
        }
        return null;
    }
}
