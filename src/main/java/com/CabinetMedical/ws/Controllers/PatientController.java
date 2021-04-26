package com.CabinetMedical.ws.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CabinetMedical.ws.dto.PatientDto;
import com.CabinetMedical.ws.responses.PatientResponse;
import com.CabinetMedical.ws.services.PatientService;


@RestController
@RequestMapping("patients/")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@GetMapping(path = "{patientId}")
	public ResponseEntity<PatientResponse> getPatient(@PathVariable("patientId") Long patientId) {
		System.out.println(patientId);
		PatientDto patientDto = patientService.getPatientById(patientId);
		ModelMapper modelMapper = new ModelMapper();
		PatientResponse patientResponse = modelMapper.map(patientDto, PatientResponse.class);
		return new ResponseEntity<PatientResponse>(patientResponse,HttpStatus.OK);

		
	}
	
	
	
//	public PatientEntity addPatient(@RequestBody PatientEntity patient) {
//		
//		PatientEntity patientEntuty=new PatientEntity(patient.getNom(), patient.getPrenom(), patient.getAdresse(), patient.getTel(), patient.getEmail(), patient.getSexe(), patient.getCin(), patient.getPrefession(), patient.getSagn(), patient.getDateNaissance(), new Date());
//		
//		
//		
//		
//		return patientEntuty; 
//	}
}
