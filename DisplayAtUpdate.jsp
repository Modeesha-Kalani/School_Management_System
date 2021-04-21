<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Display</title>
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

	
	<center><img src="logos/editnew.png" style="height:90px;width:90px"><h2>Edit Register</h2>
	<h3 class="heading">GRADE-<%=request.getParameter("grade") %>-<%=request.getParameter("className") %>-Attendance Register</h3></center>
	<h4>Date - <%=request.getParameter("date") %></h4>
	<div class="edit">
	<table border="1" style="width:800px" class="Regtable">
	<tr class="Regtable">
		<th class="Regtable">Attendance ID</th><th class="Regtable">Student ID</th><th class="Regtable">Student Name</th><th class="Regtable">Attendance Status</th><th class="Regtable" colspan="2">Edit</th>
	</tr>
	<c:forEach var="At" items="${AtDetails}">
	
	<c:set var="id" value="${At.id}"/>
	<c:set var="stuid" value="${At.stuid}"/>
	<c:set var="studentName" value="${At.studentName}"/>
	<c:set var="attendance" value="${At.attendance}"/>
	<c:set var="date" value="${At.date}"/>
	
	<tr>
		<td class="Regtable">${At.id}</td><td class="Regtable">${At.stuid}</td><td class="Regtable">${At.studentName}</td><td class="Regtable">${At.attendance}</td>
		<td class="Regtable">
		<c:url value="UpdateAttendance.jsp" var="updateattendance">

			<c:param name="id" value="${id}"/>
			<c:param name="stuid" value="${stuid }"/>
			<c:param name="studentName" value="${studentName}"/>
			<c:param name="attendance" value="${attendance}"/>
			<c:param name="date" value="${date}"/>
	
		</c:url>
	
	<a href="${updateattendance}">
		<img src="edit.png" style="width:25px;height:25px">
	</a></td>
	<td class="Regtable">
		<c:url value="DeleteAttendance.jsp" var="deleteattendance">

			<c:param name="id" value="${id}"/>
			<c:param name="stuid" value="${stuid }"/>
			<c:param name="studentName" value="${studentName}"/>
			<c:param name="attendance" value="${attendance}"/>
			<c:param name="date" value="${date}"/>
	
		</c:url>
	
	<a href="${deleteattendance}">
		<img src="delete.png" style="width:25px;height:25px">
	</a>
	</tr>
	
	</c:forEach>
	</table>
	</div>
</body>
</html>