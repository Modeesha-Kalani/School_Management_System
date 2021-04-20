$(function() {
	loadSubjectList();
	loadTeacherList();
	
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'teacher') {
				if (validateRequired('teacher')) {
					$("#year").focus().select();					
				}
			}else if(e.target.id === 'year'){
				if (validateRequired('year')) {
					$("#section").focus().select();					
				}
			}else if(e.target.id === 'section'){
				if (validateRequired('section')) {
					$("#class").focus().select();					
				}
			}else if(e.target.id === 'class'){
				if (validateRequired('class')) {
					$("#grade").focus().select();					
				}
			}else if(e.target.id === 'grade'){
				if (validateRequired('grade')) {
					$("#subject").focus().select();					
				}
			}else if(e.target.id === 'subject'){
				if (validateRequired('subject')) {
					validateSubmit(e);					
				}
			}
		}
	});
});

const validateSubmit = (event) => {
	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('teacher')){
		validateRequired('teacher');
		err++;
	}
	
	if(!validateRequired('year')){
		validateRequired('year');
		err++;
	}
	
	if(!validateRequired('section')){
		validateRequired('section');
		err++;
	}
	
	if(!validateRequired('class')){
		validateRequired('class');
		err++;
	}
	
	if(!validateRequired('grade')){
		validateRequired('grade');
		err++;
	}
	
	if(!validateRequired('subject')){
		validateRequired('subject');
		err++;
	}
	
	 
	
	if(err == 0){
		 TeacherSubject(event);
	}else{
		return false;
	}
}

const TeacherSubject = (e) => {
	e.preventDefault();
	$("#assingSubForTeacher").prop("disabled", true);
	const teacher = $("#teacher").val();
	const year = $("#year").val();
	const section = $("#section").val();
	const classes = $("#class").val();
	const grade = $("#grade").val();
	const subject = $("#subject").val();

	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/techerHassubjectController?teacher="+teacher+"&year="+year+"&section="+section
		+"&classes="+classes+"&grade="+grade+"&subject="+subject,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Teachers Subjects Details Saved!',
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
		
			$("#assingSubForTeacher").prop("disabled", false);
		}
	});
};

const clearForm = () => {
	$("#addTeacherSubject").trigger('reset');
};

const loadTeacherList = () => {

	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/t",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#teacher").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};

const loadSubjectList = () => {
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/RetrieveSubjectList",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#all_subject").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};
