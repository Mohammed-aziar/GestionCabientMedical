package com.CabinetMedical.ws.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabinetMedical.ws.dto.RDVDto;
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
}
