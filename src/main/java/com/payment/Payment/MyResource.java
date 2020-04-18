package com.payment.Payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//For REST Service 
import javax.ws.rs.*;


//For JSON 
//import com.google.gson.*;

//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	Payment payObj = new Payment();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        //return "Got it!";
    	return payObj.readItems();
    }
	
	@POST 
    @Path("/insert") 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    @Produces(MediaType.TEXT_PLAIN) 
    public String insertItem(@FormParam("paymentId") String paymentId,       
    						@FormParam("docName") String docName,    
    						@FormParam("patiName") String patiName,       
    						@FormParam("docCharges") String docCharges,
    						@FormParam("booknCharges") String booknCharges,
							@FormParam("hosptlCharges") String hosptlCharges,
							@FormParam("pharmBill") String pharmBill)
    {  
    	String output = payObj.insertPayment(paymentId, docName, patiName, docCharges, booknCharges, hosptlCharges, pharmBill);  
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
    	String itemID = doc.select("paymentId").text(); 
     
    	String output = payObj.deleteItem(itemID); 
     
    	return output; 
    	
    }
}
