package com.bizprout.procure2pay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.dto.UserDTO;
import com.bizprout.procure2pay.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseDTO  add(UserDTO userDTO){
		return userService.add(userDTO);
		
	}
	@PostMapping("/update")
	public ResponseDTO  update(UserDTO userDTO){
		return userService.add(userDTO);
		
	}
	
	

	
}
