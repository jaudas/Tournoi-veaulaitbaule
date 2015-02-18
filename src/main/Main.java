package main;

import view.*;
import controleur.*;
import model.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ConsoleView.accueil(); 
		
//Initialisation du tournoi
		//Demande du type de tournoi
		int tournoiType = ConsoleView.choixTournoi();
		Tournoi tournoi = new Tournoi();
		
		//Demande le nombre d'équipes dans le tournoi
		LinkedList<Equipe> listeEquipes=InfoEquipes.inscrireEquipes();
		ConsoleView.afficherEquipesEtJoueurs(listeEquipes);		
		
		//Si c'est un tournoi par élminitation directe
		if (tournoiType == 1)
		{
			tournoi = new TournoiEliminationDirecte(listeEquipes);
			System.out.println("Tournoi par élimination ! ");
			//TourEliminatoire tourInitial = new TourEliminatoire(tournoi.getListeEquipes());
			tournoi.creerTour();
			
		}
		//Tournoi par poules
		if (tournoiType == 2)
		{
			tournoi = new TournoiParPoules(listeEquipes);
			tournoi.creerPoules();
			System.out.println("Tournoi par poules ! ");
			ConsoleView.afficherPoules((TournoiParPoules)tournoi);
			
		}

		//ConsoleView.afficherEquipes(tournoi.getListeEquipes());
		
		ConsoleView.menu(tournoi, tournoiType);		
		
		//ConsoleView.affichermenu();
				
		//InfoEquipes.modifierEquipes(listeEquipe);
		//ConsoleView.afficherEquipesEtJoueurs(listeEquipe);  
	 
      //ConsoleView.afficherEquipesEtJoueurs(listeEquipe);
	}




}
