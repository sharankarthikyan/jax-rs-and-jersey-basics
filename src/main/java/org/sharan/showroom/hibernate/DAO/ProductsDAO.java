package org.sharan.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.sharan.showroom.hibernate.entities.*;

public class ProductsDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        String hql = "from product p where p.brandEntity.id = :brandId";
        Query<ProductEntity> query = session.createQuery(hql, ProductEntity.class);
        query.setParameter("brandId", brandId);
        List<ProductEntity> productList = query.getResultList();
		return productList;
	}
}