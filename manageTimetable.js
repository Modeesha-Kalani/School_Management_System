$(function() {
	getTimetable();
});

const getTimetable = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/timetableController?action=get",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function (data) {
			$('#tblViewStudents > tbody').html('');
			$.each(data, function (i, timetable) {
				appendTimeTable(timetable);
			});
		}
	});
}

const appendTimeTable = (item) => {
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewStudents > tbody').append(textToInsert);
};

const addRow = (item) => {
	
	
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.timeTableId + 'delete" onclick="deleteTimetable(\'' + item.timeTableId + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Time Table</button>';
	
	 
	
	let row = '<tr id="' + item.timeTableId + '">'
		+ '<td>' + item.section + '</td>'
		+ '<td>' + item.grade + '</td>'
		+ '<td>' + item.userClass + '</td>'
		
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};


const deleteTimetable = (id) => {
	console.log(id);
	console.log(status);
	
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
				url: "/SchoolManagementSystem/timetableController?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getTimetable();						
					}
				}
			});
			
		} 
	})
};

