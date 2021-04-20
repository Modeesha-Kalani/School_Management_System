import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.schoolmanagement.model.students.Student;
import com.schoolmanagement.model.students.StudentModel;
import com.schoolmanagement.model.teacherDetails.TeacherModel;

/**
 * Servlet implementation class ManageStudentController
 */
@WebServlet("/ManageStudentController")
public class ManageStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStudentController() {
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
		
		if(action.equalsIgnoreCase("get")) {
			
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			//call model
			ArrayList<Student> students = StudentModel.retrieveAllUsers();
			out.print(json.toJson(students));
			out.flush();
			out.close();	
			
		}else if(action.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int status = Integer.parseInt(request.getParameter("status")) == 1 ? 0: 1;
			boolean state = StudentModel.changeStudentStatus(id, status);
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(state));
			out.flush();
			out.close();
			
		}else if(action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean state = StudentModel.deleteStudent(id);
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(state));
			out.flush();
			out.close();
		}
	}

}
