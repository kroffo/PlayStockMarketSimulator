package controllers;

import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;

import services.User;
import services.Company;

import com.fasterxml.jackson.databind.JsonNode;

public class UserStocks extends Controller {
	
    public Result getStocks(String name) {

	//updatePrices();

	services.User user = services.User.getUser(name);
	if(user == null) {
	    return status(404);
	}

	String json = getUserStockJSON(user);
	return ok(json);
    }

    private String getUserStockJSON(services.User user) {
	services.Company[] companies = services.Company.getCompanies();
	String json = "{\n";
	    
	for(int i=0, length=companies.length; i<length; ++i) {
	    services.Company company = companies[i];
	    String currentPath = request().host() + request().path();
	    String cname = company.getName();
	    String csym = company.getSymbol();
	    json += "  \"" + csym + "\": {\n";
	    json += "    \"price\": " + company.getStockValue() + ",\n";
	    json += "    \"available\": " + company.getNumberOfAvailableStocks() + ",\n";
	    json += "    \"stocks\": " + user.getNumberOfStocks(cname) + ",\n";
	    json += "    \"averagePurchasePrice\": " + user.getAveragePurchasePrice(cname) + ",\n";
	    json += "    \"links\": [\n";
	    json += "      {\n";
	    json += "        \"rel\": \"self\",\n";
	    json += "        \"href\": \"" + currentPath + "/" +  csym + "\"\n";;
	    json += "      }\n";
	    json += "    ]\n";
	    json += "  }";
	    if(i<length-1) json += ",";
	    json += "\n";
	}
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
