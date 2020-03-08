package com.example.Liyakhat_Poc.controller;

import com.example.Liyakhat_Poc.service.IFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Value("${fileStorageLocation}")
    private String fileStorageLocation;

    @Autowired
    private IFileUploadService fileUploadService;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, @RequestParam("filetype") String fileType) throws IOException {

        if(file.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        byte[] bytes = file.getBytes();
        System.out.println(bytes);
        String dir = fileStorageLocation+"//files";
        Path path = Paths.get(dir+"//"+file.getOriginalFilename());
        Files.write(path, bytes);
        String input = new String(Files.readAllBytes(path));

        fileUploadService.process(input,fileType);
        return ResponseEntity.ok(fileType+" saved successfully");

    }
}