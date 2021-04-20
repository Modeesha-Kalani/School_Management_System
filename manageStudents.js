$(function() {
	getStudents(); //run as soon as loads
});

const getStudents = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/manageStudent?action=get", //send to controller
		headers : { //json type
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		
	//success function
		success: function (data) {
			$('#tblViewStudents > tbody').html(''); //clear all data to stop data repeating
			$.each(data, function (i, student) { //loop for all rows
				appendStudentTable(student); //below function
			});
		}
	});
}

const appendStudentTable = (item) => { //get data from student class
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewStudents > tbody').append(textToInsert);
};

//seperated to 3 because it was needed to add into tbody

const addRow = (item) => {
	
	const statusChangeBtn = '<button type="button" class="btn btn-info btn-xs" id="' + item.id + 'changeStatus" onclick="changeStatus(\'' + item.id + '\',\'' + item.status + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.id + 'delete" onclick="deleteStudent(\'' + item.id + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Student</button>';
	
	let statusBadge;
	if(item.status == 1){ //get status from student class using item
		statusBadge = '<span class="badge badge-success">Active</span>' //if status is active show green sign
	}else{
		statusBadge = '<span class="badge badge-danger">Inactive</span>'
	}
	
	let row = '<tr id="' + item.id + '">'
		+ '<td>' + item.fullName + '</td>'
		+ '<td>' + item.firstName + '</td>'
		+ '<td>' + item.lastName + '</td>'
		+ '<td>' + item.dob + '</td>'
		+ '<td>' + item.admissionDate + '</td>'
		+ '<td>' + item.addmissionNo + '</td>'
		+ '<td>' + item.guardianName + '</td>'
		+ '<td>' + item.cno + '</td>'
		+ '<td>' + statusBadge + '</td>'
		+ '<td>'
			+ statusChangeBtn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};

const changeStatus = (id, status) => {
	console.log(id);
	console.log(status);
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to change status?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				type: "POST",
				url: "/SchoolManagementSystem/manageStudent?action=update&id="+id+"&status="+status,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getStudents();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};

const deleteStudent = (id) => {
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
				url: "/SchoolManagementSystem/manageStudent?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getStudents();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};
