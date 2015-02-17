package model;

import java.util.ArrayList;
import java.util.Collections;

public class Poule {
	//Attributs
	private String nom;
	private ArrayList<Equipe> equipesPoule;
	private EnumTypeMatch type;
	
	//Constructeurs
	public Poule(){
		super();
	}

	public Poule(String nom, ArrayList<Equipe> equipesPoule, Tournoi tournoi, int groupePoule) {
		super();
		this.nom = nom;
		this.equipesPoule = equipesPoule;
		//this.type = 
		
		creerTableauMatchs(tournoi);
		//creerClassement();
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
	
	public EnumTypeMatch attribuerType (int groupePoule){
		while (groupePoule != )
	}
		
	
	//Création des matchs des poules. Les matchs seront stockés dans une liste de matchs qui est un attribut de la classe TournoiParPoules
	public void creerTableauMatchs(Tournoi tournoi){
		int ind = 0;
		
		if (equipesPoule.size() == 1){
			System.out.println("Une seule équipe dans la poule. Pas de tableau de matchs.");
		}
		
		else
		{
			while (ind<equipesPoule.size()-1)
			{									
				Match match1 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+1), this.groupe);
				tournoi.addMatch(match1);
				
				if (ind+2<equipesPoule.size()){
					Match match2 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+2), this.groupe);
					tournoi.addMatch(match2);
				}
				if (ind+3<equipesPoule.size()){
					Match match3 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+3), this.groupe);
					tournoi.addMatch(match3);
				}
				ind ++;						
			}
			//System.out.println("Nombre de matchs créés : "+listeM.size());
		}
	}
	
	//Classer les équipes d'une poule	
	public ArrayList<Equipe> classerEquipes(){ 
		Collections.sort(equipesPoule);
		return equipesPoule;
	}
	
}

