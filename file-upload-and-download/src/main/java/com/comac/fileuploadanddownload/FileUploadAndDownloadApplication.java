package com.comac.fileuploadanddownload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.comac.fileuploadanddownload.dao")
public class FileUploadAndDownloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadAndDownloadApplication.class, args);
    }

}
