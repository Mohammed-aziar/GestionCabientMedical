package com.CabinetMedical.ws.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RDVDto {
	private Long RDVId;
	private LocalDateTime date_RDV;
	private Date dateCreationRDV;
	private PatientDto patient;
	

	
	
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatientDto(PatientDto patient) {
		this.patient = patient;
	}
	public Long getRDVId() {
		return RDVId;
	}
	public LocalDateTime getDate_RDV() {
		return date_RDV;
	}
	public Date getDateCreationRDV() {
		return dateCreationRDV;
	}
	public void setRDVId(Long rDVId) {
		RDVId = rDVId;
	}
	public void setDate_RDV(LocalDateTime date_RDV) {
		this.date_RDV = date_RDV;
	}
	public void setDateCreationRDV(Date dateCreationRDV) {
		this.dateCreationRDV = dateCreationRDV;
	}
}
