package com.CabinetMedical.ws.requests;

public class AssurenceRequest {
	
	private Long assurenceId;
	private Long patientId;
	private Long typeAssurenceId;
	
	public Long getAssurenceId() {
		return assurenceId;
	}
	public void setAssurenceId(Long assurenceId) {
		this.assurenceId = assurenceId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public Long getTypeAssurenceId() {
		return typeAssurenceId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public void setTypeAssurenceId(Long typeAssurenceId) {
		this.typeAssurenceId = typeAssurenceId;
	}
	
}
