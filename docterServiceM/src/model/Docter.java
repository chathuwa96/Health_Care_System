package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Docter {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");

			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertdocter(String firstName, String lastName, String address, String description, String speciality,
			String qualification, String gender, String phoneNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = "insert into docter values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, description);
			preparedStmt.setString(6, speciality);
			preparedStmt.setString(7, qualification);
			preparedStmt.setString(8, gender);
			preparedStmt.setString(9, phoneNo);
			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";
			System.out.println(" insert");
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
			System.out.println("not insert");
		}

		return output;
	}

	public String readdocter() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\" width=\"100%\"><tr><th>firstName</th> <th>lastName</th> <th>address</th>  <th>description</th> <th>speciality</th> <th>qualification</th> <th>gender</th>  <th>phoneNo</th>	 <th>Update</th> <th>Remove</th>  </tr>";

			String query = "select * from docter";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String docID = Integer.toString(rs.getInt("docID"));
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String address = rs.getString("address");
				String description = rs.getString("description");
				String speciality = rs.getString("speciality");
				String qualification = rs.getString("qualification");
				String gender = rs.getString("gender");
				String phoneNo = rs.getString("phoneNo");

				// Add into the html table
				output += "<tr><td><input id=\"hidItemIDUpdate\" name=\"hidItemIDUpdate\" type=\"hidden\" value=\""
						+ docID + "\">" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + description + "</td>";
				output += "<td>" + speciality + "</td>";
				output += "<td>" + qualification + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + phoneNo + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\" btnUpdate btn btn-secondary\"></td> <td><form method=\"post\" action=\"docter.jsp\">  <input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">  <input name=\"hidItemIDDelete\" type=\"hidden\" value=\""
						+ docID + "\">" + "</form></td>      </tr>";
			}
			con.close();

			// Complete the html table
			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatedocter(String docID, String firstName, String lastName, String address, String description,
			String speciality, String qualification, String gender, String phoneNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE docter SET firstName=?, lastName=?, address=?, description=?, speciality=?, qualification=?, gender=?, phoneNo=? WHERE docID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, description);
			preparedStmt.setString(5, speciality);
			preparedStmt.setString(6, qualification);
			preparedStmt.setString(7, gender);
			preparedStmt.setString(8, phoneNo);
			preparedStmt.setInt(9, Integer.parseInt(docID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	/*
	 * public String updatedocter(String docID,String firstName, String lastName,
	 * String address, String description,String speciality,String
	 * qualification,String gender,String phoneNo) { String output = ""; try {
	 * Connection con = connect(); if (con == null) {return
	 * "Error while connecting to the database for updating."; } // create a
	 * prepared statement String query =
	 * "UPDATE items SET firstName=?,lastName=?,address=?,description=?,speciality=?,qualification=?,gender=?,phoneNo=? WHERE itemID=?"
	 * ; PreparedStatement preparedStmt = con.prepareStatement(query); // binding
	 * values preparedStmt.setInt(1, 0); preparedStmt.setString(2, firstName);
	 * preparedStmt.setString(3, lastName); preparedStmt.setString(4, address);
	 * preparedStmt.setString(5, description); preparedStmt.setString(6,
	 * speciality); preparedStmt.setString(7, qualification);
	 * preparedStmt.setString(8, gender); preparedStmt.setString(9, phoneNo); //
	 * execute the statement preparedStmt.execute(); con.close(); output =
	 * "Updated successfully"; } catch (Exception e) { output =
	 * "Error while updating the item."; System.err.println(e.getMessage()); }
	 * return output; }
	 */

	public String deletedocter(String docID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from docter where docID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
