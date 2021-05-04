package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.TypeAnalyseDto;
import com.CabinetMedical.ws.entities.TypeAnalyseEntity;
import com.CabinetMedical.ws.repositories.TypeAnalyseRepository;
import com.CabinetMedical.ws.services.TypeAnalyseService;

@Service
public class TypeAnalyseServiceImpl implements TypeAnalyseService {

	@Autowired
	TypeAnalyseRepository typeAnalyseRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public TypeAnalyseDto getTypeAnalyseById(Long typeAnalyseId) {

		TypeAnalyseEntity entity = typeAnalyseRepository.findByTypeAnalyseId(typeAnalyseId);

		if (entity == null)
			throw new RuntimeException("Type Analyse n'exist pas");

		TypeAnalyseDto dto = modelMapper.map(entity, TypeAnalyseDto.class);

		return dto;
	}

	@Override
	public TypeAnalyseDto createTypeAnalyse(TypeAnalyseDto Analyse) {
		TypeAnalyseEntity check = typeAnalyseRepository.findByLibelle(Analyse.getLibelle());
		if (check != null)
			throw new RuntimeException("Type Analyse exist déja");

		TypeAnalyseEntity entity = modelMapper.map(Analyse, TypeAnalyseEntity.class);

		TypeAnalyseEntity createdTypeAnalyse = typeAnalyseRepository.save(entity);

		TypeAnalyseDto dto = modelMapper.map(createdTypeAnalyse, TypeAnalyseDto.class);

		return dto;
	}

	@Override
	public void deletetypeAnalyse(long typeAnalyseId) {
		TypeAnalyseEntity check = typeAnalyseRepository.findByTypeAnalyseId(typeAnalyseId);

		if (check == null)
			throw new RuntimeException("Type Analyse n'exist pas");

		typeAnalyseRepository.delete(check);

	}

	@Override
	public TypeAnalyseDto updateTypeAnalyse(Long typeAnalyseId, TypeAnalyseDto Analyse) {
		
		TypeAnalyseEntity entity = typeAnalyseRepository.findByTypeAnalyseId(typeAnalyseId);

		if (entity == null)
			throw new RuntimeException("Type Analyse n'exist pas");

		entity.setLibelle(Analyse.getLibelle());

		TypeAnalyseEntity updated = typeAnalyseRepository.save(entity);

		TypeAnalyseDto dto = modelMapper.map(updated, TypeAnalyseDto.class);

		return dto;
	}

	@Override
	public List<TypeAnalyseDto> getAllTypeAnalyse() {
		List<TypeAnalyseEntity> entity = typeAnalyseRepository.findAll();
		List<TypeAnalyseDto> dto = new ArrayList<>();

		for (TypeAnalyseEntity e : entity) {
			TypeAnalyseDto typeAnalyse = modelMapper.map(e, TypeAnalyseDto.class);
			dto.add(typeAnalyse);
		}
		return dto;
	}

}
