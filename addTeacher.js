$(function() {
	$("#fullName").focus().select();
	getMaxId();
	$('.select2').select2();
	$('.select2bs4').select2({
		theme : 'bootstrap4'
	});
	
	// enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'fullName') {
				if (validateRequired('fullName')) {
					$("#dob").focus().select();					
				}
			}else if(e.target.id === 'dob'){
				if (validateRequired('dob')) {
					$("#nic").focus().select();					
				}
			}else if(e.target.id === 'nic'){
				if (validateRequired('nic')) {
					$("#joinDate").focus().select();					
				}
			}else if(e.target.id === 'joinDate'){
				if (validateRequired('joinDate')) {
					$("#description").focus().select();					
				}
			}else if(e.target.id === 'description'){
				if (validateRequired('description')) {
					addToQualificationTable(e);					
				}
			}
		}
	});
	
});

const validateSubmit = (event) => {
	event.preventDefault();
	let err = 0;
	
	if(!validateRequired('fullName')){
		validateRequired('fullName');
		err++;
	}
	
	if(!validateRequired('dob')){
		validateRequired('dob');
		err++;
	}
	
	if(!validateRequired('nic')){
		validateRequired('nic');
		err++;
	}
	
	if(!validateRequired('joinDate')){
		validateRequired('joinDate');
		err++;
	}
	
	if(err == 0){
		 addTeacher(event);
	}else{
		return false;
	}
};

const addToQualificationTable = (event) => {
	event.preventDefault();
	const fullName = $('#fullName').val();
	const description = $('#description').val();
	
	if (fullName == "") {
		alert("Please enter teacher's name !");
	} else if (description == "") {
		alert("Please enter Qualification !");
	} else {
		
		$('#description').val("");
		$("#description").focus().select();
		
		const id = description.replace(/[^a-z0-9\s]/gi, '').replace(/\s/g, "");
		
		let isExsist = false;
		
		if ($('#tblQualifications > tbody').find('#' + id).length > 0) {
			isExsist = true;
		}
		
		if (!isExsist) {
			addRow(id);
		}else{
			console.log("else state!");
		}
		
		$('#fullName' + id).val(fullName);
		$('#description' + id).val(description);
		
		$('#tblQualifications >tbody >tr').find('.iteminsert').val('');
	}
};

const addRow = (id) => {
	let text = "";
	$('#tblQualifications tbody').append('<tr id="' + id + '"><td class="td-input">'
		+ '<input  type="text" id="fullName' + id + '" name="fullName' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '<td class="td-input" >'
		+ '<input type="text" id="description' + id + '" name="description' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '</td>'
		+ '<td class="text-center" id="deleteRow' + id + '" onclick="removeFromTables(this.id);" ><span class="fas fa-window-close" style="color:red;cursor: pointer"></span>'
		+ '</td>'
		+ '</tr>');
};

const addTeacher = (event) => {
	event.preventDefault();
	$("#submitBtn").prop("disabled", true);
	const fullName = $("#fullName").val();
	const dob = $("#dob").val();
	const nic = $("#nic").val();
	const gender = $("#gender").val();
	const joinDate = $("#joinDate").val();
	const id = $("#nextId").val();
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/addTeacher?action=add&fullName="+fullName+"&dob="+dob+"&nic="+nic
		+"&gender="+gender+"&joinDate="+joinDate+"&id="+id,
		success: function (data) {
			console.log(data);
			if(data){
				if(addTeacherQualification()){
					Swal.fire(
							'Successful!',
							'Teacher Details Saved!',
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
			}else{
				Swal.fire(
						'Error!',
						'Unable to save!',
						'error'
				);
			}
		
			$("#submitBtn").prop("disabled", false);
		}
	});
	
};

const getMaxId = () => {
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/addTeacher?action=maxId",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function (data) {
			const id = data.id;
			const newId = parseInt(id) + 1;
			$("#newId").text("Next ID : " + newId);
			$("#nextId").val(newId);
		}
	});
};

const addTeacherQualification = () => {
	let teacherQualifications = new Array();
	let error = 0;
	$('#tblQualifications > tbody > tr').each(function (row, tr) {
		teacherQualifications[row] = {
			"teacherId": $("#nextId").val()
			, "description": $(tr).find('td:eq(1) input').val()
		};
	});
	
	
	$.each(teacherQualifications, function (i, teacherQualification) {
		$.ajax({
			type: "POST",
			url: "/SchoolManagementSystem/addTeacher?action=addTeacherQualification&id="+teacherQualification.teacherId
			+"&description="+teacherQualification.description,
			success: function (data) {
				if(!data){
					error++;
				}
			}
		});
	});
	
	
	if(error > 0){
		return false;
	}
	
	return true;
};

const clearForm = () => {
	$("#addTeacherForm").trigger('reset');
	$("#tblQualifications > tbody").find("tr").remove();
	$("#nextId").val("");
	getMaxId();
};

const removeFromTables = (id) => {
	$("#" + id).parent().remove();
};
