package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testproduct1")
public class Product {

	@Id
	@Column(name = "Productid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Productid;

	@Column(name = "type")
	private String type;

	@Column(name = "Color")
	private String color;

	@Column(name = "Location")
	private String location;

	@Column(name = "Price")
	private String price;

	
	public int getId() {
		return Productid;
	}

	public void setId(int id) {
		this.Productid = id;
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

	public String getLocation() {
		// System.out.print("getlocation"+location);
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public String toString() {

		        return "Product [Productid=" + Productid + ", Color=" + color + ", Type="
	                + type + ", Price=" + price +  ", Location=" + location +"]";
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