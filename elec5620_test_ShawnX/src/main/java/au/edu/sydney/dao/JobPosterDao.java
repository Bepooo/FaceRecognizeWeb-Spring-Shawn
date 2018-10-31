package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.domain.JobPoster;

@Repository(value = "jobPosterDao")
@Transactional
public class JobPosterDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveJobPoster(JobPoster jobPoster) {
		sessionFactory.getCurrentSession().save(jobPoster);
	}

	
	public void deleteJobPosterById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete JobPoster where id=?").setParameter(0, i).executeUpdate();
	}
	

	public List getJobPosters() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(JobPoster.class).list();
	}
	
	 public JobPoster getJobPosterByQuery(String[] limits) {
			// TODO Auto-generated method stub
			//return sessionFactory.getCurrentSession().createQuery("from Product where color=?and type=?").setParameter(0, query).setParameter(1, query).list();
			//return null;
			
			return (JobPoster) sessionFactory.getCurrentSession().createCriteria(JobPoster.class)
					.add(Restrictions.like("email", limits[0]))
					.add(Restrictions.like("password", limits[1]))
					.uniqueResult();
		}

	public JobPoster getJobPosterByName(String username) {
		// TODO Auto-generated method stub
		return (JobPoster) sessionFactory.getCurrentSession().createCriteria(JobPoster.class)
				.add(Restrictions.like("name", username))
				.uniqueResult();
	}
}