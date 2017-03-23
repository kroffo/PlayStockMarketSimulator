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
	
    public Result getUser(String name) {
	
	services.User u = services.User.getUser(name);	    
	if(u == null) {
	    return badRequest("Not Found"); // CHANGE THIS TO 500 ERROR
	}
	
	String json = getJsonForUser(u);
	return ok(json);
    }
    
//     @PUT
// 	@Produces(MediaType.APPLICATION_JSON)
// 	@Consumes(MediaType.APPLICATION_JSON)
// 	public Response updateUser (@PathParam("name") String name, InputStream data) {
// 	services.User u = services.User.loadUser(name);
// 	if (u == null) { 
// 	    return Response.status(Response.Status.NOT_FOUND).build();
// 	}
	
// 	String json = "";
// 	try {
// 	    BufferedReader in = new BufferedReader(new InputStreamReader(data));
// 	    String line = null;
// 	    while ((line = in.readLine()) != null)
// 		json += line;
	    
// 	    JSONObject obj = new JSONObject(json);
// 	    String password = obj.getString("password");
	    
// 	    if (!services.User.updateUser(name, password)){
// 		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
// 	    }
	    
// 	} catch(IOException | JSONException e) {
// 	    return Response.status(Response.Status.BAD_REQUEST).build();
// 	}
// 	return Response.status(Response.Status.NO_CONTENT).build();
//     }
    
//     @DELETE
// 	@Produces(MediaType.APPLICATION_JSON)
// 	public Response deleteUser( @PathParam("name") String name ) {
// 	services.User u = services.User.loadUser(name);
// 	if(u == null) {
// 	    return Response.status(Response.Status.NOT_FOUND).build();
// 	}
	
// 	if(!services.User.deleteUser(name)) {
// 	    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
// 	}
// 	String json = getJsonForUser(u);
// 	return Response.ok(json, MediaType.APPLICATION_JSON).build();
//     }
     
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