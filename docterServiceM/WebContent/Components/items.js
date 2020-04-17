$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
 $("#formItem").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
 $("#firstName").val($(this).closest("tr").find('td:eq(0)').text());
 $("#lastName").val($(this).closest("tr").find('td:eq(1)').text());
 $("#address").val($(this).closest("tr").find('td:eq(2)').text());
 $("#description").val($(this).closest("tr").find('td:eq(3)').text());
 $("#speciality").val($(this).closest("tr").find('td:eq(4)').text());
 $("#qualification").val($(this).closest("tr").find('td:eq(5)').text());
 $("#gender").val($(this).closest("tr").find('td:eq(6)').text());
 $("#phoneNo").val($(this).closest("tr").find('td:eq(7)').text());
});
// CLIENTMODEL=========================================================================
function validateItemForm()
{
// CODE
if ($("#firstName").val().trim() == "")
 {
 return "Insert First Name.";
 }
// NAME
if ($("#lastName").val().trim() == "")
 {
 return "Insert Last Name.";
 } 
//NAME
if ($("#address").val().trim() == "")
{
return "Insert Address.";
}
//NAME
if ($("#description").val().trim() == "")
{
return "Insert Description.";
}
//NAME
if ($("#speciality").val().trim() == "")
{
return "Insert Speciality.";
}
//NAME
if ($("#qualification").val().trim() == "")
{
return "Insert Qualification.";
}
if ($("#gender").val().trim() == "")
{
return "Insert Gender.";
}
if ($("#phoneNo").val().trim() == "")
{
return "Insert Phone Number.";
}
return true;
}