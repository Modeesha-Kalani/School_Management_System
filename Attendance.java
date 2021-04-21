package com.schoolmanagement.model.attendance;

public class Attendance {

		private int id;
		private String attendance;
		private String date;
		
		public Attendance(int id,String attendance, String date) {
			
			this.id=id;
			this.attendance = attendance;
			this.date = date;
		}

		public int getId() {
			return id;
		}

		public String getAttendance() {
			return attendance;
		}

		public String getDate() {
			return date;
		}
		
		
}


