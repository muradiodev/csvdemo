package com.csvtask.demo.controller;

import com.csvtask.demo.entities.Product;
import com.csvtask.demo.service.FileUploadingService;
import com.csvtask.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/")
public class FileUploadingController {

    private final FileUploadingService fileUploadingService;

    private final ProductService productService;


    @PostMapping("upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {

        try {
            log.info("fileUpload is running");
            return fileUploadingService.fileUploading(file);
        } catch (Exception e) {
            log.info("fileUpload error" + e);
            return "Error in Uploading";
        }
    }

    @GetMapping("products")
    public List<Product> getProductList(@RequestParam Map<String, Object> map) {
        try {
            log.info("getProductList is running");
            return productService.getProductList(map);
        } catch (Exception e) {
            log.info("getProductList error" + e);
            return null;
        }
    }

    @GetMapping("product/{code}")
    public Product getByCode(@PathVariable String code) {
        try {
            log.info("getByCode is running ");
            return productService.getProductByCode(code);
        } catch (Exception e) {
            log.info("getByCode error" + e);
            return null;
        }
    }

    @DeleteMapping("all")
    public String deleteAll() {
        try {
            log.info("Delete All is running");
            productService.deleteAllBy();
            return "Deleted";
        } catch (Exception e) {
            log.info("Delete All error" + e);
            return null;
        }
    }
}
