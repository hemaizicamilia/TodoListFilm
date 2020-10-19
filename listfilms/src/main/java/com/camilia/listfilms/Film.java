package com.camilia.listfilms;


public class Film {
	
	private int id;
	private String titre;
	private String annee;
	private String genre;
	private boolean viewed;
	private boolean fav;

	public Film(int id, String titre, String annee, String genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.genre = genre;
		this.viewed = false;
		this.fav = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isFav() {
		return fav;
	}

	public void setFav(boolean fav) {
		this.fav = fav;
	}
	
	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", genre=" + genre + ", fav=" + fav + "]";
	}
	
	
	
}
