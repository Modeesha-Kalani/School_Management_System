<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<input type="checkbox" id="nav_animation">
		<header>
		
			

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
		<center><h3 class="heading"><img src="logos/select2.png" style="height:50px;width:50px">Select View Register</h3></center>
	<form action="searchStuAttendance" method="post">
		<label>Input Student ID :</label>
		<input type="text" class="stuid" name="StuId">
		<label>Input Date :</label>
		<input type="date" class="date" name="date">
		<input class="btn" type="submit" name="submit" value="Search">

	</form>
</div>
</body>
</html>