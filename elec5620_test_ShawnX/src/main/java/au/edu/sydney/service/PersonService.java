package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.Person;
import au.edu.sydney.domain.QA;
 
@Transactional
@Service(value="personService")
public class PersonService {
	
	@Autowired
	PersonDao PersonDao;
	
	
	public void addPerson(Person person) {
        PersonDao.savePerson(person);
    }
	/*public void deleteResumeById(int  id) {
		ResumeDao.deleteResumeById(id);
    }
	
	
	public List getResumeByCompany(String co){
       
    }

	
	public List getResumes() {
        return ResumeDao.getResumes();
    }*/


	public List getPersonByFirst(String username) {
		// TODO Auto-generated method stub
		 return PersonDao.getPersonByFirst(username);
	}
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		 return PersonDao.getPersonById(id);
	}
	
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		Person q = PersonDao.getPersonById(person.getId());
        if(q!=null){
            q.setFirst(person.getFirst());
            q.setLast(person.getLast());
            q.setAge(person.getAge());
            q.setPhonenumber(person.getPhonenumber());
            q.setEmail(person.getEmail());
		        }
	}
}
