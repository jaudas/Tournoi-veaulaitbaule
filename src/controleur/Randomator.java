package controleur;

import java.util.LinkedList;
import java.util.ListIterator;

import view.ConsoleView;
import model.*;

public class Randomator {
	//Classe fournissant une liste de fonction permettant de g�n�rer la fin du tournoi de fa�on al�atoire

	public static void finirtournoi(Tournoi tAleatoire)
	{
		//On complete les matchs non jou�s de la liste 
		tirageMatchsGeneres(tAleatoire.getListeMatchs());
		tAleatoire.creerTour();
		ConsoleView.afficherMatchsJoues(tAleatoire.getListeMatchs());
	}
	
	public static void tirageMatchsGeneres(LinkedList<Match> listeMatchTournoi)
	{
		ListIterator<Match> liMatch = listeMatchTournoi.listIterator();
		Match matchTemp;

		while(liMatch.hasNext()){
			matchTemp = liMatch.next();
			if (matchTemp.estJoue() == false){
				System.out.println("Match g�n�r� ! ");
				matchTemp.setScoreAleatoire();
				liMatch.set(matchTemp);
			}
		}
	}
}
