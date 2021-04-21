package com.classes;

public class Question {

	String QuestionID;
	String Question_Statement;
	String Option_1;
	String Option_2;
	String Option_3;
	String Option_4;
	String Answer;
	public String getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(String questionID) {
		QuestionID = questionID;
	}
	public String getQuestion_Statement() {
		return Question_Statement;
	}
	public void setQuestion_Statement(String question_Statement) {
		Question_Statement = question_Statement;
	}
	public String getOption_1() {
		return Option_1;
	}
	public void setOption_1(String option_1) {
		Option_1 = option_1;
	}
	public String getOption_2() {
		return Option_2;
	}
	public void setOption_2(String option_2) {
		Option_2 = option_2;
	}
	public String getOption_3() {
		return Option_3;
	}
	public void setOption_3(String option_3) {
		Option_3 = option_3;
	}
	public String getOption_4() {
		return Option_4;
	}
	public void setOption_4(String option_4) {
		Option_4 = option_4;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public Question(String questionID, String question_Statement, String option_1, String option_2, String option_3,
			String option_4, String answer) {
		super();
		QuestionID = questionID;
		Question_Statement = question_Statement;
		Option_1 = option_1;
		Option_2 = option_2;
		Option_3 = option_3;
		Option_4 = option_4;
		Answer = answer;
	}
	
	
	
}
