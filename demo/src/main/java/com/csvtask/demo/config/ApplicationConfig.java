package com.csvtask.demo.config;

import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ApplicationConfig {


    @Value("${upload-dir}")
    private String uploadDir;
}
