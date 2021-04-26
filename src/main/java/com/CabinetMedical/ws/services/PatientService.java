package com.CabinetMedical.ws.services;

import com.CabinetMedical.ws.dto.PatientDto;

public interface PatientService {

	PatientDto getPatientById(Long patientId);
}
