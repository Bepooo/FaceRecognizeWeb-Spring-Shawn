package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.Resume;

@Repository(value = "feedbackDao")
public class FeedbackDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().save(feedback);

	}
	public List getFeedbacks() {
        return sessionFactory.getCurrentSession().createCriteria(Feedback.class).list();
    }

	public void deleteFeedbackById(int id) {
		 sessionFactory.getCurrentSession().createQuery("delete Feedback where id=?").setParameter(0, id).executeUpdate();
		
	}

}
