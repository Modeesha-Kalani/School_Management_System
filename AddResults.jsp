<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>

<link rel="stylesheet" href="css/Kanampella.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body><input type="checkbox" id="nav_animation">


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
<div class="wrapperadd">
<h2>Enter Results</h2>

	<form action="AddResult" method="post">
	
		<div class="input_field">
		<label>Enter Student Id    </label><input type="text" name="stid" pattern="[S][0-9][0-9][0-9]" placeholder="SXXX"required><br>
		</div>
		<div class="input_field">
		<label>Subject 01:     </label><select name="subject01" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>         </label><input type="text" name="mark1"><br>
		</div>
		
		<div class="input_field">
		<label>Subject 02:</label><select name="subject02" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>    </label><input type="text" name="mark2"><br>
		</div>
		
		<div class="input_field">
		<label>Subject 03:</label><select name="subject03" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>       </label><input type="text" name="mark3"><br>
		
		</div>
		<div class="input_field">
		<label>Subject 04:</label><select name="subject04" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>      </label><input type="text" name="mark4"><br>
		</div>
		<div class="input_field">
		<label>Subject 05:</label><select name="subject05" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>    </label><input type="text" name="mark5"><br>
		
		</div>
		<div class="input_field">
		<label>Subject 06:</label><select name="subject06" required>
		<option value="Maths" >Maths</option>
		<option value="English">English</option>
		<option value="History">History</option>
		<option value="Religion" >Religion</option>
		<option value="Sinhala Lang and lit">Sinhala lang and lit</option>
		<option value="Science">Science</option>
		</select>
		</div>
		<div class="input_field">
		<label>     </label><input type="text" name="mark6"><br>
		</div>
		<div class="input_field">
		<label>Optional Subject 07:</label><select name="subject07" required>
		<option value="Music" >Music</option>
		<option value="English Literature">English Literature</option>
		<option value="IT">IT</option>
		<option value="Hygiene" >Hygiene</option>
		<option value="Western Music">Western Music</option>
		<option value="Business Studies">Business Studies</option>
		</select>
		</div>
		<div class="input_field">
		<label>      </label><input type="text" name="mark7"><br>
		</div>
		<div class="input_field">
		<label>Optional Subject 08:</label><select name="subject08" required>
		<option value="Music" >Music</option>
		<option value="English Literature">English Literature</option>
		<option value="IT">IT</option>
		<option value="Hygiene" >Hygiene</option>
		<option value="Western Music">Western Music</option>
		<option value="Business Studies">Business Studies</option>
		</select>
		</div>
		<div class="input_field">
		<label>      </label><input type="text" name="mark8"><br>
		</div>
		
		
		<div class="input_field">
		<label>Optional Subject 09:</label><select name="subject09" required>
		<option value="Music" >Music</option>
		<option value="English Literature">English Literature</option>
		<option value="IT">IT</option>
		<option value="Hygiene" >Hygiene</option>
		<option value="Western Music">Western Music</option>
		<option value="Business Studies">Business Studies</option>
		</select>
		</div>
		<div class="input_field">
		<label>    </label><input type="text" name="mark9"><br>
		</div>
		<div class="btn1">
		<input type=Submit name="Submit" Value="Submit"> 
		</div>
	</form>

</div>
</div>
</body>
</html>