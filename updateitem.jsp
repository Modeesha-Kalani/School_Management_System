<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%      
        String ItemNo=request.getParameter("ItemNo");
		String ItemName = request.getParameter("ItemName");
		String ItemCode = request.getParameter("ItemCode");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String date = request.getParameter("date");
	
	%>

<form id="form1"action="update" method="post">
	<table>
	<tr>
			<td>Item NO</td>
			<td><input type="text" name="INO" value="<%=ItemNo  %>" readonly>
			
			</td>
		</tr>
	    <tr>
			<td>Item Name</td>
			<td><input type="text" name="IName" value="<%= ItemName %>" >
			
			</td>
		</tr>
		<tr>
			<td>Item Code</td>
			<td><input type="text" name="Icode" value="<%= ItemCode  %>" ></td>
		</tr>
		<tr>
			
			<td>Category</td>
			<td><label for="assing"></label>
            <select name="category" >
              <option value="furniture"><%= category %></option>
              <option value="stationary">stationary</option>
              <option value="sport">sport</option>
              <option value="electronic">Electronic</option>
            </select> 
            </td> 

		</tr>
		<tr>
		<td>Description</td>
		<td><input type="text" name="Description" value="<%= description %>" ></td>
	</tr>
	<tr>
		
		<td>Status</td>
		<td><label for="assing"></label>
            <select name="Status">
              <option value="avilable"><%= status %></option>
              <option value="Discurd">Descurd</option>
              <option value="Using">Using</option>
              <option value="Re-condition">Re-condition</option>
               <option value="Avilable">Available</option>
              
            </select>
		
		</td>
	</tr>
	
	<tr>
		<td>Date</td>
		<td><input type="text" name="Date" value="<%= date %>" ></td>
	</tr>		
	</table>
	
	<br>
	
	<input type="submit" name="submit" value="Update">
	
	</form>

</body>
</html>