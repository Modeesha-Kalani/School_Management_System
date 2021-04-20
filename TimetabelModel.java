package com.schoolmanagement.model.timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.schoolmanagement.model.DataAccess;

public class TimetabelModel {
	
	public static int addTimeTabelData(Timetable timetable) {
			int i =0;
			
			Connection con = DataAccess.connect();
			String sql = "INSERT INTO Time_Table VALUES (?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1, timetable.getTimeTableId());
				ps.setString(2, timetable.getSection());
				ps.setString(3, timetable.getGrade());
				ps.setString(4, timetable.getUserClass());
				
				i = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
	}
	
	public static Timetable getMaxId() {
		String sql = "select max(idTime_Table) as max from Time_Table";
		Connection con = DataAccess.connect();

		// preparedStatemen
		PreparedStatement ps = null;

		// result set
		ResultSet rs = null;
		Timetable time = new Timetable();

		try {
			ps = con.prepareStatement(sql);
			rs = (ResultSet) ps.executeQuery();

			if (rs.first()) {
				time.setTimeTableId(rs.getInt("max"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return time;
	}
	
	public static int addSubject(int timetableID, String period,String teacher,String subject,String day) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into Time_Table_has_Subject values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, timetableID);
			ps.setString(2, subject);
			ps.setString(3, teacher);
			ps.setString(4, period);
			ps.setString(5, day);
			
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
	
	
	public static ArrayList<Timetable> retrieveAllTimetable(){
		ArrayList<Timetable> timetable = new ArrayList<>();
		Timetable time = null;
		
		Connection con = DataAccess.connect();
		String sql = "select * from Time_Table";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				time = new Timetable();
				
				time.setTimeTableId(resultset.getInt("idTime_Table"));
				time.setSection(resultset.getString("section"));
				time.setGrade(resultset.getString("grade"));
				time.setUserClass(resultset.getString("class"));
				
				timetable.add(time);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return timetable;
		
	}
	
	public static boolean deleteTimetable(int id) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from Time_Table where idTime_Table=?";
		String sqlUpdate_timeTable = "delete from Time_Table_has_Subject where Time_Table_idTime_Table=?";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			PreparedStatement psUpdateTimetable= (PreparedStatement)connection.prepareStatement(sqlUpdate_timeTable);
			
			psUpdate.setInt(1, id);
			psUpdateTimetable.setInt(1, id);
			
			psUpdate.executeUpdate();
			psUpdateTimetable.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return true;
	}
	

}
