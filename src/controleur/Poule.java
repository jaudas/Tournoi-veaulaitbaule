package controleur;

import java.util.ArrayList;

import model.Equipe;

public class Poule {
	//Attributs
	private String nom;
	private ArrayList<Equipe> equipesPoule;
	
	
	//Constructeurs
	public Poule(){
		super();
	}

	public Poule(String nom, ArrayList<Equipe> equipesPoule) {
		super();
		this.nom = nom;
		this.equipesPoule = equipesPoule;
	}

	//Méthodes
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Equipe> getEquipesPoule() {
		return equipesPoule;
	}

	public void setEquipesPoule(ArrayList<Equipe> equipesPoule) {
		this.equipesPoule = equipesPoule;
	}
	
	
	public void calculerClassement(){
		
	}
}

