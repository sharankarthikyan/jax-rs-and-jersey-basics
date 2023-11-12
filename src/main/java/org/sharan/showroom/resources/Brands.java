package org.sharan.showroom.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/showroom")
public class Brands {
	@GET
	@Path("/getBrands")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBrands() {
		return "List of strings";
	}
	
	@POST
	@Path("/setBrand")
	@Produces(MediaType.TEXT_PLAIN)
	public String setBrand() {
		return "Add a new Brand";
	}
}
