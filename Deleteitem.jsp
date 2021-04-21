<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Item Delete</h1>
<form id="form1"action="Delete" method="post">
	<table>
	<tr>
			<td>Item NO</td>
			<td><input type="text" name="INO" value="<%=ItemNo  %>" readonly>
			
			</td>
		</tr>
	    <tr>
			<td>Item Name</td>
			<td><input type="text" name="IName" value="<%= ItemName %>" readonly>
			
			</td>
		</tr>
		<tr>
			<td>Item Code</td>
			<td><input type="text" name="Icode" value="<%= ItemCode  %>" readonly ></td>
		</tr>
		<tr>
			
			<td>Category</td>
			<td> 
			<input type="text" name="Icode" value="<%= category  %>" readonly >
            </td> 

		</tr>
		<tr>
		<td>Description</td>
		<td><input type="text" name="Description" value="<%= description %>" readonly></td>
	</tr>
	<tr>
		
		<td>Status</td>
		<td>
		<input type="text" name="Description" value="<%= status %>" readonly>
		</td>
	</tr>
	
	<tr>
		<td>Date</td>
		<td><input type="text" name="Date" value="<%= date %>"   readonly ></td>
	</tr>		
	</table>
	
	<br>
	
	<input type="submit" name="submit" value="Delete Item">
	
	</form>


</body>
</html>