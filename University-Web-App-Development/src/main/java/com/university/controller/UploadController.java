package com.university.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UploadController {

	 @Value("${uploaddir}")
	 private String uploadDir;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File uploadFolder = new File(uploadDir);
            System.out.println("uploadFolder.exists():"+uploadFolder.exists());
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs(); // Create the directory if it doesn't exist
            }

            String fileName = "Gousiya" + "_" + file.getOriginalFilename();
            File destinationFile = new File(uploadFolder, fileName);
            file.transferTo(destinationFile);

            return ResponseEntity.ok("/uploads/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }
}

