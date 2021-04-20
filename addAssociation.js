/**
 * 
 */
 
 $(function() {
	loadTeacherList();
	getAssociation();
	

	$("#name").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'asso_name') {
				if (validateRequired('asso_name')) {
					$("#count").focus().select();					
				}
			}else if(e.target.id === 'count'){
				if (validateRequired('count')) {
					validateSubmit(e);					
				}
			}
		}
	});
});
 
 
 const validateSubmit = (event) =>{
 	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('asso_name')){
		validateRequired('asso_name');
		err++;
	}
	
	if(!validateRequired('count')){
		validateRequired('count');
		err++;
	}
	
	if(err == 0){
		addAssociation(event);
	}else{
		return false;
	}
 }
 
 
 const addAssociation = (e) =>{
 	e.preventDefault();
	$("#submitAssorciations").prop("disabled", true);
	
	const association = $("#asso_name").val();
	const teacher = $("#teacher").val();
	const count = $("#count").val();
	 
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/addAssorciationController?association="+association+"&teacher="+teacher+"&count="+count,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Association Details Saved!',
					'success'
				);
				clearForm();
				getAssociation();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			$("#submitAssorciations").prop("disabled", false);
		}
	});
	
 };
 
 
 const clearForm = () => {
	$("#association_frm").trigger('reset');
};


const getAssociation = () => {

	console.log("Get Students");
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageAssociationController?action=get",
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
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.accociationId + 'delete" onclick="deleteAsso(\'' + item.accociationId + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Association</button>';
	const update_btn = '<button type="button" class="btn btn-info btn-xs" id="' + item.accociationId + 'delete" onclick="update(\'' + item.accociationId + '\',\'' + item.name + '\',\'' + item.teacherDetailsId + '\',\'' + item.memberCount + '\')">&nbsp;Update Association</button>';
	 
	
	let row = '<tr id="' + item.accociationId + '">'
		+ '<td>' + item.name + '</td>'
		+ '<td>' + item.teacherDetailsId + '</td>'
		+ '<td>' + item.memberCount + '</td>'
		+ '<td>'
			+ update_btn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
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
					$("#update_teacher").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};

const deleteAsso = (id) => {
	 
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
				url: "/SchoolManagementSystem/ManageAssociationController?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getAssociation();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};


const update = (id,name,teacher,mem) => {
	$('#ModalSport').modal('show');
	document.getElementById('hidden_id').value = id;
	document.getElementById('a_name').value = name;
	document.getElementById('mem_count_update').value = mem;
};


const update_asso = () => {
	
	const a_name = $("#a_name").val();
	const update_teacher = $("#update_teacher").val();
	const mem_count_update = $("#mem_count_update").val();
	const id=$("#hidden_id").val();
	 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageAssociationController?action=update&id="+id+"&AssoName="+a_name+"&teachers="+update_teacher+"&memberCount="+mem_count_update,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Sport Details Updated!',
					'success'
				);
				$('#ModalSport').modal('hide');
				clearForm();
				getAssociation();
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
