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

import com.CabinetMedical.ws.dto.TypeAssurenceDto;
import com.CabinetMedical.ws.requests.TypeAssurenceRequest;
import com.CabinetMedical.ws.responses.TypeAssurenceResponse;
import com.CabinetMedical.ws.services.TypeAssurenceService;



@RestController
@RequestMapping("/typeAssurence")
public class TypeAssurenceController {
	
	@Autowired
	TypeAssurenceService typeAssurenceService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/getTypeAssurencetById")
	public ResponseEntity<TypeAssurenceResponse> getPatientId(@RequestParam(value = "id") Long typeAssurenceId) {
		System.out.println(typeAssurenceId);
		
		TypeAssurenceDto typeAssurenceDto = typeAssurenceService.getTypeAssurenceById(typeAssurenceId);
		
		TypeAssurenceResponse typeAssurenceResponse = modelMapper.map(typeAssurenceDto, TypeAssurenceResponse.class);
		
		return new ResponseEntity<TypeAssurenceResponse>(typeAssurenceResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("/getListTypeAssurence")
	public ResponseEntity<List<TypeAssurenceResponse>> getAllTypeAssurence() {
		
		List<TypeAssurenceDto> typeAssurenceDto = typeAssurenceService.getAllTypeAssurence();
		List<TypeAssurenceResponse> typeAssurenceResponses = new ArrayList<>();
		for(TypeAssurenceDto dto : typeAssurenceDto) {
			TypeAssurenceResponse Response = modelMapper.map(dto, TypeAssurenceResponse.class);
			typeAssurenceResponses.add(Response);
		}
		
		
		
		return new ResponseEntity<List<TypeAssurenceResponse>>(typeAssurenceResponses, HttpStatus.OK);
	}
	
	@PostMapping("/addTypeAssurence")
	public TypeAssurenceResponse creerPatient(@RequestBody TypeAssurenceRequest Assurence) {
		
		TypeAssurenceDto typeAssurenceDto = modelMapper.map(Assurence, TypeAssurenceDto.class);

		TypeAssurenceDto createdtypeAssurence = typeAssurenceService.createTypeAssurence(typeAssurenceDto);

		TypeAssurenceResponse response = modelMapper.map(createdtypeAssurence, TypeAssurenceResponse.class);
		
		return response;
	}
	
	
	@DeleteMapping("/deleteTypeAssurence")
	public ResponseEntity<Object> deleteTypeAssurence(@RequestParam("id") Long typeAssurenceId) {
		typeAssurenceService.deletetypeAssurence(typeAssurenceId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updateTypeAssurence")
	public ResponseEntity<TypeAssurenceResponse> updateTypeAssurence(@RequestBody TypeAssurenceRequest typeAssurenceRequest,
			@RequestParam("id") Long typeAssurenceId) {
		
		TypeAssurenceDto typeAssurenceDto = modelMapper.map(typeAssurenceRequest, TypeAssurenceDto.class);
		
		TypeAssurenceDto updatedTypeAssurence = typeAssurenceService.updateTypeAssurence(typeAssurenceId, typeAssurenceDto);

		TypeAssurenceResponse Response = modelMapper.map(updatedTypeAssurence, TypeAssurenceResponse.class);

		return new ResponseEntity<TypeAssurenceResponse>(Response, HttpStatus.ACCEPTED);
	}
	
	
}
