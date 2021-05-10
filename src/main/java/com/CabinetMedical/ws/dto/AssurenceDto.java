package com.CabinetMedical.ws.dto;


public class AssurenceDto {
	private Long assurenceId;
	private long patientId;
	private Long typeAssurenceId;
	
	
	/**
	 * 
	 */
	public AssurenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param assurenceId
	 * @param patientId
	 * @param typeAssurenceId
	 */
	public AssurenceDto(Long assurenceId, long patientId, Long typeAssurenceId) {
		super();
		this.assurenceId = assurenceId;
		this.patientId = patientId;
		this.typeAssurenceId = typeAssurenceId;
	}

	public Long getAssurenceId() {
		return assurenceId;
	}
	public long getPatientId() {
		return patientId;
	}
	public Long getTypeAssurenceId() {
		return typeAssurenceId;
	}
	public void setAssurenceId(Long assurenceId) {
		this.assurenceId = assurenceId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public void setTypeAssurenceId(Long typeAssurenceId) {
		this.typeAssurenceId = typeAssurenceId;
	}
	
	
}
