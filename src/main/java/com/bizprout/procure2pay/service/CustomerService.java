package com.bizprout.procure2pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizprout.procure2pay.constants.Constants;
import com.bizprout.procure2pay.dto.CustomerDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.entity.Customer;
import com.bizprout.procure2pay.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepository;

	// @Transactional
	public ResponseDTO create(CustomerDTO customerDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = responseDTO.getResponse();
		try {
			Customer customer = new Customer(); //dao
			BeanUtils.copyProperties(customerDTO, customer);
			custRepository.save(customer);
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Customer Saved!!");
			response.put(Constants.RESPONSE_KEY_DATA, customerDTO);
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Customer not saved!!");
		}
		return responseDTO;
	}
	
	// @Transactional
	public ResponseDTO getCustomer(Long custId) {
		ResponseDTO responseDTO = new ResponseDTO();
//		CustomerDTO customerDTO = new CustomerDTO();
		Map<String, Object> response = responseDTO.getResponse();
		
		System.out.println(custId);
		
		try {
			Customer customer = new Customer();
//			BeanUtils.copyProperties(customer, customerDTO);
			customer = custRepository.findOne(custId);
			
			if(customer==null)
				response.put(Constants.RESPONSE_KEY_MESSAGE, "No data found for id : "+custId);
			else{
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Customer data !!");
			response.put(Constants.RESPONSE_KEY_DATA, customer);
			}
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Customer data not found!!");
		}
		return responseDTO;
	}
	

	// @Transactional
	public ResponseDTO getAllCustomers() {
		ResponseDTO responseDTO = new ResponseDTO();
		CustomerDTO customerDTO = new CustomerDTO();
		Map<String, Object> response = responseDTO.getResponse();
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customer, customerDTO);
			customer = (Customer) custRepository.findAll();
			
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Customer data fetched!!");
			response.put(Constants.RESPONSE_KEY_DATA, customer);
			
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Customer data not found!!");
		}
		return responseDTO;
	}
	public ResponseDTO delete(Long custId) {
		ResponseDTO responseDTO = new ResponseDTO();
		CustomerDTO customerDTO = new CustomerDTO();
		Map<String, Object> response = responseDTO.getResponse();
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customer, customerDTO);
			custRepository.delete(custId);
			
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Deleted Customer id :"+custId);
			response.put(Constants.RESPONSE_KEY_DATA, customer);
			
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Customer Id not found!!");
		}
		return responseDTO;
	}
	
	
	
	
	
}
