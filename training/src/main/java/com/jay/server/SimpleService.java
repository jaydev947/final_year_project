package com.jay.server;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jay.database.DatabaseCommunicator;




@Path("user")
public class SimpleService implements UserManagement{
	static DatabaseCommunicator databaseCommunicator;
	static Map<String,UserDetails> userList = new HashMap<String, UserDetails>();
	static {
		 databaseCommunicator = new DatabaseCommunicator("org.postgresql.Driver","jdbc:postgresql://localhost:5432/testdb","postgres", "jaydev@1");
	}
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public UserDetails getUserDetails(@PathParam("id")String id) {
    	return databaseCommunicator.fetch(id, "user");
		
	}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Result setUserDetails(UserDetails userDetails) {
		if(databaseCommunicator.insert(userDetails, "user")) {
			return new Result(200,"inserted","","");
		}else {
			return new Result(201,"not inserted","","");
		}
		
	}
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Result modifyUserDetails(UserDetails userDetails) {
		if(databaseCommunicator.update(userDetails, "user")) {
			return new Result(200,"modified","","");
		}else {
			return new Result(202,"did not modify","","");
		}
		
	}
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Result deleteUserDetails(@PathParam("id")String id) {
		if(databaseCommunicator.delete(id, "user")) {
			return new Result(200,"deleted","","");
		}else {
			return new Result(203,"could not delete","","");
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails[] getAllUsers() {
		return databaseCommunicator.fetchAll("user");
	}
    
}
