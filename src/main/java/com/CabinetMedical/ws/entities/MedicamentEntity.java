package com.CabinetMedical.ws.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
@Entity(name = "medicament")
public class MedicamentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4189314699328674204L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long medicamentId;
	private String libelle;
	
	@OneToMany(mappedBy = "medicamentEntity",cascade = CascadeType.ALL)
	private List<PresciptionEntity> presciptionEntities;

	/**
	 * 
	 */
	public MedicamentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param libelle
	 * @param presciptionEntities
	 */
	public MedicamentEntity(String libelle, List<PresciptionEntity> presciptionEntities) {
		super();
		this.libelle = libelle;
		this.presciptionEntities = presciptionEntities;
	}

	public Long getMedicamentId() {
		return medicamentId;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<PresciptionEntity> getPresciptionEntities() {
		return presciptionEntities;
	}

	public void setMedicamentId(Long medicamentId) {
		this.medicamentId = medicamentId;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPresciptionEntities(List<PresciptionEntity> presciptionEntities) {
		this.presciptionEntities = presciptionEntities;
	}

	
	
	
}
