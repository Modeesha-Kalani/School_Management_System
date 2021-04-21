package com.schoolmanagement.controller.attendance;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.model.attendance.attendanceDButill;

import com.schoolmanagement.model.attendance.StudentAttendance;

/**
 * Servlet implementation class ViewAttendance
 */
@WebServlet("/ViewAttendanceUpdateServlet")
public class ViewAttendanceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAttendanceUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grade=request.getParameter("grade");
		String className=request.getParameter("className");
		String date =request.getParameter("date");
		
		try{	
			List<com.schoolmanagement.model.attendance.StudentAttendance> AtDetails = attendanceDButill.viewattendance(grade,className,date);
			request.setAttribute("AtDetails", AtDetails); 
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			RequestDispatcher dis = request.getRequestDispatcher("DisplayAtUpdate.jsp");
			dis.forward(request, response);
	}

}
