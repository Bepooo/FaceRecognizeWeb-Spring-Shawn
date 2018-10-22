package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.Person;
 
@Transactional
@Service(value="feedbackService")
public class FeedbackService {
	
	@Autowired
	FeedbackDao feedbackDao;
	
	
	public void addFeedback(Feedback feedback) {
		feedbackDao.saveFeedback(feedback);
    }
	
	public List getFeedbacks() {
		
        return feedbackDao.getFeedbacks();

	}

	public void deleteFeedbackById(int id) {
		feedbackDao.deleteFeedbackById(id);
		
	}
    
}
