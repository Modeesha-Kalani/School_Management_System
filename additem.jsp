<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Item</title>
<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">

</head>
<body>

<body >
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
				<img src="css/logo.jpeg" class="user_type" alt="">
			</center>
			
			<a href="Home.jsp"><i class="fa fa-home" aria-hidden="true"></i><span>Home</span></a>
			<a href="additem.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Resources</span></a>
			<a href="search.jsp"><i class="fa fa-search" aria-hidden="true"></i><span>Search Resources Details</span></a>
			<a href="search.jsp"><i class="fa fa-cogs" aria-hidden="true"></i><span>Update Resources Info</span></a>
			<a href="genarateReport.jsp"><i class="fa fa-book" aria-hidden="true"></i><span>View Inventory Report</span></a>
			
		
			
			</div>
			
			<br><br>
			<br><br>
			<br><br>
			<br><br>
			
			
<!-- page content -->	
	
<div class="wrapper">
   
   <form action="Additem_servlet"  method="post"  >
			
			<h1> Add Item </h1>
			<div class="input_field">
			Item name :<input type="text" name="item_name" pattern="[A-Za-z]{50}" required><br/><br/>
			Item code :<input type="text" name="item_code" id="inputDate" pattern="[A-Z]+-[0-9]{,3}" placeholder="Example for offfice table:Office Table-001" required><br/><br/>
			
			
			
			<label for="assing">Category:</label>
            <select name="category" required >
              <option value="furniture">furniture</option>
              <option value="stationary">stationary</option>
              <option value="sport">sport</option>
              <option value="electronic">Electronic</option>
              <option value="Other">Other</option>
              
              
              
            </select>
			<br/><br/>
			
			Description:<br>
			<textarea  name="discription" rows="8" cols="50" required>
			
			</textarea>
			<br/><br/>
			</div>
			
			<div class="btn1">
			
            <input type="submit"  name ="submit" value="create item">
			</div>
			
   </form>
   
</div>   

</body>
</html>