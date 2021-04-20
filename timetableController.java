package com.studentmanagement.controller.timetable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.schoolmanagement.model.timetable.TimetabelModel;
import com.schoolmanagement.model.timetable.Timetable;


/**
 * Servlet implementation class timetableController
 */
@WebServlet("/timetableController")
public class timetableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timetableController() {
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
		response.setContentType("application/json");
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("maxId")) {
			
			Timetable time = TimetabelModel.getMaxId();
			
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(time));
			out.flush();
			out.close();
			
		}else if(action.equalsIgnoreCase("add")){

			Timetable timetable = new Timetable();
			
			timetable.setTimeTableId(Integer.parseInt(request.getParameter("nextId")));
			timetable.setGrade(request.getParameter("gradeVal"));
			timetable.setSection(request.getParameter("sectionVal"));
			timetable.setUserClass(request.getParameter("class_text"));
			
			int status = TimetabelModel.addTimeTabelData(timetable);
			
			
			
			
			
			boolean responseStatus = true;
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			
			if(status!= 0) {
				System.out.println("Succesfully Inserted!");
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}else {
				System.out.println("Error in Insert!");
				responseStatus = false;
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}
			
		}else if(action.equalsIgnoreCase("addTimetable")) {
			
			PrintWriter out = response.getWriter();
			
			int timetable_id = Integer.parseInt(request.getParameter("id"));
			String period = request.getParameter("period");
			String teacher = request.getParameter("teacher");
			String subject = request.getParameter("subject");
			String day = request.getParameter("day");
			
			Gson json = new Gson();
			
			int state = TimetabelModel.addSubject(timetable_id,period,teacher,subject,day);
			boolean responseStatus = true;
			
			if(state!= 0) {
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}else {
				responseStatus = false;
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}
			
		}else if(action.equalsIgnoreCase("get")) {
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			ArrayList<Timetable> time = TimetabelModel.retrieveAllTimetable();
			out.print(json.toJson(time));
			out.flush();
			out.close();
			
		}else if(action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean state = TimetabelModel.deleteTimetable(id);
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(state));
			out.flush();
			out.close();
		}
		
		
		
		
		doGet(request, response);
	}

}
