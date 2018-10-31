package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Clothes;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.QA;

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

    
    public String[] saveJobPost(JobPost jobpost) {
        sessionFactory.getCurrentSession().save(jobpost);
        int cid=jobpost.getId();
        String posterna=jobpost.getPostername();
        String[] result=new String[2];
        		result[0]=String.valueOf(cid);
        		result[1]=posterna;
        return result;
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
    
    public JobPost getJobPosterById(int i) {
		// TODO Auto-generated method stub
		return (JobPost) sessionFactory.getCurrentSession().createQuery("from JobPost where id=?").setParameter(0, i).uniqueResult();
	}

	public List getJobpostsByQuery(String[] limits) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createCriteria(JobPost.class)
				.add(Restrictions.like("employmenttype", limits[0]))
				.add(Restrictions.like("location", limits[1]))
				.list();
	}

	public List getJobPostsByPostername(String u) {
		// TODO Auto-generated method stub
		return (List) sessionFactory.getCurrentSession().createQuery("from JobPost where postername=?").setParameter(0, u).list();
	}

	public JobPost getJobpostById(int id) {
		// TODO Auto-generated method stub
		return (JobPost) sessionFactory.getCurrentSession().createCriteria(JobPost.class).add(Restrictions.like("jobPostid", id)).uniqueResult();

	}



}