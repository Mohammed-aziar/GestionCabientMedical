package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.TypeAssurenceDto;

public interface TypeAssurenceService {

	TypeAssurenceDto getTypeAssurenceById(Long typeAssurenceId);
	
	TypeAssurenceDto createTypeAssurence(TypeAssurenceDto Assurence);
	void deletetypeAssurence(long typeAssurenceId);
	
	TypeAssurenceDto updateTypeAssurence(Long typeAssurenceId,TypeAssurenceDto Assurence);
	
	List<TypeAssurenceDto> getAllTypeAssurence();
}
