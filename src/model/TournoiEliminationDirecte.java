package model;

import java.util.LinkedList;

public class TournoiEliminationDirecte extends Tournoi{
	
	//Constructeur
	public TournoiEliminationDirecte (int nbeq, String descr,LinkedList<Equipe> listEq ){
		super.nbEquipesInit = nbeq;
		super.description = descr;

		super.listeEquipes = listEq;


	}

	public TournoiEliminationDirecte(){
		super();
	}


	//Methode
	@Override
	public String toString(){
		String str = super.toString() + "C'est un tournoi avec Úlimination directe. \n Description du tournoi: " + super.description;
		return str;
	}

}
