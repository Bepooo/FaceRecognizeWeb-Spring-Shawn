package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Clothes;
import au.edu.sydney.domain.JobPost;

@Repository(value = "jobPostDao")
public class JobPostDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public int saveJobPost(JobPost jobpost) {
        sessionFactory.getCurrentSession().save(jobpost);
        int cid=jobpost.getId();
        return cid;
    }

	public void deleteJobPostById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete JobPost where id=?").setParameter(0, i).executeUpdate();
	}
	
    public List getJobPosts() {
        return sessionFactory.getCurrentSession().createCriteria(JobPost.class).list();
    }
//.uniqueResult()
	/*public JobPost getJobPostByCompany(String co) {
		return (JobPost) this.sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co);
	}*/
    
    public List getJobPostByCompany(String co) {
		return sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co).list();
	}

	public List getJobpostsByQuery(String[] limits) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createCriteria(JobPost.class)
				.add(Restrictions.like("employmenttype", limits[0]))
				.add(Restrictions.like("location", limits[1]))
				.list();
	}

}