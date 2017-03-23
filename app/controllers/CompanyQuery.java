package controllers;

import play.mvc.*;

import views.html.*;

import services.Company;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class CompanyQuery extends Controller {

    public Result getCompany(String sym) {
	    
	//updatePrices();

	services.Company c = services.Company.getCompanyBySymbol(sym);
	if(c == null) {
	    return badRequest("Bad Request"); // CHANGE THIS TO RETURN AN INTERNAL SERVER ERROR (500)
	}
	
	String json = getJsonForCompany(c);
	return ok(json);
    }
    
	// @PUT
	//     @Produces(MediaType.APPLICATION_JSON)
	//     @Consumes(MediaType.APPLICATION_JSON)
	//     public Response updateCompany( @PathParam("symbol") String sym, InputStream data) {
	//     services.Company c = services.Company.getCompanyBySymbol(sym);
	//     if(c == null) {
	// 	return Response.status(Response.Status.NOT_FOUND).build();
	//     }
	    
	//     String json = "";
	//     try {
	// 	BufferedReader in = new BufferedReader(new InputStreamReader(data));
	// 	String line = null;
	// 	while((line = in.readLine()) != null)
	// 	    json += line;

	// 	JSONObject obj = new JSONObject(json);
	// 	String name = obj.getString("name");
		
	// 	// Attempt to update the company
	// 	// If it fails, return a server error
	// 	if(!services.Company.updateCompany(name, sym)) {
	// 	    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	// 	}
		
	//     } catch(IOException | JSONException e) { // bad json format
	// 	return Response.status(Response.Status.BAD_REQUEST).build();
	//     }
	//     return Response.status(Response.Status.NO_CONTENT).build();
	// }
	
	// @DELETE
	//     @Produces(MediaType.APPLICATION_JSON)
	//     public Response deleteCompany( @PathParam("symbol") String sym ) {
	//     services.Company c = services.Company.getCompanyBySymbol(sym);
	//     if(c == null) {
	// 	return Response.status(Response.Status.NOT_FOUND).build();
	//     }

	//     // Attempt to add the company
	//     // If it fails, return a server error
	//     if(!services.Company.deleteCompany(sym)) {
	// 	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	//     }
	//     String json = getJsonForCompany(c);
	//     return Response.ok(json, MediaType.APPLICATION_JSON).build();
	// }

    private String getJsonForCompany(services.Company c) {
	String json = "{\n";
	json += "  \"name\": \"" + c.getName() + "\",\n";
	json += "  \"symbol\": \"" + c.getSymbol() + "\",\n";
	json += "  \"stockValue\": " + c.getStockValue() + ",\n";
	json += "  \"availableStocks\": " + c.getNumberOfAvailableStocks() + "\n";
	json += "}";
	return json;
    }

	// // Updates the stock prices of the companies.
	// public void updatePrices() {
	//     services.Company[] companies = services.Company.getCompanies();
	//     String[] symbols = new String[companies.length];
	//     for(int i=0, length=companies.length; i<length; ++i) {
	// 	symbols[i] = companies[i].getSymbol();
	//     }
	//     services.StockReader.updateStocks(symbols);
	// }
}
