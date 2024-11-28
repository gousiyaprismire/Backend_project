package com.university.serviceImpl;

import com.university.model.Announcement;
import com.university.repository.AnnouncementRepository;
import com.universtiy.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Override
    public Announcement addannoucement(Announcement annoucement) {
        return announcementRepository.save(annoucement);
    }
    @Override
    public List<Announcement> getall(){
        return announcementRepository.findAll();
    }
}
