package com.classes;

public class RegistrationDetails {
	private String StudentId;
	private String Email;
	private String Date;
	
	public RegistrationDetails(String studentId, String email, String date) {
		super();
		StudentId = studentId;
		Email = email;
		Date = date;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
	
	
	
	

}
