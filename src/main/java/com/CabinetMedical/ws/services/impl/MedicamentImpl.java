package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.MedicamentDto;
import com.CabinetMedical.ws.entities.MedicamentEntity;
import com.CabinetMedical.ws.repositories.MedicamentRepository;
import com.CabinetMedical.ws.services.MedicamentService;
@Service
public class MedicamentImpl implements MedicamentService {

	@Autowired
	MedicamentRepository medicamentRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public MedicamentDto getMedicament(String libelle) {

		MedicamentEntity entity = medicamentRepository.findByLibelle(libelle);

		if (entity == null)
			throw new RuntimeException("Type Medicament n'exist pas");

		MedicamentDto dto = modelMapper.map(entity, MedicamentDto.class);

		return dto;
	}
	

	@Override
	public List<MedicamentDto> getListMedicament() {
		List<MedicamentEntity> entity = medicamentRepository.findAll();
		List<MedicamentDto> dto = new ArrayList<>();

		for (MedicamentEntity e : entity) {
			MedicamentDto medicamentdto = modelMapper.map(e, MedicamentDto.class);
			dto.add(medicamentdto);
		}
		return dto;
	}

	@Override
	public MedicamentDto createMedicament(MedicamentDto medicamentDto) {
		MedicamentEntity check = medicamentRepository.findByLibelle(medicamentDto.getLibelle());
		if (check != null)
			throw new RuntimeException("Type Médicament exist déja");

		MedicamentEntity entity = modelMapper.map(medicamentDto, MedicamentEntity.class);

		MedicamentEntity createdMedicament = medicamentRepository.save(entity);

		MedicamentDto dto = modelMapper.map(createdMedicament, MedicamentDto.class);

		return dto;
	}

	@Override
	public void deleteMedicament(long medicamentId) {
		MedicamentEntity check = medicamentRepository.findByMedicamentId(medicamentId);

		if (check == null)
			throw new RuntimeException("Type Médicament n'exist pas");

		medicamentRepository.delete(check);
		
	}

	
	@Override
	public MedicamentDto updateMedicament(long medicamentId, MedicamentDto medicamentDto) {
		MedicamentEntity entity = medicamentRepository.findByMedicamentId(medicamentId);

		if (entity == null)
			throw new RuntimeException("Type Médicament n'exist pas");

		entity.setLibelle(medicamentDto.getLibelle());

		MedicamentEntity updated = medicamentRepository.save(entity);

		MedicamentDto dto = modelMapper.map(updated, MedicamentDto.class);

		return dto;
	}

}
