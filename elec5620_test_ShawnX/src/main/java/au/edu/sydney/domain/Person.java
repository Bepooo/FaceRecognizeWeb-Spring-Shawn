package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testperson2")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;
    
    @Column(name = "gender")
    private  String gender;
    
  /*  //@Column(name = "facetoken")
    public  String facetoken;*/
    
    @Column(name = "facebase64")
    private  String base;
    
    @Column(name = "favor")
	private String favor;

    @Column(name = "height")
	private String height;

    @Column(name = "faceto")
	private String faceto;

    @Column(name = "advice")
	private String advice;
    
    @Column(name = "phonenumber")
	private String phonenumber;
    
    @Column(name = "email")
	private String email;

    @Column(name = "facety")
	private String facety;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*public  String getFaceToken() {
        return facetoken;
    }

    public void setFaceToken(String facetoken) {
        this.facetoken = facetoken;
    }*/
    
    public  String getFaceto() {
        return faceto;
    }

    public void setFaceto(String faceto) {
        this.faceto = faceto;
    }
    
    public  String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }
    public  String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    public  String getFaceTy() {
        return facety;
    }

    public void setFaceTy(String facety) {
        this.facety = facety;
    }
    
    public  String getBase() {
        return base;
    }

    public void setBase(String aaa) {
        this.base = base;
    }
    
    public  String getAdvice() {
        return advice;
    }
    
	public void setAdvice(String advice) {
		// TODO Auto-generated method stub
		this.advice = advice;
		
	}
    public String toString() {

        return "Person [Id=" + id + ", First=" + first + ", Last="
            + last + ", Age="+age+", Gender=" + gender + ", FaceToken=" 
        		+ faceto + ", Favor="+favor+", Height="+height+" ,FaceType="+facety+", Advice="+advice+"]";
    }
   
}