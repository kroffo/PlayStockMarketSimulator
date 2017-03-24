package controllers;

import play.mvc.*;

import views.html.*;

import services.User;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class UserQuery extends Controller {
    
    //GET
    public Result getUser(String name) {
	
	services.User u = services.User.getUser(name);	    
	if(u == null) {
	    return status(500);
	}
	
	String json = getJsonForUser(u);
	return ok(json);
    }
    
    //PUT
    public Result updateUser (String name) {
	JsonNode json = request().body().asJson();
	if (json == null)
	    return badRequest("Expecting Json data");

	services.User u = services.User.loadUser(name);
	if (u == null) { 
	    return status(404, "User with the name " + name + "does not exist."); 
	}
	
	String json = "";
	try {
	    BufferedReader in = new BufferedReader(new InputStreamReader(data));
	    String line = null;
	    
	    String password = json.findPath("password").textValue();

	    if(password == null)
		return badRequest("Missing parameter [password]");
	    
	    if (!services.User.updateUser(name, password)){
		return status(500);
	    }
	    
	} catch(IOException | JSONException e) {
	    return status(400);
	}
	return status(204);
    }
    
    //DELETE
    public Result deleteUser( String name ) {
	services.User u = services.User.loadUser(name);
	if(u == null) {
	    return status(404);
	}
	
	if(!services.User.deleteUser(name)) {
	    return status(500);
	}
	String json = getJsonForUser(u);
	return ok(json);
    }
     
    private String getJsonForUser(services.User u) {
	String json = "{\n";
	json += " \"name\": \"" + u.getName() + "\",\n";
	json += " \"password\": \"" + u.getPassword() + "\",\n";
	json += " \"money\": " + u.getMoney() + ",\n";
	json += " \"stockValue\": " + u.getStockValue() + "\n";
	json += "}";
	return json;
    }
    
}