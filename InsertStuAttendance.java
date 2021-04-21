package com.schoolmanagement.controller.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.model.attendance.attendanceDButill;

/**
 * Servlet implementation class InsertAttendanceServlet
 */
@WebServlet("/InsertStuAttendance")
public class InsertStuAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStuAttendance() {
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
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int count =  Integer.parseInt(request.getParameter("count"));
		
		String[] att2=new String[count];
		String[] stuid2=  new String[count];
		String[] date2=new String[count];
		int i;
		for(i=0;i<count;i++)
		{
			stuid2[i]=request.getParameter("stuid"+i);
			att2[i]=request.getParameter("attendance"+i);
			date2[i]=request.getParameter("date");
		}
		
		boolean isTrue = false;
		for(int a=0;a<count;a++)
		{
		isTrue =attendanceDButill.insertattendance(stuid2[a],date2[a],att2[a]);
		}
		
//		System.out.println(stuid2 +" Count " +count);
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Attendance Mark Succesfully !');");
			out.println("location='SelectStuRegister.jsp'");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Attendance Mark UnSucces!');");
			out.println("location='SelectStuRegister.jsp'");
			out.println("</script>");
		}
	}

}
