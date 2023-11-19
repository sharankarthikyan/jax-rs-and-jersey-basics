package org.sharan.showroom.hibernate.entities;

import jakarta.persistence.*;

// This replicates the table schema of Brand
@Entity(name = "brand")
@Table(name = "brand")
public class BrandEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandId")
	int brandId;
	
	@Column(name = "brandName")
	String brandName;

	public BrandEntity() {
		
	}
	
	public BrandEntity(int brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
