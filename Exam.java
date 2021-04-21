package com.classes;

public class Exam {

	String ExamID;
	Integer Total_Question;
	Integer Marks;
	String SubjectID;
	public String getExamID() {
		return ExamID;
	}
	public void setExamID(String examID) {
		ExamID = examID;
	}
	public Integer getTotal_Question() {
		return Total_Question;
	}
	public void setTotal_Question(Integer total_Question) {
		Total_Question = total_Question;
	}
	public Integer getMarks() {
		return Marks;
	}
	public void setMarks(Integer marks) {
		Marks = marks;
	}
	public String getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(String subjectID) {
		SubjectID = subjectID;
	}
	public Exam(String examID, Integer total_Question, Integer marks, String subjectID) {
		super();
		ExamID = examID;
		Total_Question = total_Question;
		Marks = marks;
		SubjectID = subjectID;
	}
	
	
}
