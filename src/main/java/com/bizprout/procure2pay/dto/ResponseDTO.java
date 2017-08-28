package com.bizprout.procure2pay.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseDTO implements Serializable {

	private Map<String, Object> response = new HashMap<String, Object>();

	public Map<String, Object> getResponse() {
		return response;
	}

}
