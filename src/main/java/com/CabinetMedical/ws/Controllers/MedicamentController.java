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

import com.CabinetMedical.ws.dto.MedicamentDto;
import com.CabinetMedical.ws.requests.MedicamentRequest;
import com.CabinetMedical.ws.responses.MedicamentResponse;
import com.CabinetMedical.ws.services.MedicamentService;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {

	@Autowired
	MedicamentService medicamentService;
	
	ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/getMedicament")
	public ResponseEntity<MedicamentResponse> getMedicament(@RequestParam(value = "medicament") String  medicament) {
		
		MedicamentDto medicamentDto = medicamentService.getMedicament(medicament);
		
		MedicamentResponse medicamentResponse = modelMapper.map(medicamentDto, MedicamentResponse.class);
		
		return new ResponseEntity<MedicamentResponse>(medicamentResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("/getListMedicament")
	public ResponseEntity<List<MedicamentResponse>> getListMedicament() {
		
		List<MedicamentDto> medicamentDto = medicamentService.getListMedicament();
		
		List<MedicamentResponse> medicamentResponses = new ArrayList<>();
		
		for(MedicamentDto dto : medicamentDto) {
			
			MedicamentResponse medicamentResponse = modelMapper.map(dto, MedicamentResponse.class);
			
			medicamentResponses.add(medicamentResponse);
			
		}
		
		return new ResponseEntity<List<MedicamentResponse>>(medicamentResponses, HttpStatus.OK);
	}


	@PostMapping
	public MedicamentResponse createMedicament(@RequestBody MedicamentRequest medicament) {
		
		MedicamentDto medicamentDto = modelMapper.map(medicament, MedicamentDto.class);

		MedicamentDto createdMedicament = medicamentService.createMedicament(medicamentDto);

		MedicamentResponse response = modelMapper.map(createdMedicament, MedicamentResponse.class);

		return response;
	}

	
	@DeleteMapping
	public ResponseEntity<Object> deleteMedicament(@RequestParam("medicamentId") Long medicamentId) {
		medicamentService.deleteMedicament(medicamentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@PutMapping
	public ResponseEntity<MedicamentResponse> updateMedicament(@RequestBody MedicamentRequest medicamentRequest,
			@RequestParam("medicamentId") Long medicamentId) {
		MedicamentDto medicamentDto = modelMapper.map(medicamentRequest, MedicamentDto.class);
		MedicamentDto medicamentDto2 = medicamentService.updateMedicament(medicamentId, medicamentDto);

		MedicamentResponse Response = modelMapper.map(medicamentDto2, MedicamentResponse.class);

		return new ResponseEntity<MedicamentResponse>(Response, HttpStatus.ACCEPTED);
	}
}
