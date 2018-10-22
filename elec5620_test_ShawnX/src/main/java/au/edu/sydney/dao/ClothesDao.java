package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import au.edu.sydney.domain.Clothes;

@Repository(value = "clothesDao")
public class ClothesDao {

    @Resource
    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public int saveClothes(Clothes clothes) {
        sessionFactory.getCurrentSession().save(clothes);
        int cid=clothes.getId();
        return cid;
    }

	public void deleteClothesById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete Clothes where id=?").setParameter(0, i).executeUpdate();
	}
	
    public List getClothes() {
        return sessionFactory.getCurrentSession().createCriteria(Clothes.class).list();
    }
    
    public List getClothesByQuery(String[] limits) {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().createQuery("from Product where color=?and type=?").setParameter(0, query).setParameter(1, query).list();
		//return null;
		
		return sessionFactory.getCurrentSession().createCriteria(Clothes.class)
				.add(Restrictions.like("color", limits[0]))
				.add(Restrictions.like("type", limits[1]))
				.list();

	}
    
//.uniqueResult()
	/*public JobPost getJobPostByCompany(String co) {
		return (JobPost) this.sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co);
	}*/
    
    
   /* public List getProductByCompany(String co) {
		return sessionFactory.getCurrentSession().createQuery("from JobPost where Company=?").setParameter(0, co).list();
	}*/

}