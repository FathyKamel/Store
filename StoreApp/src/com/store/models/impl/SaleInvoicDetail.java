package com.store.models.impl;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;

@Entity
@Table(name = "invoice_sale_detail")
public class SaleInvoicDetail implements BasicStoreEntity{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "InvoiceSaleDetailID", unique = true, nullable = false)
	private Integer InvoiceSaleDetailID;

	

	
	private Double InvoiceSaleDetailPrice;

	
	private Integer InvoiceSaleDetailQuantity;
	
	@Column(name = "ProductID")
	private Integer ProductID;
	
	
	private Integer InvoiceSaleDetailDiscount;
	
	
	
	@ManyToOne
	@JoinColumn(name="InvoiceSaleID")
	private SaleInvoice SaleInvoice ;



	

	@Column(name = "InvoiceSaleDetailPrice")
	public Double getInvoiceSaleDetailPrice() {
		return InvoiceSaleDetailPrice;
	}



	public void setInvoiceSaleDetailPrice(Double invoiceSaleDetailPrice) {
		InvoiceSaleDetailPrice = invoiceSaleDetailPrice;
	}


	@Column(name = "InvoiceSaleDetailQuantity")
	public Integer getInvoiceSaleDetailQuantity() {
		return InvoiceSaleDetailQuantity;
	}



	public void setInvoiceSaleDetailQuantity(Integer invoiceSaleDetailQuantity) {
		InvoiceSaleDetailQuantity = invoiceSaleDetailQuantity;
	}



	public SaleInvoice getSaleInvoice() {
		return SaleInvoice;
	}



	public void setSaleInvoice(SaleInvoice saleInvoice) {
		SaleInvoice = saleInvoice;
	}



	@Override
	public Integer getId() {
		
		return this.InvoiceSaleDetailID;
	}



	@Override
	public void setId(Integer idee) {
		this.InvoiceSaleDetailID= idee;
		
	}



	public Integer getProductID() {
		return ProductID;
	}



	public void setProductID(Integer productID) {
		ProductID = productID;
	}


	@Column(name = "InvoiceSaleDetailDiscount")
	public Integer getInvoiceSaleDetailDiscount() {
		return InvoiceSaleDetailDiscount;
	}



	public void setInvoiceSaleDetailDiscount(Integer invoiceSaleDetailDiscount) {
		InvoiceSaleDetailDiscount = invoiceSaleDetailDiscount;
	}
	
	
	
	


}
