package org.sharan.showroom.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.sharan.showroom.model.BrandEntity;
import org.sharan.showroom.model.ProductEntity;


// This is DAO layer. This will communicate with DB.
public class BrandsDAO {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String hql = "from brand";
		Query<BrandEntity> query = session.createQuery("from brand", BrandEntity.class);
		List<BrandEntity> brandList = query.getResultList();
		return brandList;
	}

	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandEntity updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updatedBrand.getBrandId();
		BrandEntity brand = session.get(BrandEntity.class, id);
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		session.remove(brand);
		session.getTransaction().commit();
	}

	public BrandEntity getBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
        String hql = "from brand b where b.id = :brandId";
        Query<BrandEntity> query = session.createQuery(hql, BrandEntity.class);
        query.setParameter("brandId", brandId);
        BrandEntity brand = query.getSingleResult();
		return brand;
	}

}
