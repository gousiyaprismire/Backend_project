package com.university.controller;

import com.university.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/{studentId}/upload")
    public ResponseEntity<String> uploadCollegeId(
            @PathVariable UUID studentId,
            @RequestParam("file") MultipartFile file) {
        boolean success = uploadService.uploadCollegeId(file, studentId);
        if (success) {
            String filePath = "/uploads/" + studentId + "-" + file.getOriginalFilename();
            return ResponseEntity.ok(filePath);
        } else {
            return ResponseEntity.status(500).body("File upload failed");
        }
    }
}
