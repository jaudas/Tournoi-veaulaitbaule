package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import controleur.InfoEquipes;
import controleur.InfoMatch;
import controleur.Randomator;
import model.*;

public class ConsoleView {
	static Scanner sc = new Scanner(System.in);
	static final int EXITMENU = 6;
	
	public static void accueil() {
		System.out.println("Bonjour ! Bienvenue dans le logiciel de gestion de tournoi de volley-ball.\n"
				+ "Ce programme vous permet de :"
				+ "\n- saisir les équipes, joueurs et scores de votre tournoi de volley-ball "
				+ "\n- gérer un tournoi par éliminations directes ou par phases de poules "
				+ "\n- générer un tounoi avec des équipes aléatoires."
				+ "\n C'est parti !\n"); 
	}

	public static int choixTournoi()
	{
		int choix;
		System.out.println("Souhaitez-vous un tournoi :\n- par éliminations directes (tapez 1)?\n- avec une phase de poules (tapez 2)?");
		//Ajouter exception et controle de la saisie
		choix=sc.nextInt();
		return choix;
	}


	public static void afficherEquipesEtJoueurs(LinkedList<Equipe> listeEquipe){  
		System.out.println("-- Voici les équipes du tournoi et leurs joueurs : --");
		for(int i = 0; i< listeEquipe.size(); i++){
			System.out.println(listeEquipe.get(i));
			afficherJoueurs(i-1, listeEquipe.get(i).getListeJoueurs());
		}
	}
	
	public static void afficherEquipes(Tournoi tournoi, int type){     
		System.out.println("-- Equipes du tournoi : -- : ");
		if (type == 1){
			System.out.println(tournoi.getListeEquipes().size());
			for(int i = 0; i< tournoi.getListeEquipes().size(); i++){
				System.out.println(tournoi.getListeEquipes().get(i).toString());				
			}
		}
		else if (type == 2){
			afficherPoules((TournoiParPoules)tournoi);
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
	
	//Afficher les poules et leurs équipes. Passer en paramètre la liste de poules d'un objet de type TournoiParPoules
	public static void afficherPoules(TournoiParPoules tournoi) {
		System.out.println("\n-- Les poules du tournoi sont : --");
		
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
		System.out.println("\n---- Match Joués ----");	
		
		int temp = 0;
		int i=0;
		
		for (i = 0; i <listeMatchs.size(); i++){
			if (listeMatchs.get(i).estJoue() == true){		
				
				if (temp!=listeMatchs.get(i).getType())
				{
					temp=listeMatchs.get(i).getType();
					ConsoleView.afficherCategorieMatch(temp);
				}
				
				System.out.println("Match "+i+" : "+listeMatchs.get(i).toString());
			}
		}
		
		if (temp==0)
			System.out.println("Aucun match n'a été joué pour le moment :(");

	}
	
	public static void afficherCategorieMatch(int ID)
	{
		if (ID>0 && ID<10)
		{
			System.out.println("-- Matchs joués dans la Poule "+ID+" --");
		}
		
		if (ID==-1)
			System.out.println("----- FINALE -----");
		if (ID==-2)
			System.out.println("----- DEMI-FINALE -----");
		if (ID==-3)
			System.out.println("----- QUART DE FINALE -----");
		if (ID==-4)
			System.out.println("----- HUITIEME DE FINALE -----");
		if (ID==-5)
			System.out.println("----- SEIXIEME DE FINALE -----");
		if (ID==-6)
			System.out.println("----- TRENTE DEUXIEME DE FINALE -----");
		
		else System.out.println("Catégorie de Match imcomprise :(");
	}

	public static void afficherEquipesEnJeu()
	{
		System.out.println("From ConsoleView.afficherEquipesEnJeu");
		
	}


	public static void menu(Tournoi tournoi, int type)
	{
		int choixMenu = 0;

		do{
			
			System.out.println("\n-- Menu principal --");
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1. Modifier les équipes");
			System.out.println("2. Afficher les résultats des matchs");
			System.out.println("3. Afficher/Modifier les équipes");
			System.out.println("4. Saisir les résultats d'un match");
			System.out.println("5. Générer la suite du tournoi automatiquement");
			System.out.println("6. Exit");

			choixMenu=sc.nextInt();

			switch(choixMenu){
			case 1 : 
				InfoEquipes.modifierEquipes(tournoi.getListeEquipes());
				System.out.println("Liste des équipes modifiée ! ");
				break;

			case 2 : 
				afficherMatchsJoues(tournoi.getListeMatchs());
				break;

			case 3 : 
				afficherEquipes(tournoi, type);
				InfoEquipes.questionModif(tournoi);
				break;

			case 4 : 
				afficherMatchNonJoues(tournoi);
				InfoMatch.selectionnerMatch(tournoi.getListeMatchs());
				break;
				
			case 5 : 
				System.out.println("From consoleView : creer les fonctionnalités dans le randomator");
				Randomator.finirtournoi(tournoi);
				break;

			}

		}
		while (choixMenu != EXITMENU); 
	}

	public static void afficherMatchNonJoues(Tournoi t)
	{	
		ListIterator<Match> li = t.getListeMatchs().listIterator();	
		Match matchTemp;
		int i = 1;

		System.out.println("-- Liste des matchs à jouer: --");
		while(li.hasNext()){
			matchTemp = li.next();
			if (matchTemp.estJoue() == false){
			System.out.println("Match "+i+" : "+matchTemp.toString());
			i ++;
			}
			
		}
		
		if (i==1 && t.getListeToursEliminatoires().getLast().getListeEquipesTour().size() < 2)
		{
			t.creerTour();
		}
		
		else 
			System.out.println("Le tournoi est fini ! ");
	}
}