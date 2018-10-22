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
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.dao.ClothesDao;
import au.edu.sydney.dao.ResumeDao;
import au.edu.sydney.dao.ShoppingassistDao;
import au.edu.sydney.domain.Clothes;
import au.edu.sydney.domain.Feedback;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.Person;
//import au.edu.sydney.domain.Product;
import au.edu.sydney.domain.Resume;
import au.edu.sydney.domain.Shoppingassist;
import au.edu.sydney.service.ClothesService;
import au.edu.sydney.service.FeedbackService;
import au.edu.sydney.service.JobPostService;
import au.edu.sydney.service.PersonService;
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
	public int JobPostid;

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

		return "home";
	}

	@RequestMapping(value = "/FaceFacebookLogin", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);



		return "FaceFacebookLogin";
	}
	
	
	
	@RequestMapping(value = "/FaceTechies", method = RequestMethod.GET)
	public String FaceTechies(Locale locale) {
		return "FaceTechiesHome";
	}
	
	@Autowired
	ShoppingassistDao shoppingassistDao;
	@RequestMapping(value = "/FaceAddShoppingassist", method = RequestMethod.POST)
	public String AddShoppingassist(Shoppingassist shoppingassist) {

		Shoppingassist f = new Shoppingassist();


		f.setName(shoppingassist.getName());
		f.setPassword(shoppingassist.getPassword());


		shoppingassistDao.saveShoppingassist(f);
		System.out.print(shoppingassist.getName());
		System.out.print(shoppingassist.getPassword());
		return "FaceHome";
	}
	@Autowired
	ShoppingassistService shoppingassistService;

	@RequestMapping(value = "/FaceReadShoppingassist", method = RequestMethod.GET)
	public String FaceReadShoppingassist(ModelMap model) {
		System.out.println("FaceReadShoppingassist");

		// 遍历集合，查看查询到的数据
		List shoppingassists = shoppingassistService.getShoppingassists();
		model.addAttribute("Shoppingassists", shoppingassists);
		System.out.println(shoppingassists);

		return "FaceShowShoppingassists";
	}
	

	@RequestMapping(value = { "/delete-{id}-shoppingassist" }, method = RequestMethod.GET)
	public String deleteShoppingassistById(@PathVariable int id) {
		System.out.println("delete");
		shoppingassistService.deleteShoppingassistById(id);
		return "FaceHome";
	}
	
	/*
	 * @RequestMapping(value = "/jdbcAdd", method = RequestMethod.GET) public String
	 * jdbcAdd(Locale locale, Model model) {
	 * 
	 * // JDBC driver name and database URL String JDBC_DRIVER =
	 * "com.mysql.jdbc.Driver"; // String DB_URL =
	 * "jdbc:mysql://localhost/elec5619"; String DB_URL =
	 * "jdbc:mysql://localhost/elec5619?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 * 
	 * // Database credentials String USER = "root"; // String PASS = "123456";
	 * 
	 * Connection conn = null; PreparedStatement preparedStatement = null; try { //
	 * Register JDBC driver Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * // Open a connection System.out.println("Connecting to database..."); conn =
	 * DriverManager.getConnection(DB_URL, USER, PASS);
	 * 
	 * String insertTableSQL =
	 * "INSERT INTO employee (id, age, first, last) VALUES (?,?,?,?)";
	 * 
	 * preparedStatement = conn.prepareStatement(insertTableSQL);
	 * preparedStatement.setInt(1, 2); preparedStatement.setInt(2, 25);
	 * preparedStatement.setString(3, "Test"); preparedStatement.setString(4,
	 * "Name");
	 * 
	 * // execute insert SQL statement preparedStatement.executeUpdate();
	 * System.out.println("Record is inserted into employee table!");
	 * 
	 * // Clean-up environment preparedStatement.close(); conn.close(); } catch
	 * (SQLException se) { // Handle errors for JDBC se.printStackTrace(); } catch
	 * (Exception e) { // Handle errors for Class.forName e.printStackTrace(); }
	 * finally { try { if (preparedStatement != null) preparedStatement.close(); }
	 * catch (SQLException se2) { } try { if (conn != null) conn.close(); } catch
	 * (SQLException se) { se.printStackTrace(); } }
	 * 
	 * return "home"; }
	 * 
	 * @Autowired SessionFactory sessionFactory;
	 * 
	 * @RequestMapping(value = "/hibernateAdd", method = RequestMethod.GET) public
	 * String hibernateAdd(Locale locale, Model model) {
	 * 
	 * Person p = new Person(); p.setAge(20); p.setFirst("FirstName");
	 * p.setLast("lastName");
	 * 
	 * sessionFactory.getCurrentSession().save(p); return "home"; }
	 */

	@Autowired
	PersonDao personDao;

	@RequestMapping(value = "/hibernateDaoAdd", method = RequestMethod.GET)
	public String hibernateDaoAdd(Locale locale, Model model) {
		Person p = new Person();
		p.setAge(25);
		p.setFirst("FirstName");
		p.setLast("lastName");

		personDao.savePerson(p);

		return "home";
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
	@RequestMapping(value = "/FaceHome", method = RequestMethod.GET)
	public String facehome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Local.DeleteFile();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "FaceHome";
	}
	
	@RequestMapping(value = "/FaceLookingfor", method = RequestMethod.GET)
	public String Facelookingfor(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		
		

		return "FaceLookingforClothes";
	}

	@RequestMapping(value = "/FaceWriteFeedback", method = RequestMethod.GET)
	public String FaceWriteFeedback(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "FaceWriteFeedback";
	}
	
	@RequestMapping(value = "/FaceWriteClothes", method = RequestMethod.GET)
	public String FaceWritePrdocuct(Locale locale, Model model) {



		return "FaceWriteClothes";
	}
	
	
	@Autowired
	ClothesDao clothesDao;
	@RequestMapping(value = "/FaceAddClothes", method = RequestMethod.POST)
	public String addClothes(Clothes clothes) {

		Clothes f = new Clothes();


		f.setColor(clothes.getColor());
		f.setLocation(clothes.getLocation());
		f.setType(clothes.getType());
		f.setPrice(clothes.getPrice());

		clothesDao.saveClothes(f);
		System.out.print(clothes.getColor());
		System.out.print(clothes.getType());
		return "FaceHome";
	}


	@Autowired
	ClothesService clothesService;
	@RequestMapping(value = { "/FaceQueryClothes" }, method = RequestMethod.POST)
	public String FaceFindClothes(Feedback feedback) {
		System.out.println("query clothes"+feedback);
		String[] limits=new String[2]; 
		limits[0]=feedback.getFeedback();
		limits[1]=feedback.getType();
		System.out.println("color= "+limits[0]);
		System.out.println("type= "+limits[1]);
		List clothessquery=clothesService.getClothesByQuery(limits);
		
		//model.addAttribute("Products", productsquery);
		System.out.println(clothessquery);
		//System.out.println(model);
		//return new ModelAndView("ShowJobPosterResumes", "model",model);
		return "FaceHome";
	}
	
	
	@Autowired
	FeedbackDao feedbackDao;

	@RequestMapping(value = "/FaceSubmitFeedback")
	public String addFeedback(Feedback feedback) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Feedback f = new Feedback();
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		String time = df.format(dateobj);
		// f.setFeedback(feedback.getId());

		f.setFeedback(feedback.getFeedback());
		f.setTime(time);
		f.setType(feedback.getType());

		feedbackDao.saveFeedback(f);
		System.out.print(feedback.getFeedback());
		System.out.print(feedback.getType());
		return "FaceHome";
	}

	/*
	 * @RequestMapping(value = "/FaceDetectLogin", method = RequestMethod.GET)
	 * public String advices() {
	 * 
	 * System.out.println("FaceDetectLogin"); new
	 * Local().renameFile("D:\\5620\\download", "D:\\\\5620\\\\photo.png"); String
	 * photo="D:\\\\5620\\\\photo.png"; Facedetect.detect(photo);
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = "/FaceRegisterHome", method = RequestMethod.GET)
	public String faceregister() {
		//Local.DeleteFile();
		System.out.println("FaceRegisterHome");
		return "FaceRegistering";
	}

	@RequestMapping(value = "/FaceRegisterStart", method = RequestMethod.GET)
	public ModelAndView faceRegisterStart(ModelMap model) {

		System.out.println("FaceRegisterStart");
		new Local().renameFile("D:\\5620\\download", "D:\\\\5620\\\\photo.png");
		String photo = "D:\\\\5620\\\\photo.png";
		String facetoken = Facedetect.detect(photo);
		return new ModelAndView("FaceRegisterInformation", "model", facetoken);

	}

	//////////////////////////////////
	@Autowired
	PersonService personService;	

	@RequestMapping(value = "/FaceAddPerson")
	public String addPerson(Person person) {
		//Person p = new Person();
		String facetokeninreg = person.getFaceto();
		String a = FaceSearch.RegisterSearch(facetokeninreg);
		System.out.println("a= " + a);
		String advice="";
		if (a.equals("SUCCESS")) {
			String b = FaceSearch.ResultSearch(facetokeninreg);
			System.out.println("b= " + b);
			if (b.equals("no")) {
				System.out.println("user not exists, true");

				person.setAdvice(Local.getAdvice(person));
				
				//person.setAdvice(advice);
				System.out.println("Person= "+person);
				personService.addPerson(person);
				FaceAdd.add(person.getId(), person.getFirst(), person.getFaceto());
				// get advices
				return "FaceUserMainPage";
			} else if (b.equals("yes")) {
				System.out.println("user exists");

				return "FaceUserExistPage";
			}
		} else if (a.equals("Not Found")) {

			
	
			person.setAdvice(Local.getAdvice(person));
			
			System.out.println("Person= "+person);
			personService.addPerson(person);
			FaceAdd.add(person.getId(), person.getFirst(), person.getFaceto());
			return "FaceUserMainPage";
		} else {
			return "FaceWrongPage";

		}

		System.out.print(person);
		return "home";
	}
	
	@RequestMapping(value = "/FaceLoginHome", method = RequestMethod.GET)
	public String FaceLoginHome() {
		//Local.DeleteFile();
		System.out.println("FaceLoginHome");
		return "FaceLoginStart";
	}
	
	@RequestMapping(value = "/FaceLogining", method = RequestMethod.GET)
	public ModelAndView FaceLoginHome(ModelMap model) {

		System.out.println("FaceLoginStart");
		new Local().renameFile("D:\\5620\\download", "D:\\\\5620\\\\photo.png");
		String photo = "D:\\\\5620\\\\photo.png";
		String ft = Facedetect.detect(photo);
		String a = FaceSearch.LoginSearch(ft);
		if (a.equals("yes")) {
			System.out.println("user exists, login");
			String username = Local.getName(ft);
			List p = personService.getPersonByFirst(username);
			System.out.println("p= "+p);
			model.addAttribute("PersonInfo", p);
			System.out.println("model= "+model);
			return new ModelAndView("FaceUserMainPage", "model", model);
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
	
	@Autowired
	FeedbackService feedbackService;

	@RequestMapping(value = "/FaceReadFeedback", method = RequestMethod.GET)
	public String FaceReadFeedbacks(ModelMap model) {
		System.out.println("FaceReadFeedbacks");

		// 遍历集合，查看查询到的数据
		List feedbacks = feedbackService.getFeedbacks();
		model.addAttribute("Feedbacks", feedbacks);
		System.out.println(feedbacks);

		return "FaceShowFeedbacks";
	}

	@RequestMapping(value = { "/delete-{id}-feedback" }, method = RequestMethod.GET)
	public String deleteFeedbackById(@PathVariable int id) {
		System.out.println("delete");
		feedbackService.deleteFeedbackById(id);
		return "FaceHome";
	}
	/////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////

	@Autowired
	JobPostDao jobpostDao;

	@RequestMapping(value = "/addJobPost", method = RequestMethod.POST)
	public String submitJP(@Valid @ModelAttribute("jobpost") JobPost jobpost, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		String time = df.format(dateobj);

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
		System.out.println("time= " + time);
		// jobpostDao.saveJobPost(p);
		JobPostid = jobpostDao.saveJobPost(p);// largest id in database
		p.setId(JobPostid);
		System.out.print("JobPostId= " + JobPostid);

		model.addAttribute("location", jobpost.getLocation());
		model.addAttribute("company", jobpost.getCompany());
		model.addAttribute("department", jobpost.getDepartment());
		model.addAttribute("position", jobpost.getPosition());
		model.addAttribute("employmenttype", jobpost.getEmploymenttype());
		model.addAttribute("jobdescription", jobpost.getJobdescription());
		model.addAttribute("requirements", jobpost.getRequirements());
		model.addAttribute("time", time);
		model.addAttribute("jobpostid", JobPostid);

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

	@RequestMapping(value = "/deleteLatestJobPost")
	public String deletejobPost() {
		System.out.println("删除");
		System.out.println(JobPostid);
		jobPostService.deleteJobPostById(JobPostid);
		System.out.println(JobPostid);
		return "home";
	}

	@RequestMapping(value = { "/delete-{id}-jobpost" }, method = RequestMethod.GET)
	public String deleteJobPostById(@PathVariable int id) {
		System.out.println("delete one");
		jobPostService.deleteJobPostById(id);
		return "home";
	}

	@RequestMapping(value = "/JobCentre", method = RequestMethod.GET)
	public String readJobPost(ModelMap model) {
		System.out.println("read");

		// 遍历集合，查看查询到的数据
		List jobposts = jobPostService.getJobPosts();
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

	//////////////////////////////////////////
	// For job seekers
	//////////////////////////////////////////
	@RequestMapping(value = "/jobSeekerViewAllJobPosts", method = RequestMethod.GET)
	public String viewAllJobPosts(ModelMap model) {
		System.out.println("jobSeeker Read JobPosts");

		// 遍历集合，查看查询到的数据
		List jobposts = jobPostService.getJobPosts();
		model.addAttribute("JobPosts", jobposts);
		System.out.println(jobposts);

		return "jobSeekerViewAllJobPosts";
	}

	@Autowired
	ResumeDao resumeDao;

	@RequestMapping(value = "/save-{model}-resume")
	public String addResume(Resume resume, int model) {
		System.out.println("model= " + model);
		Resume r = new Resume();

		r.setJobPostId(model);
		r.setName(resume.getName());
		r.setAge(resume.getAge());

		System.out.println(r);
		resumeDao.saveResume(r);
		return "home";
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
	@RequestMapping(value = { "/apply-{id}-apply" }, method = RequestMethod.GET)
	public ModelAndView applyJobPostById(@PathVariable int id, ModelMap model) {
		System.out.println("applying" + id);
		model.addAttribute("JobPostId", id);

		System.out.println(model);
		return new ModelAndView("submitResumePage", "model", id);
		/*
		 * Resume resume=new Resume(); resume.setJobPostId((id));
		 */

		// return "submitResumePageController";
	}

	////////////////////// resumecentre
	@RequestMapping(value = { "/ResumeCentre" }, method = RequestMethod.GET)
	public ModelAndView findResumeByJobPostPoster(ModelMap model) {
		System.out.println("queryresume");
		String rid = "18";
		List resumesquery = resumeService.getResumeByRid(rid);
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

}