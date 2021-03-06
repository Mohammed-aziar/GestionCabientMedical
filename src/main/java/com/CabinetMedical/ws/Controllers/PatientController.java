package com.CabinetMedical.ws.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabinetMedical.ws.dto.PatientDto;
import com.CabinetMedical.ws.requests.PatientRequest;
import com.CabinetMedical.ws.responses.PatientResponse;
import com.CabinetMedical.ws.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientService patientService;

	ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/getPatientByFullName")
	public ResponseEntity<PatientResponse> getPatientId(@RequestParam(value = "patientId") Long patientId) {
		PatientDto patientDto = patientService.getPatientById(patientId);
		PatientResponse patientResponse = modelMapper.map(patientDto, PatientResponse.class);
		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getListPatientsFullName")
	public ResponseEntity<List<PatientResponse>> getPatientsFullName(@RequestParam(value = "nom",defaultValue = "") String  nom) {
		
		List<PatientDto> patientDto = patientService.getPatientsFullName(nom);
		List<PatientResponse> patientResponses = new ArrayList<>();
		for(PatientDto dto : patientDto) {
			PatientResponse patientResponse = modelMapper.map(dto, PatientResponse.class);
			patientResponses.add(patientResponse);
		}
		
		
		
		return new ResponseEntity<List<PatientResponse>>(patientResponses, HttpStatus.OK);
	}


	@PostMapping
	public PatientResponse creerPatient(@RequestBody PatientRequest patient) {
		PatientDto patientDto = modelMapper.map(patient, PatientDto.class);

		PatientDto createdPatient = patientService.createPatient(patientDto);

		PatientResponse response = modelMapper.map(createdPatient, PatientResponse.class);

		return response;
	}

	@DeleteMapping
	public ResponseEntity<Object> deletePatient(@RequestParam("id") Long patientId) {
		patientService.deletePatinet(patientId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@PutMapping
	public ResponseEntity<PatientResponse> updatePatient(@RequestBody PatientRequest patientRequest,
			@RequestParam("patientId") Long patientId) {
		PatientDto patientDto = modelMapper.map(patientRequest, PatientDto.class);
		PatientDto patinetDto2 = patientService.updatePatient(patientId, patientDto);

		PatientResponse patientResponse = modelMapper.map(patinetDto2, PatientResponse.class);

		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.ACCEPTED);
	}

}
