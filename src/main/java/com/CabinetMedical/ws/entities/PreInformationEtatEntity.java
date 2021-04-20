package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "preInfoEtat")
public class PreInformationEtatEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6624716282817023384L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long infoId;
	@Column(length = 200)
	private String historique;

	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private PatientEntity patientEntity;

	/**
	 * 
	 */
	public PreInformationEtatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param historique
	 * @param patientEntity
	 */
	public PreInformationEtatEntity(String historique, PatientEntity patientEntity) {
		super();
		this.historique = historique;
		this.patientEntity = patientEntity;
	}

	public Long getInfoId() {
		return infoId;
	}

	public String getHistorique() {
		return historique;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public void setHistorique(String historique) {
		this.historique = historique;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	@Override
	public String toString() {
		return "PreInformationEtatEntity [infoId=" + infoId + ", historique=" + historique + ", patientEntity="
				+ patientEntity + "]";
	}

	
	
}
