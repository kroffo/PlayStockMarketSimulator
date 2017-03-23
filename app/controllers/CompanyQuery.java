package controllers;

import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;

import services.Company;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class CompanyQuery extends Controller {

    public Result getCompany(String sym) {
	    
	//updatePrices();

	services.Company c = services.Company.getCompanyBySymbol(sym);
	if(c == null) {
	    return badRequest("Bad Request");
	}
	
	String json = getJsonForCompany(c);
	return ok(json);
    }

    @BodyParser.Of(Json.class)
    public Result updateCompany(String symbol) {
	services.Company c = services.Company.getCompanyBySymbol(symbol);
	if(c == null) {
	    return status(404, "Company with symbol " + symbol + " does not exist.");
	}
	JsonNode json = request().body().asJson();
	
	if(json == null)
	    return badRequest("Expecting Json data");

	String name = json.findPath("name").textValue();
	if(name == null)
	    return badRequest("Missing parameter [name]");
	
	// Attempt to update the company
	// If it fails, return a server error
	if(!services.Company.updateCompany(name, symbol)) {
	    return internalServerError();
	}
	    
	return status(204);
    }
	
    public Result deleteCompany(String symbol) {
	services.Company c = services.Company.getCompanyBySymbol(symbol);
	if(c == null) {
	    return status(404);
	}
	
	// Attempt to add the company
	// If it fails, return a server error
	if(!services.Company.deleteCompany(symbol)) {
	    return internalServerError();
	}
	String json = getJsonForCompany(c);
	return ok(json);
    }

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
