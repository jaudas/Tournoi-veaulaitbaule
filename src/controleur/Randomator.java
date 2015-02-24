package controleur;

import java.util.LinkedList;
import java.util.ListIterator;

import model.Equipe;
import model.Match;
import model.Tournoi;
import model.TournoiParPoules;
import view.ConsoleView;

public class Randomator {
	// Classe fournissant une liste de fonction permettant de générer la fin du tournoi de façon aléatoire

	public static void finirtournoi(Tournoi tAleatoire) {
		//Verification du nombre d'équipes
		if (tAleatoire.getListeEquipes().size() > 1) {
			// On complete les matchs non joués de la liste de match
			tirageMatchsGeneres(tAleatoire.getListeMatchs());

			//Si c'est un tournoi par poules
			if (tAleatoire instanceof TournoiParPoules) {
				((TournoiParPoules) tAleatoire).creerEqQualifiees();
				ConsoleView.afficherResultatPoules((TournoiParPoules) tAleatoire);
			} 
			
			else {
				tAleatoire.nouveauTour();
			}

			// Tant qu'il y a plus d'une équipe en jeu
			// = tant que le dernier tour de la liste de tours a plus de 1
			// équipe
			while (tAleatoire.getListeToursEliminatoires().getLast()
					.getListeEquipesTour().size() >= 2) {
				tAleatoire.remplirTour();
				tirageMatchsGeneres(tAleatoire.getListeMatchs());
				tAleatoire.nouveauTour();
			}
			
			System.out.println("Tournoi fini ! Récapiltulatif des matchs : ");
			ConsoleView.afficherMatchsJoues(tAleatoire);
			Equipe gagnant = tAleatoire.getListeMatchs().getLast().getGagnant();
			System.out.println("Gagnant : " + gagnant);
		} else
			System.out.println("Gagnant : "
					+ tAleatoire.getListeEquipes().getFirst());

	}

	public static void tirageMatchsGeneres(LinkedList<Match> listeMatchTournoi) {
		ListIterator<Match> liMatch = listeMatchTournoi.listIterator();
		Match matchTemp;
		System.out.println("Tirage au sort des matchs : ");

		while (liMatch.hasNext()) {
			matchTemp = liMatch.next();
			if (matchTemp.estJoue() == false) {
				// System.out.println("Match généré ! ");
				matchTemp.setScoreAleatoire();
				liMatch.set(matchTemp);
				System.out.println(matchTemp.toString());
			}
		}
	}

}
