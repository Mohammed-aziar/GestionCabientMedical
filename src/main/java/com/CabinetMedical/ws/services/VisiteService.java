package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.VisiteDto;

public interface VisiteService {

	VisiteDto getByVisiteId(Long visiteId);
	List<VisiteDto>	getListVisiteByPatientId(Long patientId);
	VisiteDto createVisite(VisiteDto visiteDto);
}
