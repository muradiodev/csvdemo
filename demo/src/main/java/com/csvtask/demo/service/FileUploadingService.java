package com.csvtask.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadingService {
    String fileUploading(MultipartFile file);
}
