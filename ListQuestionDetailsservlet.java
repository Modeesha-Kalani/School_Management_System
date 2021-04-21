package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Question;
import com.connection.ExamsDBUtil;


@WebServlet("/ListQuestionDetailsservlet")
public class ListQuestionDetailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Question> questionDetails = ExamsDBUtil.questionDetails();//create an object to call the methode created in dbutil
			request.setAttribute("quesDetails", questionDetails);//set an attribute to get the details in the servlet and pass it to the jsp file
			
			
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("ListQuestionDetails.jsp");
		
		dis.forward(request, response);
	
	}

}
