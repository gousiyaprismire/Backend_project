package com.university.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
    private static final String UPLOAD_DIRECTORY = "uploads/";

    public UploadService() {
    }

    public boolean uploadCollegeId(MultipartFile file, UUID studentId) {
        try {
            String var10000 = studentId.toString();
            String fileName = var10000 + "-" + file.getOriginalFilename();
            Path filePath = Paths.get("uploads/" + fileName);
            File destinationFile = filePath.toFile();
            file.transferTo(destinationFile);
            return true;
        } catch (IOException var6) {
            IOException e = var6;
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCollegeIdExists(UUID studentId) {
        File file = new File("uploads/" + studentId.toString() + "-college-id.jpg");
        return file.exists();
    }
}