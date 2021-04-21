package add.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteItem_servlet")
public class DeleteItem_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String ItemNo=request.getParameter("INO");
		boolean isTrue;
		
		isTrue=itemDButil.DeleteItem(ItemNo);
		
		if(isTrue==true) {
			RequestDispatcher dis =request.getRequestDispatcher("search.jsp");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Can not delete this item in inventory i this moment!');");
			out.println("location='search.jsp'");
			out.println("</script>");
			}
		
		
		
		
	}

}
