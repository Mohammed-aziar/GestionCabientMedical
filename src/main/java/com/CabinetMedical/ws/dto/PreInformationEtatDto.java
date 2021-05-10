package com.CabinetMedical.ws.dto;

public class PreInformationEtatDto {
	private Long infoId;
	private String historique;
	private Long patinetId;
	
	/**
	 * 
	 */
	

	public Long getInfoId() {
		return infoId;
	}
	/**
	 * 
	 */
	public PreInformationEtatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param infoId
	 * @param historique
	 * @param patinetId
	 */
	public PreInformationEtatDto(Long infoId, String historique, Long patinetId) {
		super();
		this.infoId = infoId;
		this.historique = historique;
		this.patinetId = patinetId;
	}
	public String getHistorique() {
		return historique;
	}
	public Long getPatinetId() {
		return patinetId;
	}
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	public void setHistorique(String historique) {
		this.historique = historique;
	}
	public void setPatinetId(Long patinetId) {
		this.patinetId = patinetId;
	}
}
