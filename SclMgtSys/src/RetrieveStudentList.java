import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.schoolmanagement.model.students.Student;
import com.schoolmanagement.model.students.StudentModel;

/**
 * Servlet implementation class RertieveStudentList
 */
@WebServlet("/c")
public class RetrieveStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStudentList() {
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
		ArrayList<Student> Sudent_list = StudentModel.retrieveAllUsers();
		JsonArray datas = new JsonArray();
		for (int i = 0; i < Sudent_list.size(); i++) {
			JsonObject students = new JsonObject();
			students.addProperty("id", Sudent_list.get(i).getId());
			students.addProperty("name", Sudent_list.get(i).getFullName());
			datas.add(students);
		}
		
		response.getWriter().write(datas.toString());

	}

}