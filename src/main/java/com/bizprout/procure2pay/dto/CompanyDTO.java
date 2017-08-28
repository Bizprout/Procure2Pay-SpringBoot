package com.bizprout.procure2pay.dto;

import javax.validation.constraints.NotNull;

public class CompanyDTO {
	
	private Long companyId;
	
	@NotNull
	private int clientId;	
	
	@NotNull
	private String companyGUID;

	@NotNull
	private String companyName;
	
	private String companyBooksFrom;
	
	private String syncFromDate;
	
	private String contactPerson;
	
	private String mobileNo;
	
	@NotNull
	private String status;

	

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Long companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}

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
