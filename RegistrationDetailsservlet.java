package com.servlets;

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ExamsDBUtil;


@WebServlet("/RegistrationDetailsservlet")
public class RegistrationDetailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String StudentID = request.getParameter("sid");
		String Email = request.getParameter("semail");
		String Date = request.getParameter("date");
		
		
		boolean isTrue;
		
		isTrue = ExamsDBUtil.insertregistrationdetails(StudentID, Email, Date);//call the methode
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ListRegistrationDetails.jsp");//navigate to the jsp file from the servlet
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/views/Unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
	
}


