package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.JobPostDao;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.Person;
import au.edu.sydney.domain.QA;
 
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
        return jobPostDao.getJobPosts();
    }


	public List getJobpostsByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return jobPostDao.getJobpostsByQuery(limits);
	}


	public List getJobPostsByPostername(String u) {
		// TODO Auto-generated method stub
		return jobPostDao.getJobPostsByPostername(u);
	}
	


	public void updateJobPost(JobPost jobpost) {
		// TODO Auto-generated method stub
		JobPost jp = jobPostDao.getJobpostById(jobpost.getId());
		System.out.println("inside"+jobpost);
        if(jp!=null){
            //jp.setPostername(jp.getPostername());
            jp.setCompany(jobpost.getCompany());
            jp.setDepartment(jobpost.getDepartment());
            jp.setPosition(jobpost.getPosition());
            jp.setEmploymenttype(jobpost.getEmploymenttype());
            jp.setJobdescription(jobpost.getJobdescription());
            jp.setRequirements(jobpost.getRequirements());
		        }
	}


	public JobPost getJobPostById(int id) {
		// TODO Auto-generated method stub
		return jobPostDao.getJobpostById(id);
	}
}
