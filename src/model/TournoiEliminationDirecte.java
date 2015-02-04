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
		String str = super.toString() + "C'est un tournoi avec �limination directe. \n Description du tournoi: " + super.description;
		return str;
	}

	public void deroulementTournoi()
	{
		LinkedList<Equipe> listEqEnJeu = super.getListeEquipes();
		TourEliminatoire  tourJeu;
		int compteurtour = 0;
		
		while(listEqEnJeu.size()!= 1) //Tant qu'il y a plus d'une �quipe en jeu, alors on effectue un tournoi
		{
			
			//Creation d'un tour 
			tourJeu = new TourEliminatoire(listEqEnJeu);
			compteurtour ++; 
			System.out.println("Lancement du tour "+compteurtour);
			System.out.println("Liste des �quipes du tour : ");
			for(int i=0; i<tourJeu.getListeEquipesTour().size();i++)
		       {
		       	 System.out.println (i+"=>"+tourJeu.getListeEquipesTour().get(i));
		       }
			
			
			//On d�finit le qualifi� d'office si il existe
			tourJeu.setQualifOffice();
			
			//On cree le tour de jeu
			System.out.println("C'est parti pour la cr�ation des matchs ! ");
			tourJeu.CreerTour();
			System.out.println("Matchs g�n�r�s ! ");
			
			//On mets � jour la liste des �quipes en jeu
			listEqEnJeu = tourJeu.equipesQualifiees();
			System.out.println("Fin du tour "+compteurtour);
			
		}
		
		
	}






}
