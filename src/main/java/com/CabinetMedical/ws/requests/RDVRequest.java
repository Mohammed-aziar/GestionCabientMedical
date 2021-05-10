package com.CabinetMedical.ws.requests;

import java.time.LocalDateTime;
import java.util.Date;

public class RDVRequest {
	private Long RDVId;
	private LocalDateTime date_RDV;
	private Date dateCreationRDV;
	private Long patientId;
	
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
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
