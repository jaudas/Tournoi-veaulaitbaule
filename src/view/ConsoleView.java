package view;

import java.util.LinkedList;
import java.util.Scanner;

import controleur.InfoEquipes;
import model.*;



public class ConsoleView {
	static Scanner sc = new Scanner(System.in);
	static final int EXITMENU = 6;

	public static int choixTournoi()
	{
		int choix;
		System.out.println("From ConsoleView.choixTournoi : Texte de choix du tournoi. \n 1 = elimination directe, 2 = par poules ");
		//Ajouter exception et controle de la saisie
		choix=sc.nextInt();
		return choix;
	}



	public static void afficherEquipesEtJoueurs(LinkedList<Equipe> listeEquipe){      
		for(int i = 0; i< listeEquipe.size(); i++){
			System.out.println(listeEquipe.get(i));
			afficherJoueurs(i-1, listeEquipe.get(i).getListeJoueurs());
		}
	}
	public static void afficherEquipes(LinkedList<Equipe> listeEquipe){     
		System.out.println("Affichage des équipes : ");
		System.out.println(listeEquipe.size());
		for(int i = 0; i< listeEquipe.size(); i++){
			System.out.println(listeEquipe.get(i));

		}
	}
	public static void afficherJoueurs(int idEquipe,LinkedList<Joueur> listeJoueurs){      
		for(int i = 0; i< listeJoueurs.size(); i++){
			int nbJoueur=i+1;
			System.out.println(nbJoueur+". " + listeJoueurs.get(i)); 
		}
	}
	public static void afficherMatch(LinkedList<Match> listeMatch){      
		for(int i = 0; i< listeMatch.size(); i++){
			System.out.println(listeMatch.get(i)); 
		}
	}

	public static void accueil() {
		System.out.println(" From ConsoleView.accueil : Texte d'accueil à modifier !");

	}

	public static void afficherPoules() {
		System.out.println(" From ConsoleView.afficherPoules : Afficher le numero de la poule et la liste des équipes qui y sont.");

	}
	
	public static void afficherMatchsJoues()
	{
		System.out.println("From ConsoleView.afficherMatchsJoués");
	}
	
	public static void afficherEquipesEnJeu()
	{
		System.out.println("From ConsoleView.afficherEquipesEnJeu");
	}

	public static void menu(Tournoi tournoi)
	{
		int choixMenu = 0;

		do{
			System.out.println("From ConsoleView.menu : Menu principal :");
			System.out.println("1. Modifier les équipes");
			System.out.println("2. Afficher les résultats des matchs");
			System.out.println("3. Afficher les équipes en jeu");
			System.out.println("4. Afficher toutes les équipes");
			System.out.println("5. Saisir des résultats d'un match");
			System.out.println("6. Exit");

			choixMenu=sc.nextInt();

			switch(choixMenu){
			case 1 : 
				InfoEquipes.modifierEquipes(tournoi.getListeEquipes());
				System.out.println("Liste des équipes modifiée ! ");
				break;
				
			case 2 : 
				System.out.println("Afficher les résultats des derniers matchs : A faire ! ");
				afficherMatchsJoues();
				break;
				
			case 3 : 
				System.out.println("Afficher les équipes en jeu : A faire ! ");
				afficherEquipesEnJeu();
				break;

			case 4 : 
				afficherEquipes(tournoi.getListeEquipes());
				break;
				
			case 5 : 
				System.out.println("Afficher la liste des matchs à jouer = ceux qui sont dans la liste de matchs et qui ont 0-0 comme score (dans ConsoleView)") ; 
				System.out.println("Permettre la saisie des résultats d'un match, si il y en a plusieurs (dans InfoMatch)");
				break;

			}

		}
		while (choixMenu != EXITMENU); 
	}

}
