package com.university.controller;

import com.university.model.Announcement;
import com.university.serviceImpl.AnnouncementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementServiceImpl announcementService;
    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement annoucement){
        Announcement annoucement1 = announcementService.addannoucement(annoucement);
        System.out.println("Received  :" + annoucement1);
        return  new ResponseEntity<>(annoucement1, HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Announcement>> getall(){
        List<Announcement> annoucement = announcementService.getall();
        return new ResponseEntity<>(annoucement, HttpStatus.OK);
    }
}
