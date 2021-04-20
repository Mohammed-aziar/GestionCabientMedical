package com.CabinetMedical.ws.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity(name="TypeAssurence")
public class TypeAssurenceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2465379345564420780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long typeId;
	
	
	private String libelle;
	
	@OneToMany(mappedBy = "typeAssurenceEntity") 
	private List<AssurenceEntity> assurenceEntity;

	
	
	
	/**
	 * @param typeId
	 * @param libelle
	 */
	public TypeAssurenceEntity(Long typeId, String libelle) {
		super();
		this.typeId = typeId;
		this.libelle = libelle;
	}

	/**
	 * @param typeId
	 * @param assurenceEntity
	 */
	public TypeAssurenceEntity(Long typeId, List<AssurenceEntity> assurenceEntity) {
		super();
		this.typeId = typeId;
		this.assurenceEntity = assurenceEntity;
	}

	/**
	 * 
	 */
	public TypeAssurenceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTypeId() {
		return typeId;
	}

	public List<AssurenceEntity> getAssurenceEntity() {
		return assurenceEntity;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setAssurenceEntity(List<AssurenceEntity> assurenceEntity) {
		this.assurenceEntity = assurenceEntity;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
