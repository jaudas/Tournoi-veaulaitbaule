package model;

import java.util.LinkedList;

public class TournoiEliminationDirecte extends Tournoi {

	// Constructeur
	public TournoiEliminationDirecte(int nbeq, String descr,
			LinkedList<Equipe> listEq) {
		super.nbEquipesInit = nbeq;
		super.description = descr;
		super.listeEquipes = listEq;
		super.listeMatchs = new LinkedList<Match>();
		super.listeToursEliminatoires = new LinkedList <TourEliminatoire>();
		
		//Creation du premier tour de jeu
		super.creerTour();
	}


	public TournoiEliminationDirecte(LinkedList<Equipe> listEq) {
		super.listeEquipes = listEq;
		super.nbEquipesInit = listEq.size();
		super.listeToursEliminatoires = new LinkedList <TourEliminatoire>();
		
		//Creation du premier tour de jeu
		super.creerTour();
	}
	

	// Methode
	@Override
	public String toString() {
		String str = super.toString()
				+ "C'est un tournoi avec élimination directe. \n Description du tournoi: "
				+ super.description;
		return str;
	}

	
}
