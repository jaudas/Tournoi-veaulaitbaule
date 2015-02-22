package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import model.Equipe;
import model.Joueur;
import model.Match;
import model.Poule;
import model.Tournoi;
import model.TournoiParPoules;
import controleur.Exception;
import controleur.InfoEquipes;
import controleur.InfoMatch;
import controleur.Randomator;

public class ConsoleView {
	static Scanner sc = new Scanner(System.in);
	static final int EXITMENU = 5;

	// Constantes pour les phases d'un tournoi
	final static int PHASEPOULE = 0;
	final static int FINALE = 1;
	final static int DEMIFINALE = 2;
	final static int QUARTDEFINALE = 3;
	final static int HUITIEMEDEFINALE = 4;
	final static int SEIZIEMEDEFINALE = 5;
	final static int TRENTEDEUXIEMEDEFINALE = 6;

	public static void accueil() {
		System.out
		.println("Bonjour ! Bienvenue dans le logiciel de gestion de tournoi de volley-ball.\n"
				+ "Ce programme vous permet de :"
				+ "\n- saisir les équipes, joueurs et scores de votre tournoi de volley-ball "
				+ "\n- gérer un tournoi par éliminations directes ou par phases de poules "
				+ "\n- générer un tounoi avec des équipes aléatoires."
				+ "\n C'est parti !\n");
	}

	public static int choixTournoi() {
		String CH;
		int choix=0;

		do{
			System.out
			.println("Souhaitez-vous un tournoi :\n- par éliminations directes (tapez 1)?\n- avec une phase de poules (tapez 2)?");
			CH=sc.nextLine();
			choix = Exception.mauvaisNumero(CH);
			if ((choix != 1)&&(choix != 2)){
				System.out.println("Saisie incorrecte !");
			}
		}while ((choix != 1)&&(choix != 2));

		return choix;

	}

	public static void afficherEquipesEtJoueurs(LinkedList<Equipe> listeEquipe) {
		System.out
		.println("-- Voici les équipes du tournoi et leurs joueurs : --");
		for (int i = 0; i < listeEquipe.size(); i++) {
			System.out.println("\n" + listeEquipe.get(i));
			afficherJoueurs(i - 1, listeEquipe.get(i).getListeJoueurs());
		}
	}

	public static void afficherEquipes(Tournoi tournoi, int type) {
		System.out.println("-- Equipes du tournoi : -- : ");
		if (type == 1) {
			System.out.println(tournoi.getListeEquipes().size());
			for (int i = 0; i < tournoi.getListeEquipes().size(); i++) {
				System.out.println(tournoi.getListeEquipes().get(i).toString());
			}
		} else if (type == 2) {
			afficherPoules((TournoiParPoules) tournoi);
		}
	}

	public static void afficherJoueurs(int idEquipe,
			LinkedList<Joueur> listeJoueurs) {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			int nbJoueur = i + 1;
			System.out.println(nbJoueur + ". " + listeJoueurs.get(i));
		}
	}

	public static void afficherMatch(LinkedList<Match> listeMatch) {
		System.out.println("Liste des matchs : ");
		for (int i = 0; i < listeMatch.size(); i++) {
			System.out.println(listeMatch.get(i));
		}
	}

	// Afficher les poules et leurs équipes. Passer en paramètre la liste de
	// poules d'un objet de type TournoiParPoules
	public static void afficherPoules(TournoiParPoules tournoi) {
		System.out.println("\n-- Les poules du tournoi sont : --");

		ArrayList<Poule> listePoules = tournoi.getListePoules();

		for (int cptPoule = 0; cptPoule < listePoules.size(); cptPoule++) {
			Poule pouleAffichage = listePoules.get(cptPoule);
			System.out.println("-- " + pouleAffichage.getNom() + " --");
			for (int i = 0; i < pouleAffichage.getEquipesPoule().size(); i++) {
				System.out.println("Equipe " + (i + 1) + ": "
						+ pouleAffichage.getEquipesPoule().get(i).getNom());
			}
			System.out.println("\n");
		}
	}

	public static void afficherMatchsJoues(Tournoi tournoi) {
		System.out.println("\n---- Match Joués ----");

		LinkedList<Match> listeMatchs = tournoi.getListeMatchs();		
		int temp = 0;
		int i = 0;

		for (i = 0; i < listeMatchs.size(); i++) {
			if (listeMatchs.get(i).estJoue() == true) {
				if (temp != listeMatchs.get(i).getType()) {
					temp = listeMatchs.get(i).getType();
					ConsoleView.afficherCategorieMatch(temp);
					System.out.println("Match " + (i + 1) + " : "
							+ listeMatchs.get(i).toString());
				}				
				else if (temp == PHASEPOULE) {
					i = afficherMatchsJouesPoules((TournoiParPoules) tournoi);
					temp = 1;
				}
				else{
					System.out.println("Match " + (i + 1) + " : "
							+ listeMatchs.get(i).toString());
					temp = listeMatchs.get(i).getType();
				}
			}
		}

		if (temp == 0)
			System.out.println("Aucun match n'a été joué pour le moment :(");

	}

	public static int afficherMatchsJouesPoules(TournoiParPoules tPP){

		afficherCategorieMatch(0);
		int cptMatch=0;
		int cptPP = 0;

		for (int cptPoule = 0 ; cptPoule< tPP.getListePoules().size(); cptPoule ++){
			System.out.println("-- Poule "+(cptPoule+1)+" --");
			if (tPP.getListePoules().get(cptPoule).getEquipesPoule().size() == 1){
				System.out.println("Aucun match : une seule équipe dans cette poule.");
			}
			else {
				while ((cptPP <6)&&(cptMatch < tPP.getListeMatchs().size())&&(tPP.getListeMatchs().get(cptMatch).estJoue()==true)&&(tPP.getListeMatchs().get(cptMatch).getType() == 0)){
					System.out.println("Match "+(cptMatch+1)+" : "+tPP.getListeMatchs().get(cptMatch).toString());
					cptPP ++;
					cptMatch ++;
				}
				cptPP = 0;
			}
		}

		return cptMatch;

	}

	public static void afficherCategorieMatch(int ID) {
		if (ID == PHASEPOULE) 
			System.out.println("\n----- PHASE DE POULES ------");
		else if (ID == FINALE)
			System.out.println("\n----- FINALE -----");
		else if (ID == DEMIFINALE)
			System.out.println("\n----- DEMI-FINALE -----");
		else if (ID == QUARTDEFINALE)
			System.out.println("\n----- QUART DE FINALE -----");
		else if (ID == HUITIEMEDEFINALE)
			System.out.println("\n----- HUITIEME DE FINALE -----");
		else if (ID == SEIZIEMEDEFINALE)
			System.out.println("\n----- SEIZIEME DE FINALE -----");
		else if (ID == TRENTEDEUXIEMEDEFINALE)
			System.out.println("\n----- TRENTE DEUXIEME DE FINALE -----");
	}

	public static void menu(Tournoi tournoi, int type) {
		int choixMenu = 0;

		do {

			System.out.println("\n-- Menu principal --");
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1. Saisir les résultats d'un match");
			System.out.println("2. Afficher les résultats des matchs joués");
			System.out.println("3. Afficher/Modifier les équipes");
			System.out
			.println("4. Générer la suite du tournoi automatiquement");
			System.out.println("5. Exit");

			choixMenu = sc.nextInt();

			switch (choixMenu) {
			case 1:
				boolean fin = !afficherMatchNonJoues(tournoi);
				if (fin == false)
					InfoMatch.selectionnerMatch(tournoi.getListeMatchs());
				else 
					choixMenu = EXITMENU;
				break;

			case 2:
				afficherMatchsJoues(tournoi);
				break;

			case 3:
				afficherEquipes(tournoi, type);
				InfoEquipes.questionModif(tournoi);
				break;

			case 4:
				Randomator.finirtournoi(tournoi);
				choixMenu = EXITMENU;
				break;
			}

		} while (choixMenu != EXITMENU);
	}

	public static boolean afficherMatchNonJoues(Tournoi t) {
		//Indiquons si il y a des matchs à jouer
		boolean indic = InfoMatch.matchaJouer(t.getListeMatchs());


		//Si il n'y a pas de match à jouer
		if (indic == false)
		{
			// Si il faut creer le premier tour d'un tournoi par poules
			if (t.getListeToursEliminatoires().size() == 0) {
				System.out.println("Qualification des équipes");
				((TournoiParPoules) t).creerEqQualifiees();
				// On creer les rencontres en fonction des équipes du tour
				t.remplirTour();
			}

			// Si c'est un tour suivant
			else if (t.getListeToursEliminatoires().getLast().getListeEquipesTour().size() > 2) {
				t.nouveauTour();
				//On creer les rencontres en fonction des équipes du tour
				t.remplirTour();
			}
			indic = InfoMatch.matchaJouer(t.getListeMatchs());
		}

		//Si on a pu générer une liste de matchs
		if (indic == true)
		{
			ListIterator<Match> li = t.getListeMatchs().listIterator();
			Match matchTemp;
			System.out.println("-- Liste des matchs à jouer --");
			while (li.hasNext()) {
				matchTemp = li.next();
				if (matchTemp.estJoue() == false) {
					System.out.println("Match " + li.nextIndex() + " : "
							+ matchTemp.toString());
				}

			}
		}
		//Si on a pas pu générer de matchs
		else {
			System.out.println("Nombre d'équipe(s) dans le dernier tour : "
					+ t.getListeToursEliminatoires().getLast()
					.getListeEquipesTour().size());
			System.out.println("Le tournoi est fini ! ");
		}
		return indic;
	}


	public static void affichagefin(Tournoi t) {
		System.out
		.println("Le Tournoi est terminé ! Voici la liste des matchs joués au cours du Tournoi : ");
		afficherMatch(t.getListeMatchs());

		System.out.println("Voici des statistiques sur les équipes : ");
		afficherStatEquipes(t);

	}

	public static void afficherResultatPoules(TournoiParPoules tPP) {
		for (int cptPoule = 0; cptPoule< tPP.getListePoules().size(); cptPoule++){
			System.out.println("-- Poule "+(cptPoule+1)+" --");
			System.out.println(" Classement |        Equipe        | Points | Victoires | Sets Gagnés |  Goal Average ");
			for (int cptEq = 0; cptEq <tPP.getListePoules().get(cptPoule).getEquipesPoule().size(); cptEq ++){
				Equipe eqTemp = tPP.getListePoules().get(cptPoule).getEquipesPoule().get(cptEq);
				System.out.print("      "+(cptEq+1)+"             "+eqTemp.getNom()+"\t\t"+eqTemp.getScore()+"          "+eqTemp.getNbVictoire()+"          "
						+eqTemp.getNbSetGagne()+ "            " + eqTemp.calculGoalAverage() + "            ") ;
				if ((cptEq == 0)||(cptEq == 1))	{	
					System.out.print("Qualifiée\n");
				}
				else{
					System.out.print(" \n");
				}
			}
		}
	}

	public static void afficherStatEquipes(Tournoi t) {
		System.out.println("     Equipe          | Joués | Victoires | Sets Gagnés |  Goal Average ");
		LinkedList<Equipe> eqTriees = t.getListeEquipes();
		Collections.sort(eqTriees);

		for (int cptEq = 0; cptEq <t.getListeEquipes().size(); cptEq ++){
			Equipe eqTemp = eqTriees.get(cptEq);
			System.out.print((cptEq+1)+"     "+eqTemp.getNom()+"\t\t "+eqTemp.getNbMatchJoue()+"\t  "+eqTemp.getNbVictoire()+"           "
					+eqTemp.getNbSetGagne()+ "              " + eqTemp.calculGoalAverage() + "\n") ;
		}
	}
}