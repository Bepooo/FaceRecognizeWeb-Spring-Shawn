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
import au.edu.sydney.dao.JobSeekerDao;
import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.dao.AdminDao;
import au.edu.sydney.dao.AnnouncementDao;
import au.edu.sydney.dao.ClothesDao;
import au.edu.sydney.dao.DonationDao;
import au.edu.sydney.dao.ResumeDao;
import au.edu.sydney.dao.ShoppingassistDao;
import au.edu.sydney.domain.Admin;
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
import au.edu.sydney.service.AdminService;
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


@Controller
@Transactional
@SessionAttributes("login")
public class AdminController {
	public int JobPostid,LargestAnnouncementid;


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
	public String WriteNewAnnouncement(Announcement announcement, HttpServletRequest request) {
		announcementDao.deleteAnnouncement();
		Announcement f = new Announcement();


		f.setContent(announcement.getContent());


		announcementDao.saveAnnouncement(f);
		System.out.print(announcement.getContent());
		return "redirect:" + request.getHeader("Referer");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//Login
	@RequestMapping(value = "/AdminLoginForm", method = RequestMethod.GET)
	public ModelAndView LoginForm() {
		return new ModelAndView("adminLoginForm", "login", new Admin());
	}
	
	@ModelAttribute("Admin")
	public Admin getUser(){
		return new Admin();
	}
	@Autowired
	AdminService adminService;
	@RequestMapping(value="/AdminLogin",method = RequestMethod.POST) 
	public ModelAndView validateUsr(@ModelAttribute("Admin") Admin admin,HttpServletRequest request,ModelMap model,Model theModel,BindingResult result,HttpSession session) 
			throws ServletException, IOException{

        String msg = "";///////////////////////////////////////
        boolean isValid =false;
		if(admin !=null){
			isValid = true;
	        logger.info("Is user valid?= " + isValid);
	        
	        String[] limits=new String[2]; 
			limits[0]=admin.getEmail();
			limits[1]=admin.getPassword();
			admin=adminService.getAdminByQuery(limits);
			System.out.println(admin);
			String name = admin.getName();
			System.out.println(name);
			session.setAttribute("Name", name);


			//return new ModelAndView("adminViewAllJobPosts","msg",msg);
			return new ModelAndView("redirect:/adminHome");
		}else {
			msg ="Invaild";
			return new ModelAndView("adminLoginForm","msg",msg);
		}
	}
	
	
	
	

	@Autowired
	
	AdminDao adminDao;
	@RequestMapping(value = "/adminRegisterForm", method = RequestMethod.GET)
	public ModelAndView RegisterForm() {
		return new ModelAndView("adminRegisterForm", "register", new Admin());
	}
	
	
	@RequestMapping(value = "/AdminRegister", method = RequestMethod.POST)
	public String Register(Admin admin) {
		System.out.println("get into register");
		Admin f = new Admin();


		f.setName(admin.getName());
		f.setEmail(admin.getEmail());
		f.setPassword(admin.getPassword());
		
		adminDao.saveAdmin(f);
		System.out.print(admin.getName());
		System.out.print(admin.getEmail());
		System.out.print(admin.getPassword());
		return "adminLoginForm";
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
	  
	         System.out.println(qa);
	   	         qaService.updateQA(qa);

	         model.addAttribute("success", "Question " + qa.getQuestion()+" "+qa.getAnswer()  + " updated successfully");

	         return "adminQASuccess";

	     }



  

}
