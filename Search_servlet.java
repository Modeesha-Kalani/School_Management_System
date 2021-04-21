package add.item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Search_servlet")
public class Search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		//jsp page value catch
		String itemCode=request.getParameter("itemName");
		String Status=request.getParameter("Status");
		
		boolean istrue;
		
		//call validate function 
		istrue=itemDButil.searchvalid(itemCode,Status);
		if(istrue==true) {
			List<item> itemDetails=itemDButil.getiItems(itemCode,Status);
			request.setAttribute("itemDetails",itemDetails);
		    
			RequestDispatcher dis =request.getRequestDispatcher("search.jsp");
			dis.forward(request, response);
		}
		else
		{
			out.println("<script type='text/javascript'>");
			out.println("alert('Item name is not valid ');");
			out.println("location='search.jsp'");
			out.println("</script>");
			
		}
		
		
	}

}
