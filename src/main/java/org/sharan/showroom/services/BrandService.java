package org.sharan.showroom.services;

import java.util.List;

import org.sharan.showroom.hibernate.DAO.BrandsDAO;
import org.sharan.showroom.hibernate.entities.BrandEntity;

public class BrandService {

	BrandsDAO DAO = new BrandsDAO();
	
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = DAO.getBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) {
		DAO.updateBrand(updatedBrand);
	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
	}
	
}
