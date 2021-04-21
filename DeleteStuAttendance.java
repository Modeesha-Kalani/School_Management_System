package com.schoolmanagement.controller.attendance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.model.attendance.attendanceDButill;

/**
 * Servlet implementation class DeleteStuAttendance
 */
@WebServlet("/DeleteStuAttendance")
public class DeleteStuAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStuAttendance() {
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
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String id = request.getParameter("ID");
		boolean isTrue;
		
		isTrue = attendanceDButill.deleteAttendance(id);
		
		if (isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Attendance Delete Succesfully !');");
			out.println("location='SelectStuUpdate.jsp'");
			out.println("</script>");
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Attendance Delete Unsuccesfully !');");
			out.println("location='SelectStuUpdate.jsp'");
			out.println("</script>");
		}
	}

}
