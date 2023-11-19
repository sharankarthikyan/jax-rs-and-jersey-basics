package org.sharan.showroom.resources;

import java.net.URI;
import java.util.*;

import org.sharan.showroom.hibernate.entities.*;
import org.sharan.showroom.services.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;


// 1. This is REST API layer.
@Path("/showroom/brands")
public class Brands {
	
	BrandService brandService = new BrandService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = brandService.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandEntity getBrand(@PathParam("brandId") int brandId) {
		BrandEntity brand = brandService.getBrand(brandId);
		return brand;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrand(BrandEntity brand, @Context UriInfo uri) {
		URI location = uri.getAbsolutePath();
		brandService.addBrand(brand);
		return Response.created(location).entity(brand).build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrand(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		brandService.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}
	
	@Path("/{brandId}/products")
	public Products productsDelegration() {
		return new Products();
	}
}
