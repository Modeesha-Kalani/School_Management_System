import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.schoolmanagement.model.DataAccess;
import com.schoolmanagement.model.sports.Sports;

public class AssociatonModel {
	
	public static int registerAssociation(Association association) {
		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "INSERT INTO `Association`(`name`, `Teacher_Details_idTeacher_Details`, `mem_count`) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, association.getName());
			ps.setString(2, association.getTeacherDetailsId()+"");
			ps.setString(3, association.getMemberCount());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	public static ArrayList<Association> retrieveAllAsso(){
		ArrayList<Association> asso = new ArrayList<>();
		Association association = null;
		
		Connection con = DataAccess.connect();
		String sql = "select * from Association s inner join teacher_details t on s.Teacher_Details_idTeacher_Details=t.id";
		
		try { 
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				association = new Association();
				
				association.setAccociationId(resultset.getInt("idAssociation"));
				association.setName(resultset.getString("s.name"));
				association.setTeacherDetailsId(resultset.getString("t.fullName"));
				association.setMemberCount(resultset.getString("mem_count"));
				
			
				asso.add(association);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return asso;
		
	}
	
	


	public static boolean deleteAsso(int id) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from Association where idAssociation=?";
		
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
	
	public static int updateAssociationData(Association association) {
		Connection connection = DataAccess.connect();
	int i = 0;
	String sql = "UPDATE `Association` SET `name`=?,`Teacher_Details_idTeacher_Details`=?,`mem_count`=? WHERE `idAssociation`=?";
	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, association.getName());
		ps.setString(2, association.getTeacherDetailsId());
		ps.setString(3, association.getMemberCount());
		ps.setInt(4, association.getAccociationId());
		i = ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return i; 
	}
	
}
