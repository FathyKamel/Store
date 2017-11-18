package com.store.models.impl;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;


@Entity
@Table(name="Products")
public class Product implements BasicStoreEntity{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ProductsID", unique = true, nullable = false)
	private Integer ProductsId;
        
        @Column(name = "ProductsName", length = 255)
	private String ProductsName;
	
	 
        
        @Column(name = "ProductsCategory", length = 255)
	private String ProductsCategory;
        
        @Column(name = "ProductsUnit", length = 255)
    	private int ProductsUnit;
        
        @Column(name = "ProductsIn", length = 255)
    	private int ProductsIn;

        @Column(name = "ProductsOut", length = 255)
    	private int ProductsOut;
        
        @Column(name = "ProductsLocation", length = 255)
    	private String ProductsLocation;
        
    	@Column(name = "ProductPrice", length = 255)
    	private Double ProductPrice;
    	
    	
    	
        
    public Double getProductPrice() {
			return ProductPrice;
		}

		public void setProductPrice(Double productPrice) {
			ProductPrice = productPrice;
		}

	@Override
    public Integer getId() {
       return this.ProductsId;
    }

    @Override
    public void setId(Integer id) {
       this.ProductsId=id;
    }

    public String getProductsName() {
        return ProductsName;
    }

    public void setProductsName(String ProductsName) {
        this.ProductsName = ProductsName;
    }

    public String getProductsCategory() {
        return ProductsCategory;
    }

    public void setProductsCategory(String ProductsCategory) {
        this.ProductsCategory = ProductsCategory;
    }

	public int getProductsUnit() {
		return ProductsUnit;
	}

	public void setProductsUnit(int ProductsUnit) {
		this.ProductsUnit = ProductsUnit;
	}

	public int getProductsIn() {
		return ProductsIn;
	}

	public void setProductsIn(int ProductsIn) {
		ProductsIn = ProductsIn;
	}

	public int getProductsOut() {
		return ProductsOut;
	}

	public void setProductsOut(int ProductsOut) {
		ProductsOut = ProductsOut;
	}
    
	public String getProductsLocation() {
		return ProductsLocation;
	}

	public void setProductsLocation(String ProductsLocation) {
		ProductsLocation = ProductsLocation;
	}
}
