package com.CabinetMedical.ws.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;



public class PatientDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2108082616547351353L;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
