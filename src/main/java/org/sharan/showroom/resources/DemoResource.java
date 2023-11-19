package org.sharan.showroom.resources;


import org.sharan.showroom.model.ErrorPayload;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/")
public class DemoResource {
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String dummy(@HeaderParam("HeaderValue") String headerValue, @CookieParam("_csrf") String csrf) {
		return headerValue + " " + csrf;
	}
	
	@GET
	@Path("demo")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public String contextDemo(@HeaderParam("header") String header) {
		ErrorPayload error = new ErrorPayload(404, "The value of custom header not found");
		Response response = Response.status(404).entity(error).build();
		if(header == null) {
			throw new WebApplicationException(response);
		}
		return "The value of custom header is: " + header;
	}
}
