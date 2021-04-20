package com.CabinetMedical.ws.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity(name="RDV")
public class RDVEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991151979323305128L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long RDVId;
	
	private LocalDateTime date_RDV;
	private Date dateCreationRDV;
	
	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private PatientEntity patient;
	
	
	/**
	 * @param date_RDV
	 * @param dateCreationRDV
	 * @param patient
	 */
	public RDVEntity(LocalDateTime date_RDV, Date dateCreationRDV, PatientEntity patient) {
		super();
		this.date_RDV = date_RDV;
		this.dateCreationRDV = dateCreationRDV;
		this.patient = patient;
	}
	
	
	/**
	 * 
	 */
	public RDVEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getRDVId() {
		return RDVId;
	}
	
	public LocalDateTime getDate_RDV() {
		return date_RDV;
	}
	public Date getDateCreationRDV() {
		return dateCreationRDV;
	}
	public void setRDVId(Long rDVId) {
		RDVId = rDVId;
	}
	public void setDate_RDV(LocalDateTime date_RDV) {
		this.date_RDV = date_RDV;
	}
	public void setDateCreationRDV(Date dateCreationRDV) {
		this.dateCreationRDV = dateCreationRDV;
	}


	public PatientEntity getPatient() {
		return patient;
	}


	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "RDVId=" + RDVId + "\n date_RDV=" + date_RDV + " \n  dateCreationRDV=" + dateCreationRDV
				+ "\n  patient=" + patient ;
	}


	
	
	
	
	
}
