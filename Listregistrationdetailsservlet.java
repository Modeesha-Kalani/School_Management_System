package com.servlets;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.RegistrationDetails;
import com.connection.ExamsDBUtil;


@WebServlet("/Listregistrationdetailsservlet")
public class Listregistrationdetailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<RegistrationDetails> RegistrationDetails = ExamsDBUtil.getregistrationDetails();//create an object to call the methode created in dbutil
			request.setAttribute("regDetails", RegistrationDetails);//set an attribute to get the details in the servlet and pass it to the jsp file
			
			
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("ListRegistrationDetails.jsp");
		
		dis.forward(request, response);
	}
}
