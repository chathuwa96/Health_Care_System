package com.hospitalManageSystem.Appointment;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	
	Appointment appObj = new Appointment();
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
       // return "Got it!";
    	return appObj.readAppointment();
    }
    
    
    @POST 
    @Path("/insert") 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    @Produces(MediaType.TEXT_PLAIN) 
    public String insertItem(@FormParam("patientID") String patientID,       
    						@FormParam("Date") String Date,    
    						@FormParam("docName") String docName,       
    						@FormParam("hosName") String hosName,
    						@FormParam("appType") String appType) 
    {  
    	String output = appObj.insertAppointment(patientID, Date, docName, hosName,appType);  
    	return output; 
    } 
    
    
   @PUT 
    @Path("/update") 
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.TEXT_PLAIN) 
    public String updateItem(String itemData) {  

    	//Convert the input string to a JSON object  
    	JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject(); 
     
    	//Read the values from the JSON object 
    	int appointmentID = itemObject.get("appointmentID").getAsInt();  
    	String patientID = itemObject.get("patientID").getAsString();  
    	String Date = itemObject.get("Date").getAsString();  
    	String docName = itemObject.get("docName").getAsString();  
    	String hosName = itemObject.get("hosName").getAsString();  
    	String appType = itemObject.get("appType").getAsString(); 
     
        String output = appObj.updateAppointment(appointmentID,patientID, Date, docName, hosName, appType); 
     
    	return output; 
    } 
    
    
   
   @DELETE 
   @Path("/delete") 
   @Consumes(MediaType.APPLICATION_XML) 
   @Produces(MediaType.TEXT_PLAIN) 
   public String deleteItem(String itemData) {  
   	
   	//Convert the input string to an XML document  
   	Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());     
   	
   	//Read the value from the element <itemID>  
   	String appointmentID = doc.select("appointmentID").text(); 
    
   	String output = appObj.deleteAppointment(appointmentID); 
    
   	return output; 
   	
   }
   
    
}
