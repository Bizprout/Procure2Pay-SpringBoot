package com.bizprout.procure2pay.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizprout.procure2pay.constants.Constants;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.dto.UserDTO;
import com.bizprout.procure2pay.entity.User;
import com.bizprout.procure2pay.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// @Transactional
	public ResponseDTO add(UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = responseDTO.getResponse();
		try {
			User user = new User(); 
			BeanUtils.copyProperties(userDTO, user);
			userRepository.save(user);
			response.put(Constants.RESPONSE_KEY_MESSAGE, "User Data Saved!!");
			response.put(Constants.RESPONSE_KEY_DATA, userDTO);
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "User data not saved!!");
		}
		return responseDTO;
	}

}
