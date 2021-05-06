package com.CabinetMedical.ws.services;

import java.util.List;

import com.CabinetMedical.ws.dto.MedicamentDto;

public interface MedicamentService {

	MedicamentDto getMedicament(String libelle);
	
	List<MedicamentDto> getListMedicament();
	
	MedicamentDto createMedicament(MedicamentDto medicamentDto);
	
	void deleteMedicament(long medicamentId);
	
	MedicamentDto updateMedicament(long medicamentId,MedicamentDto medicamentDto);

}
