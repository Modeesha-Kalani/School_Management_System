package com.connection;

import java.sql.Connection;





import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classes.RegistrationDetails;

import com.connection.DBconnection;
import com.classes.Question;
import com.classes.Exam;



public class ExamsDBUtil {
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	private static boolean isSuccess;
	private static String QuestionID;
	
	
	/*Add registration details to the database*/	
	
	//boolean value return the success or unsucess status to the servlet from the dbutil	
	public static boolean insertregistrationdetails(String StudentId,String Email, String Date)//create parameters to catch the values pass from the servlet
		{
		    	
		    	boolean isSuccess = false;
		    	
		    try {
		    		
		    		con = DBconnection.getConnection();//call dbconnection class
		    		stmt = con.createStatement();
		    	    String sql = "insert into kanampella_junior.registration values ('"+StudentId+"','"+Email+"','"+Date+"')";
		    		int rs = stmt.executeUpdate(sql);
		   
		    		if(rs > 0) 
		    		{
		    			isSuccess = true;//data is added to the database
		    		}
		    		else 
		    		{
		    			isSuccess = false;//data is not added to the database
		    		}
		    		
		    	}
		    	catch (Exception e) {
		    		e.printStackTrace();
		    	}
		 	
		    	return isSuccess;//to return the success unsuccess status of the sql statment through the insertcustomerdetails methode
		}


/*Display registration details from the database*/


//static methode use here to directly access the class
public static List <RegistrationDetails>getregistrationDetails(){

	
	ArrayList<RegistrationDetails> reglist = new ArrayList<>();//create an array list

	try {
			con = DBconnection.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from kanampella_junior.registration";
			ResultSet rs= stmt.executeQuery(sql);

			while(rs.next()) {
				String studentId = rs.getString(1);//Column Index
				String email = rs.getString(2);  
				String date = rs.getString(3);
				
	
				RegistrationDetails r1 = new RegistrationDetails(studentId, email, date);//add colums to the constructor
				reglist.add(r1);//pass the registrationdetails object values to the arraylist variable
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return reglist;

	}

/*Add new quetion papers to the database*/	

//boolean value return the success or unsucess status to the servlet from the dbutil	
public static boolean insertquestions(String QuestionID, String Question_Statement, 
String Option_1,String Option_2, String Option_3, String Option_4,String Answer )//create parameters to catch the values pass from the servlet
	{
	    	
	    	boolean isSuccess = false;
	    	
	    try {
	    
	    		con = DBconnection.getConnection();//call dbconnection class
	    		stmt = con.createStatement();
	    	    String sql = "insert into kanampella_junior.question_details values ('"+QuestionID+"','"+Question_Statement+"','"+Option_1+"','"+Option_2 +"', '"+Option_3+"','"+Option_4+"','"+Answer+"')";
	    		int rs = stmt.executeUpdate(sql);
	   
	    		if(rs > 0) 
	    		{
	    			isSuccess = true;//data is added to the database
	    		}
	    		else 
	    		{
	    			isSuccess = false;//data is not added to the database
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;//to return the success unsuccess status of the sql statment through the insertcustomerdetails methode
	}


/*Display Question details from the database*/


//static methode use here to directly access the class
public static List <Question>questionDetails(){

	
	ArrayList<Question> queslist = new ArrayList<>();//create an array list

	try {
			con = DBconnection.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from kanampella_junior.question_details";
			ResultSet rs= stmt.executeQuery(sql);

			while(rs.next()) {
				String questionID = rs.getString(1);//Column Index
				String question_Statement = rs.getString(2);  
				String option_1 = rs.getString(3);
				String option_2 = rs.getString(4);
				String option_3 = rs.getString(5);
				String option_4 = rs.getString(6);
				String answer = rs.getString(7);
				
				
				
	
				Question q1 = new Question(questionID, question_Statement, option_1, option_2, option_3, option_4, answer);//add colums to the constructor
				queslist.add(q1);//pass the customer object values to the arraylist variable
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return queslist;

	}

/*update registration form  from the database*/
public static boolean updateregistrationdetails(String StudentID,String Email)//create the update methode
{
	
	boolean isSuccess = false;
	
	try {
		
		con = DBconnection.getConnection();
		stmt = con.createStatement();
	    String sql = "UPDATE kanampella_junior.registration SET Email = ('"+Email+"') WHERE StudentID = '"+StudentID+"'";
		int rs = stmt.executeUpdate(sql);

		if(rs > 0) 
		{
			isSuccess = true;
		}
		else 
		{
			isSuccess = false;
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
	
	
}


/*update Question Details from the database*/
public static boolean updatequestiondetails(String QuestionID,String Question_Statement, String Option_1,String Option_2, String Option_3,String Option_4,String Answer)//create the update methode
{
	
	boolean isSuccess = false;
	
	try {
		
		con = DBconnection.getConnection();
		stmt = con.createStatement();
	    String sql = "UPDATE from kanampella_junior.question_details SET Question_Statement = ('"+Question_Statement+"'), Option_1 = ('"+Option_1+"'), Option_2 = ('"+Option_2+"'), Option_3 = ('"+Option_3+"'), Option_4 = ('"+Option_4+"'), Answer = ('"+Answer+"') WHERE QuestionID = '"+QuestionID+"'";
		int rs = stmt.executeUpdate(sql);

		if(rs > 0) 
		{
			isSuccess = true;
		}
		else 
		{
			isSuccess = false;
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
	
	
}



/*Delete Questions from the database*/	
public static boolean deletequestion(String QuestionID)//declare the methode
{
	
 	boolean isSuccess = false;
	
	try {
		
		//create connection
		con = DBconnection.getConnection();
		stmt = con.createStatement();
		String sql = "delete from  kanampella_junior.question_details WHERE QuestionID = '"+QuestionID+"'";
		int rs = stmt.executeUpdate(sql);

		if(rs > 0) 
		{
			isSuccess = true;
		}
		else 
		{
			isSuccess = false;
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}

/*Add new Exam papers to the database*/	

//boolean value return the success or unsucess status to the servlet from the dbutil	
public static boolean insertexams(String ExamID,Integer Total_Questions, Integer Marks, String SubjectID )//create parameters to catch the values pass from the servlet
	{
	    	
	    	boolean isSuccess = false;
	    	
	    try {
	    
	    		con = DBconnection.getConnection();//call dbconnection class
	    		stmt = con.createStatement();
	    	    String sql = "insert into kanampella_junior.exam values ('"+ExamID+"','"+Total_Questions+"','"+Marks+"','"+SubjectID +"')";
	    		int rs = stmt.executeUpdate(sql);
	   
	    		if(rs > 0) 
	    		{
	    			isSuccess = true;//data is added to the database
	    		}
	    		else 
	    		{
	    			isSuccess = false;//data is not added to the database
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;//to return the success unsuccess status of the sql statment through the insertcustomerdetails methode
	}


/*Display Exam details from the database*/


//static methode use here to directly access the class
public static List <Exam>examDetails(){

	
	ArrayList<Exam> examlist = new ArrayList<>();//create an array list

	try {
			con = DBconnection.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from kanampella_junior.exam";
			ResultSet rs= stmt.executeQuery(sql);

			while(rs.next()) {
				String examID = rs.getString(1);//Column Index
				int total_Question = rs.getInt(2);  
				int marks = rs.getInt(3); 
				String subjectID = rs.getString(4);
				
				
	
				Exam e1 = new Exam(examID, total_Question, marks, subjectID);//add colums to the constructor
				examlist.add(e1);//pass the customer object values to the arraylist variable
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return examlist;

	}
/*Display a searched customers details from the database*/


public static List <Exam>searchexamDetails(String ExamID){


	
	ArrayList<Exam> exlist = new ArrayList<>();//create an array list

	try {
			con = DBconnection.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from kanampella_junior.exam WHERE ExamID = '"+ExamID+"' ";
			ResultSet rs= stmt.executeQuery(sql);

			while(rs.next()) {
				String examID = rs.getString(1);
				int total_Question = rs.getInt(2);
				int  marks = rs.getInt(3);
				String subjectID = rs.getString(4);
				
				
	
				Exam e2 = new Exam(examID, total_Question, marks, subjectID);
				exlist.add(e2);//pass the customer object to the arraylist variable
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return exlist;

	}

}