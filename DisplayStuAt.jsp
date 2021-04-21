<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Attendance</title>
<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>

<input type="checkbox" id="nav_animation">
		<header>
		
		
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
			
			<br><br>
			<br><br>
			<br><br>
			<br><br>
			
<div class="wrapper">
		<center><img src="logos/Attendancelogo.png" style="height:70px;width:70px">
		
	<h2><%=request.getParameter("grade") %>-<%=request.getParameter("className") %> Register</h2>
	<h3><%=request.getParameter("date") %></h3></center>
	<div class="register">
	<table class="Regtable" style="width:700px">
	<tr class="Regtable">
		<th class="Regtable">Attendance ID</th><th class="Regtable">Student ID</th><th class="Regtable">Student Name</th><th class="Regtable">Attendance Status</th>
	</tr>
	<c:forEach var="At" items="${AtDetails}">
	<tr class="Regtable">
		<td class="Regtable">${At.id}</td><td class="Regtable">${At.stuid}</td><td class="Regtable">${At.studentName}</td><td class="Regtable">${At.attendance}</td>
	</tr>
	
	</c:forEach>
	</table>
	</div>
</div>
</body>
</html>