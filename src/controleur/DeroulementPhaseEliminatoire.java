package controleur;

import java.util.LinkedList;

import model.Equipe;
import model.TourEliminatoire;
import model.Tournoi;
import model.TournoiParPoules;

public class DeroulementPhaseEliminatoire {
	
	public static void deroulementAleatoire(Tournoi t) {
		LinkedList<Equipe> listEqEnJeu = t.getListeEquipes();
		
		
		
		TourEliminatoire tourJeu;
		int compteurtour = 0;

		while (listEqEnJeu.size() != 1) // Tant qu'il y a plus d'une �quipe en
										// jeu, alors on effectue un tournoi
		{

			// Creation d'un tour
			tourJeu = new TourEliminatoire(listEqEnJeu);
			compteurtour++;
			System.out.println("\nLancement du tour " + compteurtour);
			System.out.println("Liste des �quipes du tour : ");
			for (int i = 0; i < tourJeu.getListeEquipesTour().size(); i++) {
				System.out.println(i + "=>"
						+ tourJeu.getListeEquipesTour().get(i));
			}

			// On d�finit le qualifi� d'office si il existe
			tourJeu.setQualifOffice();

			// On cree le tour de jeu
			System.out.println("C'est parti pour la cr�ation des matchs ! ");
			tourJeu.creerTour(t);
			System.out.println("Matchs g�n�r�s ! ");

			// On mets � jour la liste des �quipes en jeu
			listEqEnJeu = tourJeu.equipesQualifiees();
			System.out.println("\nFin du tour " + compteurtour);

		}
		System.out.println("Le super gagnant est : " + listEqEnJeu.getFirst());

	}
	public static void deroulementPhases(Tournoi t) {
		LinkedList<Equipe> listEqEnJeu = t.getListeEquipes();
		TourEliminatoire tourJeu;
		int compteurtour = 0;

		while (listEqEnJeu.size() != 1) // Tant qu'il y a plus d'une �quipe en
										// jeu, alors on effectue un tournoi
		{

			// Creation d'un tour
			tourJeu = new TourEliminatoire(listEqEnJeu);
			compteurtour++;
			System.out.println("\nLancement du tour " + compteurtour);
			System.out.println("Liste des �quipes du tour : ");
			for (int i = 0; i < tourJeu.getListeEquipesTour().size(); i++) {
				System.out.println(i + "=>"
						+ tourJeu.getListeEquipesTour().get(i));
			}

			// On d�finit le qualifi� d'office si il existe
			tourJeu.setQualifOffice();

			// On cree le tour de jeu
			System.out.println("C'est parti pour la cr�ation des matchs ! ");
			tourJeu.creerTour(t);
			System.out.println("Matchs g�n�r�s ! ");

			// On mets � jour la liste des �quipes en jeu
			listEqEnJeu = tourJeu.equipesQualifiees();
			System.out.println("\nFin du tour " + compteurtour);

		}
		System.out.println("Le super gagnant est : " + listEqEnJeu.getFirst());

	}

}
