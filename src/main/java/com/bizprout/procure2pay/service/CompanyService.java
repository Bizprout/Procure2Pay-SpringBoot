package com.bizprout.procure2pay.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bizprout.procure2pay.constants.Constants;
import com.bizprout.procure2pay.dto.CompanyDTO;
import com.bizprout.procure2pay.dto.ResponseDTO;
import com.bizprout.procure2pay.entity.Company;
import com.bizprout.procure2pay.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyrepository;

	public ResponseDTO createCompany(CompanyDTO companydto) {
		ResponseDTO responsedto = new ResponseDTO();
		Map<String, Object> response = responsedto.getResponse();

		System.out.println("Create Company");

		System.out.println(companydto.getClientId());

		try {
			Company company = new Company();
			BeanUtils.copyProperties(companydto, company);
			companyrepository.save(company);
			response.put(Constants.RESPONSE_KEY_MESSAGE,
					Constants.COMPANY_SUCCESS_MESSAGE);

		} catch (DataIntegrityViolationException e) {
			response.put(Constants.RESPONSE_KEY_MESSAGE,
					e.getMostSpecificCause().getMessage());
		}
		return responsedto;

	}

	public ResponseDTO updateCompany(CompanyDTO companydto) {

		ResponseDTO responseDTO = new ResponseDTO();

		Map<String, Object> response = responseDTO.getResponse();

		try {

			Company comp = null;

			comp = companyrepository.findOne(companydto.getCompanyId());

			// BeanUtils.copyProperties(companydto, comp);

			comp.setCompanyName(companydto.getCompanyName());

			response.put(Constants.RESPONSE_KEY_MESSAGE, "Company Data Saved!");
			response.put(Constants.RESPONSE_KEY_DATA, comp);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			response.put(Constants.RESPONSE_KEY_MESSAGE,
					"Company Data not Saved!");
		}

		return responseDTO;

	}

	public ResponseDTO getAllCompanyData() {

		ResponseDTO responseDTO = new ResponseDTO();
		// List<CompanyDTO> compdto=null;
		Map<String, Object> response = responseDTO.getResponse();

		try {

			List<Company> comp = null;
			comp = (List<Company>) companyrepository.findAll();

			response.put(Constants.RESPONSE_KEY_MESSAGE,
					"Company Data Fetched!");
			response.put(Constants.RESPONSE_KEY_DATA, comp);

		} catch (Exception e) {
			response.put(Constants.RESPONSE_KEY_MESSAGE,
					"Company Data not Found!");
		}

		return responseDTO;

	}

	public ResponseDTO getAllCompanyNames() {
		ResponseDTO responseDTO = new ResponseDTO();

		Map<String, Object> response = responseDTO.getResponse();

		List<Company> cmpName = null;

		try {
			cmpName = (List<Company>) companyrepository.findAll();

			List<CompanyDTO> companyNameList = cmpName.stream()
					.map(obj -> new CompanyDTO(obj.getCompanyId(),
							obj.getCompanyName()))
					.collect(Collectors.toList());

			response.put(Constants.RESPONSE_KEY_DATA, companyNameList);

		} catch (Exception e) {

			response.put(Constants.RESPONSE_KEY_MESSAGE,
					"Company Names not found!");

		}

		return responseDTO;
	}

	public ResponseDTO getCompany(Long companyId) {

		ResponseDTO responseDTO = new ResponseDTO();

		Map<String, Object> response = responseDTO.getResponse();

		Company complist = null;

		try {

			complist = companyrepository.findOne(companyId);

			response.put(Constants.RESPONSE_KEY_DATA, complist);

		} catch (Exception e) {

			e.printStackTrace();

			response.put(Constants.RESPONSE_KEY_MESSAGE,
					"Company Data not found for " + companyId + "!");
		}

		return responseDTO;
	}

}
