package com.schoolmanagement.model.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.schoolmanagement.model.DataAccess;
import com.schoolmanagement.model.sports.Sports;

public class SubjectModel {
	
	public static int registerSubject(Subject subject) {
		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "INSERT INTO `Subject`(`description`) VALUES (?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, subject.getDescription());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static ArrayList<Subject> retrieveAllSubject(){
		ArrayList<Subject> subjects = new ArrayList<>();
		Subject subject = null;
		
		Connection con = DataAccess.connect();
		String sql = "select * from Subject";
		
		try { 
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				subject = new Subject();
				
				subject.setSubjectId(resultset.getInt("idSubject"));
				subject.setDescription(resultset.getString("description"));
				 
			
				subjects.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return subjects;
		
	}
	
	public static boolean deleteSubject(int id) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from Subject where idSubject=?";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, id);
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return true;
	}
	
	
	public static int updateSubjectData(Subject sp) {
		Connection connection = DataAccess.connect();
		int i = 0;
		String sql = "UPDATE Subject SET description=? WHERE idSubject=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, sp.getDescription());
			ps.setInt(2, sp.getSubjectId());
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return i;
	}

}
