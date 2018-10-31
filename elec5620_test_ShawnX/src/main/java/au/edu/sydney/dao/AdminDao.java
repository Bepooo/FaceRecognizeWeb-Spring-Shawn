package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.domain.Admin;

@Repository(value = "adminDao")
@Transactional
public class AdminDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveAdmin(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
	}

	
	public void deleteAdminById(int i) {
		 sessionFactory.getCurrentSession().createQuery("delete Admin where id=?").setParameter(0, i).executeUpdate();
	}
	

	public List getAdmins() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Admin.class).list();
	}
	
	 public Admin getAdminByQuery(String[] limits) {
			// TODO Auto-generated method stub
			//return sessionFactory.getCurrentSession().createQuery("from Product where color=?and type=?").setParameter(0, query).setParameter(1, query).list();
			//return null;
			
			return (Admin) sessionFactory.getCurrentSession().createCriteria(Admin.class)
					.add(Restrictions.like("email", limits[0]))
					.add(Restrictions.like("password", limits[1]))
					.uniqueResult();
		}
}