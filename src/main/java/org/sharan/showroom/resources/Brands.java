package org.sharan.showroom.resources;

import java.util.*;

import org.sharan.showroom.hibernate.entities.*;
import org.sharan.showroom.services.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


// 1. This is REST API layer.
@Path("/showroom/brands")
public class Brands {
	
	BrandService brandService = new BrandService();
	ProductService productService = new ProductService();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = brandService.getBrands();
		return list;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBrand(BrandEntity brand) {
		brandService.addBrand(brand);
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
	
	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId) {
		List<ProductEntity> productList = productService.getProductsByBrand(brandId);
		return productList;
	}
}
