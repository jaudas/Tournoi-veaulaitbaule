package model;

import java.util.LinkedList;

import controleur.TourEliminatoire;

public class TournoiEliminationDirecte extends Tournoi{

	//Constructeur
	public TournoiEliminationDirecte (int nbeq, String descr,LinkedList<Equipe> listEq){
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
		String str = super.toString() + "C'est un tournoi avec élimination directe. \n Description du tournoi: " + super.description;
		return str;
	}

	public void deroulementTournoi()
	{
		LinkedList<Equipe> listEqEnJeu = super.getListeEquipes();
		TourEliminatoire  tourJeu;
		int compteurtour = 0;
		
		while(listEqEnJeu.size()!= 1) //Tant qu'il y a plus d'une équipe en jeu, alors on effectue un tournoi
		{
			
			//Creation d'un tour 
			tourJeu = new TourEliminatoire(listEqEnJeu);
			compteurtour ++; 
			System.out.println("Lancement du tour "+compteurtour);
			System.out.println("Liste des équipes du tour : ");
			for(int i=0; i<tourJeu.getListeEquipesTour().size();i++)
		       {
		       	 System.out.println (i+"=>"+tourJeu.getListeEquipesTour().get(i));
		       }
			
			
			//On définit le qualifié d'office si il existe
			tourJeu.setQualifOffice();
			
			//On cree le tour de jeu
			System.out.println("C'est parti pour la création des matchs ! ");
			tourJeu.CreerTour();
			System.out.println("Matchs générés ! ");
			
			//On mets à jour la liste des équipes en jeu
			listEqEnJeu = tourJeu.equipesQualifiees();
			System.out.println("Fin du tour "+compteurtour);
			
		}
		
		
	}






}
