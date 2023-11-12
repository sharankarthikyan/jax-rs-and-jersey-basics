package org.sharan.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sharan.showroom.hibernate.entities.BrandEntity;

public class BrandsDAO {
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BrandEntity.class).buildSessionFactory();

	public List<BrandEntity> getBrands() {
		return null;
	}

	public void addBrand(BrandEntity brand) {
		
	}

	public void updateBrand(BrandEntity updatedBrand) {
		
	}

	public void deleteBrand(int brandId) {
		
	}

}
