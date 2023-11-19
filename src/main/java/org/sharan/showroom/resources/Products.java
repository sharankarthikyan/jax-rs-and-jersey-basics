package org.sharan.showroom.resources;

import java.util.List;

import org.sharan.showroom.hibernate.entities.ProductEntity;
import org.sharan.showroom.services.ProductService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

public class Products {
	
	ProductService productService = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category, @QueryParam("start") int start,
			@QueryParam("size") int size) {
		
		List<ProductEntity> productList;
		if("bike".equals(category) || "car".equals(category)) {
			productList = productService.getProductsByBrandAndCategory(brandId, category);
		} else {
			productList = productService.getProductsByBrand(brandId);
		}
		
		if(start >= 0 && size >= 0) {
			 productList = productList.subList(start, size);
		}
		
		return productList;
	}
}
