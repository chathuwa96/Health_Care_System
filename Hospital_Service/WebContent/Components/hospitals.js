$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateHospitalForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#formHospital").submit();
});
// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidhosIDSave").val(
					$(this).closest("tr").find('#hidhosIDUpdate').val());
			$("#hosName").val($(this).closest("tr").find('td:eq(0)').text());
			$("#hosAddress").val($(this).closest("tr").find('td:eq(1)').text());
			$("#hosPhoneNo").val($(this).closest("tr").find('td:eq(2)').text());
			$("#hosEmail").val($(this).closest("tr").find('td:eq(3)').text());
			$("#hosNoOfRooms").val($(this).closest("tr").find('td:eq(4)').text());
		});
// CLIENTMODEL=========================================================================
function validateHospitalForm() {
	// CODE
	if ($("#hosName").val().trim() == "") {
		return "Insert Hospital Name.";
	}
	// NAME
	if ($("#hosAddress").val().trim() == "") {
		return "Insert Hospital Address.";
	}
	// DESCRIPTION------------------------
	if ($("#hosPhoneNo").val().trim() == "") {
		return "Insert Hospital Phone No.";
	}
	// DESCRIPTION------------------------
	if ($("#hosEmail").val().trim() == "") {
		return "Insert Hospital Email.";
	}
	// DESCRIPTION------------------------
	if ($("#hosNoOfRooms").val().trim() == "") {
		return "Insert No Of Rooms.";
	}
	return true;
}