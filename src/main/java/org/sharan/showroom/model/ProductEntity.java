package org.sharan.showroom.model;

import jakarta.persistence.*;

@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	int productId;
	
	@ManyToOne(targetEntity = BrandEntity.class)
	@JoinColumn(name = "brandId")
	BrandEntity brandEntity;
	
	@Column(name = "productName")
	String productName;
	
	@Column(name = "category")
	String category;
	
	@Column(name = "cost")
	int cost;

	public ProductEntity() {
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BrandEntity getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
