<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete marks</title>
<link rel="stylesheet" href="css/Kanampella.css">

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


</header>


<div class="sidenav">

<center>
<img src="css/logo.jpeg"  class="user_type" alt="userprofile">

</center>
<a href="#"><i class="fas fa-home" aria-hidden="true"></i><span>Home</span></a>
<a href="searchMarks.jsp"><i class="fa fa-archive" aria-hidden="true"></i><span>Search Marks</span></a>
<a href="AddResults.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Results</span></a>
<a href="Addprogress.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Evaluate</span></a>
<a href="Editmark.jsp"><i class="fa fa-cogs" aria-hidden="true"></i><span>Update Results</span></a>
<a href="deleteMark.jsp"><i class="fas fa-trash" aria-hidden="true"></i><span>Delete Results</span></a>
<a href="SearchSubject.jsp"><i class="fas fa-edit" aria-hidden="true"></i><span>List Subject Result</span></a>


</div>
<div class="workspace">
<div class="wrapper">
<h2>Delete Results</h2>
<form action="deleteMark"  method="post">
			<div class="input_field">
			<label>Index No</label><input type="text" name="Stid" pattern="[S][0-9][0-9][0-9]" placeholder="SXXX"required><br>
			</div>
			<div class="input_field">
			<label>Select subject:</label><select name="Subject" required>
			<option value="Maths" >Maths</option>
			<option value="English">English</option>
			<option value="History">History</option>
			<option value="Religion" >Religion</option>
			<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
			<option value="Science">Science</option>
			<option value="Music" >Music</option>
		   <option value="English Literature">English Literature</option>
		   <option value="IT">IT</option>
		   <option value="Hygiene" >Hygiene</option>
		   <option value="Western Music">Western Music</option>
		   <option value="Business Studies">Business Studies</option>
		   </select>
			</div>
			<div class="btn1">
			<input type="submit" name="delete" value="Delete">
			</div>
			
</form>	
		
</div>
</div>	
</body>
</html>