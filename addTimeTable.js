$(function() {
	loadTeacherList();
	loadSubjectList();
	getMaxId();
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if(e.target.id === 'section_text'){
				if (validateRequired('section_text')) {
					$("#grade_text").focus().select()				
				}
			}else if(e.target.id === 'grade_text'){
				if (validateRequired('grade_text')) {
					$("#class_text").focus().select()						
				}
			} 
		}
	});
});

const validateSubmit = (event) => {
	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('section_text')){
		validateRequired('section_text');
		err++;
	}
	
	if(!validateRequired('grade_text')){
		validateRequired('grade_text');
		err++;
	}
	
	if(!validateRequired('class_text')){
		validateRequired('class_text');
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
	$("#addTimeTable").prop("disabled", true);
	const sections = $("#section_text").val();
	const grade = $("#grade_text").val();
	const class_text = $("#class_text").val();
	const nextId = $("#nextId").val();
	
	let tabel_data = [];
	
	var table = $("#timetable table tbody");
	
	table.find('tr').each(function (i, el) {
        var $tds = $(this).find('td'),
            day = $tds.eq(0).text(),
            period = $tds.eq(1).text(),
            teachername = $tds.eq(2).text();
        	subject = $tds.eq(3).text();
        	close = $tds.eq(4).text();
        
        // do something with productId, product, Quantity
    });
	
	 
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/timetableController?action=add&sectionVal="+sections+"&nextId="+nextId+"&gradeVal="+grade+"&class_text="+class_text,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Time Table Saved Successfully !',
					'success'
				);
				addTimetabelSubject();
				getMaxId();
				clearForm();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			$("#addTimeTable").prop("disabled", false);
		}
	});
};

const clearForm = () => {
	$("#addTimeTableForms").trigger('reset');
	$("#timetable > tbody").find("tr").remove();
	$("#nextId").val("");
	$("#section_text").val("");
	$("#grade_text").val("");
	$("#class_text").val("");
	getMaxId();
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
					$("#teacher").append(`<option>${element.name}</option>`);
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
					$("#all_subject").append(`<option>${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};


const addToTimetable = (event) => {
	
	event.preventDefault();
	const day = $('#day').val();
	const period = $('#period').val();
	const teacher = $('#teacher').val();
	const all_subject = $('#all_subject').val();
	
	  
	
	 
		
	$('#timetable >tbody >tr').find('.iteminsert').val('');
	
	
	const id = all_subject.replace(/[^a-z0-9\s]/gi, '').replace(/\s/g, "");
	
	let isExsist = false;
	
	if ($('#timetable > tbody').find('#' + id).length > 0) {
		isExsist = true;
	}
	
	if (!isExsist) {
		addRow(id);
	}else{
		console.log("else state!");
	}
	
	$('#day' + id).val(day);
	$('#period' + id).val(period);
	$('#teacher' + id).val(teacher);
	$('#all_subject' + id).val(all_subject);
	
	$('#timetable >tbody >tr').find('.iteminsert').val('');
	
};

const addRow = (id) => {
	
	let text = "";
	$('#timetable tbody').append('<tr id="' + id + '"><td class="td-input">'
		+ '<input  type="text" id="day' + id + '" name="day' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '<td class="td-input" >'
		+ '<input type="text" id="period' + id + '" name="period' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '<td class="td-input" >'
		+ '<input type="text" id="teacher' + id + '" name="teacher' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '<td class="td-input" >'
		+ '<input type="text" id="all_subject' + id + '" name="all_subject' + id + '" class="form-control" readonly >'
		+ '</td>'
		+ '</td>'
		+ '<td class="text-center" id="deleteRow' + id + '" onclick="removeFromTables(this.id);" ><span class="fas fa-window-close" style="color:red;cursor: pointer"></span>'
		+ '</td>'
		+ '</tr>');
};


const removeFromTables = (id) => {
	$("#" + id).parent().remove();
};


const getMaxId = () => {
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/timetableController?action=maxId",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},//
		success: function (data) { 
			
			const id = data.timeTableId;
			const newId = parseInt(id) + 1;
			$("#newId").text("Next ID : " + newId);
			$("#nextId").val(newId);
		}
	});
};


const addTimetabelSubject = () => {
	let timetable = new Array();
	let error = 0;
	$('#timetable > tbody > tr').each(function (row, tr) {
		timetable[row] = {
			"ID": $("#nextId").val()
			, "day": $(tr).find('td:eq(0) input').val()
			, "period": $(tr).find('td:eq(1) input').val()
			, "teacher": $(tr).find('td:eq(2) input').val()
			, "subject": $(tr).find('td:eq(3) input').val()
		};
	});
	

	$.each(timetable, function (i, timetable) {
		$.ajax({
			type: "POST",
			url: "/SchoolManagementSystem/timetableController?action=addTimetable&id="+timetable.ID+"" +
					"&period="+timetable.period+"&day="+timetable.day+"&teacher="+timetable.teacher+"&subject="+timetable.subject,
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

