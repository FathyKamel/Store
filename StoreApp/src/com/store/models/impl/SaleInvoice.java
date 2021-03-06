package com.store.models.impl;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.store.models.basic.BasicStoreEntity;

@Entity
@Table(name = "invoice_sale")
public class SaleInvoice implements BasicStoreEntity{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "InvoiceSaleID", unique = true, nullable = false)
	private Integer InvoiceSaleID;

	@Column(name = "InvoiceSaleDate", length = 255)
	private long InvoiceSaleDate;

	@Column(name = "CustomerID", length = 255)
	private String CustomerID;

	@Column(name = "DelegatID", length = 255)
	private String DelegatID;
	
	@OneToMany( mappedBy= "SaleInvoice" , cascade = CascadeType.ALL)
	private List<SaleInvoicDetail> SaleInvoiceDetailList  = new ArrayList<SaleInvoicDetail>();
	
	

	@Override
	public Integer getId() {
		
		return this.InvoiceSaleID;
	}

	@Override
	public void setId(Integer idee) {
		
		this.InvoiceSaleID= idee;
	}

	public String getInvoiceSaleDate() {
		ZonedDateTime todaydate = LocalDate.now( ZoneId.of( "America/Montreal" ) ).atStartOfDay(ZoneId.of( "America/Montreal" ));
		int year=todaydate.getYear();
		int mounth=todaydate.getMonthValue();
		int day=todaydate.getDayOfMonth();
		String  InvoiceSaleDate=(Integer.toString(day)+"/"+Integer.toString(mounth)+"/"+Integer.toString(year));
		return InvoiceSaleDate;
	}

	public void setInvoiceSaleDate(long invoiceSaleDate) {
		InvoiceSaleDate = invoiceSaleDate;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getDelegatID() {
		return DelegatID;
	}

	public void setDelegatID(String delegatID) {
		DelegatID = delegatID;
	}

	public List<SaleInvoicDetail> getSaleInvoiceDetailList() {
		return SaleInvoiceDetailList;
	}

	public void setSaleInvoiceDetailList(
			List<SaleInvoicDetail> saleInvoiceDetailList) {
		SaleInvoiceDetailList = saleInvoiceDetailList;
	}
	
	
	
	


}
