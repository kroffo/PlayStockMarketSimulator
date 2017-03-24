package controllers;

import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;

import services.User;
import services.Company;

import com.fasterxml.jackson.databind.JsonNode;

public class UserCompanyStocks extends Controller {
	
    public Result getStocks(String name, String symbol) {

	//updatePrices();

	services.User user = services.User.getUser(name);
	services.Company company = services.Company.getCompanyBySymbol(symbol);
	if(user == null) {
	    return status(404);
	}
	if(company == null) {
	    status(404);
	}

	String json = getUserCompanyStockJSON(user, company);
	return ok(json);
    }

    private String getUserCompanyStockJSON(services.User user, services.Company company) {
	String json = "{\n";
	String cname = company.getName();
	json += "  \"price\": " + company.getStockValue() + ",\n";
	json += "  \"available\": " + company.getNumberOfAvailableStocks() + ",\n";
	json += "  \"stocks\": " + user.getNumberOfStocks(cname) + ",\n";
	json += "  \"averagePurchasePrice\": " + user.getAveragePurchasePrice(cname) + "\n";
	json += "}";
	return json;
    }
    
    @BodyParser.Of(Json.class)
    public Result performTransaction(String name, String symbol) {
	
	services.User user = services.User.getUser(name);
	services.Company company = services.Company.getCompanyBySymbol(symbol);
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
	if(action.equals("buy")) {
	    if(user.purchaseStock(cname)) {
		json = "{ ";
		json += "\"status\" : \"success\","; 
		json += "\"balance\" : " + user.getMoney() + ",";
		json += "\"stockValue\" : " + user.getStockValue() + ",";
		json += "\"available\" : " + company.getNumberOfAvailableStocks() + ",";
		json += "\"owned\" : " + user.getNumberOfStocks(cname) + ",";
		json += "\"averagePurchasePrice\" : " + user.getAveragePurchasePrice(cname);
		json += "}";
	    } else // not enough money or stocks available
		json = "{ \"status\" : \"Failed\" }";
	} else if(action.equals("sell")) {
	    if(user.sellStock(cname)) {
		json = "{ ";
		json += "\"status\" : \"success\","; 
		json += "\"balance\" : " + user.getMoney() + ",";
		json += "\"stockValue\" : " + user.getStockValue() + ",";
		json += "\"available\" : " + company.getNumberOfAvailableStocks() + ",";
		json += "\"owned\" : " + user.getNumberOfStocks(cname) + ",";
		json += "\"averagePurchasePrice\" : " + user.getAveragePurchasePrice(cname);
		json += "}";
	    } else // not enough money
		json = "{ \"status\" : \"Failed\" }";
	} else {
	    return badRequest("Parameter [action] must have value \"buy\" or \"sell\".");
	}
	return ok(json);
    }
    
    // // Updates the stock prices of the companies.
    // public void updatePrices() {
    // 	services.Company[] companies = services.Company.getCompanies();
    // 	String[] symbols = new String[companies.length];
    // 	for(int i=0, length=companies.length; i<length; ++i) {
    // 	    symbols[i] = companies[i].getSymbol();
    // 	}
    // 	services.StockReader.updateStocks(symbols);
    // }

}
