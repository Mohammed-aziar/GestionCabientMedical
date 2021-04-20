package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import javax.persistence.ManyToOne;

@Entity(name = "presciptions")
public class PresciptionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1871217232199070592L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long presciptionId;
	
	private String dosage;
	
	@ManyToOne
	@JoinColumn(name="visite_id")
	private VisiteEntity visite; 
	
	@ManyToOne
	@JoinColumn(name="medicament_Id")
	private MedicamentEntity medicamentEntity;

	/**
	 * 
	 */
	public PresciptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dosage
	 * @param visite
	 * @param medicamentEntity
	 */
	public PresciptionEntity(String dosage, VisiteEntity visite, MedicamentEntity medicamentEntity) {
		super();
		this.dosage = dosage;
		this.visite = visite;
		this.medicamentEntity = medicamentEntity;
	}

	public Long getPresciptionId() {
		return presciptionId;
	}

	public String getDosage() {
		return dosage;
	}

	public VisiteEntity getVisite() {
		return visite;
	}

	public MedicamentEntity getMedicamentEntity() {
		return medicamentEntity;
	}

	public void setPresciptionId(Long presciptionId) {
		this.presciptionId = presciptionId;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public void setVisite(VisiteEntity visite) {
		this.visite = visite;
	}

	public void setMedicamentEntity(MedicamentEntity medicamentEntity) {
		this.medicamentEntity = medicamentEntity;
	}

	
	
	
	
	
}
