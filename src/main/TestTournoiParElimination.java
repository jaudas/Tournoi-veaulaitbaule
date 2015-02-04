package main;

import java.util.LinkedList;

import model.*;

public class TestTournoiParElimination {

	public static void main(String[] args) {
		
		//Creation d'un tournoi
		System.out.println("Création du tournoi par elimination directe ! ");
		TournoiEliminationDirecte tournoi = new TournoiEliminationDirecte();
		
		
		//Creation liste equipes 
		System.out.println("Création de la liste des équipes ! ");
		LinkedList<Equipe> liste = new LinkedList<Equipe>();
		Equipe e1= new Equipe("Equipe 1");
		liste.add(e1);
		Equipe e2= new Equipe("Equipe 2");
		liste.add(e2);
		Equipe e3= new Equipe("Equipe 3");
		liste.add(e3);
		Equipe e4= new Equipe("Equipe 4");
		liste.add(e4);
		Equipe e5= new Equipe("Equipe 4");
		liste.add(e5);
		
		tournoi.setListeEquipes(liste);
		
		tournoi.deroulementTournoi();
		
		
		

	}

}
