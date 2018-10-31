package au.edu.sydney;

import java.io.FileNotFoundException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.ModelAndView;



import au.edu.sydney.dao.FeedbackDao;
import au.edu.sydney.dao.JobPostDao;
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
//import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public int JobPostid,LargestAnnouncementid;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		Local.DeleteFile();
		return "Homepage";
	}
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		List jobposts = jobPostService.getJobPosts();
		model.addAttribute("JobPosts", jobposts);
		System.out.print(jobposts);

		return "adminHome";
	}
	
	


	
	
	


	




	
	

	

	
	

	@RequestMapping(value = "/JobPostHome", method = RequestMethod.GET)
	public ModelAndView showFormJP() {
		return new ModelAndView("JobPostHome", "jobpost", new JobPost());
	}

	/*
	 * @Autowired JobPostDao jobpostDao;
	 * 
	 * @RequestMapping(value = "/JobPostDaoAdd", method = RequestMethod.GET) public
	 * String JobPostDaoAdd(Locale locale, Model model) { JobPost p = new JobPost();
	 * p.setId(2); p.setAge(26); p.setFirst("FirstName"); p.setLast("lastName");
	 * 
	 * jobpostDao.saveJobPost(p);
	 * 
	 * return "home"; }
	 */

	//////////////////////////////
	// Facedetect
	//////////////////////////////
	
	/////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////

	
/*	@RequestMapping(value = "/registerJobSeeker", method = RequestMethod.GET)
	public String registerJobSeeker() {
		//Local.DeleteFile();
		System.out.println("registerJobSeeker");
		return "registerJobSeeker";
	}
	
	@RequestMapping(value = "/loginJobSeeker", method = RequestMethod.GET)
	public String loginJobSeeker() {
		//Local.DeleteFile();
		System.out.println("loginJobSeeker");
		return "loginJobSeeker";
	}
	*/
	/*@Autowired
	JobSeekerDao jobSeekerDao;
	@RequestMapping(value = "/AddNewJobSeeker", method = RequestMethod.POST)
	public String AddNewJobSeeker(JobSeeker jobSeeker) {

		JobSeeker f = new JobSeeker();


		f.setName(jobSeeker.getName());
		f.setPassword(jobSeeker.getPassword());


		jobSeekerDao.saveJobSeeker(f);
		System.out.print(jobSeeker.getName());
		System.out.print(jobSeeker.getPassword());
		return "FaceHome";
	}
	
	@Autowired
	JobSeekerService jobSeekerService;
	@RequestMapping(value = { "/JobSeekerlogin" }, method = RequestMethod.POST)
	public ModelAndView JobSeekerlogin(JobSeeker jobSeeker,ModelMap model) {
		System.out.println("query jobSeeker"+jobSeeker);
		String[] limits=new String[2]; 
		limits[0]=jobSeeker.getName();
		limits[1]=jobSeeker.getPassword();
		System.out.println("name= "+limits[0]);
		System.out.println("password= "+limits[1]);
		JobSeeker loginjobseeker=jobSeekerService.getJobSeekerByQuery(limits);
		//List jobseekerloginquery=jobSeekerService.getClothesByQuery(limits);
		
		model.addAttribute("Jobseekerloginquery", loginjobseeker);
		System.out.println(loginjobseeker);
		//System.out.println(model);
		return new ModelAndView("home", "model",model);
		//return "FaceHome";
	}*/
	@Autowired
	JobPostDao jobpostDao;

	/*@RequestMapping(value = "/addJobPost", method = RequestMethod.POST)
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
*/
	@Autowired
	JobPostService jobPostService;
	/*@RequestMapping(value = { "/jobSeekerQueryJobposts" }, method = RequestMethod.POST)
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
*/
	
	/*@RequestMapping(value = "/deleteLatestJobPost")
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

    }*/
	


	/*@RequestMapping(value = "/JobCentre", method = RequestMethod.GET)
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
		
		 * model.addAttribute("jobpost", jobPostService.getJobPostById("5"));
		 
		List jobpostsquery = jobPostService.getJobPostByCompany(qa);
		model.addAttribute("JobPosts", jobpostsquery);
		System.out.print(jobpostsquery);

		return "jobposts";
	}*/

	//////////////////////////////////////////
	// For job seekers
	//////////////////////////////////////////
	@RequestMapping(value = "/jobSeekerViewAllJobPosts")
	public String viewAllJobPosts(ModelMap model) {
		System.out.println("jobSeeker Read JobPosts");

		// 遍历集合，查看查询到的数据
		List jobposts = jobPostService.getJobPosts();
		model.addAttribute("JobPosts", jobposts);
		System.out.println(jobposts);

		return "jobSeekerViewAllJobPostsPage";
	}



	
	
	@Autowired
	ResumeDao resumeDao;
	JobPostDao jobPostDao;
	
	
	@RequestMapping(value = "/save-{model}-resume")
	public String addResume(Resume resume, int model, HttpSession session, HttpServletRequest request) {
		////
		
		
		
		String u=(String)session.getAttribute("Name");
		System.out.println(u);
		System.out.println("model= " + model);
		JobPost j=jobpostDao.getJobPosterById(model);
		String n=j.getPostername();
		String l=j.getLocation();
		String c=j.getCompany();
		String jd=j.getJobdescription();
		String p=j.getPosition();
		System.out.println(n);
		
		System.out.println(resume);
		Resume r = new Resume();
		r.setUsername(u);
		r.setJobPostId(model);
		r.setName(resume.getName());
		r.setAge(resume.getAge());
		r.setGender(resume.getGender());
		r.setEducation(resume.getEducation());
		r.setCapability(resume.getCapability());
		r.setCompany(c);
		r.setLocation(l);
		r.setJobdescription(jd);
		r.setPosition(p);
		r.setPostername(n);

		System.out.println(r);
		resumeDao.saveResume(r);
		return "redirect:" + request.getHeader("Referer");
	}

	@Autowired
	ResumeService resumeService;

	/*
	 * @RequestMapping(value = "/apply-{id}-apply", method = RequestMethod.GET)
	 * public ModelAndView applyJobPostById(@PathVariable int id, ModelMap model) {
	 * new ModelAndView("submitResumePage", "jobpost", new JobPost());
	 * System.out.println("applying"); model.addAttribute("Resumeid", id); return
	 * new ModelAndView("submitResumePage", "jobpost", new JobPost()); }
	 */
	/*
	 * @RequestMapping(value = "/JobPostHome", method = RequestMethod.GET) public
	 * ModelAndView showFormJP() { return new ModelAndView("JobPostHome", "jobpost",
	 * new JobPost()); }
	 */
	@RequestMapping(value = { "/apply-{id}-resume" }, method = RequestMethod.GET)
	public ModelAndView applyJobPostById(@PathVariable int id,ModelMap model) {
		System.out.println("applying" + id);

		model.addAttribute("JobPostId", id);

		System.out.println(model);
		return new ModelAndView("submitResumePage", "model", id);
		/*
		 * Resume resume=new Resume(); resume.setJobPostId((id));
		 */

		// return "submitResumePageController";
	}
	
	////////////////////// resumecentref
	@RequestMapping(value = { "/jobSeekerManageResumes" }, method = RequestMethod.GET)
	public ModelAndView jobSeekerManageJobPosts(ModelMap model,HttpSession session) {
		String u=(String)session.getAttribute("Name");
		System.out.println("queryresume"+u);
		//int rid=27;
		List resumesqueryn = resumeService.getResumeByName(u);
		model.addAttribute("Resumes", resumesqueryn);
		System.out.println(resumesqueryn);
		System.out.println(model);
		return new ModelAndView("jobSeekerManageResumesByName", "model",model);
		//return"ShowJobPosterResumes";
	}
	
	@RequestMapping(value = { "/delete-{id}-resume" }, method = RequestMethod.GET)
    public String deleteResume(@PathVariable int id) {
		resumeService.deleteResumeById(id);
        return "home";
    }
	
	@RequestMapping(value = { "/ResumeCentre" }, method = RequestMethod.GET)
	public ModelAndView findResumeByJobPostPoster(ModelMap model,HttpSession session) {
		String u=(String)session.getAttribute("Name");
		System.out.println("queryresume"+u);
		int rid=27;
		List resumesquery = resumeService.getResumeByPoster(u);
		model.addAttribute("Resumes", resumesquery);
		System.out.println(resumesquery);
		System.out.println(model);
		return new ModelAndView("ShowJobPosterResumes", "model",model);
		//return"ShowJobPosterResumes";
	}

	/*
	 * /*
	 * 
	 * @Autowired JobPostDao jobpostDao;
	 * 
	 * @RequestMapping(value = "/addJobPost/saveJobPost", method =
	 * RequestMethod.POST) public String saveJP(@Valid @ModelAttribute("jobpost")
	 * JobPost jobpost, BindingResult result, ModelMap model) { if
	 * (result.hasErrors()) { return "error"; }
	 * System.out.println(jobpost.getLocation());
	 * System.out.println(jobpost.getDepartment()+"savejobpost");
	 * System.out.println(jobpost.getPosition());
	 * System.out.println(jobpost.getEmploymenttype());
	 * System.out.println(jobpost.getJobdescription());
	 * System.out.println(jobpost.getRequirements());
	 * 
	 * model.addAttribute("location", jobpost.getLocation());
	 * model.addAttribute("company", jobpost.getCompany());
	 * model.addAttribute("department", jobpost.getDepartment());
	 * model.addAttribute("position", jobpost.getPosition());
	 * model.addAttribute("employmenttype", jobpost.getEmploymenttype());
	 * model.addAttribute("jobdescription", jobpost.getJobdescription());
	 * model.addAttribute("requirements", jobpost.getRequirements()); JobPost p =
	 * new JobPost(); p.setId(2); p.setAge(26); p.setFirst(jobpost.getCompany());
	 * p.setLast(jobpost.getDepartment()); jobpostDao.saveJobPost(p); return
	 * "JobPostConfirm"; }
	 */

	@RequestMapping(value = "/FaceDetect", method = RequestMethod.GET)
	public String facedetect(ModelMap model) {
		System.out.println("facedetect");

		return "FaceDetect";
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

}