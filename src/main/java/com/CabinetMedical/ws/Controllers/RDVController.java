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


import com.CabinetMedical.ws.dto.RDVDto;
import com.CabinetMedical.ws.requests.RDVRequest;
import com.CabinetMedical.ws.responses.RDVResponse;
import com.CabinetMedical.ws.services.RDVService;

@RestController
@RequestMapping("/rdv")
public class RDVController {
	@Autowired
	RDVService rdvService;
	ModelMapper modelMapper=new ModelMapper();
	
	@GetMapping("/getRDVById")
	public ResponseEntity<RDVResponse> getRDVId(@RequestParam(value = "rdvId") Long rdvId) {
		RDVDto rdvDto = rdvService.getRDVById(rdvId);
		
		RDVResponse rdvResponse = modelMapper.map(rdvDto, RDVResponse.class);
		
		return new ResponseEntity<RDVResponse>(rdvResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getRDVList")
	public ResponseEntity<List<RDVResponse>> getRDVList(@RequestParam(value = "rdvId",defaultValue = "") Long rdvId) {
		List<RDVDto> rdvDto = rdvService.getList();
		List<RDVResponse> rdvResponse = new ArrayList<>();
		for(RDVDto rdv : rdvDto) {
			RDVResponse res = modelMapper.map(rdv, RDVResponse.class);
			rdvResponse.add(res);
		}
		
		return new ResponseEntity<List<RDVResponse>>(rdvResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public RDVResponse createdRdv(@RequestBody RDVDto rdvDtp){
		
		RDVDto rdvDto = modelMapper.map(rdvDtp , RDVDto.class);
		
		RDVDto dto	= rdvService.createdRDV(rdvDto);
		
		RDVResponse response = modelMapper.map(dto,RDVResponse.class);
		
		return response;
	}
	

	@DeleteMapping
	public ResponseEntity<Object> deletePatient(@RequestParam("rdvId") Long rdvId) {
		rdvService.deleteRdv(rdvId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<RDVResponse> updateRdv(@RequestBody RDVRequest rdvRequest,
			@RequestParam("rdvId") Long rdvId) {
		RDVDto rdvDto = modelMapper.map(rdvRequest, RDVDto.class); 
		RDVDto rdvDto2 = rdvService.updateRDV(rdvId, rdvDto);

		RDVResponse Response = modelMapper.map(rdvDto2, RDVResponse.class);

		return new ResponseEntity<RDVResponse>(Response, HttpStatus.ACCEPTED);
	}
	
}
