package payment;

import java.sql.*;


public class paymentModel {
	
	//Connect to DB
	private Connection connect() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?serverTimezone=UTC", "root", "");
	
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		return con;
	}
	
	//Insert data to DB
	public String insertPayment(String docName,String patiName,String docCharges,String booknCharges,String hosptlCharges,String pharmBill,String dt)
	{
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				
				return "DB Insert error.";
			}
			
			// create a prepared statement
			String query = "INSERT INTO `payment`(`paymentId`, `docName`, `patiName`, `docCharges`, `booknCharges`, `hosptlCharges`, `pharmeasyBill`, `dateTime`)" 
			+ "VALUES (?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(100, docName);
			preparedStmt.setString(100, patiName);
			preparedStmt.setDouble(4, Double.parseDouble(docCharges));
			preparedStmt.setDouble(4, Double.parseDouble(booknCharges));
			preparedStmt.setDouble(4, Double.parseDouble(hosptlCharges));
			preparedStmt.setDouble(4, Double.parseDouble(pharmBill));

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Inserted successfully";
					
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	//jj
	
	
	



}
