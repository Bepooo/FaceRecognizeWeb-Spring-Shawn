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
	
	


	@Autowired
	AnnouncementService announcementService;
	@RequestMapping(value = "/announcementManagement", method = RequestMethod.GET)
	public String announcementManagement(ModelMap model) {

		System.out.println("Announcement Management");
		List announcements = announcementService.getAnnouncements();
		Object announcement1=announcements.get(0);
		model.addAttribute("Announcement", announcement1);
		System.out.println(announcement1);

		return "readAnnouncementManagement";
	}

	@RequestMapping(value = "/WriteNewAnnouncement", method = RequestMethod.GET)
	public String WriteNewAnnouncement(Locale locale) {
		return "editNewAnnouncement";
	}

	@Autowired
	//AnnouncementService announcementService;
	AnnouncementDao announcementDao;
	@RequestMapping(value = "/SubmitNewAnnouncement", method = RequestMethod.POST)
	public String WriteNewAnnouncement(Announcement announcement) {
		announcementDao.deleteAnnouncement();
		Announcement f = new Announcement();


		f.setContent(announcement.getContent());


		announcementDao.saveAnnouncement(f);
		System.out.print(announcement.getContent());
		return "adminHome";
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
	public String FaceAddShoppingassist(Shoppingassist shoppingassist) {

		Shoppingassist f = new Shoppingassist();

		f.setName(shoppingassist.getName());
		f.setPassword(shoppingassist.getPassword());

		System.out.println(f);
		shoppingassistDao.saveShoppingassist(f);
		System.out.print(shoppingassist.getName());
		System.out.print(shoppingassist.getPassword());
		return "FaceTechiesHome";
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
	@RequestMapping(value = { "/FaceShoppingassistHomeLogin" }, method = RequestMethod.GET)
	public String FaceShoppingassistHomeLogin(ModelMap model) {

		System.out.println("FaceShoppingassistHomeLogin");
		return "FaceShoppingassistHomeLogin";
	}
	@RequestMapping(value = { "/FaceShoppingassistLogin" }, method = RequestMethod.POST)
	public ModelAndView ShoppingAssistlogin(Shoppingassist shoppingassist,ModelMap model) {
		System.out.println("query shoppingassist"+shoppingassist);
		String[] limits=new String[2]; 
		limits[0]=shoppingassist.getName();
		limits[1]=shoppingassist.getPassword();
		System.out.println("name= "+limits[0]);
		System.out.println("password= "+limits[1]);
		Shoppingassist shoppingassistquery=shoppingassistService.getShoppingassistByQuery(limits);
		if(shoppingassistquery==null)
		{
			return new ModelAndView("FaceHome", "model",model);
		}
		else {
			String shoppingassistname=shoppingassistquery.getName();
		model.addAttribute("Shoppingassistquery", shoppingassistname);
		System.out.println(shoppingassistquery);
		return new ModelAndView("FaceShoppingassistHome", "model",shoppingassistname);
		}
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
		p.setPhonenumber("phonenumber");
		p.setEmail("email");

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
	DonationDao donationDao;
	
	@RequestMapping(value = "/FaceMakeDonation", method = RequestMethod.GET)
	public String FaceMakeDonation(Locale locale, Model model) {

		return "FaceMakeDonation";
	}
	
	
	@RequestMapping(value = "/FaceAddDonation", method = RequestMethod.POST)
	public String FaceAddDonation(Donation donation) {

		Donation f = new Donation();


		f.setColor(donation.getColor());
		f.setType(donation.getType());
		f.setDescription(donation.getDescription());

		donationDao.saveDonation(f);
		System.out.print(donation.getColor());
		System.out.print(donation.getType());
		System.out.print(donation.getDescription());
		return "FaceShowDonationAfterAdd";
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
	public ModelAndView FaceFindClothes(Feedback feedback,ModelMap model) {
		System.out.println("query clothes"+feedback);
		String[] limits=new String[2]; 
		limits[0]=feedback.getFeedback();
		limits[1]=feedback.getType();
		System.out.println("color= "+limits[0]);
		System.out.println("type= "+limits[1]);
		List clothessquery=clothesService.getClothesByQuery(limits);
		
		model.addAttribute("Clotheses", clothessquery);
		System.out.println(clothessquery);
		//System.out.println(model);
		return new ModelAndView("FaceQueryClothesResult", "model",model);
		//return "FaceHome";
	}
	
	@RequestMapping(value = "/FaceReadClothes", method = RequestMethod.GET)
	public String FaceReadClothes(ModelMap model) {
		System.out.println("FaceReadClothes");

		// 遍历集合，查看查询到的数据
		List clotheses = clothesService.getClothes();
		model.addAttribute("Clotheses", clotheses);
		System.out.println(clotheses);

		return "FaceShowClothes";
	}
	
	@RequestMapping(value = { "/delete-{id}-clothes" }, method = RequestMethod.GET)
    public String deleteClothes(@PathVariable int id) {
        clothesService.deleteClothesById(id);
        return "FaceShowClothes";
    }
	
	
	@Autowired
	QAService qaService;
	@Autowired
	    MessageSource messageSource;

	@RequestMapping(value = { "/qaManagement" })
	public String adminReadQA(ModelMap model) {
	List qas = qaService.getQAs();
	System.out.print("qas= "+qas);
    model.addAttribute("qas", qas);

    return "adminReadQA";
	}
	
	@RequestMapping(value = { "/adminWriteQA" }, method = RequestMethod.GET)

	    public String newQA(ModelMap model) {
	        QA qa = new QA();
	        model.addAttribute("qa", qa);
	        model.addAttribute("edit", false);
	        return "adminQAForm";
	    }
	@RequestMapping(value = { "/adminWriteQA" }, method = RequestMethod.POST)
	public String saveQA(@Valid QA qa, BindingResult result,
			            ModelMap model) {

			        if (result.hasErrors()) {
			            return "adminQAForm";
			        }
			        /*if(!qaService.isQAUnique(qa.getQuestion(), qa.getAnswer())){
			        	FieldError ssnError =new FieldError("qa","answer",messageSource.getMessage("non.unique.answer", new String[]{qa.getAnswer()}, Locale.getDefault()));
			        	            return "adminHome";
			        	        }*/
			        	        qaService.addQA(qa);
			        	        System.out.println(qa);
			        	        model.addAttribute("success", "Q&A " + qa.getQuestion() +" "+qa.getAnswer()+ " added successfully");

			        	        return "adminQASuccess";
			        	    }

	
	
	
	 @RequestMapping(value = { "/edit-{id}-qa" }, method = RequestMethod.GET)
	     public String editQA(@PathVariable int id, ModelMap model) {
	         QA qa = qaService.findQAById(id);
	         model.addAttribute("qa", qa);
	         System.out.println("get into edit question "+id);
	         //model.addAttribute("edit", true);
	         return "adminQAForm";
	     }


	     @RequestMapping(value = { "/edit-{id}-qa" }, method = RequestMethod.POST)
	     public String updateQA(@Valid QA qa, BindingResult result,
	             ModelMap model, @PathVariable int id) {   
	         /*if (result.hasErrors()) {
	             return "adminQAForm";
	         }
	         if(!qaService.isQAUnique(qa.getQuestion(), qa.getAnswer())){
	             FieldError answerError =new FieldError("qa","answer",messageSource.getMessage("non.unique.ssn", new String[]{qa.getAnswer()}, Locale.getDefault()));
	             result.addError(answerError);
	             return "adminQAForm";
	         }*/System.out.println(qa);
	   	         qaService.updateQA(qa);

	         model.addAttribute("success", "Question " + qa.getQuestion()+" "+qa.getAnswer()  + " updated successfully");

	         return "adminQASuccess";

	     }


	     

	///////////////
	
	
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
	 @RequestMapping(value = { "/edit-{id}-person" }, method = RequestMethod.GET)
     public String editPerson(@PathVariable int id, ModelMap model) {
         Person person = personService.getPersonById(id);
         model.addAttribute("person", person);
         System.out.println("get into edit person information "+id);
         //model.addAttribute("edit", true);
         return "FacePersonForm";
     }


     @RequestMapping(value = { "/edit-{id}-person" }, method = RequestMethod.POST)
     public String updatePerson(@Valid Person person, BindingResult result,
             ModelMap model, @PathVariable int id) {   
         /*if (result.hasErrors()) {
             return "adminQAForm";
         }
         if(!qaService.isQAUnique(qa.getQuestion(), qa.getAnswer())){
             FieldError answerError =new FieldError("qa","answer",messageSource.getMessage("non.unique.ssn", new String[]{qa.getAnswer()}, Locale.getDefault()));
             result.addError(answerError);
             return "adminQAForm";
         }*/System.out.println(person);
   	         personService.updatePerson(person);

         

         return "FaceHome";

     }
	
	
	
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
				return "FaceHome";
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
	
	
	
	@Autowired
	DonationService donationService;

	@RequestMapping(value = "/FaceManageDonation", method = RequestMethod.GET)
	public String FaceShowDonation(ModelMap model) {
		System.out.println("FaceShowDonation");
		List donations = donationService.getDonations();
		model.addAttribute("Donations", donations);
		System.out.println(donations);

		return "FaceShowDonation";
	}
	
	@RequestMapping(value = { "/delete-{id}-donation" }, method = RequestMethod.GET)
	public String deleteDonationById(@PathVariable int id) {
		System.out.println("delete");
		donationService.deleteDonationById(id);
		return "FaceHome";
	}
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
		return "home";
	}

	@RequestMapping(value = { "/delete-{id}-jobpost" }, method = RequestMethod.GET)
	public String deleteJobPostById(@PathVariable int id) {
		System.out.println("delete one");
		jobPostService.deleteJobPostById(id);
		return "home";
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
	public String addResume(Resume resume, int model, HttpSession session) {
		////
		
		
		
		String u=(String)session.getAttribute("Name");
		System.out.println(u);
		System.out.println("model= " + model);
		JobPost j=jobpostDao.getJobPosterById(model);
		String n=j.getPostername();
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
		r.setPostername(n);

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

}