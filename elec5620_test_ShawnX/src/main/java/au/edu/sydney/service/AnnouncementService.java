package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.AnnouncementDao;
import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.Announcement;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.Person;
 
@Transactional
@Service(value="announcementService")
public class AnnouncementService {
	
	@Autowired
	AnnouncementDao announcementDao;
	
	
	public void addAnnouncement(Announcement announcement) {
		announcementDao.saveAnnouncement(announcement);
    }
	
	public List getAnnouncements() {
		
        return announcementDao.getAnnouncements();

	}

	public void deleteAnnouncement() {
		announcementDao.deleteAnnouncement();
		
	}
    
}
