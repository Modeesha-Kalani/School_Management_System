<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.schoolmanagement.model.attendance.Teacher"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Register</title>
<link rel="stylesheet" href="exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<%
	ArrayList<Teacher> teachDetails = (ArrayList) request.getAttribute("teachDetails");
%>
	<th>Teachers Register</th>
	
	<form name="Insert" action="InsertTeachAtServlet" method="post">
		<th2>Please Enter Date :</th2><input type="date" name="date" class="date">
		
		
		<table border="1">
			<tr><th>Teacher ID<th>Name</th><th colspan="2">Attendance</th></tr>
			
				<% 
					int temp = teachDetails.size();
					int count = 0;
					int[] teachid=new int[temp];
					int i=0;
					
				%>
			
			<%
			for(Teacher t : teachDetails){
				
				teachid[i]= t.getId();
				i++;	
			%>
				<tr>
					<td><c:out value="<%=t.getId() %>"></c:out></td>
					<td><c:out value="<%=t.getFullName() %>"></c:out></td>
					<td style="border: none"><input type="radio" id="present" name="attendance<%=count %>" value="Present"><lable>Present</lable></td>
					<td style="border: none"><input type="radio" id="absent" name="attendance<%=count %>" value="Absent"><lable>Absent</lable></td>
				</tr>
				
				<input type="hidden" name="teachid<%=count %>" value="<%=t.getId() %>">
				<% count++; 
					}
				%>
			
			
			<% request.setAttribute("teacher_id", count); %>
			
			<input type="hidden" name="count" value="<%=count %>">
			<tr><td><input class="submit" type="submit" name="submit" value="submit"></td></tr>
		</table>
	</form>
</body>
</html>