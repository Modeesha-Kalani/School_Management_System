package com.schoolmanagement.controller.attendance;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmanagement.model.attendance.Student;
import com.schoolmanagement.model.attendance.attendanceDButill;

/**
 * Servlet implementation class viewRegisterServlet
 */
@WebServlet("/ViewStuRegisterServlet")
public class ViewStuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStuRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grade=request.getParameter("grade");
		String className=request.getParameter("className");
		
		try{	
			List<Student> stuDetails = attendanceDButill.getstudentDetails(grade,className);
			request.setAttribute("stuDetails", stuDetails); 
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			RequestDispatcher dis = request.getRequestDispatcher("StuAtRegister.jsp");
			dis.forward(request, response);
		
		
	}
	

}
