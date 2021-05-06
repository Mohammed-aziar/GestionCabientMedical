package com.CabinetMedical.ws.responses;

public class MedicamentResponse {

	private Long medicamentId;
	private String libelle;
	public Long getMedicamentId() {
		return medicamentId;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setMedicamentId(Long medicamentId) {
		this.medicamentId = medicamentId;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
