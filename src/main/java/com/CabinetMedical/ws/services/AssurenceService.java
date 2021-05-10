package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.AssurenceDto;

public interface AssurenceService {
	AssurenceDto getAssurence(long assurenceId);
	
	AssurenceDto createAssurence(AssurenceDto assurence);
	
	AssurenceDto updateAssurence(long assurenceId,AssurenceDto assurence);
	
	void deleteAssurence(Long assurenceId);
	List<AssurenceDto> getListAssurence();
	
}
