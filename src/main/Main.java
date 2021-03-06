package main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import model.Equipe;
import model.SaveList;

import model.Tournoi;
import model.TournoiEliminationDirecte;
import model.TournoiParPoules;
import view.ConsoleView;
import controleur.InfoEquipes;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {

		

		ConsoleView.accueil(); 

		//Initialisation du tournoi
		//Demande du type de tournoi
		int tournoiType = ConsoleView.choixTournoi();
		Tournoi tournoi = new Tournoi();

		//Demande le nombre d'�quipes dans le tournoi
		LinkedList<Equipe> listeEquipes=InfoEquipes.inscrireEquipes();
		ConsoleView.afficherEquipesEtJoueurs(listeEquipes);	
		SaveList.save("Tournoi 1", listeEquipes);
		//Si c'est un tournoi par �lminitation directe
		if (tournoiType == 1)
		{
			tournoi = new TournoiEliminationDirecte(listeEquipes);
		}
		//Tournoi par poules
		if (tournoiType == 2)
		{
			tournoi = new TournoiParPoules(listeEquipes);
			ConsoleView.afficherPoules((TournoiParPoules)tournoi);
		}

		ConsoleView.afficherMatch(tournoi.getListeMatchs());

		ConsoleView.menu(tournoi, tournoiType);		

		ConsoleView.affichagefin(tournoi);
	}

}
