package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Results;
import com.classes.Student;
import com.connection.ResultsUtil;



/**
 * Servlet implementation class editResult
 */
@WebServlet("/editResult")
public class editResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
				
	
		
		  String stid=request.getParameter("Stid");
		   String subject=request.getParameter("Subject");
		   String mark=request.getParameter("mark");
		   
		   double marks=Double.parseDouble(mark);
		   double total=ResultsUtil.SelectTotal(stid);
		   boolean isTrue;
		   isTrue=ResultsUtil.updateResults(stid, subject, marks);
		   
		   if(isTrue==true) {
			   RequestDispatcher dis = request.getRequestDispatcher("success.jsp");//pass control to view 
				
				dis.forward(request, response);
		   }
		   else {
			   RequestDispatcher dis2 = request.getRequestDispatcher("usuccess.jsp");//pass control to view 
				
				dis2.forward(request, response);
		   }
			
		
			
			
	}
}


