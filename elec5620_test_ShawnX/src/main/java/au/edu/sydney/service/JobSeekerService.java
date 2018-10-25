package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.domain.JobSeeker;
import au.edu.sydney.dao.JobSeekerDao;
 
@Transactional
@Service(value="jobSeekerService")
public class JobSeekerService {
	
	@Autowired
	public JobSeekerDao JobSeekerDao;
	
	
	public void addJobSeeker(JobSeeker jobSeeker) {
		JobSeekerDao.saveJobSeeker(jobSeeker);
    }
	public void deleteShoppingassistById(int  id) {
		JobSeekerDao.deleteJobSeekerById(id);
    }
	
	public List getJobSeekers() {
		// TODO Auto-generated method stub
		return JobSeekerDao.getJobSeekers();
	}
	
	public JobSeeker getJobSeekerByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return JobSeekerDao.getJobSeekerByQuery(limits);
	}
}
