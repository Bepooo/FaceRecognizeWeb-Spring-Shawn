package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import au.edu.sydney.domain.Donation;
import au.edu.sydney.domain.QA;

@Repository(value = "qaDao")
public class QADao {

    @Resource
    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public int saveQA(QA qa) {
        sessionFactory.getCurrentSession().save(qa);
        int cid=qa.getId();
        return cid;
    }

	public void deleteQAById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete QA where id=?").setParameter(0, i).executeUpdate();
	}
	
    public List getQAs() {
        return sessionFactory.getCurrentSession().createCriteria(QA.class).list();
    }
    
    public QA findQAById(int id) {

        /*    Criteria criteria = createEntityCriteria();

            criteria.add(Restrictions.eq("answer", answer));

            return (QA) criteria.uniqueResult();*/
        	return (QA) sessionFactory.getCurrentSession().createCriteria(QA.class).add(Restrictions.like("id", id)).uniqueResult();

        }
    
    
    public QA findQAByQuestion(String question) {

    /*    Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("answer", answer));

        return (QA) criteria.uniqueResult();*/
    	return (QA) sessionFactory.getCurrentSession().createCriteria(QA.class).add(Restrictions.like("question", question)).uniqueResult();

    }

    
   /* public List getDonationByQuery(String[] limits) {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().createQuery("from Product where color=?and type=?").setParameter(0, query).setParameter(1, query).list();
		//return null;
		
		return sessionFactory.getCurrentSession().createCriteria(Donation.class)
				.add(Restrictions.like("color", limits[0]))
				.add(Restrictions.like("type", limits[1]))
				.list();

	}*/
    
//.uniqueResult()
	/*public JobPost getJobPostByCompany(String co) {
		return (JobPost) this.sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co);
	}*/
    
    
   /* public List getProductByCompany(String co) {
		return sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co).list();
	}*/

}