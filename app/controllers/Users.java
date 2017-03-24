package controllers;

import play.mvc.*;

import views.html.*;
import play.mvc.BodyParser.Json;

import services.User;
import services.Company;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class Users extends Controller {

    //GET
    public Result getUsers(String sortingMethod, String symbol) {
	services.User[] users = services.User.getUsers();
	services.Company[] companies = services.Company.getCompanies();
	
	String json = "";
	if(sortingMethod != null) {
	    if (sortingMethod.equals("stocks") && symbol != null) {
		services.Company company = services.Company.getCompanyBySymbol(symbol);
		if(company != null) {
		    String companyName = company.getName();
		    for (int i = 0; i <users.length; ++i) {
			for (int j = i + 1; j <users.length; ++j) {
			    if (users[j].getNumberOfStocks(companyName) > users[i].getNumberOfStocks(companyName)) {
				services.User temp = users[i];
				users[i] = users[j];
				users[j] = temp;
			    }
			}
		    }
		}
	    } else if (sortingMethod.equals("money")) {
		for (int i = 0; i < users.length; ++i) {
		    for (int j = i + 1; j < users.length; ++j) {
			if (users[j].getMoney() > users[i].getMoney()) {
			    services.User temp = users[i];
			    users[i] = users[j];
			    users[j] = temp;
			}
		    }
		}
	    } else if (sortingMethod.equals("total_money")) {
		for (int i = 0; i < users.length; ++i) {
		    double totalMoneyI = users[i].getMoney() + users[i].getStockValue();
		    for (int j = i + 1; j < users.length; ++j) {
			double totalMoneyJ = users[j].getMoney() + users[j].getStockValue();
			if (totalMoneyJ > totalMoneyI) {
			    services.User temp = users[i];
			    users[i] = users[j];
			    users[j] = temp;
			}
		    }
		}
	    }
	}
	
	json += "[\n";
	for(int i = 0, length = users.length; i < length; ++i) {
	    services.User u = users[i];
	    String currentPath = request().host() + request().path();
	    String uname = u.getName();
	    double totalMoney = u.getMoney() + u.getStockValue();
	    json += "  {\n";
	    json += "    \"name\": \"" + uname + "\",\n";
	    json += "    \"password\": \"" + u.getPassword() + "\",\n";
	    json += "    \"money\": " + u.getMoney() + ",\n";
	    json += "    \"stockValue\": " + u.getStockValue() + ",\n";
	    json += "    \"totalMoney\": " + totalMoney + ",\n";
	    json += "    \"stocks\": {\n";
	    for(services.Company c : companies) {
		json += "      \"" + c.getName() + "\": {\n";
		String cname = c.getName();
		json += "        \"stocks\": " + u.getNumberOfStocks(cname) + ",\n";
		json += "        \"averagePurchasePrice\": " + u.getAveragePurchasePrice(cname) + ",\n";
		json += "      }\n";
	    }
	    json += "    }\n";
	    json += "    \"links\": [\n";
	    json += "      {\n";
	    json += "        \"rel\": \"self\",\n";
	    json += "        \"href\": \"" + currentPath + "/" + uname + "\"\n";;
	    json += "      }\n";
	    json += "    ]\n";
	    json += "  }";
	    if(i < length - 1)
		json += ",";
	    json += "\n";
	}
	json += "]";
	
	return ok(json);
    }
    
    //POST
    @BodyParser.Of(Json.class)
	public Result postUser () {
	JsonNode json = request().body().asJson();
	if(json == null)
	    return badRequest("Expecting Json data");
	
	String name = json.findPath("name").textValue();
	String password = json.findPath("password").textValue();
	if(name == null || name.equals(""))
	    return badRequest("Missing parameter [name]");
	if(password == null || password.equals(""))
	    return badRequest("Missing parameter [password]");
	
	services.User u = services.User.getUser(name);
	if(u != null) {
	    return status(409, "User with name " + name + " already exists.");
		}
	
	if(!services.User.addUser(name, password)) {
	    return internalServerError();
	}
	
	return created();
    }
    
    
}
