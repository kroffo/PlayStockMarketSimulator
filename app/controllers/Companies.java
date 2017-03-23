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

public class Companies extends Controller {

    public Result getCompanies() {

	//updatePrices();
	
	services.Company[] companies = services.Company.getCompanies();
	if(companies == null)
	    return ok("Bad request"); // CHANGE THIS TO RETURN AN INTERNAL SERVER ERROR (500)

	String json = "[\n";
	for(int i=0, length=companies.length; i<length; ++i) {
	    services.Company c = companies[i];
	    String currentPath = request().host() + request().path();
	    String cname = c.getName();
	    String csym = c.getSymbol();
	    json += "  {\n";
	    json += "    \"name\": \"" + cname + "\",\n";
	    json += "    \"symbol\": \"" + c.getSymbol() + "\",\n";
	    json += "    \"stockValue\": " + c.getStockValue() + ",\n";
	    json += "    \"availableStocks\": " + c.getNumberOfAvailableStocks() + ",\n";
	    json += "    \"links\": [\n";
	    json += "      {\n";
	    json += "        \"rel\": \"self\",\n";
	    json += "        \"href\": \"" + currentPath + "/" + csym + "\"\n";;
	    json += "      }\n";
	    json += "    ]\n";
	    json += "  }";
	    if(i<length-1)
		json += ",";
	    json += "\n";
	}
	json += "]";

	return ok(json);
    }

    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response postCompany(InputStream data) {

    // 	String json = "";
    // 	try {
    // 	    BufferedReader in = new BufferedReader(new InputStreamReader(data));
    // 	    String line = null;
    // 	    while((line = in.readLine()) != null)
    // 		json += line;
		
    // 	    JSONObject obj = new JSONObject(json);
    // 	    String name = obj.getString("name");
    // 	    String symbol = obj.getString("symbol");

    // 	    if( symbol == null || symbol.equals("") ||
    // 		name == null || name.equals("") )
    // 		return Response.status(Response.Status.BAD_REQUEST).entity("Must provide a symbol and name.").build();
		
    // 	    services.Company c = services.Company.getCompanyBySymbol(symbol);
    // 	    if(c != null) {
    // 		return Response.status(Response.Status.CONFLICT).entity("Company " + symbol + " already exists").build();
    // 	    }

    // 	    // Attempt to add the company
    // 	    // If it fails, return a server error
    // 	    if(!services.Company.addCompany(name, symbol)) {
    // 		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    // 	    }

    // 	} catch(IOException | JSONException e) { // bad json format
    // 	    return Response.status(Response.Status.BAD_REQUEST).build();
    // 	}
    // 	return Response.status(Response.Status.CREATED).build();
    // }

    // Updates the stock prices of the companies.
    // public void updatePrices() {
    // 	services.Company[] companies = services.Company.getCompanies();
    // 	String[] symbols = new String[companies.length];
    // 	for(int i=0, length=companies.length; i<length; ++i) {
    // 	    symbols[i] = companies[i].getSymbol();
    // 	}
    // 	services.StockReader.updateStocks(symbols);
    // }
}
