package com;

import model.Hospital;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Hospitals")

public class HospitalService {
	
	
	Hospital hospitalObj = new Hospital();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals() {
		return hospitalObj.readHospitals();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("hosName") String hosName, @FormParam("hosAddress") String hosAddress,
			@FormParam("hosPhoneNo") String hosPhoneNo, @FormParam("hosEmail") String hosEmail, @FormParam("hosNoOfRooms") String hosNoOfRooms) {
		String output = hospitalObj.insertHospital(hosName, hosAddress, hosPhoneNo, hosEmail,hosNoOfRooms);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {
		// Convert the input string to a JSON object
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		// Read the values from the JSON object
		String hosID = hospitalObject.get("hosID").getAsString();
		String hosName = hospitalObject.get("hosName").getAsString();
		String hosAddress = hospitalObject.get("hosAddress").getAsString();
		String hosPhoneNo = hospitalObject.get("hosPhoneNo").getAsString();
		String hosEmail = hospitalObject.get("hosEmail").getAsString();
		String hosNoOfRooms = hospitalObject.get("hosNoOfRooms").getAsString();
		String output = hospitalObj.updateHospital(hosID, hosName, hosAddress, hosPhoneNo, hosEmail, hosNoOfRooms);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

		// Read the value from the element <hosID>
		String hosID = doc.select("hosID").text();
		String output = hospitalObj.deleteHospital(hosID);
		return output;
	}

}