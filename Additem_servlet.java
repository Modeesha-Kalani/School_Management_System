package add.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Additem_servlet")
public class Additem_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String itemname = request.getParameter("item_name");
		String itemcode=request.getParameter("item_code");
		String category=request.getParameter("category");
		String discription=request.getParameter("discription");
		String Status = "Available";
		
		
		 boolean isTrue;
			
		  //call insert function
			isTrue = itemDButil.insertitem(itemname, itemcode,category,discription,Status);
		  //check data successful add or not 	
			if(isTrue == true) {
				
				
				out.println("<script type='text/javascript'>");
				out.println("alert('Item successful Add to Inventory');");
				out.println("location='additem.jsp'");
				out.println("</script>");
				
				
				
				
			} else {
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
			
  }
	
	
	
}
