package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Announcement;


@Repository(value = "announcementDao")
public class AnnouncementDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveAnnouncement(Announcement announcement) {
		sessionFactory.getCurrentSession().save(announcement);

	}
	public List getAnnouncements() {
        return sessionFactory.getCurrentSession().createCriteria(Announcement.class).list();
    }


	public void deleteAnnouncement() {
		 sessionFactory.getCurrentSession().createQuery("delete from Announcement").executeUpdate();
		
	}

}
