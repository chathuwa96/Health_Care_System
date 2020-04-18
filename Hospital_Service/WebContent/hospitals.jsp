<%@page import="model.Hospital"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	//Initialize---------------------------
session.setAttribute("statusMsg", "");
System.out.println("Tryingto process...");

//Save---------------------------------
if (request.getParameter("hosName") != null) {
	Hospital hospitalObj = new Hospital();
	String stsMsg = "";
	//Insert--------------------------
	if (request.getParameter("hidhosIDSave") == "") {
		stsMsg = hospitalObj.insertHospital(request.getParameter("hosName"), request.getParameter("hosAddress"),
		request.getParameter("hosPhoneNo"), request.getParameter("hosEmail"),
		request.getParameter("hosNoOfRooms"));
	} else//Update----------------------
	{
		stsMsg = hospitalObj.updateHospital(request.getParameter("hidhosIDSave"), request.getParameter("hosName"),
		request.getParameter("hosAddress"), request.getParameter("hosPhoneNo"),
		request.getParameter("hosEmail"), request.getParameter("hosNoOfRooms"));
	}
	session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidhosIDDelete") != null) {
	Hospital hospitalObj = new Hospital();
	String stsMsg = hospitalObj.deleteHospital(request.getParameter("hidhosIDDelete"));
	session.setAttribute("statusMsg", stsMsg);
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospitals Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/hospitals.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="cal-6">

				<h1>Hospitals Management</h1>

				<form id="formHospital" name="formHospital" method="post" action="hospitals.jsp">
					Hospital Name: <input id="hosName" name="hosName" type="text"
						class="form-control form-control-sm"> <br> Hospital Address:
					<input id="hosAddress" name="hosAddress" type="text"
						class="form-control form-control-sm"> <br> Hospital
					Phone No: <input id="hosPhoneNo" name="hosPhoneNo" type="text"
						class="form-control form-control-sm"> <br> Hospital
					Email: <input id="hosEmail" name="hosEmail" type="text"
						class="form-control form-control-sm"> <br> Hospital
					No Of Rooms: <input id="hosNoOfRooms" name="hosNoOfRooms" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidhosIDSave" name="hidhosIDSave" value="">
				</form>
				<br>

				<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>
				<%
				Hospital hospitalObj = new Hospital();
				out.print(hospitalObj.readHospitals());
				%>

			</div>
		</div>
	</div>
	<br>
</body>
</html>