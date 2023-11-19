package org.sharan.showroom.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Demo {
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	public String dummy(@HeaderParam("HeaderValue") String headerValue, @CookieParam("_csrf") String csrf) {
		return headerValue + " " + csrf;
	}
	
	@GET
	@Path("demo")
	public String contextDemo(@Context HttpHeaders headers) {
		return uriInfo.getAbsolutePath().toString() + " - " + headers.getRequestHeaders().toString();
	}
}
