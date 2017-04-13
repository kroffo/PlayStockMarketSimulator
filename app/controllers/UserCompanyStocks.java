package controllers;

import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;

import models.User;
import models.Company;

import com.fasterxml.jackson.databind.JsonNode;

public class UserCompanyStocks extends Controller {
	
    public Result getStocks(String name, String symbol) {

	updatePrices();

	models.User user = models.User.getUser(name);
	models.Company company = models.Company.getCompanyBySymbol(symbol);
	if(user == null) {
	    return status(404);
	}
	if(company == null) {
	    return status(404);
	}
	
	String json = getUserCompanyStockJSON(user, company);
	return ok(json);
    }

    private String getUserCompanyStockJSON(models.User user, models.Company company) {
	String json = "{\n";
	String csym = company.getSymbol();
	json += "  \"price\": " + company.getStockValue() + ",\n";
	json += "  \"available\": " + company.getNumberOfAvailableStocks() + ",\n";
	json += "  \"stocks\": " + user.getNumberOfStocks(csym) + ",\n";
	json += "  \"averagePurchasePrice\": " + user.getAveragePurchasePrice(csym) + "\n";
	json += "}";
	return json;
    }
    
    @BodyParser.Of(Json.class)
    public Result performTransaction(String name, String symbol) {
	
	models.User user = models.User.getUser(name);
	models.Company company = models.Company.getCompanyBySymbol(symbol);
	if(user == null) {
	    return status(404);
	}
	if(company == null) {
	    status(404);
	}
	
	JsonNode reqJson = request().body().asJson();
	if(reqJson == null)
	    return badRequest("Expecting Json data");

	String action = reqJson.findPath("action").textValue();

	if(action == null)
	    return badRequest("Missing parameter [action]");

	String json = "";
	String cname = company.getName();
        String csym = company.getSymbol();
	if(action.equals("buy")) {
	    if(user.purchaseStock(csym)) {
		// Re-read the company to update changed values
		company = Company.getCompanyBySymbol(csym);
		json = "{ ";
		json += "\"status\" : \"success\","; 
		json += "\"balance\" : " + user.getMoney() + ",";
		json += "\"stockValue\" : " + user.getStockValue() + ",";
		json += "\"available\" : " + company.getNumberOfAvailableStocks() + ",";
		json += "\"owned\" : " + user.getNumberOfStocks(csym) + ",";
		json += "\"averagePurchasePrice\" : " + user.getAveragePurchasePrice(csym);
		json += "}";
	    } else // not enough money or stocks available
		json = "{ \"status\" : \"Failed\" }";
	} else if(action.equals("sell")) {
	    if(user.sellStock(csym)) {
		// Re-read the company to update changed values
		company = Company.getCompanyBySymbol(csym);
		json = "{ ";
		json += "\"status\" : \"success\","; 
		json += "\"balance\" : " + user.getMoney() + ",";
		json += "\"stockValue\" : " + user.getStockValue() + ",";
		json += "\"available\" : " + company.getNumberOfAvailableStocks() + ",";
		json += "\"owned\" : " + user.getNumberOfStocks(csym) + ",";
		json += "\"averagePurchasePrice\" : " + user.getAveragePurchasePrice(csym);
		json += "}";
	    } else // not enough money
		json = "{ \"status\" : \"Failed\" }";
	} else {
	    return badRequest("Parameter [action] must have value \"buy\" or \"sell\".");
	}
	return ok(json);
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
