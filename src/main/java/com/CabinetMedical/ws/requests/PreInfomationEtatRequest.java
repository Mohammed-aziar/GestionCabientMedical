package com.CabinetMedical.ws.requests;

public class PreInfomationEtatRequest {

	private Long infoId;
	private String historique;
	private Long patinetId;
	

	
	public PreInfomationEtatRequest(Long infoId , String historique , Long patinetId) {
		super();
		this.infoId = infoId;
		this.historique = historique;
		this.patinetId = patinetId;
	}
	
	
	public PreInfomationEtatRequest() {
		super();
	}
	
	public Long getInfoId() {
		return infoId;
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
