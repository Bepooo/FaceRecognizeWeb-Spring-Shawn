package au.edu.sydney;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import au.edu.sydney.dao.PersonDao;
import au.edu.sydney.domain.JobPost;
import au.edu.sydney.domain.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

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

	@RequestMapping(value = "/jdbcAdd", method = RequestMethod.GET)
	public String jdbcAdd(Locale locale, Model model) {

		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// String DB_URL = "jdbc:mysql://localhost/elec5619";
		String DB_URL = "jdbc:mysql://localhost/elec5619?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		// Database credentials
		String USER = "root"; //
		String PASS = "123456";

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String insertTableSQL = "INSERT INTO employee (id, age, first, last) VALUES (?,?,?,?)";

			preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, 2);
			preparedStatement.setInt(2, 25);
			preparedStatement.setString(3, "Test");
			preparedStatement.setString(4, "Name");

			// execute insert SQL statement
			preparedStatement.executeUpdate();
			System.out.println("Record is inserted into employee table!");

			// Clean-up environment
			preparedStatement.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return "home";
	}

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "/hibernateAdd", method = RequestMethod.GET)
	public String hibernateAdd(Locale locale, Model model) {

		Person p = new Person();
		p.setAge(20);
		p.setFirst("FirstName");
		p.setLast("lastName");

		sessionFactory.getCurrentSession().save(p);
		return "home";
	}

	@Autowired
	PersonDao personDao;

	@RequestMapping(value = "/hibernateDaoAdd", method = RequestMethod.GET)
	public String hibernateDaoAdd(Locale locale, Model model) {
		Person p = new Person();
		p.setAge(20);
		p.setFirst("FirstName");
		p.setLast("lastName");

		personDao.savePerson(p);

		return "home";
	}

	@RequestMapping(value = "/JobPostHome", method = RequestMethod.GET)
	public ModelAndView showFormJP() {
		return new ModelAndView("JobPostHome", "jobpost", new JobPost());
	}

	@RequestMapping(value = "/addJobPost", method = RequestMethod.POST)
	public String submitJP(@Valid @ModelAttribute("jobpost") JobPost jobpost, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		System.out.println(jobpost.getLocation());
		System.out.println(jobpost.getDepartment());
		System.out.println(jobpost.getPosition());
		System.out.println(jobpost.getEmploymenttype());
		System.out.println(jobpost.getJobdescription());
		System.out.println(jobpost.getRequirements());
		/*
		 * System.out.println(jobpost.getContactNumber());
		 * System.out.println(jobpost.getId());
		 */
		model.addAttribute("company", jobpost.getCompany());
		model.addAttribute("department", jobpost.getDepartment());
		model.addAttribute("position", jobpost.getPosition());
		model.addAttribute("employmenttype", jobpost.getEmploymenttype());
		model.addAttribute("jobdescription", jobpost.getJobdescription());
		model.addAttribute("requirements", jobpost.getRequirements());
		/*
		 * model.addAttribute("contactNumber", jobpost.getContactNumber());
		 * model.addAttribute("id", jobpost.getId());
		 */
		return "JobPostConfirm";
	}

}
