package au.edu.sydney.domain;

public class JobPost {

	// private long id;
	/*
	 * public String location, company, department, position, employmenttype,
	 * jobdescription, requirements
	 */

	private String name;
	private String location;
	private long id;
	private String company, department, position, employmenttype, jobdescription, requirements;

	public String getLocation() {
		// System.out.print("getlocation"+location);
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * public Long getId() { //System.out.print("getlocation"+location); return id;
	 * } public void setId(Long id) { this.id = id; }
	 */

	/*
	 * public String getContactNumber() {
	 * //System.out.print("getlocation"+location); return contactNumber; } public
	 * void setContactNumber(String contactNumber) { this.contactNumber =
	 * contactNumber; }
	 */
	// standard getters and setters

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