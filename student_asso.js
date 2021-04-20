/**
 * 
 */
 
 $(function() {
	 loadAssocList();
	 loadStudentList();
	//enter key press event
	$(document).keypress(function (e) {
		std_association(event);
		if (e.which === 13) {
			e.preventDefault();
			std_association(event);
		}
	});
});
 
 const validateSubmit = (event) => {
		
	 std_association(event);
		
};
 
 
 const std_association = (e) =>{
 	e.preventDefault();
	$("#assignAssos").prop("disabled", true);
	
	const assoc = $("#assoc").val();
	const student = $("#student").val();
	
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/accociationHasStudentaController?assoc="+assoc+"&student="+student,
		success: function (data) {
			console.log(data);
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
		
			$("#assignAssos").prop("disabled", false);
		}
	});
	
 };
 
 
 const clearForm = () => {
	$("#std_asso").trigger('reset');
};

const loadAssocList = () => {
	
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/RetrieveAssoList",
		success: function (data) {
			console.log(data);
			if(data){
				var list = JSON.parse(data);
				list.forEach(element => {
					$("#assoc").append(`<option value="${element.id}">${element.name}</option>`);
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
