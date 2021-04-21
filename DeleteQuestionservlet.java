package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ExamsDBUtil;

@WebServlet("/DeleteQuestionservlet")
public class DeleteQuestionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String QuestionID = request.getParameter("qid");
		
		boolean isTrue;
		
		isTrue = ExamsDBUtil.deletequestion(QuestionID);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ListQuestionDetails.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/views/Unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
