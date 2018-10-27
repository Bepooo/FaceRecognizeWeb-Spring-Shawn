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

import au.edu.sydney.dao.JobPosterDao;
import au.edu.sydney.domain.JobPoster;
import au.edu.sydney.service.JobPostService;
import au.edu.sydney.service.JobPosterService;


@Controller
@SessionAttributes("login")
public class JobPosterController {
	


	
	private static final Logger logger = LoggerFactory.getLogger(JobPosterController.class);
	
	//Login
	@RequestMapping(value = "/JobPosterLoginForm", method = RequestMethod.GET)
	public ModelAndView LoginForm() {
		return new ModelAndView("jobPosterLoginForm", "login", new JobPoster());
	}
	
	@ModelAttribute("JobPoster")
	public JobPoster getUser(){
		return new JobPoster();
	}
	@Autowired
	JobPosterService jobPosterService;
	JobPostService jobPostService;
	@RequestMapping(value="/JobPosterLogin",method = RequestMethod.POST) 
	public ModelAndView validateUsr(@ModelAttribute("JobPoster") JobPoster jobPoster,HttpServletRequest request,ModelMap model,Model theModel,BindingResult result,HttpSession session) 
			throws ServletException, IOException{

        String msg = "";///////////////////////////////////////
        boolean isValid =false;
		if(jobPoster !=null){
			isValid = true;
	        logger.info("Is user valid?= " + isValid);
	        
	        String[] limits=new String[2]; 
			limits[0]=jobPoster.getEmail();
			limits[1]=jobPoster.getPassword();
			jobPoster=jobPosterService.getJobPosterByQuery(limits);
			System.out.println(jobPoster);
			String name = jobPoster.getName();
			System.out.println(name);
			session.setAttribute("Name", name);


			//return new ModelAndView("jobPosterViewAllJobPosts","msg",msg);
			return new ModelAndView("redirect:/JobPostHome");
		}else {
			msg ="Invaild";
			return new ModelAndView("jobPosterLoginForm","msg",msg);
		}
	}
	
	
	
	

	@Autowired
	
	JobPosterDao jobPosterDao;
	@RequestMapping(value = "/jobPosterRegisterForm", method = RequestMethod.GET)
	public ModelAndView RegisterForm() {
		return new ModelAndView("jobPosterRegisterForm", "register", new JobPoster());
	}
	
	
	@RequestMapping(value = "/JobPosterRegister", method = RequestMethod.POST)
	public String Register(JobPoster jobPoster) {
		System.out.println("get into register");
		JobPoster f = new JobPoster();


		f.setName(jobPoster.getName());
		f.setEmail(jobPoster.getEmail());
		f.setPassword(jobPoster.getPassword());
		
		jobPosterDao.saveJobPoster(f);
		System.out.print(jobPoster.getName());
		System.out.print(jobPoster.getEmail());
		System.out.print(jobPoster.getPassword());
		return "jobPosterLoginForm";
	}
	

	


  

}
