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
@Entity(name = "Type_Analyse")
public class TypeAnalyseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8237719358667541612L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long typeAnalyseId;
	@Column(nullable = false , length = 30)
	private String libelle;
	
	@OneToMany(mappedBy = "typeAnalyse",cascade = CascadeType.ALL)
	private List<AnalyseEntity> analyseEntities;

	/**
	 * 
	 */
	public TypeAnalyseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param libelle
	 * @param analyseEntities
	 */
	public TypeAnalyseEntity(String libelle, List<AnalyseEntity> analyseEntities) {
		super();
		this.libelle = libelle;
		this.analyseEntities = analyseEntities;
	}

	public Long getTypeAnalyseId() {
		return typeAnalyseId;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<AnalyseEntity> getAnalyseEntities() {
		return analyseEntities;
	}

	public void setTypeAnalyseId(Long typeAnalyseId) {
		this.typeAnalyseId = typeAnalyseId;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setAnalyseEntities(List<AnalyseEntity> analyseEntities) {
		this.analyseEntities = analyseEntities;
	}
	
	
	
}
