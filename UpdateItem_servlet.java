package add.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UpdateItem_servlet")
public class UpdateItem_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ItemNo=request.getParameter("INO");
		String ItemName = request.getParameter("IName");
		String ItemCode = request.getParameter("Icode");
		String category = request.getParameter("category");
		String description = request.getParameter("Description");
		String status = request.getParameter("Status");
		String Date = request.getParameter("Date");
		
		
        boolean istrue;
		
		istrue=itemDButil.Updateitem(ItemNo,ItemName,ItemCode,category,description,status,Date);
		
		
		if(istrue==true) {
			RequestDispatcher dis =request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}
		else {
				RequestDispatcher dis =request.getRequestDispatcher("unsuccess.jsp");
				dis.forward(request, response);
			}
		
	}

}
