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
	}


	public TournoiEliminationDirecte(LinkedList<Equipe> listEq) {
		super.listeEquipes = listEq;
		super.listeToursEliminatoires = new LinkedList <TourEliminatoire>();
	}
	
	public TournoiEliminationDirecte() {
		super();
		super.listeToursEliminatoires = new LinkedList <TourEliminatoire>();
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
