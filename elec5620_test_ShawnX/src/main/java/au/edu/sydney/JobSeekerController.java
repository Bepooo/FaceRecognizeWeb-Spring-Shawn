package au.edu.sydney;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import au.edu.sydney.dao.JobSeekerDao;
import au.edu.sydney.domain.JobSeeker;
import au.edu.sydney.service.JobPostService;
import au.edu.sydney.service.JobSeekerService;


@Controller
@SessionAttributes("login")
public class JobSeekerController {
	


	
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerController.class);
	
	//Login
	@RequestMapping(value = "/LoginForm", method = RequestMethod.GET)
	public ModelAndView LoginForm() {
		return new ModelAndView("jobSeekerLoginForm", "login", new JobSeeker());
	}
	
	@ModelAttribute("JobSeeker")
	public JobSeeker getUser(){
		return new JobSeeker();
	}
	@Autowired
	JobSeekerService jobSeekerService;
	JobPostService jobPostService;
	@RequestMapping(value="/Login",method = RequestMethod.POST) 
	public ModelAndView validateUsr(@ModelAttribute("JobSeeker") JobSeeker jobSeeker,HttpServletRequest request,ModelMap model,Model theModel,BindingResult result,HttpSession session) 
			throws ServletException, IOException{

        String msg = "";///////////////////////////////////////
        boolean isValid =false;
		if(jobSeeker !=null){
			isValid = true;
	        logger.info("Is user valid?= " + isValid);
	        
	        String[] limits=new String[2]; 
			limits[0]=jobSeeker.getEmail();
			limits[1]=jobSeeker.getPassword();
			jobSeeker=jobSeekerService.getJobSeekerByQuery(limits);
			System.out.println(jobSeeker);
			String name = jobSeeker.getName();
			System.out.println(name);
			session.setAttribute("Name", name);


			//return new ModelAndView("jobSeekerViewAllJobPosts","msg",msg);
			return new ModelAndView("redirect:/jobSeekerViewAllJobPosts");
		}else {
			msg ="Invaild";
			return new ModelAndView("jobSeekerLoginForm","msg",msg);
		}
	}
	
	
	@RequestMapping(value="/testsession1",method = RequestMethod.GET) 
	public String Homepage(HttpServletRequest requst,Model theModel,HttpSession session)
		throws ServletException, IOException{
		String u = (String) session.getAttribute("Name");
		System.out.println("seesion"+u);
		return "testsession";
	}
	
	

	@Autowired
	
	JobSeekerDao jobSeekerDao;
	@RequestMapping(value = "/RegisterForm", method = RequestMethod.GET)
	public ModelAndView RegisterForm() {
		return new ModelAndView("jobSeekerRegisterForm", "register", new JobSeeker());
	}
	
	
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String Register(JobSeeker jobSeeker) {
		System.out.println("get into register");
		JobSeeker f = new JobSeeker();


		f.setName(jobSeeker.getName());
		f.setEmail(jobSeeker.getEmail());
		f.setPassword(jobSeeker.getPassword());
		
		jobSeekerDao.saveJobSeeker(f);
		System.out.print(jobSeeker.getName());
		System.out.print(jobSeeker.getEmail());
		System.out.print(jobSeeker.getPassword());
		return "jobSeekerLoginForm";
	}
	

	


  

}
