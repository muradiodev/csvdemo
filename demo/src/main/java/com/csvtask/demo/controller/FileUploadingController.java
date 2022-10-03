package com.csvtask.demo.controller;

import com.csvtask.demo.entities.Product;
import com.csvtask.demo.service.FileUploadingService;
import com.csvtask.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/")
public class FileUploadingController {

    private final FileUploadingService fileUploadingService;

    private final ProductService productService;


    @PostMapping("uploadFile")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        log.info("uploadFile");
        return fileUploadingService.fileUploading(file);
    }
}
