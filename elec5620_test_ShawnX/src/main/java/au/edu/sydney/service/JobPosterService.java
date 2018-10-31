package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.domain.JobPoster;
import au.edu.sydney.dao.JobPosterDao;
 
@Transactional
@Service(value="jobPosterService")
public class JobPosterService {
	
	@Autowired
	public JobPosterDao JobPosterDao;
	
	
	public void addJobPoster(JobPoster jobPoster) {
		JobPosterDao.saveJobPoster(jobPoster);
    }
	public void deleteShoppingassistById(int  id) {
		JobPosterDao.deleteJobPosterById(id);
    }
	
	public List getJobPosters() {
		// TODO Auto-generated method stub
		return JobPosterDao.getJobPosters();
	}
	
	public JobPoster getJobPosterByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return JobPosterDao.getJobPosterByQuery(limits);
	}
	public JobPoster getJobPosterByName(String username) {
		// TODO Auto-generated method stub
		return JobPosterDao.getJobPosterByName(username);
	}
}
