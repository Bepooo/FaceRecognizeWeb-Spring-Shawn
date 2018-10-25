package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



import au.edu.sydney.domain.Shoppingassist;

@Repository(value = "shoppingassistDao")
public class ShoppingassistDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveShoppingassist(Shoppingassist shoppingassist) {
		sessionFactory.getCurrentSession().save(shoppingassist);
	}

	
	public void deleteShoppingassistById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete Shoppingassist where id=?").setParameter(0, i).executeUpdate();
	}
	
	public List getShoppingassist() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Shoppingassist.class).list();
		//return null;
	}

	public List getShoppingassists() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Shoppingassist.class).list();
	}

	public Shoppingassist getShoppingassistByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return (Shoppingassist) sessionFactory.getCurrentSession().createCriteria(Shoppingassist.class)
				.add(Restrictions.like("name", limits[0]))
				.add(Restrictions.like("password", limits[1]))
				.uniqueResult();
	}
}