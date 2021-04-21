package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ResultsUtil;

/**
 * Servlet implementation class addProgress
 */
@WebServlet("/addProgress")
public class addProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String progress=request.getParameter("Remark");
		String teacher_Id=request.getParameter("teacherId");
		String sid=request.getParameter("stId");
		
		boolean isTrue;
		  isTrue=ResultsUtil.AddRemark(sid,progress,teacher_Id);
	    if(isTrue==true) {
			//navigate to jsp the path
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");//pass control to view 
			
			dis.forward(request, response);
		}else {
		
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			
			
		}
		
	}

}
