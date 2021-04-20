package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "Analyse")
public class AnalyseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2543319915027175895L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long analyseId;
	@Column(length = 200)
	private String conclusion;

	@ManyToOne
	@JoinColumn(name="visite_id")
	private VisiteEntity visite;
	
	@ManyToOne
	@JoinColumn(name="typeAnalyse_id")
	private TypeAnalyseEntity typeAnalyse;

	/**
	 * 
	 */
	public AnalyseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param conclusion
	 * @param visite
	 * @param typeAnalyse
	 */
	public AnalyseEntity(String conclusion, VisiteEntity visite, TypeAnalyseEntity typeAnalyse) {
		super();
		this.conclusion = conclusion;
		this.visite = visite;
		this.typeAnalyse = typeAnalyse;
	}

	public Long getAnalyseId() {
		return analyseId;
	}

	public String getConclusion() {
		return conclusion;
	}

	public VisiteEntity getVisite() {
		return visite;
	}

	public TypeAnalyseEntity getTypeAnalyse() {
		return typeAnalyse;
	}

	public void setAnalyseId(Long analyseId) {
		this.analyseId = analyseId;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public void setVisite(VisiteEntity visite) {
		this.visite = visite;
	}

	public void setTypeAnalyse(TypeAnalyseEntity typeAnalyse) {
		this.typeAnalyse = typeAnalyse;
	}
	
	
	
}
