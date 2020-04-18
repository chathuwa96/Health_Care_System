package com;
import model.Docter;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

	
	@Path("/Docter")
	public class docterService {
		Docter itemObj = new Docter();

		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readItems() {
			return itemObj.readdocter();
		}
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("firstName") String firstName,
		 @FormParam("lastName") String lastName,
		 @FormParam("address") String address,
		 @FormParam("description") String description,
		 @FormParam("speciality") String speciality,
		 @FormParam("qualification") String qualification,
		 @FormParam("gender") String gender,
		 @FormParam("phoneNo") String phoneNo)
		{
		 String output = itemObj.insertdocter(firstName, lastName, address, description, speciality, qualification, gender, phoneNo);
		return output;
		}
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatedocter(String itemData)
		{
		//Convert the input string to a JSON object
		 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		 String docID = itemObject.get("docID").getAsString();
		 String firstName = itemObject.get("firstName").getAsString();
		 String lastName = itemObject.get("lastName").getAsString();
		 String address = itemObject.get("address").getAsString();
		 String description = itemObject.get("description").getAsString();
		 String speciality = itemObject.get("speciality").getAsString();
		 String qualification = itemObject.get("qualification").getAsString();
		 String gender = itemObject.get("gender").getAsString();
		 String phoneNo = itemObject.get("phoneNo").getAsString();
		 String output = itemObj.updatedocter(docID, firstName, lastName, address, description, speciality, qualification, gender, phoneNo);
		return output;
		}
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletedocter(String itemData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String docID = doc.select("docID").text();
		 String output = itemObj.deletedocter(docID);
		return output;
		}

}
