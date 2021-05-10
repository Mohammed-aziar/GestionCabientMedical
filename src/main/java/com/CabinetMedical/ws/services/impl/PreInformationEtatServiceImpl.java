package com.CabinetMedical.ws.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.PreInformationEtatDto;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.entities.PreInformationEtatEntity;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.repositories.PreInformationEtatRepository;
import com.CabinetMedical.ws.services.PreInformationEtatService;
@Service
public class PreInformationEtatServiceImpl  implements PreInformationEtatService{
	@Autowired
	PreInformationEtatRepository preInformationEtatRepository;
	@Autowired
	PatientRepository  patientRepository;
	
	@Override
	public PreInformationEtatDto getPreInfoById(Long infoId) {
		PreInformationEtatEntity entity = preInformationEtatRepository.findByInfoId(infoId);
		
		if( entity == null ) throw new RuntimeException("Pre information n'exist pas .");
		
		return new PreInformationEtatDto(entity.getInfoId(), entity.getHistorique(), entity.getPatientEntity().getPatientId());
	}

	@Override
	public PreInformationEtatDto createPreInfo(PreInformationEtatDto preInfoDto) {
		
		PatientEntity patient = patientRepository.findByPatientId(preInfoDto.getPatinetId());
		
		if( patient == null )throw new RuntimeException("cette patient n'exist pas .");

		PreInformationEtatEntity checkPatientPreInfo = preInformationEtatRepository.findByPatinetId(preInfoDto.getPatinetId());
		
		if(checkPatientPreInfo != null) throw new RuntimeException("pré état il existe déjà");
		

		PreInformationEtatEntity info = new PreInformationEtatEntity(preInfoDto.getHistorique(), patient);

		PreInformationEtatEntity entity = preInformationEtatRepository.save(info);
		
		PreInformationEtatDto dto = new PreInformationEtatDto(entity.getInfoId(), entity.getHistorique(), entity.getPatientEntity().getPatientId());
		
		return dto;
		
	}

	@Override
	public void deletePreInfoEtat(Long infoId) {
		PreInformationEtatEntity check = preInformationEtatRepository.findByInfoId(infoId);
		if( check == null ) throw new RuntimeException("Pre information etat n'exist pas .");

		preInformationEtatRepository.delete(check);
	}

	@Override
	public PreInformationEtatDto updatePreInfo(Long preInfoId, PreInformationEtatDto preInfoDto) {
		
		PatientEntity patient = patientRepository.findByPatientId(preInfoDto.getPatinetId());
		
		if( patient == null )throw new RuntimeException("cette patient n'exist pas .");

		PreInformationEtatEntity checkPatientPreInfo = preInformationEtatRepository.findByPatinetId(preInfoDto.getPatinetId());
		
		checkPatientPreInfo.setHistorique(preInfoDto.getHistorique());
		
		PreInformationEtatEntity updatedPreInfoEtat = preInformationEtatRepository.save(checkPatientPreInfo);
		
		PreInformationEtatDto dto = new PreInformationEtatDto(updatedPreInfoEtat.getInfoId(), updatedPreInfoEtat.getHistorique(), updatedPreInfoEtat.getPatientEntity().getPatientId()); 
		
		return dto;
	}

}
