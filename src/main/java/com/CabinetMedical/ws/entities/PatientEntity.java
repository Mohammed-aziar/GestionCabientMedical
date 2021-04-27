package com.CabinetMedical.ws.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name = "patients")
public class PatientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7042060186198335180L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long patientId;
	@Column(length = 30, nullable = false)
	private String nom;
	@Column(length = 30, nullable = false)
	private String prenom;
	@Column(length = 100)
	private String adresse;
	@Column(length = 20)
	private String tel;
	@Column(length = 120, unique = true)
	private String email;
	
	@Column(length = 20)
	private String sexe;
	
	@Column(length = 20)
	private String cin;
	
	@Column(length = 30)
	private String prefession;
	@Column(length = 10)
	private String sagn;
	private LocalDate dateNaissance;
	private Date dateCreationFichierMedical;

	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL)
	private List<RDVEntity> RDV;
		
	@OneToOne(mappedBy = "patientEntity")
	private PreInformationEtatEntity preInformationEtatEntity;

	
	@OneToOne(mappedBy = "patient")
	private AssurenceEntity assurenceEntity;
	
	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL)
	private List<VisiteEntity> visiteEntities;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param tel
	 * @param email
	 * @param sexe
	 * @param cin
	 * @param prefession
	 * @param sagn
	 * @param dateNaissance
	 * @param dateCreationFichierMedical
	 * @param rDV
	 */
	public PatientEntity(String nom, String prenom, String adresse, String tel, String email, String sexe, String cin,
			String prefession, String sagn, LocalDate dateNaissance, Date dateCreationFichierMedical) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.sexe = sexe;
		this.cin = cin;
		this.prefession = prefession;
		this.sagn = sagn;
		this.dateNaissance = dateNaissance;
		this.dateCreationFichierMedical = dateCreationFichierMedical;
	}


	/**
	 * 
	 */
	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getPatientId() {
		return patientId;
	}

	public String getNom() {
		return nom;
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

	public List<RDVEntity> getRDV() {
		return RDV;
	}


	public void setRDV(List<RDVEntity> rDV) {
		RDV = rDV;
	}


	public PreInformationEtatEntity getPreInformationEtatEntity() {
		return preInformationEtatEntity;
	}


	public AssurenceEntity getAssurenceEntity() {
		return assurenceEntity;
	}


	public List<VisiteEntity> getVisiteEntities() {
		return visiteEntities;
	}


	public void setPreInformationEtatEntity(PreInformationEtatEntity preInformationEtatEntity) {
		this.preInformationEtatEntity = preInformationEtatEntity;
	}


	public void setAssurenceEntity(AssurenceEntity assurenceEntity) {
		this.assurenceEntity = assurenceEntity;
	}


	public void setVisiteEntities(List<VisiteEntity> visiteEntities) {
		this.visiteEntities = visiteEntities;
	}


	@Override
	public String toString() {
		return " patientId=" + patientId + "\n nom=" + nom + "\n prenom=" + prenom + "\n adresse=" + adresse + "\n tel="
				+ tel + "\n email=" + email + "\n sexe=" + sexe + "\n cin=" + cin + "\n prefession=" + prefession
				+ "\n sagn=" + sagn + "\n dateNaissance=" + dateNaissance  +"\n dateCreationFichierMedical=" + dateCreationFichierMedical;
	}

}
