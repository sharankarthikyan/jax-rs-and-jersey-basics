package org.sharan.showroom.model;

import java.util.*;

import jakarta.persistence.*;

// This replicates the table schema of Brand
@Entity(name = "brand")
@Table(name = "brand")
public class BrandEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandId")
	private int brandId;
	
	@Column(name = "brandName")
	private String brandName;
	
	@Transient
	private List<Link> links;

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

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
