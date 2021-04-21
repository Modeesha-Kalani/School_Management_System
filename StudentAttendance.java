package com.schoolmanagement.model.attendance;

public class StudentAttendance extends Attendance {

	private int stuid;
	private String FullName;
	
	public StudentAttendance(int id, String attendance, String date, int stuid, String FullName) {
		super(id, attendance, date);
		this.stuid = stuid;
		this.FullName = FullName;
	}

	public int getStuid() {
		return stuid;
	}


	public String getStudentName() {
		return FullName;
	}

}
