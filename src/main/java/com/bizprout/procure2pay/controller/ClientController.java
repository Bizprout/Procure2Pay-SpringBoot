package com.bizprout.procure2pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizprout.procure2pay.dto.ClientDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.service.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*") 
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@PutMapping("/add")
	public ResponseDTO create(@RequestBody ClientDTO client) {
		return clientService.create(client);
	}

	@PostMapping("/update")
	public ResponseDTO update(@RequestBody ClientDTO client) {
		Long clientId= (long) 1;
		System.out.println("Controller : "+client.getClientName()+"\t"+client.getClientCode());
		return clientService.update(client);
	}

	@GetMapping("/get")
	public ResponseDTO getClient(ClientDTO client) {
		return clientService.getClient(1L);

	}
	
	@GetMapping("/getall")
	public ResponseDTO getAllClients() {
		return clientService.getAllClients();

	}
	
	 @DeleteMapping("/delete")
	 public ResponseDTO delete(ClientDTO client) {
		 return clientService.delete(client.getClientId());
	 }

	
	
}
