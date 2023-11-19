package org.sharan.showroom.services;

import java.util.List;

import org.sharan.showroom.hibernate.DAO.ProductsDAO;
import org.sharan.showroom.hibernate.entities.ProductEntity;

public class ProductService {
	ProductsDAO DAO = new ProductsDAO();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productList = DAO.getProductsByBrand(brandId);
		return productList;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		List<ProductEntity> productList = DAO.getProductsByBrandAndCategory(brandId, category);
		return productList;
	}

}
