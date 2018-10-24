package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.DonationDao;
import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.dao.QADao;
import au.edu.sydney.domain.Donation;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.Person;
import au.edu.sydney.domain.QA;
 
@Transactional
@Service(value="qaService")
public class QAService {
	
	@Autowired
	 QADao  qaDao;
	
	
	public void addQA(QA qa) {
		qaDao.saveQA(qa);
    }
	
	public List getQAs() {
		
        return qaDao.getQAs();

	}

	public void deleteQAById(int id) {
		qaDao.deleteQAById(id);
		
	}
	public boolean isQAUnique(String question, String answer) {

		        QA qa = findQAByQuestion(question);

		        return ( qa == null || ((answer != null) && (qa.getQuestion() == answer)));
		    }

	public QA findQAByQuestion(String question) {
		// TODO Auto-generated method stub
		return qaDao.findQAByQuestion(question);

	}
	
	public QA findQAById(int id) {
		// TODO Auto-generated method stub
		return qaDao.findQAById(id);

	}

	public void updateQA(QA qa) {
		// TODO Auto-generated method stub
		QA q = qaDao.findQAById(qa.getId());
        if(q!=null){
            q.setQuestion(qa.getQuestion());
            q.setAnswer(qa.getAnswer());
		        }
	}


    
}
