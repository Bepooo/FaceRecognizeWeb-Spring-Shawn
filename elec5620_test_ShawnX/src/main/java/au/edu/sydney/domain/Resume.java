package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testResume1")
public class Resume {

	@Id
	@Column(name = "ResumeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ResumeId;

	@Column(name = "Time")
	private String time;

	@Column(name = "JobPostId")
	private int JobPostId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "age")
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
		return ResumeId;
	}

	public void setId(int id) {
		this.ResumeId = ResumeId;
	}
	
	public int getJobPostId() {
		return ResumeId;
	}

	public void setJobPostId(int id) {
		this.JobPostId = JobPostId;
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

	public String getNamen() {
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

		        return "Resume [Resumeid=" + ResumeId + ", Name="+name+", Age"+age+", Location=" + location + ", Company="
	                + company + ", Department=" + department + ", Employment Type=" + employmenttype + "]";
		    }

}
