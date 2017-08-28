package com.bizprout.procure2pay.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizprout.procure2pay.constants.Constants;
import com.bizprout.procure2pay.dto.ClientDTO;
import com.bizprout.procure2pay.dto.CustomerDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.entity.Client;
import com.bizprout.procure2pay.repository.ClientRepository;

@Service
public class ClientService {


	@Autowired
	ClientRepository clientRepository;

	// @Transactional
	public ResponseDTO create(ClientDTO clientDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = responseDTO.getResponse();
		try {
			Client client = new Client(); 
			BeanUtils.copyProperties(clientDTO, client);
			clientRepository.save(client);
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Client Data Saved!!");
			//	response.put(Constants.RESPONSE_KEY_DATA, clientDTO);
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Client data not saved!!");
		}
		return responseDTO;
	}


	// @Transactional
	public ResponseDTO update(ClientDTO clientDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Client client = null;
		Map<String, Object> response = responseDTO.getResponse();
		try {
			
			BeanUtils.copyProperties(clientDTO, client);
			client = clientRepository.findOne(clientDTO.getClientId());
			
			client.setClientCode("555");
			client.setClientEmail("punch@gmail.com");
			clientRepository.save(client);
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Client Data Saved!!");
			//	response.put(Constants.RESPONSE_KEY_DATA, clientDTO);
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Client data not saved!!");
		}
		return responseDTO;
	}

	// @Transactional
	public ResponseDTO getClient(Long clientId) {
		ResponseDTO responseDTO = new ResponseDTO();
		ClientDTO clientDTO = new ClientDTO();
		Map<String, Object> response = responseDTO.getResponse();


		try {
			Client client = null;	

			client = clientRepository.findOne(clientId);

			if(client==null)
				response.put(Constants.RESPONSE_KEY_MESSAGE, "No data found for id : "+clientId);
			else
			{
				BeanUtils.copyProperties(client,clientDTO);
				response.put(Constants.RESPONSE_KEY_MESSAGE, "Client data !!");
				response.put(Constants.RESPONSE_KEY_DATA, clientDTO);
			}
		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Exception loading data : ");
		}
		return responseDTO;
	}


	// @Transactional
	public ResponseDTO getAllClients() {
		ResponseDTO responseDTO = new ResponseDTO();
		
		Map<String, Object> response = responseDTO.getResponse();
		try {
			
			List<Client> client = (List<Client>) clientRepository.findAll();

			List<ClientDTO> clientOutput = client.stream()
					.map(obj->new ClientDTO(obj.getClientName(),obj.getClientCode(),obj.getContactPerson(),obj.getClientEmail(),obj.getClientPhone()))
					.collect(Collectors.toList());

			clientOutput.forEach(item->System.out.println(item.getClientName()));
			
			
//				BeanUtils.copyProperties(listOutput, clientDTO);


			response.put(Constants.RESPONSE_KEY_MESSAGE, "Client data fetched!!");
			response.put(Constants.RESPONSE_KEY_DATA, clientOutput);

		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Client data not found!!");
		}
		return responseDTO;
	}

	public ResponseDTO delete(Long clientId) {
		ResponseDTO responseDTO = new ResponseDTO();

		Map<String, Object> response = responseDTO.getResponse();
		try {
			clientRepository.delete(clientId);
			response.put(Constants.RESPONSE_KEY_MESSAGE, "Deleted Client id :");

		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_ERROR, "Exception Msg..!!");
		}
		return responseDTO;
	}






}
