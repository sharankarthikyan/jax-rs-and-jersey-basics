package org.sharan.showroom.resources;

import java.util.*;

import org.sharan.showroom.hibernate.entities.BrandEntity;
import org.sharan.showroom.services.BrandService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/showroom")
public class Brands {
	
	BrandService service = new BrandService();
	
	@GET
	@Path("/brands")
	@Produces(MediaType.TEXT_PLAIN)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = service.getBrands();
		return list;
	}
	
	@POST
	@Path("/brands")
	@Consumes(MediaType.TEXT_PLAIN)
	public void postBrand(BrandEntity brand) {
		service.addBrand(brand);
	}
	
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void putBrand(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteBrand(@PathParam("brandId") int brandId) {
		service.deleteBrand(brandId);
	}
}
