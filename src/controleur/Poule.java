package controleur;

import java.util.ArrayList;
import model.Equipe;
import model.Match;

public class Poule {
	//Attributs
	private String nom;
	private ArrayList<Equipe> equipesPoule;
	private ArrayList<Match> matchsPoule = new ArrayList<Match>();
	private int classement;
	
	//Constructeurs
	public Poule(){
		super();
	}

	public Poule(String nom, ArrayList<Equipe> equipesPoule) {
		super();
		this.nom = nom;
		this.equipesPoule = equipesPoule;
		creerTableauMatchs();
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
	
	
	//Création du tableau de matchs d'une poule
	public ArrayList<Match> creerTableauMatchs()
	{
		/*Match m1 = new Match (equipesPoule.get(0), equipesPoule.get(1));
		matchsPoule.add(m1);
		Match m2 = new Match (equipesPoule.get(0), equipesPoule.get(2));
		matchsPoule.add(m2);
		Match m3 = new Match (equipesPoule.get(0), equipesPoule.get(3));
		matchsPoule.add(m3);
		Match m4 = new Match (equipesPoule.get(1), equipesPoule.get(2));
		matchsPoule.add(m4);
		Match m5 = new Match (equipesPoule.get(1), equipesPoule.get(3));
		matchsPoule.add(m5);
		Match m6 = new Match (equipesPoule.get(2), equipesPoule.get(3));
		matchsPoule.add(m6);
		*/
		int ind = 0;
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
				
				if (ind+2<equipesPoule.size()-1){
					Match match2 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+2));
					matchsPoule.add(match2);
				}
				if (ind+3<equipesPoule.size()-1){
					Match match3 = new Match (equipesPoule.get(ind), equipesPoule.get(ind+2));
					matchsPoule.add(match3);
				}
				ind ++;						
			}
			return matchsPoule;
		}
	}
	
	//Générer le classement d'une poule
	public int [] creerClassement(){
		
		return null;
	}
	
}

