$(function() {
	getSubject();
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if(e.target.id === 's_name'){
				if (validateRequired('s_name')) {
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
	
	if(!validateRequired('s_name')){
		validateRequired('s_name');
		err++;
	}
	
	
	
	
	if(err == 0){
		 subject(event);
	}else{
		return false;
	}
}

const subject = (e) => {
	e.preventDefault();
	$("#addSubject").prop("disabled", true);
	const s_name = $("#s_name").val();
	 
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/subjectController?s_name="+s_name,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Subject Saved successfully !',
					'success'
				);
				clearForm();
				getSubject();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			$("#addSubject").prop("disabled", false);
		}
	});
};

const clearForm = () => {
	$("#subject_frm").trigger('reset');
};

const getSubject = () => {

	console.log("Get Students");
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageSubjectController?action=get",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function (data) {
			$('#tblViewStudents > tbody').html('');
			$.each(data, function (i, student) {
				appendSportTable(student);
			});
		}
	});
}

const appendSportTable = (item) => {
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewStudents > tbody').append(textToInsert);
};

const addRow = (item) => {
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.subjectId + 'delete" onclick="deleteSubject(\'' + item.subjectId + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Subject</button>';
	const update_btn = '<button type="button" class="btn btn-info btn-xs" id="' + item.subjectId + 'delete" onclick="update(\'' + item.subjectId + '\',\'' + item.description + '\')">&nbsp;Update Subject</button>';
	
	 
	
	let row = '<tr id="' + item.subjectId + '">'
		+ '<td>' + item.description + '</td>'
		+ '<td>'
			+ update_btn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};

const deleteSubject = (id) => {
	console.log(id);
	console.log(status);
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to delete ?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				type: "POST",
				url: "/SchoolManagementSystem/ManageSubjectController?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getSubject();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};

const update = (id,name) => {
	$('#ModalSub').modal('show');
	document.getElementById('hidden_id').value = id;
	document.getElementById('u_subject').value = name;
};

const update_sub = () => {
	
	const s_name = $("#u_subject").val();
	const id=$("#hidden_id").val();
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageSubjectController?action=update&id="+id+"&subjectName="+s_name,
		success: function (data) {
			 
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Subject Updated!',
					'success'
				);
				$('#ModalSub').modal('hide');
				clearForm();
				getSubject();
			}else{
				Swal.fire(
					'Error!',
					'Unable to Update!',
					'error'
				);
			}
		
		
		}
	});
};
