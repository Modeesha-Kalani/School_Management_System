<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search item</title>
<link rel="stylesheet" href="css/exams.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css"> 


<style type="text/css">
#input_field{


}

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

td,th{
padding:5px;
text-align:center;
}



.myButton {
	background-color:#77b55a;
	border-radius:4px;
	border:1px solid #4b8f29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 15px;
	text-decoration:none;
	text-shadow:0px 1px 0px #5b8a3c;
}
.myButton:hover {
	background-color:#72b352;
}
.myButton:active {
	position:relative;
	top:1px;
}

.myButton1 {
	box-shadow:inset 0px 39px 0px -24px #e67a73;
	background-color:#e4685d;
	border-radius:4px;
	border:1px solid #ffffff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 15px;
	text-decoration:none;
	text-shadow:0px 1px 0px #b23e35;
}
.myButton1:hover {
	background-color:#eb675e;
}
.myButton1:active {
	position:relative;
	top:1px;
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


  <form action="Search_servlet" method="post" style="width:98%;margin-left:auto;margin-right:auto;">

     <table style="width:98%;margin:auto;padding:10px;">
        <tr>
           <th>
           <div class="input_field" >
             <label>Item Name</label><input type="text" name="itemName" placeholder="enter item name" id="input">
             </div>
             </th>
             <th>
             <div class="input_field">
             <label for="assing">Item condition:</label>
            <select name="Status" id="input">
            
              <option value="Available">Available</option>
              <option value="Discurd">Broken</option>
              <option value="Using">Using</option>
              <option value="Re-condition">Re-condition</option>
              
              </select>
            </div>
          </th>
       </tr>
       </table>
          <div class="btn1">
			<input type="submit" name="submit" value="search" id="btnsubmit">
          </div>
        
       



<c:forEach var="itm"  items="${itemDetails}">

<c:set var="ItemNo" value="${itm.itemNo}"/>
<c:set var="ItemName" value="${itm.itemname}"/>
<c:set var="ItemCode" value ="${itm.itemcode}"/>
<c:set var="category" value="${itm.category}"/>
<c:set var="description" value="${itm.description}"/>
<c:set var="status" value="${itm.status}"/>
<c:set var="date" value="${itm.date}"/>
<table border="0" style="padding:5px;width:100%;border: 0px solid white">
<tr>
<th>Item No</th>
<th>Item Name</th>
<th>Item Code</th>
<th>Category</th>
<th>Description</th>
<th>Condition</th>
<th>Date</th>
<th>Update</th>
<th>Delete</th>
</tr>
<tr>

<td>${itm.itemNo}</td>
<td>${itm.itemname}</td>
<td>${itm.itemcode}</td>
<td>${itm.category}</td>
<td>${itm.description}</td>
<td>${itm.status}</td>
<td>${itm.date}</td>
<td>
<i class="fa fa-cogs">
<a href="${ItemUpdate}">
<input type="submit" name="submit" value="Update" class="myButton">
</a>
</i>
</td>
<td>
<i class="fa fa-trash">
<a href="${ItemDelete}">
<input type="submit" name="submit" value="Delete" class="myButton1">
</a>
</i>
</td>
</tr>





<!-- send to data updateitem.jsp  using url  -->

<c:url  value="updateitem.jsp" var ="ItemUpdate">

<c:param name="ItemNo" value="${ItemNo}"/>
<c:param name="ItemName" value="${ItemName}"/>
<c:param name="ItemCode" value="${ItemCode}"></c:param>
<c:param name="category" value="${category}"></c:param>
<c:param name="description" value="${description}"></c:param>
<c:param name="status" value="${status}"></c:param>
<c:param name="date" value="${date}"></c:param>
</c:url>

<!-- send to data Deleteitem.jsp  using url  -->

<c:url  value="Deleteitem.jsp" var ="ItemDelete">

<c:param name="ItemNo" value="${ItemNo}"/>
<c:param name="ItemName" value="${ItemName}"/>
<c:param name="ItemCode" value="${ItemCode}"></c:param>
<c:param name="category" value="${category}"></c:param>
<c:param name="description" value="${description}"></c:param>
<c:param name="status" value="${status}"></c:param>
<c:param name="date" value="${date}"></c:param>
</c:url>

</table>
</c:forEach>

</form> 

</body>
</html>