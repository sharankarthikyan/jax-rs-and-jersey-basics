package org.sharan.showroom.resources;

import java.net.URI;
import java.util.*;

import org.sharan.showroom.model.BrandEntity;
import org.sharan.showroom.services.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


// 1. This is REST API layer.
@Path("/showroom/brands")
public class BrandsResource {
	
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
		brandService.addBrand(brand);
		
		String resourceURL = uri.getAbsolutePath().toString() + "/" + brand.getBrandId();
		URI location = URI.create(resourceURL); 
		
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
	public ProductsResource productsDelegration() {
		return new ProductsResource();
	}
}
