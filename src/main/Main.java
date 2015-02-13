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
		LinkedList<Equipe> listeEquipes=InfoEquipes.inscrireEquipes();
		ConsoleView.afficherEquipesEtJoueurs(listeEquipes);
		
		System.out.println("Modifier les équipes ? 1. Oui 2.Non");
		int modification = 0;
		modification = sc.nextInt();
		if(modification == 1)
		{
			InfoEquipes.modifierEquipes(listeEquipes);
		}
		
		System.out.println("LISTE DES EQUIPES ETABLIE ! Vous ne pourrez plus ajouter/supprimer d'équipes. " );
		
		int tournoiType = ConsoleView.choixTournoi();
		Tournoi tournoi = new Tournoi();
		
		if (tournoiType == 1)
		{
			tournoi = new TournoiEliminationDirecte(listeEquipes);
			System.out.println("Tournoi par élimination ! ");
		}
		if (tournoiType == 2)
		{
			tournoi = new TournoiParPoules(listeEquipes);
			tournoi.creerPoules(tournoi.getListeEquipes());
			System.out.println("Tournoi par poules ! ");
		}

		System.out.println("taille de la liste : "+tournoi.getListeEquipes().size());
		ConsoleView.afficherEquipes(tournoi.getListeEquipes());
		ConsoleView.menu(tournoi);
		
		
		
		
		//ConsoleView.affichermenu();
				
		//InfoEquipes.modifierEquipes(listeEquipe);
		//ConsoleView.afficherEquipesEtJoueurs(listeEquipe);
		
		  
	 
      
      //ConsoleView.afficherEquipesEtJoueurs(listeEquipe);
	}



}
