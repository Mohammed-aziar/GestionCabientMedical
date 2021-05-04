package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.TypeAnalyseDto;

public interface TypeAnalyseService {
	
	TypeAnalyseDto getTypeAnalyseById(Long typeAnalyseId);

	TypeAnalyseDto createTypeAnalyse(TypeAnalyseDto Analyse);

	void deletetypeAnalyse(long typeAnalyseId);

	TypeAnalyseDto updateTypeAnalyse(Long typeAnalyseId, TypeAnalyseDto Analyse);

	List<TypeAnalyseDto> getAllTypeAnalyse();
}
