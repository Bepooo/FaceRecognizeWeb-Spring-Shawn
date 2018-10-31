package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.domain.JobSeeker;

@Repository(value = "jobSeekerDao")
@Transactional
public class JobSeekerDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveJobSeeker(JobSeeker jobSeeker) {
		sessionFactory.getCurrentSession().save(jobSeeker);
	}

	
	public void deleteJobSeekerById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete JobSeeker where id=?").setParameter(0, i).executeUpdate();
	}
	

	public List getJobSeekers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(JobSeeker.class).list();
	}
	
	 public JobSeeker getJobSeekerByQuery(String[] limits) {
			// TODO Auto-generated method stub
			//return sessionFactory.getCurrentSession().createQuery("from Product where color=?and type=?").setParameter(0, query).setParameter(1, query).list();
			//return null;
			
			return (JobSeeker) sessionFactory.getCurrentSession().createCriteria(JobSeeker.class)
					.add(Restrictions.like("email", limits[0]))
					.add(Restrictions.like("password", limits[1]))
					.uniqueResult();
		}

	public JobSeeker getJobSeekerByQueryAnswer(String[] limits) {
		// TODO Auto-generated method stub
		return (JobSeeker) sessionFactory.getCurrentSession().createCriteria(JobSeeker.class)
				.add(Restrictions.like("email", limits[0]))
				.add(Restrictions.like("qanswer", limits[1]))
				.uniqueResult();
	}

	public JobSeeker findJobSeekerByName(String uname) {
		return (JobSeeker) sessionFactory.getCurrentSession().createCriteria(JobSeeker.class)
				.add(Restrictions.like("name", uname))
				.uniqueResult();
	}
}