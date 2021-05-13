package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.RDVDto;

public interface RDVService {
	RDVDto getRDVById(Long rdvID);
	List<RDVDto> getList();
	RDVDto createdRDV(RDVDto rdvDto);
	void deleteRdv(Long rdvId);
	RDVDto updateRDV(Long rdvId,RDVDto rdvDto);
}
