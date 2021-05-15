package com.CabinetMedical.ws.responses;

import java.util.Date;

public class VisiteResponse {
	private Long visiteId;
	private Date dateDebut;
	private Date dateFin;
	private String motif;
	private String type;
	private String diagnostic;
	private String commantaire;
	private Long patinetId;
	
	
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
	
	public Long getPatinetId() {
		return patinetId;
	}
	public void setPatinetId(Long patinetId) {
		this.patinetId = patinetId;
	}
}
