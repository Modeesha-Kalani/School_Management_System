<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Registration Details</title>

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
			
	<h3 align="center"><span> Kanampella </span><span> Junior </span><span>   School     </span> </h3>

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
			<a href="AddExam.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Exam</span></a>
			<a href="AddRegistrationDetails.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Registration </span></a>
			<a href="ListExamDetails.jsp"><i class="fa fa-search" aria-hidden="true"></i><span>List Exam Details</span></a>
			<a href="ListRegistrationDetails.jsp"><i class="fa fa-archive" aria-hidden="true"></i><span>List Registarion Details</span></a>
			<a href="InsertQuetions.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Questions</span></a>
			<a href="ListQuestionDetails.jsp"><i class="fa fa-archive" aria-hidden="true"></i><span>List Question Details</span></a>
			<a href="UpdateQuestion.jsp"><i class="fa fa-cogs" aria-hidden="true"></i><span>Update Question</span></a>
			<a href="DeleteQuestion.jsp"><i class="fa fa-trash" aria-hidden="true"></i><span>Drop Question</span></a>
			<a href="SearchExam.jsp"><i class="fa fa-archive" aria-hidden="true"></i><span>Search Exam</span></a>
		
			
			</div>
			
			<br><br>
			<br><br>
			<br><br>
			<br><br>
			
			
		
				<div class="wrapper">
		  			
		    					<form action="UpdateRegistrationFormservlet" method="post">
		    			
	    							<h2>Add Registration Details</h2> <br>
	    					
	    								<div class="input_field">
											<input type="text" name="sid"  placeholder="Student ID-SIDXXX" pattern="[S][I][D][0-9][0-9][0-9]"required> <br><br>
											<input type="text" name="semail"  placeholder="Email" required> <br><br>
											
											
										</div>
										
											<div class="btn1">
													<input type="submit" name="submit" value="Update Details">
											</div>
									</form>
    			</div>
		
</body>
</html>