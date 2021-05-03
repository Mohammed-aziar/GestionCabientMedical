package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.PatientDto;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PatientDto getPatientById(Long patientId) {
		PatientEntity patientEntity= patientRepository.findByPatientId(patientId);
		if (patientEntity == null)
			throw new RuntimeException("aucun patient dans la base de donnée avec cette id");

		PatientDto patientDto = modelMapper.map(patientEntity, PatientDto.class);

		return patientDto;
	}

	

	@Override
	public PatientDto createPatient(PatientDto patient) {

		PatientEntity checkPatient = patientRepository.findByCin(patient.getCin());

		if (checkPatient != null)
			throw new RuntimeException("ce patient existe déjà");

		PatientEntity patientEntity = modelMapper.map(patient, PatientEntity.class);

		PatientEntity patinetEntity2 = patientRepository.save(patientEntity);

		PatientDto createdPatient = modelMapper.map(patinetEntity2, PatientDto.class);

		return createdPatient;
	}

	@Override
	public void deletePatinet(Long patientId) {
		PatientEntity Patient = patientRepository.findByPatientId(patientId);
		if (Patient == null)
			throw new RuntimeException("ce patient n'existe pas");

		patientRepository.delete(Patient);

	}

	@Override
	public PatientDto updatePatient(long patientId, PatientDto patientDto) {
		PatientEntity Patient = patientRepository.findByPatientId(patientId);
		if (Patient == null)
			throw new RuntimeException("ce patient n'existe pas");
		Patient.setNom(patientDto.getNom());
		Patient.setPrenom(patientDto.getPrenom());
		Patient.setAdresse(patientDto.getAdresse());
		Patient.setTel(patientDto.getTel());
		Patient.setEmail(patientDto.getEmail());
		Patient.setSexe(patientDto.getSexe());
		Patient.setCin(patientDto.getCin());
		Patient.setPrefession(patientDto.getPrefession());
		Patient.setSagn(patientDto.getSagn());
		Patient.setDateNaissance(patientDto.getDateNaissance());
		PatientEntity UpdatedPatient = patientRepository.save(Patient);

		PatientDto Dto = modelMapper.map(UpdatedPatient, PatientDto.class);

		return Dto;
	}

	@Override
	public List<PatientDto> getPatientsFullName(String nom) {
		List<PatientDto> patientDto = new ArrayList<>();
		List<PatientEntity> patientEntity = new ArrayList<>();
		if (!nom.isEmpty())
			patientEntity = patientRepository.findAllPatientByNomPrenom(nom);
		else 
			patientEntity = (List<PatientEntity>) patientRepository.findAll();
		
		for (PatientEntity patient : patientEntity) {
			PatientDto dto = modelMapper.map(patient, PatientDto.class);
			patientDto.add(dto);
		}
		return patientDto;
	}

}
