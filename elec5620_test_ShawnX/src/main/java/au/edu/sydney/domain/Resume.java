package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testResume30")
public class Resume {

	@Id
	@Column(name = "ResumeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resumeid;

	@Column(name = "Time")
	private String time;

	@Column(name = "JobPostId")
	private int jobpostid;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Postername")
	private String postername;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Capability")
	private String capability;
	
	@Column(name = "Company")
	private String company;
	
	@Column(name = "Education")
	private String education;

	@Column(name = "Department")
	private String department;

	@Column(name = "Location")
	private String location;

	@Column(name = "Position")
	private String position;

	@Column(name = "Employmenttype")
	private String employmenttype;

	@Column(name = "Jobdescription")
	private String jobdescription;

	@Column(name = "Requirements")
	private String requirements;



	public int getId() {
		return resumeid;
	}

	public void setId(int resumeid) {
		this.resumeid = resumeid;
	}
	
	public int getJobPostId() {
		return jobpostid;
	}

	public void setJobPostId(int jobpostid) {
		this.jobpostid = jobpostid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPostername() {
		return postername;
	}

	public void setPostername(String postername) {
		this.postername = postername;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		// System.out.print("getlocation"+location);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		// System.out.print("getlocation"+location);
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getLocation() {
		// System.out.print("getlocation"+location);
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String toString() {

		        return "Resume [Resumeid=" + resumeid + ", JobPostId=" + jobpostid + ", Username="+username+", Postername="+postername+", Name="+name+", Age="+age+", Gender="+gender+", Education="+education+", Capability="+capability+", Location=" + location + ", Company="
	                + company + ", Department=" + department + ", Employment Type=" + employmenttype + ", Job description="+jobdescription+"]";
		    }

}
