package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Exam;
import com.connection.ExamsDBUtil;


@WebServlet("/ListExamservlet")
public class ListExamservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Exam> examDetails = ExamsDBUtil.examDetails();//create an object to call the methode created in dbutil
			request.setAttribute("exDetails", examDetails);//set an attribute to get the details in the servlet and pass it to the jsp file
			
			
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("ListExamDetails.jsp");
		
		dis.forward(request, response);
	
	}

	

}
