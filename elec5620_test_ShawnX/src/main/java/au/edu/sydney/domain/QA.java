package au.edu.sydney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testqa30")
public class QA{

	@Id
	@Column(name = "QAid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int QAid;


	@Column(name = "Question")
	private String question;

	@Column(name = "Answer")
	private String answer;



	
	public int getId() {
		return QAid;
	}

	public void setId(int id) {
		this.QAid = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toString() {

		        return "QA [QAid=" + QAid + ", Question=" + question + ", Answer="
	                + answer +"]";
		    }


}