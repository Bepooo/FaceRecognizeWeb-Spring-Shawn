package au.edu.sydney;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.JobPostDao;
import au.edu.sydney.dao.JobPosterDao;
import au.edu.sydney.dao.JobSeekerDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.dao.AnnouncementDao;
import au.edu.sydney.dao.ClothesDao;
import au.edu.sydney.dao.DonationDao;
import au.edu.sydney.dao.ResumeDao;
import au.edu.sydney.dao.ShoppingassistDao;
import au.edu.sydney.domain.Announcement;
import au.edu.sydney.domain.Clothes;
import au.edu.sydney.domain.Donation;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.JobPoster;
import au.edu.sydney.domain.JobSeeker;
import au.edu.sydney.domain.Person;
import au.edu.sydney.domain.QA;
//import au.edu.sydney.domain.Product;
import au.edu.sydney.domain.Resume;
import au.edu.sydney.domain.Shoppingassist;
import au.edu.sydney.service.AnnouncementService;
import au.edu.sydney.service.ClothesService;
import au.edu.sydney.service.DonationService;
import au.edu.sydney.service.FeedbackService;
import au.edu.sydney.service.JobPostService;
import au.edu.sydney.service.JobPosterService;
import au.edu.sydney.service.JobSeekerService;
import au.edu.sydney.service.PersonService;
import au.edu.sydney.service.QAService;
//import au.edu.sydney.service.ProductService;
import au.edu.sydney.service.ResumeService;
import au.edu.sydney.service.ShoppingassistService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@Transactional
@SessionAttributes("login")
public class JobPosterController {
	
	public int JobPostid,LargestAnnouncementid;

	
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
	//JobPostService jobPostService;
	@RequestMapping(value = "/JobPosterLoginHome", method = RequestMethod.GET)
	public String FaceLoginHome() {
		//Local.DeleteFile();
		System.out.println("JobPosteLoginHome");
		return "JobPosterLoginStart";
	}
	@RequestMapping(value = "/JobPosterLogining", method = RequestMethod.GET)
	public ModelAndView jobPosterLogining(ModelMap model) {

		System.out.println("JobPosterLogining");
		new Local().renameFile("D:\\5620\\download", "D:\\\\5620\\\\photo.png");
		String photo = "D:\\\\5620\\\\photo.png";
		String ft = Facedetect.detect(photo);
		String a = FaceSearch.LoginSearch(ft);
		if (a.equals("yes")) {
			System.out.println("user exists, login");
			String username = Local.getName(ft);
			JobPoster p = jobPosterService.getJobPosterByName(username);
			System.out.println("p= "+p);
			String pname=p.getName();
			model.addAttribute("JobPosterInfo", pname);
			System.out.println("model= "+model);
			return new ModelAndView("jobPosterLoginForm", "model", model);
			/*System.out.println(username);
			UserPage.UserPage(username);*/
		} else if (a.equals("no")) {
			//no user page
			//FailPage.UserCanNotFind();
			String e="User Can Not Find";
			model.addAttribute("ErrorMessage", e);
			return new ModelAndView("FaceErrormessage", "model", model);
		} else {
			//FailPage.TryAgain(a);
			String e="System met some problem, try again~";
			model.addAttribute("ErrorMessage", e);
			return new ModelAndView("FaceErrorMessage", "model", model);
		}
		
		//return new ModelAndView("FaceRegisterInformation", "model", facetoken);
		
		

	}
	
	@RequestMapping(value="/JobPosterLogin",method = RequestMethod.POST) 
	public ModelAndView validateUsr(@ModelAttribute("JobPoster") JobPoster jobPoster,HttpServletRequest request,ModelMap model,Model theModel,BindingResult result,HttpSession session) 
			throws ServletException, IOException{

        String msg = "";///////////////////////////////////////
        boolean isValid =false;
		if(jobPoster !=null){
			isValid = true;
	        logger.info("Is user valid?= " + isValid);
	        String pname=jobPoster.getName();
	        System.out.println("pname= "+pname);
	        String[] limits=new String[2]; 
			limits[0]=jobPoster.getEmail();
			limits[1]=jobPoster.getPassword();
			try{jobPoster=jobPosterService.getJobPosterByQuery(limits);
			System.out.println(jobPoster);
			String name = jobPoster.getName();
			

			System.out.println("name= "+name);
			if (name.equalsIgnoreCase(pname)){
			
			
			session.setAttribute("Name", name);


			//return new ModelAndView("jobPosterViewAllJobPosts","msg",msg);
			return new ModelAndView("redirect:/JobPostHome");}
			else {
				Object[] options = { "OK", "CANCEL" }; 
				JOptionPane.showOptionDialog(null, "Wrong password or email,please check again!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
		         System.out.println("Exception occurred");
				return new ModelAndView("jobPosterLoginForm");}
			
			}
			
			
			
			catch(Exception e) {
				Object[] options = { "OK", "CANCEL" }; 
				JOptionPane.showOptionDialog(null, "Wrong Email or password, please check again", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
		         System.out.println("Exception occurred");
		         return new ModelAndView("jobPosterLoginForm","msg",msg);
			}
		}else {
			msg ="Invaild";
			return new ModelAndView("jobPosterLoginForm","msg",msg);
		}
	}
	
	
	
	

	@Autowired
	
	JobPosterDao jobPosterDao;
	@RequestMapping(value = "/jobPosterRegisterForm", method = RequestMethod.GET)
	public ModelAndView RegisterForm() {
		return new ModelAndView("FaceRegistering", "register", new JobPoster());
	}
	//, jobPosterRegisterForm
	@RequestMapping(value = "/FaceRegisterStart", method = RequestMethod.GET)
	public ModelAndView faceRegisterStart(ModelMap model) {

		System.out.println("FaceRegisterStart");
		new Local().renameFile("D:\\5620\\download", "D:\\\\5620\\\\photo.png");
		String photo = "D:\\\\5620\\\\photo.png";
		String facetoken = Facedetect.detect(photo);
		return new ModelAndView("jobPosterRegisterForm", "model", facetoken);

	}
	
	/*@RequestMapping(value = "/JobPosterRegister", method = RequestMethod.POST)
	public String Register(JobPoster jobPoster) {
		System.out.println("get into register");
		JobPoster f = new JobPoster();


		f.setName(jobPoster.getName());
		f.setEmail(jobPoster.getEmail());
		f.setPassword(jobPoster.getPassword());
		f.setFaceto(jobPoster.getFaceto());
		
		jobPosterDao.saveJobPoster(f);
		System.out.print(jobPoster.getName());
		System.out.print(jobPoster.getEmail());
		System.out.print(jobPoster.getPassword());
		System.out.print(jobPoster.getFaceto());
		return "FaceAddJobPoster";
	}*/
	@RequestMapping(value = "/FaceAddJobPoster")
	public String addJobPoster(JobPoster jobPoster) {
		String facetokeninreg = jobPoster.getFaceto();
		String a = FaceSearch.RegisterSearch(facetokeninreg);
		System.out.println("a= " + a);
		String advice="";
		if (a.equals("SUCCESS")) {
			String b = FaceSearch.ResultSearch(facetokeninreg);
			System.out.println("b= " + b);
			if (b.equals("no")) {
				System.out.println("user not exists, true");
				
				//person.setAdvice(advice);
				System.out.println("JobPoster= "+jobPoster);
				jobPosterService.addJobPoster(jobPoster);
				FaceAdd.add(jobPoster.getId(), jobPoster.getName(), jobPoster.getFaceto());
				// get advices
				return "JobPosterLoginStart";
			} else if (b.equals("yes")) {
				System.out.println("user exists");
				Object[] options = { "OK", "CANCEL" }; 
				JOptionPane.showOptionDialog(null, "User face already exsit!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
		         System.out.println("Exception occurred");
				return "JobPosterLoginStart";
			}
		} else if (a.equals("Not Found")) {

			
			System.out.println("JobPoster= "+jobPoster);
			jobPosterService.addJobPoster(jobPoster);
			FaceAdd.add(jobPoster.getId(), jobPoster.getName(), jobPoster.getFaceto());
			return "JobPosterLoginStart";
		} else {
			return "FaceWrongPage";

		}

		System.out.println(jobPoster);
		return "homepage";
	}

	
	@Autowired
	JobPostDao jobpostDao;

	@RequestMapping(value = "/addJobPost", method = RequestMethod.POST)
	public String submitJP(@Valid @ModelAttribute("jobpost") JobPost jobpost, BindingResult result, ModelMap model,HttpSession session) {
		if (result.hasErrors()) {
			return "error";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		String time = df.format(dateobj);
		String u=(String)session.getAttribute("Name");
		JobPost p = new JobPost();
		// p.setId(jobpost.getId());
		// System.out.println(p.getId());
		p.setAge(26);
		p.setCompany(jobpost.getCompany());
		p.setDepartment(jobpost.getDepartment());
		p.setLocation(jobpost.getLocation());
		p.setPosition(jobpost.getPosition());
		p.setEmploymenttype(jobpost.getEmploymenttype());
		p.setJobdescription(jobpost.getJobdescription());
		p.setRequirements(jobpost.getRequirements());
		p.setTime(time);
		p.setPostername(u);
		System.out.println("time= " + time);
		System.out.println("beforesave"+p);
		// jobpostDao.saveJobPost(p);
		String[] result1=new String[2];
		result1=jobpostDao.saveJobPost(p);
		JobPostid=Integer.parseInt(result1[0]);
				String JobPostname = result1[1];
		//JobPostid = jobpostDao.saveJobPost(p);// largest id in database saveveeeeeeee
		p.setId(JobPostid);
		System.out.print("JobPostId= " + JobPostid);
		
		System.out.println("aftersave"+jobpost.getPostername());
		
		model.addAttribute("postername", JobPostname);
		model.addAttribute("location", jobpost.getLocation());
		model.addAttribute("company", jobpost.getCompany());
		model.addAttribute("department", jobpost.getDepartment());
		model.addAttribute("position", jobpost.getPosition());
		model.addAttribute("employmenttype", jobpost.getEmploymenttype());
		model.addAttribute("jobdescription", jobpost.getJobdescription());
		model.addAttribute("requirements", jobpost.getRequirements());
		model.addAttribute("time", time);
		model.addAttribute("jobpostid", JobPostid);
		System.out.println(jobpost.getPostername());
		System.out.println(jobpost.getId());
		System.out.println(jobpost.getLocation());
		System.out.println(jobpost.getDepartment());
		System.out.println(jobpost.getPosition());
		System.out.println(jobpost.getEmploymenttype());
		System.out.println(jobpost.getJobdescription());
		System.out.println(jobpost.getRequirements());
		System.out.println(jobpostDao.saveJobPost(p));
		return "JobPostConfirm";
	}

	@Autowired
	JobPostService jobPostService;
	@RequestMapping(value = { "/jobSeekerQueryJobposts" }, method = RequestMethod.POST)
	public ModelAndView jobSeekerQueryJobposts(Feedback feedback,ModelMap model ) {
		System.out.println("query jobposts"+feedback);
		String[] limits=new String[2]; 
		limits[0]=feedback.getType();
		limits[1]=feedback.getFeedback();
		System.out.println("Employmenttype= "+limits[0]);
		System.out.println("Location= "+limits[1]);
		List jobpostsquery=jobPostService.getJobpostsByQuery(limits);
		
		model.addAttribute("JobPosts", jobpostsquery);
		System.out.println(jobpostsquery);
		//System.out.println(model);
		return new ModelAndView("jobSeekerViewAllJobPostsPage", "model",model);
		//return "FaceHome";
	}

	
	@RequestMapping(value = "/deleteLatestJobPost")
	public String deletejobPost() {
		System.out.println("删除");
		System.out.println(JobPostid);
		jobPostService.deleteJobPostById(JobPostid);
		System.out.println(JobPostid);
		return "JobPostHome";
	}

	@RequestMapping(value = { "/delete-{id}-jobpost" }, method = RequestMethod.GET)
	public String deleteJobPostById(@PathVariable int id, HttpServletRequest request) {
		System.out.println("delete one");
		jobPostService.deleteJobPostById(id);
		return "redirect:" + request.getHeader("Referer");
	}
	 @RequestMapping(value = { "/edit-{id}-jobpost" }, method = RequestMethod.GET)
     public String editJobPost(@PathVariable int id, ModelMap model) {
         JobPost jobpost = jobPostService.getJobPostById(id);
         model.addAttribute("jobpost", jobpost);
         System.out.println("get into edit "+id);
         //model.addAttribute("edit", true);
         return "jobposterPostForm";
     }
	////////////////////////////////////////////////
	@RequestMapping(value = { "/edit-{id}-jobpost" }, method = RequestMethod.POST)
    public String updateJobpost(@Valid JobPost jobpost, BindingResult result,
            ModelMap model, @PathVariable int id , HttpSession session) {   
System.out.println("jobpost beeing editted"+jobpost);
  	         jobPostService.updateJobPost(jobpost);
        model.addAttribute("success",jobpost.getCompany()+jobpost.getRequirements()  +" "+jobpost.getDepartment() + " updated successfully");

        return "jobposterJobPostSuccess";

    }
	
	@RequestMapping(value = "/JobCentre", method = RequestMethod.GET)
	public String readJobPost(ModelMap model, HttpSession session) {
		System.out.println("read");
		String u=(String)session.getAttribute("Name");
		// 遍历集合，查看查询到的数据
		List jobposts = jobPostService.getJobPostsByPostername(u);
		model.addAttribute("JobPosts", jobposts);
		System.out.print(jobposts);

		return "jobposts";
	}

	@RequestMapping(value = "/JobCentreQuery", method = RequestMethod.GET)
	public String queryJobPost(ModelMap model) {
		System.out.println("query");
		String qa = "wer";
		System.out.print(jobPostService.getJobPostByCompany("p"));
		/*
		 * model.addAttribute("jobpost", jobPostService.getJobPostById("5"));
		 */
		List jobpostsquery = jobPostService.getJobPostByCompany(qa);
		model.addAttribute("JobPosts", jobpostsquery);
		System.out.print(jobpostsquery);

		return "jobposts";
	}


  

}
