package com.CabinetMedical.ws.responses;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;



public class PatientResponse {
	private Long patientId;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String email;
	private String sexe;
	private String cin;
	private String prefession;
	private String sagn;
	private LocalDate dateNaissance;
	private Date dateCreationFichierMedical;
	
	private List<RDVResponse> RDV;
	
	private List<VisiteResponse> visite;

	
	public Long getPatientId() {
		return patientId;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	public String getSexe() {
		return sexe;
	}
	public String getCin() {
		return cin;
	}
	public String getPrefession() {
		return prefession;
	}
	public String getSagn() {
		return sagn;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public Date getDateCreationFichierMedical() {
		return dateCreationFichierMedical;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public void setPrefession(String prefession) {
		this.prefession = prefession;
	}
	public void setSagn(String sagn) {
		this.sagn = sagn;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public void setDateCreationFichierMedical(Date dateCreationFichierMedical) {
		this.dateCreationFichierMedical = dateCreationFichierMedical;
	}
	public List<RDVResponse> getRDV() {
		return RDV;
	}
	public void setRDV(List<RDVResponse> rDV) {
		RDV = rDV;
	}
	public List<VisiteResponse> getVisite() {
		return visite;
	}
	public void setVisite(List<VisiteResponse> visite) {
		this.visite = visite;
	}
	
	
	
	
}
