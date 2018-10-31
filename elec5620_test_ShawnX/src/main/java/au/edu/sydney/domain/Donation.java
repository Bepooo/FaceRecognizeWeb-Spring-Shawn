package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testdonation30")
public class Donation {

	@Id
	@Column(name = "Donationid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Donationid;

	@Column(name = "type")
	private String type;

	@Column(name = "Color")
	private String color;

	@Column(name = "Description")
	private String description;

	
	public int getId() {
		return Donationid;
	}

	public void setId(int id) {
		this.Donationid = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String toString() {

		        return "Donation [Donationid=" + Donationid + ", Color=" + color + ", Type="
	                + type + ", Description=" + description +  "]";
		    }


}