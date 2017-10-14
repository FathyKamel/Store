
package com.store.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;


@Entity
@Table(name="Customer")
public class Customer implements BasicStoreEntity {
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CustomerID", unique = true, nullable = false)
	private Integer customerId;
        
        @Column(name = "CustomerName", length = 255)
	private String customerName;
        
        @Column(name = "CustomerAddress", length = 255)
	private String customerAddress;
        
        @Column(name = "CustomerPhone", length = 255)
    	private String customerPhone;
        
        @Column(name = "Notes", length = 255)
    	private String Notes;

    @Override
    public Integer getId() {
       return this.customerId;
    }

    @Override
    public void setId(Integer id) {
       this.customerId=id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

   
    
    
    
    
}
