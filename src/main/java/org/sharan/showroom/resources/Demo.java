package org.sharan.showroom.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class Demo {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String dummy(@HeaderParam("HeaderValue") String headerValue, @CookieParam("_csrf") String csrf) {
		return headerValue + " " + csrf;
	}
}
