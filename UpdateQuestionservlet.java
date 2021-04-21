package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ExamsDBUtil;


@WebServlet("/UpdateQuestionservlet")
public class UpdateQuestionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String QuestionID = request.getParameter("qid");
		String Question_Statement = request.getParameter("qstatement");
		String Option_1= request.getParameter("op1");
		String Option_2= request.getParameter("op2");
		String Option_3= request.getParameter("op3");
		String Option_4= request.getParameter("op4");
		String Answer = request.getParameter("answer");
		
		boolean isTrue;
		
		isTrue = ExamsDBUtil.updatequestiondetails(QuestionID,Question_Statement,Option_1, Option_2, Option_3, Option_4,Answer );//call the methode
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ListQuestionDetails.jsp");//navigate to the jsp file from the servlet
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/views/Unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
