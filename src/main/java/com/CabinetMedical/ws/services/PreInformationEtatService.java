package com.CabinetMedical.ws.services;

import com.CabinetMedical.ws.dto.PreInformationEtatDto;

public interface PreInformationEtatService {
	PreInformationEtatDto  getPreInfoById(Long infoId);
	PreInformationEtatDto createPreInfo(PreInformationEtatDto preInfoDto);
	void deletePreInfoEtat(Long infoId);
	PreInformationEtatDto updatePreInfo(Long preInfoId,PreInformationEtatDto preInfoDto);
}
