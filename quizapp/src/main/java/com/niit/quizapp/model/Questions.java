package com.niit.quizapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue
	@Column(name = "ques_id")
	private Long questionId;

	/*@Column(name = "lang_id")
	private Long languageId;*/

	@Column(name = "question")
	private String question;

	@Column(name = "right_option")
	private Long rightOption;
	
	 private String option1;
	   
	   private String option2;
	   
	   private String option3;
	   
	   private String option4;
	   
	   @Column(name = "lang_name")
		private String languageName;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	/*public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getLanguageId() {
		return languageId;
	}
*/
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setRightOption(Long rightOption) {
		this.rightOption = rightOption;
	}

	public Long getRightOption() {
		return rightOption;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}
}
