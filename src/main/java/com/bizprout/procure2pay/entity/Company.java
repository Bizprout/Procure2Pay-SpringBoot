package com.bizprout.procure2pay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tally_company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_id")
	private Long companyId;
	
	@Column(name="client_id")
	private int clientId;	
	
	@Column(name="company_guid")
	private String companyGUID;

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_books_from")
	private String companyBooksFrom;
	
	@Column(name="sync_from_date")
	private String syncFromDate;
	
	@Column(name="contact_person")
	private String contactPerson;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="status")
	private String status;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCompanyGUID() {
		return companyGUID;
	}

	public void setCompanyGUID(String companyGUID) {
		this.companyGUID = companyGUID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyBooksFrom() {
		return companyBooksFrom;
	}

	public void setCompanyBooksFrom(String companyBooksFrom) {
		this.companyBooksFrom = companyBooksFrom;
	}

	public String getSyncFromDate() {
		return syncFromDate;
	}

	public void setSyncFromDate(String syncFromDate) {
		this.syncFromDate = syncFromDate;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
