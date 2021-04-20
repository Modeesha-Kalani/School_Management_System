$(function() {
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) { //enter button key code
			e.preventDefault();			//go down when enter is pressed
			if (e.target.id === 'fullName') {
				if (validateRequired('fullName')) {
					$("#firstName").focus().select();					
				}
			}else if(e.target.id === 'firstName'){
				if (validateRequired('fullName')) {
					$("#lastName").focus().select();					
				}
			}else if(e.target.id === 'lastName'){
				if (validateRequired('lastName')) {
					$("#dob").focus().select();					
				}
			}else if(e.target.id === 'dob'){
				if (validateRequired('dob')) {
					$("#address").focus().select();					
				}
			}else if(e.target.id === 'address'){
				if (validateRequired('address')) {
					$("#guardian").focus().select();					
				}
			}else if(e.target.id === 'guardian'){
				if (validateRequired('guardian')) {
					$("#cNumber").focus().select();					
				}
			}else if(e.target.id === 'cNumber'){
				if (validateRequired('cNumber')) {
					$("#occupation").focus().select();					
				}
			}else if(e.target.id === 'occupation'){
				if (validateRequired('occupation')) {
					$("#addmissionDate").focus().select();					
				}
			}else if(e.target.id === 'addmissionDate'){
				if (validateRequired('addmissionDate')) {
					$("#admissionNo").focus().select();					
				}
			}else if(e.target.id === 'admissionNo'){
				if (validateRequired('admissionNo')) {
					validateSubmit(e);					
				}
			}
		}
	});
});

//on clicking the submit button

const validateSubmit = (event) => {
	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('fullName')){
		validateRequired('fullName');
		err++;
	}
	
	if(!validateRequired('firstName')){
		validateRequired('firstName');
		err++;
	}
	
	if(!validateRequired('lastName')){
		validateRequired('lastName');
		err++;
	}
	
	if(!validateRequired('dob')){
		validateRequired('dob');
		err++;
	}
	
	if(!validateRequired('address')){
		validateRequired('address');
		err++;
	}
	
	if(!validateRequired('guardian')){
		validateRequired('guardian');
		err++;
	}
	
	if(!validateRequired('cNumber')){
		validateRequired('cNumber');
		err++;
	}
	
	if(!validateRequired('occupation')){
		validateRequired('occupation');
		err++;
	}
	
	if(!validateRequired('addmissionDate')){
		validateRequired('addmissionDate');
		err++;
	}
	
	if(!validateRequired('admissionNo')){
		validateRequired('admissionNo');
		err++;
	}
	
	if(err == 0){ //if no errors
		 addStudent(event);
	}else{
		return false;
	}
}

//add student details 

const addStudent = (e) => {
	e.preventDefault();

	//variables created  	data from jsp
	
	const fullName = $("#fullName").val();
	const firstName = $("#firstName").val();
	const lastName = $("#lastName").val();
	const gender = $("#gender").val();
	const dob = $("#dob").val();
	const address = $("#address").val();
	const guardian = $("#guardian").val();
	const cNumber = $("#cNumber").val();
	const occupation = $("#occupation").val();
	const addmissionDate = $("#addmissionDate").val();
	const admissionNo = $("#admissionNo").val();
	
	$.ajax({
		type: "POST",
		
		url: "/SchoolManagementSystem/AddStudentController?fullName="+fullName+"&firstName="+firstName+"&lastName="+lastName
		+"&gender="+gender+"&dob="+dob+"&address="+address+"&guardian="+guardian+"&cNumber="+cNumber
		+"&occupation="+occupation+"&addmissionDate="+addmissionDate+"&admissionNo="+admissionNo,
		
		success: function (data) {
			
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Student Details Saved!',
					'success'
				);
				clearForm();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			
		}
	});
	
};

const clearForm = () => {
	$("#addStudentForm").trigger('reset');
};
