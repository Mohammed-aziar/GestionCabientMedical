package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.PatientDto;

public interface PatientService {

	PatientDto getPatientById(Long patientId);
	List<PatientDto> getPatients(int page, int limit);
	
	PatientDto createPatient(PatientDto patient);
	void deletePatinet(Long patientId);
	PatientDto updatePatient(long patientId,PatientDto patientDto);
}
