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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabinetMedical.ws.dto.VisiteDto;
import com.CabinetMedical.ws.requests.VisiteRequest;
import com.CabinetMedical.ws.responses.VisiteResponse;
import com.CabinetMedical.ws.services.VisiteService;

@RestController
@RequestMapping("/visite")
public class VisiteController {

	@Autowired
	VisiteService visiteService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/getByVisiteId")
	public ResponseEntity<VisiteResponse> getByVisiteId(@RequestParam("visiteId") Long visiteId){
		
		VisiteDto dto = visiteService.getByVisiteId(visiteId);
		
		VisiteResponse response= modelMapper.map(dto, VisiteResponse.class);
		
		return new  ResponseEntity<VisiteResponse>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/getByPatientId")
	public ResponseEntity<List<VisiteResponse>> getListVisiteByPatientId(@RequestParam("patientId") Long patientId){
		
		List<VisiteDto> dto = visiteService.getListVisiteByPatientId(patientId);
	
		List<VisiteResponse> response	=	new ArrayList<>();
		
		for(VisiteDto visiteDto : dto) {
			
			VisiteResponse visiteResponse= modelMapper.map(visiteDto, VisiteResponse.class);
			
			response.add(visiteResponse);
		}
		
		return new  ResponseEntity<List<VisiteResponse>>(response,HttpStatus.OK);
	}
	
//	@PostMapping
//	public VisiteResponse createVisite(@RequestBody VisiteRequest visiteRequest){
//		
//		VisiteDto visiteDto=modelMapper.map(visiteRequest, VisiteDto.class);
//		VisiteDto createVisite = visiteService.createVisite(visiteDto);
//		
//		VisiteResponse visiteResponse= modelMapper.map(createVisite, VisiteResponse.class);
//		
//		return visiteResponse;
//	}
	
	
	@DeleteMapping
	public ResponseEntity<Object> deletePatient(@RequestParam("rdvId") Long rdvId) {
		rdvService.deleteRdv(rdvId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
