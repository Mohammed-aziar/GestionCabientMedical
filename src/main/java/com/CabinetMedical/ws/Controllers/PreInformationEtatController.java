package com.CabinetMedical.ws.Controllers;

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

import com.CabinetMedical.ws.dto.PreInformationEtatDto;
import com.CabinetMedical.ws.requests.PreInfomationEtatRequest;
import com.CabinetMedical.ws.responses.PreInformationEtatResponse;
import com.CabinetMedical.ws.services.PreInformationEtatService;

@RestController
@RequestMapping("/preInfoEtat")
public class PreInformationEtatController {

	@Autowired
	PreInformationEtatService preInformationEtatService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/getPreInfo")
	public ResponseEntity<PreInformationEtatResponse> getPreInformationEtat(@RequestParam("infoId") Long infoId) {
		
		PreInformationEtatDto Dto = preInformationEtatService.getPreInfoById(infoId);
		
		PreInformationEtatResponse response = modelMapper.map(Dto, PreInformationEtatResponse.class);
		return new ResponseEntity<PreInformationEtatResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public PreInformationEtatResponse createPreInfoEtat(@RequestBody PreInfomationEtatRequest preInfoRequest){
		PreInformationEtatDto preInfoDto = modelMapper.map(preInfoRequest , PreInformationEtatDto.class);

		System.out.println(preInfoDto.getHistorique()+" "+preInfoDto.getInfoId()+" "+preInfoDto.getPatinetId());
		
		PreInformationEtatDto createdPreInfo = preInformationEtatService.createPreInfo(preInfoDto);

		PreInformationEtatResponse response = modelMapper.map(createdPreInfo, PreInformationEtatResponse.class);

		return response;	
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deletePreInfoEtat(@RequestParam("preInfoEtatId") Long preInfoEtatId) {
		preInformationEtatService.deletePreInfoEtat(preInfoEtatId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
