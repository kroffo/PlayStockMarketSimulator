package controllers;

import play.mvc.*;

import views.html.*;
import play.mvc.BodyParser.Json;

import services.User;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class UserQuery extends Controller {
    
    //GET
    public Result getUser(String name) {
	
	services.User u = services.User.getUser(name);	    
	if(u == null) {
	    return status(404);
	}
	
	String json = getJsonForUser(u);
	return ok(json);
    }
    
    //PUT
    public Result updateUser (String name) {
	JsonNode json = request().body().asJson();
	if (json == null)
	    return badRequest("Expecting Json data");

	services.User u = services.User.getUser(name);
	if (u == null) { 
	    return status(404, "User with the name " + name + "does not exist."); 
	}
	
	    String password = json.findPath("password").textValue();

	    if(password == null)
		return badRequest("Missing parameter [password]");
	    
	    if (!services.User.updateUser(name, password)){
		return internalServerError();
	    }
	    
	    return status(204);
    }
    
    //DELETE
    public Result deleteUser( String name ) {
	services.User u = services.User.getUser(name);
	if(u == null) {
	    return status(404);
	}
	
	if(!services.User.deleteUser(name)) {
	    return internalServerError();
	}
	String json = getJsonForUser(u);
	return ok(json);
    }
     
    private String getJsonForUser(services.User u) {
	services.Company[] companies = services.Company.getCompanies();
	String json = "{\n";
	json += "  \"name\": \"" + u.getName() + "\",\n";
	json += "  \"password\": \"" + u.getPassword() + "\",\n";
	json += "  \"money\": " + u.getMoney() + ",\n";
	json += "  \"stockValue\": " + u.getStockValue() + ",\n";
	json += "  \"stocks\": {\n";
	for(int i=0, length=companies.length; i<length; ++i) {
	    services.Company c = companies[i];
	    json += "    \"" + c.getName() + "\": {\n";
	    String cname = c.getName();
	    json += "      \"stocks\": " + u.getNumberOfStocks(cname) + ",\n";
	    json += "      \"averagePurchasePrice\": " + u.getAveragePurchasePrice(cname) + ",\n";
	    json += "    }";
	    if(i != length-1)
		json += ",";
	    json += "\n";
	}
	json += "  }\n";
	json += "}";
	return json;
    }
    
}
