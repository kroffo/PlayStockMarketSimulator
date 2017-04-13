package controllers;

import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;

import models.User;
import models.Company;

import com.fasterxml.jackson.databind.JsonNode;

public class UserStocks extends Controller {
	
    public Result getStocks(String name) {

	updatePrices();

	models.User user = models.User.getUser(name);
	if(user == null) {
	    return status(404);
	}

	String json = getUserStockJSON(user);
	return ok(json);
    }

    private String getUserStockJSON(models.User user) {
	models.Company[] companies = models.Company.getCompanies();
	String json = "{\n";
	    
	for(int i=0, length=companies.length; i<length; ++i) {
	    models.Company company = companies[i];
	    String currentPath = request().host() + request().path();
	    String csym = company.getSymbol();
	    json += "  \"" + csym + "\": {\n";
	    json += "    \"price\": " + company.getStockValue() + ",\n";
	    json += "    \"available\": " + company.getNumberOfAvailableStocks() + ",\n";
	    json += "    \"stocks\": " + user.getNumberOfStocks(csym) + ",\n";
	    json += "    \"averagePurchasePrice\": " + user.getAveragePurchasePrice(csym) + ",\n";
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
	
    // Updates the stock prices of the companies.
    public void updatePrices() {
	models.Company[] companies = models.Company.getCompanies();
     	String[] symbols = new String[companies.length];
     	for(int i=0, length=companies.length; i<length; ++i) {
     	    symbols[i] = companies[i].getSymbol();
     	}
     	StockReader.updateStocks(symbols);
    }	
}

