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
		System.out.println("Souhaitez-vous un tournoi :\n- par �liminations directes (tapez 1)?\n- avec une phase de poules (tapez 2)?");
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
		System.out.println("Affichage des �quipes : ");
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
				+ "\n- saisir les �quipes, joueurs et scores de votre tournoi de volley-ball "
				+ "\n- g�rer un tournoi par �liminations directes ou par phases de poules "
				+ "\n- g�n�rer un tounoi avec des �quipes al�atoires."
				+ "\n C'est parti !\n"); 
	}
	
	//Afficher les poules et leurs �quipes. Passer en param�tre la liste de poules d'un objet de type TournoiParPoules
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
		System.out.println("From ConsoleView.afficherMatchsJou�s");
		System.out.println("-- Match Jou�s --");	
		
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
			System.out.println("Aucun match n'a �t� jou� pour le moment :(");

	}
	
	public static void afficherCategorieMatch(int ID)
	{
		if (ID>0 && ID<10)
		{
			System.out.println("----- Matchs jou�s dans la Poule "+ID+" -----");
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
		
		else System.out.println("Cat�gorie de Match imcomprise :(");
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
			System.out.println("1. Modifier les �quipes");
			System.out.println("2. Afficher les r�sultats des matchs");
			System.out.println("3. Afficher toutes les �quipes");
			System.out.println("4. Saisir des r�sultats d'un match");
			System.out.println("5. Exit");

			choixMenu=sc.nextInt();

			switch(choixMenu){
			case 1 : 
				InfoEquipes.modifierEquipes(tournoi.getListeEquipes());
				System.out.println("Liste des �quipes modifi�e ! ");
				break;

			case 2 : 
				afficherMatchsJoues(tournoi.getListeMatchs());
				break;

			case 3 : 
				afficherEquipes(tournoi.getListeEquipes());
				break;

			case 4 : 
				System.out.println("Permettre la saisie des r�sultats d'un match, si il y en a plusieurs (dans InfoMatch)");
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

		System.out.println("Liste des matchs � jouer ! ");
		while(li.hasNext()){
			matchTemp = li.next();
			if (matchTemp.estJoue() == false){
			System.out.println(matchTemp.toString());
			}
		}
	}

}
