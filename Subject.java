package com.schoolmanagement.model.subject;

public class Subject {
	
	int subjectId;
	String description;
	
	public Subject() {
		
	}
	public Subject(int subjectId, String description) {
		super();
		this.subjectId = subjectId;
		this.description = description;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
