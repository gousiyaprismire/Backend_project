package com.university.controller;

import java.util.UUID;
import com.university.model.Student;
import com.university.repository.StudentRepository;
import com.university.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/api/students"})
public class UploadController {
    @Autowired
    private UploadService UploadService;
    @Autowired
    private StudentRepository studentRepository;

    public UploadController() {
    }

    @PostMapping({"/upload-id"})
    public ResponseEntity<String> uploadCollegeId(@RequestParam("file") MultipartFile file, @RequestParam("studentId") UUID studentId) {
        Student existingStudent = (Student)this.studentRepository.findById(studentId.toString()).orElse((Student) null);
        if (existingStudent == null) {
            return new ResponseEntity("Error: Student not found.", HttpStatus.BAD_REQUEST);
        } else {
            boolean isUploaded = this.UploadService.uploadCollegeId(file, studentId);
            return isUploaded ? new ResponseEntity("Success: College ID uploaded.", HttpStatus.OK) : new ResponseEntity("Error: Failed to upload College ID.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/upload-id"})
    public ResponseEntity<String> getCollegeId(@RequestParam("studentId") UUID studentId) {
        boolean exists = this.UploadService.isCollegeIdExists(studentId);
        return exists ? new ResponseEntity("Success: College ID exists.", HttpStatus.OK) : new ResponseEntity("Error: College ID not found.", HttpStatus.NOT_FOUND);
    }
}






















































//package com.university.controller;
//import com.university.model.UploadRequest;
//import com.university.service.UploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/students")
//public class UploadController {
//
//    @Autowired
//    private UploadService uploadService;
//
//    @PostMapping("/upload-id")
//    public ResponseEntity<String> uploadCollegeId(@RequestBody UploadRequest uploadRequest) {
//        boolean success = uploadService.uploadCollegeId(uploadRequest.getStudentId(), uploadRequest.getCollegeIdBase64());
//        if (success) {
//            return ResponseEntity.ok("Success");
//        } else {
//            return ResponseEntity.status(500).body("Error occurred while uploading ID");
//        }
//    }
//}
//
