/**
 * 
 */
 
 $(function() {
	 loadSportList();
	 loadStudentList();

	 
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			std_sport(event);
		}
	});
});
 
 const validateSubmit = (event) => {
		
	 std_sport(event);
		
};
 
 
 const std_sport = (e) =>{
	 
 	e.preventDefault();
	$("#assingsportForStudnet").prop("disabled", true);
	
	const sport = $("#sport").val();
	const student = $("#student").val();
	
	
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/sportHasStudentController?sport="+sport+"&student="+student,
		success: function (data) {
		
			if(data=="true"){
				Swal.fire(
					'Successful!',
					'Association Details Saved!',
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
		
			$("#assingsportForStudnet").prop("disabled", false);
		}
	});
	
 };
 
 
 const clearForm = () => {
	$("#std_sport").trigger('reset');
};

const loadSportList = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/RetrieveSportList",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#sport").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};


const loadStudentList = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/c",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#student").append(`<option value="${element.id}">${element.name}</option>`);
				});
			}else{
				// no data
			}
		}
	});
};
