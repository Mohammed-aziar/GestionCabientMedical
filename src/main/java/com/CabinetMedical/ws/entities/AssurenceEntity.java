package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity(name ="Assurence")
public class AssurenceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5390439515146547030L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long AssurenceId;
	
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private TypeAssurenceEntity typeAssurenceEntity;

		
	
	/**
	 * @param assurenceId
	 * @param patient
	 * @param typeAssurenceEntity
	 */
	public AssurenceEntity(Long assurenceId, PatientEntity patient, TypeAssurenceEntity typeAssurenceEntity) {
		super();
		AssurenceId = assurenceId;
		this.patient = patient;
		this.typeAssurenceEntity = typeAssurenceEntity;
	}

	/**
	 * 
	 */
	public AssurenceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAssurenceId() {
		return AssurenceId;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public TypeAssurenceEntity getListAssurence() {
		return typeAssurenceEntity;
	}

	public void setAssurenceId(Long assurenceId) {
		AssurenceId = assurenceId;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public void setListAssurence(TypeAssurenceEntity listAssurence) {
		this.typeAssurenceEntity = listAssurence;
	}
	
	
}
