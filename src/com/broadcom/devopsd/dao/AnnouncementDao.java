package com.broadcom.devopsd.dao;

import java.util.List;

import com.broadcom.devopsd.entity.Announcement;

public interface AnnouncementDao {

	void saveAnnouncement(Announcement announcement);

	List<Announcement> listActiveAnnouncements();

	Announcement getAnnouncement(int announcementId);

	void deleteAnnouncement(int announcementId);

	List<Announcement> listAllAnnouncements();

}
