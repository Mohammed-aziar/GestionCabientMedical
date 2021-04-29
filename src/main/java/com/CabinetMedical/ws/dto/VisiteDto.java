package com.CabinetMedical.ws.dto;

import java.util.Date;

public class VisiteDto {
	private Long visiteId;
	private Date dateDebut;
	private Date dateFin;
	private String motif;
	private String type;
	private String diagnostic;
	private String commantaire;
	private PatientDto patinet;
	
	public Long getVisiteId() {
		return visiteId;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public String getMotif() {
		return motif;
	}
	public String getType() {
		return type;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public String getCommantaire() {
		return commantaire;
	}
	public PatientDto getPatinet() {
		return patinet;
	}
	public void setVisiteId(Long visiteId) {
		this.visiteId = visiteId;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}
	public void setPatinet(PatientDto patinet) {
		this.patinet = patinet;
	}
}
