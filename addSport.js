/**
 * 
 */
 
 
 $(function() {
	 loadTeacherList(); //to load teacher list
	 getSport();
	 
	$("#name").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'name') {
				if (validateRequired('name')) {
					$("#name").focus().select();					
				}
			}else if(e.target.id === 'memberCounts'){
				if (validateRequired('memberCounts')) {
					$("#memberCounts").focus().select();					
				}
			}else if(e.target.id === 'memberCounts'){
				if (validateRequired('memberCounts')) {
					validateSubmit(e);					
				}
			}
		}
	});
	
});
 //if we missed something it will become red
 const validateSubmit = (event) =>{
 	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('name')){
		validateRequired('name');
		err++;
	}
	
	if(!validateRequired('memberCounts')){
		validateRequired('memberCounts');
		err++;
	}
	
	if(err == 0){
		 addSport(event);
	}else{
		return false;
	}
 }
 
 //if there is no error data will be added to here
 const addSport = (e) =>{
 	e.preventDefault();
	$("#submitSport").prop("disabled", true);
	
	const sportName = $("#name").val();
	const teachers = $("#teacher").val();
	const memebr_count = $("#memberCounts").val();
	 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/addSports?sportName="+sportName+"&teachers="+teachers+"&memberCount="+memebr_count,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Sport Details Saved!',
					'success'
				);
				clearForm();
				getSport();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			$("#submitSport").prop("disabled", false);
		}
	});
	
 };
 
 //reset the form after submission
 const clearForm = () => {
	$("#addSportData").trigger('reset');
};



const getSport = () => {
	
	 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageSportController?action=get",
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
	
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.sportId + 'delete" onclick="deleteSport(\'' + item.sportId + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Sport</button>';
	const update_btn = '<button type="button" class="btn btn-info btn-xs" id="' + item.sportId + 'delete" onclick="update(\'' + item.sportId + '\',\'' + item.name + '\',\'' + item.teacherDetailsId + '\',\'' + item.memeberCount + '\')">&nbsp;Update Sport</button>';
	 
	
	let row = '<tr id="' + item.sportId + '">'
		+ '<td>' + item.name + '</td>'
		+ '<td>' + item.teacherDetailsId + '</td>'
		+ '<td>' + item.memeberCount + '</td>'
		+ '<td>'
			+ update_btn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};

//load available teachers list 
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
					$("#update_teacher_details").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};

const deleteSport = (id) => {
	console.log(id);
	
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({ //kind of alert
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
				url: "/SchoolManagementSystem/ManageSportController?action=delete&id="+id,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getSport();						
					}
				}
			});
		
		}
	})
};

const update = (id,name,teacher,mem) => {
	$('#ModalSport').modal('show');
	document.getElementById('hidden_id').value = id;
	document.getElementById('s_name').value = name;
	document.getElementById('mem_count_update').value = mem;
};


const update_sport = () => {
	
	const s_name = $("#s_name").val();
	const update_teacher = $("#update_teacher_details").val();
	const mem_count_update = $("#mem_count_update").val();
	const id=$("#hidden_id").val();
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/ManageSportController?action=update&id="+id+"&sportName="+s_name+"&teachers_name="+update_teacher+"&memberCount="+mem_count_update,
		success: function (data) {
		
			console.log(data);
			if(data){
				Swal.fire( //kind of alert
					'Successful!',
					'Sport Details Updated!',
					'success'
				);
				$('#ModalSport').modal('hide');
				clearForm();
				getSport();
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
