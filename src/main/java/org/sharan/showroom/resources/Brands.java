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
	public String postBrand() {
		return "Add a new Brand";
	}
	
	@PUT
	@Path("/brands/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putBrand(@PathParam("brandId") int brandId) {
		return "Update brand info with ID: " + brandId;
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBrand(@PathParam("brandId") int brandId) {
		return "Delete brand from db with ID: " + brandId;
	}
}
