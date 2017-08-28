package com.bizprout.procure2pay.dto;


import javax.validation.constraints.NotNull;



public class ClientDTO {
	
	private Long clientId;
	@NotNull
	private String clientName;
	@NotNull
	private String clientCode;
	private String contactPerson;
	private String clientEmail;
	private String clientPhone;
	
	
	
	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ClientDTO(String clientName, String clientCode,String contactPerson, String clientEmail, String clientPhone) {
		super();
		this.clientName = clientName;
		this.clientCode = clientCode;
		this.contactPerson = contactPerson;
		this.clientEmail = clientEmail;
		this.clientPhone = clientPhone;
	}


	public ClientDTO(Long clientId, String clientName, String clientCode,
			String contactPerson, String clientEmail, String clientPhone) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientCode = clientCode;
		this.contactPerson = contactPerson;
		this.clientEmail = clientEmail;
		this.clientPhone = clientPhone;
	}
	


	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId= clientId;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	
	
	
	

}
