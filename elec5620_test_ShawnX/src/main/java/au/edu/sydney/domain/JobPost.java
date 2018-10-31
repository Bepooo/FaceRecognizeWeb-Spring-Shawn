package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testjobpost30")
public class JobPost {

	@Id
	@Column(name = "JobPostid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobPostid;

	@Column(name = "Postername")
	private String postername;
	
	@Column(name = "age")
	private int age;

	@Column(name = "Time")
	private String time;

	@Column(name = "Company")
	private String company;

	@Column(name = "Department")
	private String department;

	@Column(name = "Location")
	private String location;

	@Column(name = "Position")
	private String position;

	@Column(name = "employmenttype")
	private String employmenttype;

	@Column(name = "Jobdescription")
	private String jobdescription;

	@Column(name = "Requirements")
	private String requirements;

	

	public int getId() {
		return jobPostid;
	}

	public void setId(int jobPostid) {
		this.jobPostid = jobPostid;
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
	
	public String getPostername() {
		// System.out.print("getlocation"+location);
		return postername;
	}

	public void setPostername(String postername) {
		this.postername = postername;
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

		        return "JobPost [JobPostid=" + jobPostid + ", Location=" + location + ", Company="
	                + company + ", Department=" + department + ", Employment Type=" + employmenttype + ", Requirements="+requirements+", Position="+position+"]";
		    }

}
/*
 * public String toString() { return "jobpost(Location: " + this.location + ")";
 * }
 */

/*
 * public long getId() { return id; }
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * public String getContent() { return content; }
 * 
 * public void setContent(String content) { this.content = content; }
 */