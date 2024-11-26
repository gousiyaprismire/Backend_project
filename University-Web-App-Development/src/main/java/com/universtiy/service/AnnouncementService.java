package com.universtiy.service;

import com.university.model.Announcement;

import java.util.List;

public interface AnnouncementService {
    public Announcement addannoucement(Announcement annoucement);
    public List<Announcement> getall();
}
