package com.bizprout.procure2pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bizprout.procure2pay.dto.CustomerDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// @Get , @Post,@put, @delete
	// configure spring log back
	// all methods should have try catch
	// validations
	@PostMapping("/add")
	public ResponseDTO create(CustomerDTO cust) {
		return customerService.create(cust);

	}
//	@CrossOrigin(origins = "http://192.168.3.243:8080")
	@GetMapping("/get")
	public ResponseDTO getCustomer(CustomerDTO cust) {
		return customerService.getCustomer(cust.getId());

	}
	
	@GetMapping("/getall")
	public ResponseDTO getAllCustomers() {
		return customerService.getAllCustomers();

	}
	
	 @DeleteMapping("/delete")
	 public ResponseDTO delete(CustomerDTO cust) {
		 return customerService.delete(cust.getId());
	 }
	
	/*
	 * @RequestMapping("/get") public Customer getCustomer(@RequestParam Long
	 * cid){ Customer cust = custRepo.findOne(cid); return cust;
	 * 
	 * }
	 * 
	 * @RequestMapping("/getall") public List<Customer> getTest() { return
	 * (List<Customer>) custRepo.findAll(); }
	 *//**
	 * GET /update --> Update a booking record and save it in the database.
	 */
	/*
	 * @RequestMapping("/update") public Customer update(@RequestParam Long id,
	 * 
	 * @RequestParam String lname) { Customer booking = custRepo.findOne(id);
	 * booking.setLastName(lname);
	 * 
	 * booking = custRepo.save(booking); return booking; }
	 */

}
