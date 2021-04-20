package com.CabinetMedical.ws.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "visites")
public class VisiteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3232904967112721353L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private Long visiteId;
	private Date dateDebut;
	private Date dateFin;
	private String motif;
	private String type;
	private String diagnostic;
	private String commantaire;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private PatientEntity patient;
	
	@OneToOne(mappedBy ="visite",cascade = CascadeType.ALL)
	private PayementEntity payementEntity;
	
	@OneToMany(mappedBy = "visite",cascade = CascadeType.ALL)
	private List<CertificatEntity> certificatEntities;

	@OneToMany(mappedBy = "visite",cascade = CascadeType.ALL)
	private List<AnalyseEntity> analyseEntities;
	
	@OneToMany(mappedBy = "visite",cascade = CascadeType.ALL)
	private List<PresciptionEntity> presciptionEntities;
	
	
	/**
	 * @param visiteId
	 * @param dateDebut
	 * @param dateFin
	 * @param motif
	 * @param type
	 * @param diagnostic
	 * @param commantaire
	 * @param patient
	 */
	public VisiteEntity( Date dateDebut, Date dateFin, String motif, String type, String diagnostic,
			String commantaire, PatientEntity patient) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.motif = motif;
		this.type = type;
		this.diagnostic = diagnostic;
		this.commantaire = commantaire;
		this.patient = patient;
	}

	/**
	 * 
	 */
	public VisiteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public PatientEntity getPatient() {
		return patient;
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

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public PayementEntity getPayementEntity() {
		return payementEntity;
	}

	public void setPayementEntity(PayementEntity payementEntity) {
		this.payementEntity = payementEntity;
	}

	public List<CertificatEntity> getCertificatEntities() {
		return certificatEntities;
	}

	public void setCertificatEntities(List<CertificatEntity> certificatEntities) {
		this.certificatEntities = certificatEntities;
	}

	public List<AnalyseEntity> getAnalyseEntities() {
		return analyseEntities;
	}

	public void setAnalyseEntities(List<AnalyseEntity> analyseEntities) {
		this.analyseEntities = analyseEntities;
	}

	public List<PresciptionEntity> getPresciptionEntities() {
		return presciptionEntities;
	}

	public void setPresciptionEntities(List<PresciptionEntity> presciptionEntities) {
		this.presciptionEntities = presciptionEntities;
	}
	
	
	
	
}
