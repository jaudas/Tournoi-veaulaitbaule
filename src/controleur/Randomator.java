package controleur;

import java.util.LinkedList;
import java.util.ListIterator;

import view.ConsoleView;
import model.*;

public class Randomator {
	//Classe fournissant une liste de fonction permettant de générer la fin du tournoi de façon aléatoire

	public static void finirtournoi(Tournoi tAleatoire)
	{
		//On complete les matchs non joués de la liste 
		tirageMatchsGeneres(tAleatoire.getListeMatchs());
		
		if (tAleatoire instanceof TournoiParPoules)
		{
			((TournoiParPoules)tAleatoire).creerEqQualifiees();
			
			
		}
		
		System.out.println("test while : "+tAleatoire.getListeToursEliminatoires().getLast().getListeEquipesTour().size());

		//Tant qu'il y a plus d'une équipe en jeu 
		// = tant que le dernier tour de la liste de tours a plus de 1 équipe
		while (tAleatoire.getListeToursEliminatoires().getLast().getListeEquipesTour().size() >= 2)
		{
			System.out.println("Nouveau tour ! ");
			//tAleatoire.nouveauTour();
			tAleatoire.remplirTour();
			tirageMatchsGeneres(tAleatoire.getListeMatchs());
			ConsoleView.afficherMatchsJoues(tAleatoire.getListeMatchs());
			tAleatoire.nouveauTour();
		}
		
		System.out.println("Tournoi fini ! ");
		Equipe gagnant = tAleatoire.getListeMatchs().getLast().getGagnant();
		System.out.println("Gagnant : " + gagnant);
		

	}
	
	public static void tirageMatchsGeneres(LinkedList<Match> listeMatchTournoi)
	{
		ListIterator<Match> liMatch = listeMatchTournoi.listIterator();
		Match matchTemp;

		while(liMatch.hasNext()){
			matchTemp = liMatch.next();
			if (matchTemp.estJoue() == false){
				//System.out.println("Match généré ! ");
				matchTemp.setScoreAleatoire();
				liMatch.set(matchTemp);
				System.out.println(matchTemp.toString());
			}
		}
	}
	
}
