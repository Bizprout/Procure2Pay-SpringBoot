package com.bizprout.procure2pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizprout.procure2pay.dto.CompanyDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins="*")
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	@PutMapping("/add")
	public ResponseDTO create(@RequestBody CompanyDTO companydto)
	{
		return companyservice.createCompany(companydto);
	}
	
	@PutMapping("/update")
	public ResponseDTO update(@RequestBody CompanyDTO companydto)
	{
		return companyservice.updateCompany(companydto);
	}
	
	@GetMapping("/getallcompanydata")
	public ResponseDTO getAllCompanyData()
	{
		return companyservice.getAllCompanyData();
	}
	
	@GetMapping("/getallcompanynames")
	public ResponseDTO getAllCompanyNames()
	{
		return companyservice.getAllCompanyNames();
	}
	
	@PutMapping("/getcompany")
	public ResponseDTO getCompany(@RequestBody CompanyDTO companyDTO)
	{
		return companyservice.getCompany(companyDTO.getCompanyId());
	}
	

}
