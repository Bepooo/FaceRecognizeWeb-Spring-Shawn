package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.ResumeDao;
import au.edu.sydney.domain.Resume;
 
@Transactional
@Service(value="resumeService")
public class ResumeService {
	
	@Autowired
	public ResumeDao ResumeDao;
	
	
	public void addResume(Resume resume) {
        ResumeDao.saveResume(resume);
    }
	/*public void deleteResumeById(int  id) {
		ResumeDao.deleteResumeById(id);
    }
	
	
	public List getResumeByCompany(String co){
        return ResumeDao.getResumeByCompany(co);
    }

	
	public List getResumes() {
        return ResumeDao.getResumes();
    }*/


	public List getResumeByRid(int rid) {
		// TODO Auto-generated method stub
		return ResumeDao.getResumeByRid(rid);
	}


	public List getResumeByPoster(String u) {
		// TODO Auto-generated method stub
		return ResumeDao.getResumeByPoster(u);
	}


	public List getResumeByName(String u) {
		// TODO Auto-generated method stub
		return ResumeDao.getResumeByName(u);
	}


	public void deleteResumeById(int id) {
		ResumeDao.deleteResumeById(id);
		
	}
}
