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

import com.CabinetMedical.ws.dto.AssurenceDto;
import com.CabinetMedical.ws.requests.AssurenceRequest;
import com.CabinetMedical.ws.responses.AssurenceResponse;
import com.CabinetMedical.ws.services.AssurenceService;

@RestController
@RequestMapping("/assurence")
public class AssurenceController {

	@Autowired
	AssurenceService assurenceService;
	
	ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/getAssurence")
	public ResponseEntity<AssurenceResponse> getAssurence(@RequestParam("assurenceId") Long assurenceId){
		AssurenceDto assurence = assurenceService.getAssurence(assurenceId);
		AssurenceResponse response=modelMapper.map(assurence, AssurenceResponse.class);
		
		return new  ResponseEntity<AssurenceResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getListAssurence")
	public ResponseEntity<List<AssurenceResponse>> getListAssurence(){
		List<AssurenceDto> assurence = assurenceService.getListAssurence();
		
		List<AssurenceResponse> AssurenceResponse=new ArrayList<>();
		
		for(AssurenceDto dto : assurence) {
			
			AssurenceResponse response = new  AssurenceResponse(dto.getAssurenceId(), dto.getPatientId(), dto.getTypeAssurenceId());
			AssurenceResponse.add(response);
		}
		
		return new  ResponseEntity<List<AssurenceResponse>>(AssurenceResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public AssurenceResponse creerPatient(@RequestBody AssurenceRequest assurence) {
		
		AssurenceDto assuernceDto = modelMapper.map(assurence, AssurenceDto.class);

		AssurenceDto createdassurence = assurenceService.createAssurence(assuernceDto);

		AssurenceResponse response = modelMapper.map(createdassurence, AssurenceResponse.class);

		return response;
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deletePatient(@RequestParam("assurenceId") Long assurenceId) {
		assurenceService.deleteAssurence(assurenceId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<AssurenceResponse> updateAssurence(@RequestBody AssurenceRequest assurenceRequest,
			@RequestParam("assurenceId") Long assurenceId) {
		
		AssurenceDto assurenceDto = modelMapper.map(assurenceRequest, AssurenceDto.class);

		AssurenceDto assurenceDto2 = assurenceService.updateAssurence(assurenceId,assurenceDto);

		AssurenceResponse assurenceResponse = modelMapper.map(assurenceDto2, AssurenceResponse.class);

		return new ResponseEntity<AssurenceResponse>(assurenceResponse, HttpStatus.ACCEPTED);
	}
	
}
