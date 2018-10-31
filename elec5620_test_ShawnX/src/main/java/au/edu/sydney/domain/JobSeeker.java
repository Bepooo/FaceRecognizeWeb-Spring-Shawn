package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testJobSeeker30")
public class JobSeeker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Email")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "Name")
    private String name;
    
    @Column(name = "Qanswer")
    private String qanswer;

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getQanswer() {
        return qanswer;
    }

    public void setQanswer(String qanswer) {
        this.qanswer = qanswer;
    }
   
    public String toString() {

        return "JobSeeker [Id=" + id + ", Email=" + email + ", Password=" 
        		+ password + ", Name=" + name+", Qanswer="+qanswer+"]";
    }


}