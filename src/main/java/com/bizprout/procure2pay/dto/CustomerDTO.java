package com.bizprout.procure2pay.dto;

import javax.validation.constraints.NotNull;

public class CustomerDTO {

	private Long id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
