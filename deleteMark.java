package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ResultsUtil;

/**
 * Servlet implementation class deleteMark
 */
@WebServlet("/deleteMark")
public class deleteMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
		  String stid=request.getParameter("Stid");
		   String subject=request.getParameter("Subject");
		   
		   
		   boolean isTrue;
		   isTrue=ResultsUtil.deleteResults(stid, subject);
		   
		   if(isTrue==true) {
				  
				out.println("<script type = 'text/javascript'>");
				out.println("var result= confirm(\"Confirm Delete!\")");
		        out.println("location='success.jsp'");
				
				out.println("</script>");
				
				
				
			  // RequestDispatcher dis = request.getRequestDispatcher("success.jsp");//pass control to view 
				
				//dis.forward(request, response);
		   }
		   else {
			    out.println("<script type = 'text/javascript'>");
				out.println("alert('cannot be deleted');");
				out.println("location= 'unsuceess.jsp'");
				out.println("</script>");
			  
		   }
	}

}
