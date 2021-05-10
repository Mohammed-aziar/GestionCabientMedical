package com.CabinetMedical.ws.responses;



public class AssurenceResponse {

	private Long assurenceId;
	private Long patientId;
	private Long typeAssurenceId;
	
	
	/**
	 * 
	 */
	public AssurenceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param assurenceId
	 * @param patientId
	 * @param typeAssurenceId
	 */
	public AssurenceResponse(Long assurenceId, Long patientId, Long typeAssurenceId) {
		super();
		this.assurenceId = assurenceId;
		this.patientId = patientId;
		this.typeAssurenceId = typeAssurenceId;
	}


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
