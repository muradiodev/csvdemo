package com.csvtask.demo.service.impl;

import com.csvtask.demo.entities.Product;
import com.csvtask.demo.repository.FileUploadRepository;
import com.csvtask.demo.service.ProductService;
import com.csvtask.demo.utils.GenericSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final FileUploadRepository fileUploadRepository;

    @Override
    public List<Product> getProductList(Map<String, Object> map) {
        Specification<Product> specification = GenericSpecification.getSpecs(map, "LIKE");
        Pageable pageable = PageRequest.of(0, 200);
        List<Product> productList = fileUploadRepository.findAll(specification, pageable);
        return productList;
    }

    @Override
    public Product getProductByCode(String code) {
        return fileUploadRepository.getProductByCode(code);
    }

    @Transactional
    @Override
    public void deleteAllBy() {
        fileUploadRepository.deleteAllBy();
    }
}
