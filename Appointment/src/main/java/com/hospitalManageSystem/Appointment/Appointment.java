package com.hospitalManageSystem.Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Appointment {

	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/appointmentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	
	/////////////////////// Read Method ///////////////////////////////


	public String readAppointment() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>appointmentID</th><th>patientID</th><th>Date</th><th>DoctorName</th><th>HospitalName</th> <th>AppointmentType </th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String appointmentID = Integer.toString(rs.getInt("appointmentID"));
				String patientID = rs.getString("patientID");
				String Date = rs.getString("Date");
				String docName = rs.getString("docName");
				String hosName = rs.getString("hosName");
				String appType = rs.getString("appType");

				
				// Add into the html table
				//output += "<tr><td>" + itemID + "</td>";
				output += "<tr><td>" + appointmentID + "</td>";
				output += "<td>" + patientID + "</td>";
				output += "<td>" + Date + "</td>";
				output += "<td>" + docName + "</td>";
				output += "<td>" + hosName + "</td>";
				output += "<td>" + appType + "</td>";



				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"        "
						+ "value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"      "
						+ "class=\"btn btn-danger\">" + "<input name=\"itemID\" type=\"hidden\" value=\"" + appointmentID
						+ "\">" + "</form></td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the appointments.";
			System.err.println(e.getMessage());
		}

		return output;

	}
	
	
	/////////////////////// Insert Method ///////////////////////////////
	
	
	public String insertAppointment(String patientID, String Date, String docName, String hosName, String appType) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into appointment (`appointmentID`,`patientID`,`Date`,`docName`,`hosName`,`appType`)"
					+ " values (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, patientID);
			preparedStmt.setString(3, Date);
			preparedStmt.setString(4, docName);
			preparedStmt.setString(5, hosName);
			preparedStmt.setString(6, appType);


			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the appointment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

		
	/////////////////////// Update Method ///////////////////////////////

	
	public String updateAppointment(int appointmentID,String patientID, String Date, String docName,String hosName,String appType) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE appointment SET patientID=?,Date=?,docName=?,hosName=?,appType=?WHERE appointmentID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, patientID);
			preparedStmt.setString(2, Date);
			preparedStmt.setString(3, docName);
			preparedStmt.setString(4, hosName );
			preparedStmt.setString(5, appType );
			preparedStmt.setInt(6,appointmentID);



			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Appointment.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	/////////////////////// Delete Method ///////////////////////////////

	public String deleteAppointment(String appointmentID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from appointment where appointmentID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(appointmentID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the appointment.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
}
