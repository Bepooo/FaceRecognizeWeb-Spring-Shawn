package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.JobPostDao;
import au.edu.sydney.domain.JobPost;
 
@Transactional
@Service(value="jobPostService")
public class JobPostService {
	
	@Autowired
	public JobPostDao jobPostDao;
	
	public void deleteJobPostById(int  id) {
		jobPostDao.deleteJobPostById(id);
    }
	
	
	public List getJobPostByCompany(String co){
        return jobPostDao.getJobPostByCompany(co);
    }

	
	public List getJobPosts() {
        return jobPostDao.getjobPosts();
    }
}
