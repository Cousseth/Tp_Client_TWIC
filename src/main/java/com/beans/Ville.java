package com.beans;

import org.json.JSONObject;

public class Ville {
	private String code_commune_INSEE;
	private String nom_commune;
	private String code_postal;
	private String libelle_acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;

	public String getCode_commune_INSEE() {
		return code_commune_INSEE;
	}

	public void setCode_commune_INSEE(String code_commune_INSEE) {
		this.code_commune_INSEE = code_commune_INSEE;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Ville() {
		this.code_commune_INSEE = null;
		this.code_postal = "";
		this.latitude = "";
		this.libelle_acheminement = "";
		this.ligne_5 = "";
		this.longitude = "";
		this.nom_commune = "";
	}

	public Ville(JSONObject villeJson) {
		this.code_commune_INSEE = villeJson.getString("Code_commune_INSEE");
		this.nom_commune = villeJson.getString("Nom_commune");
		this.latitude = villeJson.getString("Latitude");
		this.libelle_acheminement = villeJson.getString("Libelle_acheminement");
		this.ligne_5 = villeJson.getString("Ligne_5");
		this.longitude = villeJson.getString("Longitude");
		this.code_postal = villeJson.getString("Code_Postal");
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("Code_commune_INSEE", this.code_commune_INSEE);
		json.put("Nom_commune", this.nom_commune);
		json.put("Latitude", this.latitude);
		json.put("Libelle_acheminement", this.libelle_acheminement);
		json.put("Ligne_5", this.ligne_5);
		json.put("Longitude", this.longitude);
		json.put("Code_postal", this.code_postal);
		return json;

	}

	public double calculDistance(Ville ville) {
		double rayonTerre = 6371.445;
		double a, b, c, d = 0;
		try {
			a = Double.parseDouble(this.getLatitude()) * Math.PI / 180;
			b = Double.parseDouble(ville.getLatitude()) * Math.PI / 180;
			c = Double.parseDouble(this.getLongitude()) * Math.PI / 180;
			d = Double.parseDouble(ville.getLongitude()) * Math.PI / 180;
		} catch (NullPointerException e) {
			return -1;
		}
		return rayonTerre * Math.acos(Math.sin(a) * Math.sin(b) + Math.cos(a) * Math.cos(b) * Math.cos(c - d));
	}

}
