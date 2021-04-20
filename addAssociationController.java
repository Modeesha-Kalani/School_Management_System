import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.schoolmanagement.model.association.Association;
import com.schoolmanagement.model.association.AssociatonModel;

/**
 * Servlet implementation class addAssorciationController
 */
@WebServlet("/addAssorciationController")
public class addAssorciationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAssorciationController() {
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
		
		Association association = new Association();
		
		association.setName(request.getParameter("association"));
		association.setTeacherDetailsId(request.getParameter("teacher"));
		association.setMemberCount(request.getParameter("count"));
		
		int status = AssociatonModel.registerAssociation(association);
		
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
		
		doGet(request, response);
	}

}
