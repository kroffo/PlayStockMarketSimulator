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

public class Companies extends Controller {

    public Result getCompanies() {

	//updatePrices();
	
	services.Company[] companies = services.Company.getCompanies();

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

    @BodyParser.Of(Json.class)
    public Result postCompany() {
	JsonNode json = request().body().asJson();
	if(json == null)
	    return badRequest("Expecting Json data");

	String symbol = json.findPath("symbol").textValue();
	String name = json.findPath("name").textValue();
	if(symbol == null)
	    return badRequest("Missing parameter [symbol]");
	if(name == null)
	    return badRequest("Missing parameter [name]");

	if(services.Company.getCompanyBySymbol(symbol) != null)
	    return status(409, "Company with symbol " + symbol + " already exists.");
	boolean success = Company.addCompany(name, symbol);
	if(success)
	    return created();
	return internalServerError();
    }

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
