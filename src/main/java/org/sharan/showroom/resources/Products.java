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
			@QueryParam("category") String category) {
		List<ProductEntity> productList;
		if("bike".equals(category) || "car".equals(category)) {
			productList = productService.getProductsByBrandAndCategory(brandId, category);
			return productList;
		} else {
			productList = productService.getProductsByBrand(brandId);
			return productList;	
		}
	}
}
