package com.schoolmanagement.model.timetable;

public class Timetable {
	
	int timeTableId;
	String section;
	String grade;
	String userClass;
	
	public Timetable() {}
	
	public Timetable(int timeTableId, String section, String grade, String userClass) {
		super();
		this.timeTableId = timeTableId;
		this.section = section;
		this.grade = grade;
		this.userClass = userClass;
	}

	
	public int getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(int id) {
		this.timeTableId = id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	
	

}
