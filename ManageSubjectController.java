package com.studentmanagement.controller.subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.schoolmanagement.model.subject.Subject;
import com.schoolmanagement.model.subject.SubjectModel;

/**
 * Servlet implementation class ManageSubjectController
 */
@WebServlet("/ManageSubjectController")
public class ManageSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSubjectController() {
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
		response.setContentType("application/json");
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("get")) {
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			ArrayList<Subject> subject = SubjectModel.retrieveAllSubject();
			out.print(json.toJson(subject));
			out.flush();
			out.close();			
		}else if(action.equalsIgnoreCase("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			boolean state = SubjectModel.deleteSubject(id);
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(state));
			out.flush();
			out.close();
			
		}else if(action.equalsIgnoreCase("update")) {
			
			Subject s = new Subject();
			
			s.setSubjectId(Integer.parseInt(request.getParameter("id")));
			s.setDescription(request.getParameter("subjectName"));
			
			
			int status = SubjectModel.updateSubjectData(s);
			boolean responseStatus = true;
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			
			if(status!= 0) {
				System.out.println("Succesfully updated!");
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}else {
				System.out.println("Error in update!");
				responseStatus = false;
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}
				
			
			
			
			
		}
	}

}
