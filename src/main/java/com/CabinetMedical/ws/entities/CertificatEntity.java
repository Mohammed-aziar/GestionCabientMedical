package com.CabinetMedical.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "certificat")
public class CertificatEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144595592846543238L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long certificatId;

	private int noumbreJour;

	private String commantaire;

	@ManyToOne
	@JoinColumn(name = "visite_id")
	private VisiteEntity visite;

	/**
	 * @param certificatId
	 * @param noumbreJour
	 * @param commantaire
	 * @param visite
	 */
	public CertificatEntity(int noumbreJour, String commantaire, VisiteEntity visite) {
		super();
		this.noumbreJour = noumbreJour;
		this.commantaire = commantaire;
		this.visite = visite;
	}

	/**
	 * 
	 */
	public CertificatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCertificatId() {
		return certificatId;
	}

	public int getNoumbreJour() {
		return noumbreJour;
	}

	public VisiteEntity getVisite() {
		return visite;
	}

	public void setCertificatId(Long certificatId) {
		this.certificatId = certificatId;
	}

	public void setNoumbreJour(int noumbreJour) {
		this.noumbreJour = noumbreJour;
	}

	public void setVisite(VisiteEntity visite) {
		this.visite = visite;
	}

	public String getCommantaire() {
		return commantaire;
	}

	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}

}
