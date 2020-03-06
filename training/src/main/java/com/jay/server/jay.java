package com.jay.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("jay")
public class jay{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getName() {
		return "jaay";
	}
}