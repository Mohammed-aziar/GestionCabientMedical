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

import com.CabinetMedical.ws.dto.TypeAnalyseDto;
import com.CabinetMedical.ws.requests.TypeAnalyseRequest;
import com.CabinetMedical.ws.requests.TypeAssurenceRequest;
import com.CabinetMedical.ws.responses.TypeAnalyseResponse;
import com.CabinetMedical.ws.services.TypeAnalyseService;

@RestController
@RequestMapping("/typeAnalyse")
public class TypeAnalyseController {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	TypeAnalyseService typeAnalyseService;

	@GetMapping("/getTypeAnnalyseById")
	public ResponseEntity<TypeAnalyseResponse> getPatientId(@RequestParam(value = "id") Long typeAnalyseId) {

		TypeAnalyseDto typeAnalyseDto = typeAnalyseService.getTypeAnalyseById(typeAnalyseId);

		TypeAnalyseResponse typeAnalyseResponse = modelMapper.map(typeAnalyseDto, TypeAnalyseResponse.class);

		return new ResponseEntity<TypeAnalyseResponse>(typeAnalyseResponse, HttpStatus.OK);
	}

	@GetMapping("/getListTypeAnalyse")
	public ResponseEntity<List<TypeAnalyseResponse>> getAllTypeAssurence() {

		List<TypeAnalyseDto> typeAnalyseDto = typeAnalyseService.getAllTypeAnalyse();
		List<TypeAnalyseResponse> typeAnalyseResponses = new ArrayList<>();
		for (TypeAnalyseDto dto : typeAnalyseDto) {
			TypeAnalyseResponse Response = modelMapper.map(dto, TypeAnalyseResponse.class);
			typeAnalyseResponses.add(Response);
		}

		return new ResponseEntity<List<TypeAnalyseResponse>>(typeAnalyseResponses, HttpStatus.OK);
	}

	@PostMapping("/addTypeAnalyse")
	public TypeAnalyseResponse creerPatient(@RequestBody TypeAssurenceRequest Analyse) {

		TypeAnalyseDto typeAnalyseDto = modelMapper.map(Analyse, TypeAnalyseDto.class);

		TypeAnalyseDto createdtypeAnalyse = typeAnalyseService.createTypeAnalyse(typeAnalyseDto);

		TypeAnalyseResponse response = modelMapper.map(createdtypeAnalyse, TypeAnalyseResponse.class);

		return response;
	}

	@DeleteMapping("/deleteTypeAnalyse")
	public ResponseEntity<Object> deleteTypeAnalyse(@RequestParam("id") Long typeAnalyseId) {
		typeAnalyseService.deletetypeAnalyse(typeAnalyseId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/updateTypeAnalyse")
	public ResponseEntity<TypeAnalyseResponse> updateTypeAnalyse(
			@RequestBody TypeAnalyseRequest typeAnalyseRequest, @RequestParam("id") Long typeAnalyseId) {

		TypeAnalyseDto typeAnalyseDto = modelMapper.map(typeAnalyseRequest, TypeAnalyseDto.class);

		TypeAnalyseDto updatedTypeAnalyse = typeAnalyseService.updateTypeAnalyse(typeAnalyseId,
				typeAnalyseDto);

		TypeAnalyseResponse Response = modelMapper.map(updatedTypeAnalyse, TypeAnalyseResponse.class);

		return new ResponseEntity<TypeAnalyseResponse>(Response, HttpStatus.ACCEPTED);
	}
}
