package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Resume;

@Repository(value = "resumeDao")
public class ResumeDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveResume(Resume resume) {
		sessionFactory.getCurrentSession().save(resume);

	}

	public List getResumeByRid(int rid) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Resume where Id=?").setParameter(0, rid).list();
		//return null;
	}
	public List getResumeByPoster(String u) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Resume where Postername=?").setParameter(0, u).list();
		//return null;
	}
}
