package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import controleur.InfoEquipes;
import model.*;



public class ConsoleView {
	static Scanner sc = new Scanner(System.in);
	static final int EXITMENU = 5;

	public static int choixTournoi()
	{
		int choix;
		System.out.println("Souhaitez-vous un tournoi :\n- par éliminations directes (tapez 1)?\n- avec une phase de poules (tapez 2)?");
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
		System.out.println("Bonjour ! Bienvenue dans le logiciel de gestion de tournoi de volley-ball.\n"
				+ "Ce programme vous permet de :"
				+ "\n- saisir les équipes, joueurs et scores de votre tournoi de volley-ball "
				+ "\n- gérer un tournoi par éliminations directes ou par phases de poules "
				+ "\n- générer un tounoi avec des équipes aléatoires."
				+ "\n C'est parti !\n"); 
	}
	
	//Afficher les poules et leurs équipes. Passer en paramètre la liste de poules d'un objet de type TournoiParPoules
	public static void afficherPoules(TournoiParPoules tournoi) {
		System.out.println("Les poules du tournoi sont :");
		
		ArrayList<Poule> listePoules = tournoi.getListePoules();
		
		for (int cptPoule = 0; cptPoule < listePoules.size(); cptPoule ++){
			Poule pouleAffichage = listePoules.get(cptPoule);
			System.out.println("-- "+pouleAffichage.getNom()+" --");
			for (int i = 0; i < pouleAffichage.getEquipesPoule().size(); i++) {
				System.out.println("Equipe " + (i+1) + ": "+ pouleAffichage.getEquipesPoule().get(i).getNom());
			}
		}
	}

	
	public static void afficherMatchsJoues(LinkedList<Match> listeMatchs)
	{
		System.out.println("From ConsoleView.afficherMatchsJoués");
		System.out.println("-- Match Joués --");	
		
		for (int i = 0; i <listeMatchs.size(); i++){
			if (listeMatchs.get(i).estJoue() == true){				
				System.out.println("Match "+i+" : "+listeMatchs.get(i).toString());
			}
		}
		
	}

	public static void afficherEquipesEnJeu()
	{
		System.out.println("From ConsoleView.afficherEquipesEnJeu");
		
	}

	public static void menu(Tournoi tournoi)
	{
		int choixMenu = 0;

		do{
			System.out.println("\n-- Menu principal --");
			System.out.println("1. Modifier les équipes");
			System.out.println("2. Afficher les résultats des matchs");
			System.out.println("3. Afficher toutes les équipes");
			System.out.println("4. Saisir des résultats d'un match");
			System.out.println("5. Exit");

			choixMenu=sc.nextInt();

			switch(choixMenu){
			case 1 : 
				InfoEquipes.modifierEquipes(tournoi.getListeEquipes());
				System.out.println("Liste des équipes modifiée ! ");
				break;

			case 2 : 
				System.out.println("Afficher les résultats des derniers matchs : A faire ! ");
				afficherMatchsJoues(tournoi.getListeMatchs());
				break;

			case 3 : 
				afficherEquipes(tournoi.getListeEquipes());
				break;

			case 4 : 
				System.out.println("Permettre la saisie des résultats d'un match, si il y en a plusieurs (dans InfoMatch)");
				afficherMatchNonJoues(tournoi);
				break;

			}

		}
		while (choixMenu != EXITMENU); 
	}

	public static void afficherMatchNonJoues(Tournoi t)
	{	
		ListIterator<Match> li = t.getListeMatchs().listIterator();	
		Match matchTemp;

		System.out.println("Liste des matchs à jouer ! ");
		while(li.hasNext()){
			matchTemp = li.next();
			if (matchTemp.estJoue() == false){
			System.out.println(matchTemp.toString());
			}
		}
	}

}
