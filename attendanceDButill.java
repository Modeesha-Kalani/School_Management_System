package com.schoolmanagement.model.attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanagement.model.DBConnect;
 
public class attendanceDButill {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	//Display Student Register
	
	 public static List<Student> getstudentDetails(String grade,String className) {
	    	
		 	
	    	
	    	ArrayList<Student> stu = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    			
		    		String sql = "select id,FullName from student where className='"+className+"' and grade='"+grade+"'";
		    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int id = (int) rs.getFloat("id");
	    			String FullName = rs.getString("FullName");
	    			
	    			
	    			Student t = new Student(id,FullName,className,grade);
	    			stu.add(t);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return stu;	
	    }
	//Insert student attendance
	 public static boolean insertattendance(String stuid,String date ,String attendance) {
	    	
	    	
		 boolean isSuccess = false;
		 
	    	try {
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "insert into attendance values (0,'"+stuid+"','"+date+"','"+attendance+"')";
	    	    int rs = stmt.executeUpdate(sql);
	    	    
	    	    if(rs > 0) {
	    	    	isSuccess = true;
	    	    } else {
	    	    	isSuccess = false;
	    	    }			
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;
	    }
	 
	 //Update attendance
	 public static boolean UpdateAttendance(String atid,String attendance) {
		    
	
			try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "UPDATE attendance SET attendance ='"+attendance+"' WHERE id='"+atid+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	 //view attendance
	 public static List<StudentAttendance>viewattendance(String grade,String className,String date) {
	    	
		 	
	    	
	    	ArrayList<StudentAttendance> At = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		
	    			
		    		String sql = "select s.FullName,s.id,a.attendance,a.id from attendance a,student s  where s.id=a.stuid and a.date='"+date+"' and s.grade='"+grade+"' and s.className='"+className+"'";
		    		rs = stmt.executeQuery(sql);
	    		
	    		
	    		
	    		
	    		while(rs.next()) {
	    			int stuid = (int) rs.getFloat("s.id");
	    			int  attid=(int) rs.getFloat("a.id");
	    			String studentName = rs.getString("s.FullName");
	    			String attendance =rs.getString("a.attendance");
	    			
	    			
	    			
	    			StudentAttendance t = new StudentAttendance(attid,attendance,date,stuid,studentName);
	    			At.add(t);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return At;	
	    }
	 
	 //Display Teacher Register 
	 public static List<Teacher> getteacherDetails() {
	    	
		 	
	    	
	    	ArrayList<Teacher> tch = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    			
		    		String sql = "select id,fullname from teacher";
		    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int id = (int) rs.getFloat("id");
	    			String FullName = rs.getString("FullName");
	    			
	    			
	    			Teacher t = new Teacher(id,FullName);
	    			tch.add(t);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return tch;	
	    }
	 //Insert Teacher attendance
	 public static boolean insertteachattendance(String teachid,String date ,String attendance) {
	    	
	    	
		 boolean isSuccess = false;
		 
	    	try {
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "insert into teacherattendance values (0,'"+teachid+"','"+date+"','"+attendance+"')";
	    	    int rs = stmt.executeUpdate(sql);
	    	    
	    	    if(rs > 0) {
	    	    	isSuccess = true;
	    	    } else {
	    	    	isSuccess = false;
	    	    }			
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;
	    }
	 //Delete Student Attendance
	 public static boolean deleteAttendance(String id) {
	    	
	    	int convId = Integer.parseInt(id);
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "delete from attendance where id='"+convId+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
	    		if (r > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	 
	 
}
	

