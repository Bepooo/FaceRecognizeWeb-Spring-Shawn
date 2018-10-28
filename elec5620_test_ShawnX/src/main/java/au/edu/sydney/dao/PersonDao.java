package au.edu.sydney.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import au.edu.sydney.domain.Person;

@Repository(value = "personDao")
public class PersonDao {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savePerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	public List getPersonByFirst(String username) {
		// TODO Auto-generated method stub
		return (List) sessionFactory.getCurrentSession().createQuery("from Person where first=?").setParameter(0, username).list();
		//return null;
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return (Person) sessionFactory.getCurrentSession().createQuery("from Person where id=?").setParameter(0, id).uniqueResult();
	}
}