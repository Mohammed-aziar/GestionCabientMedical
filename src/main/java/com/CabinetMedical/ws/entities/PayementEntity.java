package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity(name="payement")
public class PayementEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274330562119338398L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long payementId;
	@Column(length = 7,nullable = false)
	private double prix;
	@Column(nullable = false)
	private boolean payementValide;
	
	
	public void setPayementValide(boolean payementValide) {
		this.payementValide = payementValide;
	}


	@OneToOne
	@JoinColumn(name="visite_id",referencedColumnName = "id")
	private VisiteEntity visite;


	/**
	 * 
	 */
	public PayementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param prix
	 * @param payementValide
	 * @param visite
	 */
	public PayementEntity(double prix, Boolean payementValide, VisiteEntity visite) {
		super();
		this.prix = prix;
		this.payementValide = payementValide;
		this.visite = visite;
	}


	public Long getPayementId() {
		return payementId;
	}


	public double getPrix() {
		return prix;
	}


	public Boolean getPayementValide() {
		return payementValide;
	}


	public VisiteEntity getVisite() {
		return visite;
	}


	public void setPayementId(Long payementId) {
		this.payementId = payementId;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public void setPayementValide(Boolean payementValide) {
		this.payementValide = payementValide;
	}


	public void setVisite(VisiteEntity visite) {
		this.visite = visite;
	}
	
	
	
}
