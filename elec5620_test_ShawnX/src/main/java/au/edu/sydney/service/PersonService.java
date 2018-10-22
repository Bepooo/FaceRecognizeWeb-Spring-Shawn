package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.Person;
 
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
}
