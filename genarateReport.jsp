<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<style type="text/css">
#serchbox{
  position: absolute;
  top:auto;
  left:62%;
  transform: translate(-50%,-50%);
  max-width: 70%;
  width: 100%;
  background-color:white;
  padding: 25px;
  border-radius: 5px;
  box-shadow: 4px 4px 2px #18A81A; 
  margin-left:auto;
  margin-right:auto;
  padding:10px;
  margin-top: 10%;
}
#input{
border-radius:7px;
}
#btnsubmit:hover{
background-color: green;

}
.btn1{
margin-bottom: 5%;
}
#datepicker{
	
	{
  margin-bottom: 10px;
  color: grey;
  font-family: Nunito,-apple-system,BlinkMacSystemFont,
  "Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji",
  "Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
}
}
</style> 
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
			<a href="additem.jsp"><i class="fa fa-plus" aria-hidden="true"></i><span>Add Resources</span></a>
			<a href="search.jsp"><i class="fa fa-search" aria-hidden="true"></i><span>Search Resources Details</span></a>
			<a href="search.jsp"><i class="fa fa-cogs" aria-hidden="true"></i><span>Update Resources Info</span></a>
			<a href="genarateReport.jsp"><i class="fa fa-book" aria-hidden="true"></i><span>View Inventory Report</span></a>
			
		
			
			</div>
			
			<br><br>
			<br><br>
			<br><br>
			<br><br>
			
			
		
				<div class="wrapper" id="serchbox">
   

<form action="" method="post" style="width:98%;margin-left:auto;margin-right:auto;">
      
      <table style="width:98%;margin:auto;padding:10px;">
        <tr>
           <td>
             <div class="input_field" >
             <label for="itemName">item Name:</label>
             <input type="text"  id="itemName" placeholder="Enter item Name" pattern="[A-Za-z0-9]+" name="itemName"required>
             </div>
          </td>
          <td>
           <div class="input_field">
           <label for="ItemCondition">Item condition:</label>
           <select name="Status" class="form-control" required>
           
           <option value="Available">Available</option>
           <option value="Discurd">Broken</option>
           <option value="Using">Using</option>
           <option value="Re-condition">Re-condition</option>
              
           </select>
           </div>
          </td>   
        </tr>
        <tr>
           <td>  <div class="input_field">
                 <label>From:</label><br>
                  <input type="Date" name="Date" id="datepicker" placeholder="YY/MM/DD" required>
                  </div>
            </td>
             <td> 
                <div class="input_field">
                <label>To:</label><br>
                <input type="Date" name="Date" id="datepicker"   placeholder="YY/MM/DD" required>  
                </div>         
             </td>
          </tr>   
     </table>
  
  <div class="btn1">
  <input type="submit"  class="form-control btn btn-success" name="submit" value="View Report">
  </div>
 
</form>
</div>


	   
			


</body>
</html>