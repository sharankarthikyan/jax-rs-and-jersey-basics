package org.sharan.showroom.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/showroom")
public class Brands {
	@GET
	@Path("/brands")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBrands() {
		return "List of strings";
	}
	
	@POST
	@Path("/brands")
	@Produces(MediaType.TEXT_PLAIN)
	public String setBrand() {
		return "Add a new Brand";
	}
}
