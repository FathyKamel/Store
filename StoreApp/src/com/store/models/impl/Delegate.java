package com.store.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;


@Entity
@Table(name="Delegate")
public class Delegate implements BasicStoreEntity {
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DelegateID", unique = true, nullable = false)
	private Integer DelegateId;
        
        @Column(name = "DelegateName", length = 255)
	private String DelegateName;
        
        @Column(name = "DelegateAddress", length = 255)
	private String DelegateAddress;
        
        @Column(name = "DelegatePhone", length = 255)
    	private String DelegatePhone;
        
        

    @Override
    public Integer getId() {
       return this.DelegateId;
    }

    @Override
    public void setId(Integer id) {
       this.DelegateId=id;
    }

    public String getDelegateName() {
        return DelegateName;
    }

    public void setDelegateName(String DelegateName) {
        this.DelegateName = DelegateName;
    }

    public String getDelegateAddress() {
        return DelegateAddress;
    }

    public void setDelegateAddress(String DelegateAddress) {
        this.DelegateAddress = DelegateAddress;
    }

	public String getDelegatePhone() {
		return DelegatePhone;
	}

	public void setDelegatePhone(String DelegatePhone) {
		this.DelegatePhone = DelegatePhone;
	}
}

	
   
    
