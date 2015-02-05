package controleur;

import java.util.ArrayList;
import java.util.Collections;

import model.Equipe;
import model.Match;
import model.Tournoi;

public class Poule {
	//Attributs
	private String nom;
	private ArrayList<Equipe> equipesPoule;
	private ArrayList<Match> matchsPoule = new ArrayList<Match>();
	//private int [] classement;
	
	//Constructeurs
	public Poule(){
		super();
	}

	public Poule(String nom, ArrayList<Equipe> equipesPoule) {
		super();
		this.nom = nom;
		this.equipesPoule = equipesPoule;
		creerTableauMatchs();
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
		
	
	//Création du tableau de matchs d'une poule
	public ArrayList<Match> creerTableauMatchs(){
		int ind = 0;
		System.out.println("Taille de la liste d'équipes: "+equipesPoule.size());
		if (equipesPoule.size() == 1){
			System.out.println("Une seule équipe dans la poule. Pas de tableau de matchs.");
			return null;
		}
		
		else
		{
			while (ind<equipesPoule.size()-1)
			{									
				Match match1 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+1));
				matchsPoule.add(match1);
				
				if (ind+2<equipesPoule.size()){
					Match match2 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+2));
					matchsPoule.add(match2);
				}
				if (ind+3<equipesPoule.size()){
					Match match3 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+3));
					matchsPoule.add(match3);
				}
				ind ++;						
			}
			System.out.println("Nombre de matchs créés : "+matchsPoule.size());
			return matchsPoule;
		}
	}
	
	//Classer les équipes d'une poule	
	public ArrayList<Equipe> classerEquipes(){ 
		Collections.sort(equipesPoule);
		return equipesPoule;
	}
	
}

