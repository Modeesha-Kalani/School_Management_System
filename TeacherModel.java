package com.schoolmanagement.model.teachers;

import com.schoolmanagement.model.DataAccess;
import com.schoolmanagement.model.students.Student;
import com.studentmanagement.controller.teacherDetails.teacherDetailsController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModel {
	
	public static Teacher getMaxId() {
		String sql = "select max(id) as max from teacher_details";
		Connection con = DataAccess.connect();

		// preparedStatemen
		PreparedStatement ps = null;

		// result set
		ResultSet rs = null;
		Teacher teacher = new Teacher();

		try {
			ps = con.prepareStatement(sql);
			rs = (ResultSet) ps.executeQuery();

			if (rs.first()) {
				teacher.setId(rs.getInt("max"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	public static int registerTeacher(Teacher teacher) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into teacher_details values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getFullName());
			ps.setString(3, teacher.getGender());
			ps.setString(4, teacher.getDob());
			ps.setString(5, teacher.getNic());
			ps.setString(6, teacher.getJoinDate());
			ps.setInt(7, 1);

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
	
	public static int addTeacherQualification(int teacherId, String description) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into teacher_qualification values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, null);
			ps.setString(2, description);
			ps.setInt(3, teacherId);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
	
	public static ArrayList<Teacher> retrieveAllTeachers(){
		ArrayList<Teacher> teachers = new ArrayList<>();
		Teacher teacher = null;
		
		Connection con = DataAccess.connect();
		String sql = "select * from teacher_details";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				teacher = new Teacher();
				
				teacher.setId(resultset.getInt("id"));
				teacher.setDob(resultset.getString("dob"));
				teacher.setFullName(resultset.getString("fullName"));
				teacher.setGender(resultset.getString("gender"));
				teacher.setJoinDate(resultset.getString("joinDate"));
				teacher.setNic(resultset.getString("nic"));
				teacher.setStatus(resultset.getInt("status"));
				
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return teachers;
		
	}
	
	
	public static boolean deleteTeacher(int id) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from teacher_details where id=?";
		
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
	
	
}
