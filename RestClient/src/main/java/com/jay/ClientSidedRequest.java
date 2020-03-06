package com.jay;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;


public class ClientSidedRequest implements UserManagement {

	String url;
	Client client;
	WebTarget webTarget;
	
		

	public ClientSidedRequest(String url) {
		this.url = url;
		 client = (Client) ClientBuilder.newClient();
		 webTarget = client.target(url);
	}

	public UserDetails getUserDetails(String id) {
		UserDetails response=null;
		try {
			WebTarget userWebTarget = webTarget.path(id);
			Invocation.Builder invocationBuilder = userWebTarget.request();
			 response  = invocationBuilder.get(UserDetails.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}

	public Result setUserDetails(UserDetails userDetails) {
		if(userDetails.getAge()==null||userDetails.getId()==null||userDetails.getname()==null) {
			return new Result(201,"null fields","objects field cannot be null","null filed");
		}else {
			
			Invocation.Builder invocationBuilder = webTarget.request();
			invocationBuilder.header("Content-Type", "application/json;charset=UTF-8");
			Response response  = invocationBuilder.post(Entity.entity(userDetails, MediaType.APPLICATION_JSON));
			String jsonResponse = response.readEntity(String.class);
			System.out.println(jsonResponse);
			Gson gson = new Gson();
			Result result = gson.fromJson(jsonResponse, Result.class);
			return result;
		}

	}
	public Result modifyUserDetails(UserDetails userDetails) {
		if(userDetails.getAge()==null||userDetails.getId()==null||userDetails.getname()==null) {
			return new Result(201,"null fields","objects field cannot be null","null filed");
		}else {
			Invocation.Builder invocationBuilder = webTarget.request();
			Response response  = invocationBuilder.put(Entity.entity(userDetails, MediaType.APPLICATION_JSON));
			String jsonResponse = response.readEntity(String.class);
			Gson gson = new Gson();
			Result result = gson.fromJson(jsonResponse, Result.class);
			return result;
		}
		
	}
	public Result deleteUserDetails(String id) {
		WebTarget userWebTarget = webTarget.path(id);
		Invocation.Builder invocationBuilder = userWebTarget.request();
		Response response = invocationBuilder.delete();
		String jsonResponse = response.readEntity(String.class);
		Gson gson = new Gson();
		Result result = gson.fromJson(jsonResponse, Result.class);
		return result;
		
	}
	
	public UserDetails[] getAllUsers() {
		UserDetails[] allUsers=null;
		try {
			Invocation.Builder invocationBuilder = webTarget.request();
			 String response  = invocationBuilder.get(String.class);
			 Gson gson = new Gson();
			 allUsers = gson.fromJson(response, UserDetails[].class);
//			 System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsers;
		
		
	}

}
