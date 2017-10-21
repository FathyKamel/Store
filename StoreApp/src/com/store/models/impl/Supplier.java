
package com.store.models.impl;


import static javax.persistence.GenerationType.IDENTITY;
    
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Id;
    import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;

@Entity
@Table(name="Supplier")
	public class Supplier implements BasicStoreEntity{
    @Id
  	@GeneratedValue	  (strategy = IDENTITY)
		@Column(name = "SupplierID", unique = true, nullable = false)
		private Integer SupplierId;
	        
	        @Column(name = "SupplierName", length = 255)
		private String SupplierName;
	        
	        @Column(name = "SupplierAddress", length = 255)
		private String SupplierAddress;
	        
	        @Column(name = "SupplierPhone", length = 255)
	    	private String SupplierPhone;
	        
	        @Column(name = "Notes", length = 255)
	    	private String Notes;

	    @Override
	    public Integer getId() {
	       return this.SupplierId;
	    }

	    @Override
	    public void setId(Integer id) {
	       this.SupplierId=id;
	    }

	    public String getSupplierName() {
	        return SupplierName;
	    }

	    public void setSupplierName(String SupplierName) {
	        this.SupplierName = SupplierName;
	    }

	    public String getSupplierAddress() {
	        return SupplierAddress;
	    }

	    public void setSupplierAddress(String cSupplierAddress) {
	        this.SupplierAddress = SupplierAddress;
	    }

		public String getSupplierPhone() {
			return SupplierPhone;
		}

		public void setSupplierPhone(String SupplierPhone) {
			this.SupplierPhone = SupplierPhone;
		}

	} 

