package controleur;

import java.util.LinkedList;

import model.*;

public class Randomator {
	static LinkedList<Equipe> equipes;

	//Tournoi avec des phases de poules dont les résultats sont automatiques
	public static void genererTournoiDebut(Tournoi t)
	{
		if(t instanceof TournoiParPoules)
		{
			System.out.println("Tournoi par poules");
			t = (TournoiParPoules) t;
			t.setListeEquipes(equipes);
			((TournoiParPoules) t).creerPoules(equipes);
			t.setEqPhaseEliminatoire(equipes);
			((TournoiParPoules)t).creerEqQualifiees();
			System.out.println("\n--------------------------------\n");
			System.out.println("Equipes qualifiées : ");
			for (int i = 0; i < ((TournoiParPoules)t).getEqPhaseEliminatoire().size(); i++) {
				System.out.println("Equipe "
						+ ((TournoiParPoules)t).getEqPhaseEliminatoire().get(i).getIdEquipe()
						+ ": " + ((TournoiParPoules)t).getEqPhaseEliminatoire().get(i).getNom());
			
			equipes = ((TournoiParPoules)t).getEqPhaseEliminatoire();
			}
			
			
		

		}
		else 
		{
			System.out.println("Tournoi pas élimination directe");
			equipes = t.getListeEquipes();
			
		}

		TourEliminatoire tourJeu;
		int compteurtour = 0;

		while (equipes.size() != 1) // Tant qu'il y a plus
			// d'une équipe en
			// jeu, alors on effectue un tournoi
		{

			// Creation d'un tour
			tourJeu = new TourEliminatoire(equipes);
			compteurtour++;
			System.out.println("\nLancement du tour " + compteurtour);
			System.out.println("Liste des équipes du tour : ");
			for (int i = 0; i < tourJeu.getListeEquipesTour().size(); i++) {
				System.out.println(i + "=>"
						+ tourJeu.getListeEquipesTour().get(i));
			}

			// On définit le qualifié d'office si il existe
			tourJeu.setQualifOffice();

			// On cree le tour de jeu
			System.out.println("C'est parti pour la création des matchs ! ");
			tourJeu.creerTour();
			System.out.println("Matchs générés ! ");

			// On mets à jour la liste des équipes en jeu
			t.setEqPhaseEliminatoire(tourJeu.equipesQualifiees());
			System.out.println("\nFin du tour " + compteurtour);

		}
		System.out.println("Le super gagnant est : "
				+ equipes.getFirst());

	}

	

}
