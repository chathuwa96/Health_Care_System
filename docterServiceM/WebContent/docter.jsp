<%@page import="model.Docter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	//Initialize---------------------------
session.setAttribute("statusMsg", "");
System.out.println("Tryingto process...");

//Save---------------------------------
if (request.getParameter("firstName") != null) {
	Docter itemObj = new Docter();
	String stsMsg = "";
	//Insert--------------------------
	if (request.getParameter("hidItemIDSave") == "") {
		stsMsg = itemObj.insertdocter(request.getParameter("firstName"), request.getParameter("lastName"),
		request.getParameter("address"), request.getParameter("description"),
		request.getParameter("speciality"), request.getParameter("qualification"),
		request.getParameter("gender"), request.getParameter("phoneNo"));
	} else//Update----------------------
	{
		stsMsg = itemObj.updatedocter(request.getParameter("hidItemIDSave"), request.getParameter("firstName"),
		request.getParameter("lastName"), request.getParameter("address"), request.getParameter("description"),
		request.getParameter("speciality"), request.getParameter("qualification"),
		request.getParameter("gender"), request.getParameter("phoneNo"));
	}
	session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidItemIDDelete") != null) {
	Docter itemObj = new Docter();
	String stsMsg = itemObj.deletedocter(request.getParameter("hidItemIDDelete"));
	session.setAttribute("statusMsg", stsMsg);
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Management</title>

<style>
div.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	width: 96%;
	margin: auto;
}
</style>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-sm-2"></div>
			<div class="col-sm-8">

				<h1 align="center">Doctor Management</h1>

				<form id="formItem" name="formItem" method="post"
					action="docter.jsp">
					First Name: <input id="firstName" name="firstName" type="text"
						class="form-control form-control-sm"> <br> Last Name
					<input id="lastName" name="lastName" type="text"
						class="form-control form-control-sm"> <br> Address: <input
						id="address" name="address" type="text"
						class="form-control form-control-sm"> <br>
					Description: <input id="description" name="description" type="text"
						class="form-control form-control-sm"> <br>
					Speciality: <input id="speciality" name="speciality" type="text"
						class="form-control form-control-sm"> <br>
					Qualification: <input id="qualification" name="qualification"
						type="text" class="form-control form-control-sm"> <br>

					<!--Gender: <input id="gender" name="gender" type="text" class="form-control form-control-sm">-->

					<!--<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
						Gender:</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						Male<input id="gender" name="gender"  type="radio" class="form-control form-control-sm" value="Male">
						Female<input id="gender" name="gender"  type="radio" class="form-control form-control-sm" value=Female>
						
						
						</div>-->

					<select id="gender" name="gender">
						<option value="0">--Select Gender--</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select><br> <br> Phone Number: <input id="phoneNo"
						name="phoneNo" type="text" class="form-control form-control-sm">
					<br> <input id="btnSave" name="btnSave" type="button"
						value="Save" class="btn btn-primary btn-lg btn-block"> <input
						type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>


				<div class="col-sm-2"></div>
			</div>
		</div>
		<br> <br>

		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">

					<%
						Docter itemObj = new Docter();
					out.print(itemObj.readdocter());
					%>


				</div>

				<div class="col-sm-1"></div>
			</div>
		</div>
	</div>
</body>
</html>




