<%@page import="com.schoolmanagement.model.attendance.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Register</title>
<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<input type="checkbox" id="nav_animation">
		<header>
		
			<label for="nav_animation">
			<i class="fas fa-bars" id="sidebar_btn"></i>
			</label>
		
			<div class="company_name">

		<h1 style="color:grey;padding-left: 255px;">Kanampella Junior School </h1>

	</div>

	<!-- <div class="logout">
	<a href="login.jsp" class="logout_btn"></a>
	</div>-->
			
		</header>
			
			<div class="sidenav">
			<center>
				<img src="css/logo.jpeg" class="user_type" alt="">
			</center>
			
			<a href="Home.jsp"><i class="fa fa-home" aria-hidden="true"></i><span>Home</span></a>
			<a href="SelectStuRegister.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Mark Attendance</span></a>
			<a href="SearchStuAttendance.jsp"><i class="fa fa-search" aria-hidden="true"></i><span>Search Attendance</span></a>
			<a href="SelectStuAtView.jsp"><i class="fa fa-eye" aria-hidden="true"></i><span>View Attendance</span></a>
			<a href="SelectStuUpdate.jsp"><i class="fa fa-wrench" aria-hidden="true"></i><span>Edit Attendance</span></a>
			<a href="#"><i class="fa fa-file" aria-hidden="true"></i><span>Attendance Report</span></a>
			
			</div>
			
<div class="wrapper">
	

<%
	ArrayList<Student> stuDetails = (ArrayList) request.getAttribute("stuDetails");
%>
	<center><img src="logos/Attendancelogo.png" style="height:90px;width:90px"><h2>Mark Attendance</h2>
	<h3 class="heading">GRADE-<%=request.getParameter("grade") %>-<%=request.getParameter("className") %>-Attendance Register</h3></center>
	<br><br>
	<div class="register">
	<form  action="InsertStuAttendance" method="post" onsubmit="return validateForm()">
		<th2>Please Enter Date :</th2><input type="date" name="date" class="date" required="required">
		
		
		<table class="Regtable" style="width:800px">
			<tr class="Regtable"><th class="Regtable">Student ID<th>Name</th><th class="Regtable" colspan="4">Attendance</th></tr>
			
				<% 
					int temp = stuDetails.size();
					int count = 0;
					int[] stuid=new int[temp];
					int i=0;
					
				%>
			
			<%
			for(Student s : stuDetails){
				
				stuid[i]= s.getId();
				i++;	
			%>
				<tr class="Regtable" >
					<td class="Regtable"><c:out value="<%=s.getId() %>"></c:out></td>
					<td class="Regtable"><c:out value="<%=s.getFullName() %>"></c:out></td>
					<td class="Regtable" style="border: none;text-align: center;"><input type="radio" id="present" name="attendance<%=count %>" value="Present" required="required"><lable>Present</lable></td><td style="border: none;"><img src="logos/mark2.jpg" style="height:27px;width:30px"></td>
					<td class="Regtable" style="text-align: center;border-right: none;"><input type="radio" id="absent" name="attendance<%=count %>" value="Absent" required="required"><lable>Absent</lable></td><td style="border: none;"><img src="logos/x.jpg" style="height:27px;width:30px"></td>
				</tr class="Regtable">
				
				<input type="hidden" name="stuid<%=count %>" value="<%=s.getId() %>">
				<% count++; 
					}
				%>
			
			
			<% request.setAttribute("student_id", count); %>
			
			<input type="hidden" name="count" value="<%=count %>">
			<br>
		</table>
		
		<input class="btnAtSubmit" type="submit" name="submit" value="Submit">
	</form>
	</div>
</div>
	
</body>
</html>