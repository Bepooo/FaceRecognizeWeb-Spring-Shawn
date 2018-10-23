package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.DonationDao;
import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.Donation;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.Person;
 
@Transactional
@Service(value="donationService")
public class DonationService {
	
	@Autowired
	 DonationDao  donationDao;
	
	
	public void addFeedback(Donation donation) {
		donationDao.saveDonation(donation);
    }
	
	public List getDonations() {
		
        return donationDao.getDonations();

	}

	public void deleteDonationById(int id) {
		donationDao.deleteDonationById(id);
		
	}
    
}
