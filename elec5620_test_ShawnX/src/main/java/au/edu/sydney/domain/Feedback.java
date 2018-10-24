package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback2")
public class Feedback {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    
    @Column(name = "type")
    private String type;
    
    @Column(name = "feedback")
    private String feedback;

    @Column(name = "time")
    private String time;
    
    @Column(name = "employmenttype")
    private String employmenttype;
    
    @Column(name = "location")
    private String location;

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getEmploymenttype() {
        return employmenttype;
    }

    public void getEmploymenttype(String employmenttype) {
        this.employmenttype = employmenttype;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String toString() {

        return "Feedback [Id=" + id + ", Feedback=" + feedback + ", Time="
            + time + ", type" + type+", employmenttype="+employmenttype+", location="+location+"]";
    }
}