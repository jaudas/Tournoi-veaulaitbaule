package model;

import java.util.ArrayList;
import java.util.LinkedList;


public class TournoiParPoules extends Tournoi {
	int nbPoules;
	ArrayList<Poule> listePoules;


	//Constructeur
	public TournoiParPoules()
	{
		super();
	}

	public TournoiParPoules(int nbeq, String descr)
	{
		super.nbEquipesInit= nbeq;
		super.description = descr;

		//Calcul du nombre de poules necessaires
		int nbpoul = nbeq/4;//Nb poules complètes
		if (nbpoul%4 != 0)//S'il reste des équipes
		{
			this.nbPoules = nbpoul++;
		}
		else
		{
			this.nbPoules = nbpoul;
		}

		LinkedList<Equipe> listEq = new LinkedList<Equipe>();
		super.listeEquipesEnJeu = listEq;

		LinkedList<Match> listMatch = new LinkedList<Match>();
		super.listeMatchs = listMatch;
	}

	//Méthodes
	@Override
	public String toString()
	{
		String str = super.toString() + "Il est composé d'une phase de qualifications par poules de 4 équipes, puis d'une phase finale. \n Description : " + super.description;
		return str;
	}

	//Créer les poules du tournoi
	public ArrayList<Poule> creerPoules(ArrayList<Equipe> listeEquipes){
		int cptPoules = nbPoules;
		while (cptPoules>0){     
			ArrayList<Equipe> equipesPoule = null;
			int ind=0;
			do{

				//Trouver une équipe au hasard dans la liste d'équipes
				ind = (int) ((Math.random())*listeEquipes.size());
				System.out.println(ind);

				//Ajouter l'équipe choisie dans une poule
				equipesPoule.add(listeEquipes.get(ind));
				listeEquipes.get(ind).toString();
				listeEquipes.remove(ind);

			}while (equipesPoule.size()<4);
			System.out.println("Creation d'une poule");
			Poule poule = new Poule ("nom", equipesPoule);
			this.listePoules.add(poule);
			cptPoules --;
		}

		return this.listePoules;
	}
}
