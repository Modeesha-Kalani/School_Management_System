<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Attendance</title>
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
			
			<br><br>
			<br><br>
			<br><br>
			<br><br>
			
<div class="wrapper">
		<center><img src="logos/update2.jpg" style="height:50px;width:50px"><h3 class="heading">Update Register</h3></center>

<form action="UpdateStuAttendanceServlet" method="post">
	<%
		String id=request.getParameter("id");
		String stuid=request.getParameter("stuid");
		String stuname=request.getParameter("studentName");
		String attendance=request.getParameter("attendance");
		String date=request.getParameter("date");
	%>
	<input type="hidden" value="<%=id %>" name="ID">
	<div class="updatebox">
	<table class="Regtable"  style="width:500px;">
		<tr class="Regtable">
		<td class="Regtable">Attendance ID :</td><td class="Regtable"><%=id %></td>
		
		</tr>
		<tr class="Regtable">
		<td class="Regtable">Student ID :</td><td class="Regtable"><%=stuid %></td>
		</tr>
		<tr class="Regtable">
		<td class="Regtable">Student Name :</td><td class="Regtable"><%=stuname %></td>
		</tr>
		<tr class="Regtable">
		<td class="Regtable">Date :</td><td class="Regtable"><%=date %></td>
		</tr>
		<tr class="Regtable">
		<td class="Regtable">Attendance Status :</td><td class="Regtable">
				
		<c:set var = "attendance" value = "<%=attendance%>"/>
		<c:choose>
		<c:when test="${attendance == 'Present'}">
		
		<input type="radio" id="present1" name="attendance" value="Present" checked="checked" ><lable>Present</lable>
		<input type="radio" id="absent2" name="attendance" value="Absent" ><lable>Absent</lable>
		
		</c:when>
		<c:otherwise>
		
		<input type="radio" id="present3" name="attendance" value="Present"><lable>Present</lable>
		<input type="radio" id="absent" name="attendance" value="Absent" checked="checked"><lable>Absent</lable>
		
		</c:otherwise>
		</c:choose>
		</td>
		</tr>
	</table>
	<input class="btnAtSubmit" type="submit" name="submit" value="Update">
	</div>
	</form>
	
</body>
</html>