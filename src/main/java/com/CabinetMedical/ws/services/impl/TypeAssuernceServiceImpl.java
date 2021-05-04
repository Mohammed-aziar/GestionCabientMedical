package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.TypeAssurenceDto;
import com.CabinetMedical.ws.entities.TypeAssurenceEntity;
import com.CabinetMedical.ws.repositories.TypeAssurenceRepository;
import com.CabinetMedical.ws.services.TypeAssurenceService;
@Service
public class TypeAssuernceServiceImpl implements TypeAssurenceService {
	
	@Autowired
	TypeAssurenceRepository typeAssurenceRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	
	@Override
	public TypeAssurenceDto getTypeAssurenceById(Long typeAssurenceId) {
		
		TypeAssurenceEntity entity= typeAssurenceRepository.findByTypeId(typeAssurenceId);
		
		if(entity == null)throw new RuntimeException("Type Assurence n'exist pas");
		
		TypeAssurenceDto dto=modelMapper.map(entity, TypeAssurenceDto.class);
		
		return dto;
	}


	@Override
	public TypeAssurenceDto createTypeAssurence(TypeAssurenceDto Assurence) {
		
		TypeAssurenceEntity check = 	typeAssurenceRepository.findByLibelle(Assurence.getLibelle());
		if(check != null)throw new RuntimeException("Type Assurence exist déja");
		
		TypeAssurenceEntity entity	=	modelMapper.map(Assurence, TypeAssurenceEntity.class);
		
		TypeAssurenceEntity createdTypeAssurence	=	typeAssurenceRepository.save(entity);
		
		TypeAssurenceDto	dto = modelMapper.map(createdTypeAssurence, TypeAssurenceDto.class);
		return dto;
	}


	@Override
	public void deletetypeAssurence(long typeAssurenceId) {
		
		TypeAssurenceEntity check = typeAssurenceRepository.findByTypeId(typeAssurenceId);
		
		if(check == null)throw new RuntimeException("Type Assurence n'exist pas");
		
		typeAssurenceRepository.delete(check);
	}


	@Override
	public TypeAssurenceDto updateTypeAssurence(Long typeAssurenceId, TypeAssurenceDto Assurence) {
		
		TypeAssurenceEntity entity = typeAssurenceRepository.findByTypeId(typeAssurenceId);
		
		if(entity == null)throw new RuntimeException("Type Assurence n'exist pas");
		
		entity.setLibelle(Assurence.getLibelle());
		
		TypeAssurenceEntity updated = typeAssurenceRepository.save(entity);
		
		TypeAssurenceDto dto = modelMapper.map(updated, TypeAssurenceDto.class);
		
		return dto;
	}


	@Override
	public List<TypeAssurenceDto> getAllTypeAssurence() {
		List <TypeAssurenceEntity> entity = typeAssurenceRepository.findAll();
		List<TypeAssurenceDto> dto=new ArrayList<>();
		
		for (TypeAssurenceEntity e : entity) {
			TypeAssurenceDto typeAssurence=modelMapper.map(e, TypeAssurenceDto.class);
			dto.add(typeAssurence);
		}
		return dto;
	}

}
