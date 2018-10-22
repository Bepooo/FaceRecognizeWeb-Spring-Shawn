package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testResume2")
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
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Company")
	private String company;

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

		        return "Resume [Resumeid=" + resumeid + ", JobPostId=" + jobpostid + ", Name="+name+", Age="+age+", Location=" + location + ", Company="
	                + company + ", Department=" + department + ", Employment Type=" + employmenttype + "]";
		    }

}
