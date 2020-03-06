package com.jay.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jay.UserDetails;
import javax.jws.WebMethod;
import javax.jws.WebService;

//@WebService
//public class Service {
//
//    @WebMethod(operationName = "jay")
//    public String myMethod(){
//        return "Hello World";
//    }
//
//}
@Path("/hello")
public class Service {
  
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name) {
  
        String output = "Welcome   : " + name;
  
        return Response.status(200).entity(output).build();
    }
}

/*@Path("user")
public class Service {
	
public static void main(String[] args) {
	
	Service service = new Service();
}
@GET
@Produces(MediaType.APPLICATION_JSON)
public UserDetails sendDetails() {
	return new UserDetails("123","jaydev","20");
	
}*/
		
		
	

//}
