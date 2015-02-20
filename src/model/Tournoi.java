package model;

import java.util.Iterator;
import java.util.LinkedList;

public class Tournoi {
	// Attributs
	protected int nbEquipesInit;
	protected String description;
	protected LinkedList<Equipe> listeEquipes;
	protected LinkedList<TourEliminatoire> listeToursEliminatoires = new LinkedList<TourEliminatoire>();
	protected LinkedList<Match> listeMatchs = new LinkedList<Match>();

	// Get & Set
	public int getNbEquipesInit() {
		return nbEquipesInit;
	}

	public void setNbEquipesInit(int nbEquipesInit) {
		this.nbEquipesInit = nbEquipesInit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LinkedList<Equipe> getListeEquipes() {
		return this.listeEquipes;
	}

	public LinkedList<Match> getListeMatchs() {
		return this.listeMatchs;
	}

	public void setListeEquipes(LinkedList<Equipe> listeEquipes) {
		this.listeEquipes = listeEquipes;
	}

	public LinkedList<TourEliminatoire> getListeToursEliminatoires() {
		return this.listeToursEliminatoires;
	}

	public void addMatch(Match m) {
		listeMatchs.add(m);
	}

	// Methodes
	public String toString() {
		String str = ("Le tournoi se compose de " + nbEquipesInit + " équipes. Les équipes encore en jeu sont les suivantes : ");

		Iterator<Equipe> iter = listeEquipes.iterator();
		while (iter.hasNext()) {
			str = str + iter.next().getNom() + " ";
		}
		return str;
	}

	public void ajouterEquipe(Equipe e) {
		listeEquipes.add(e);
	}

	public void creerPoules() {
		// TODO Auto-generated method stub
	}

	public void creerEqQualifiees() {
		// TODO Auto-generated method stub

	}

	public void remplirTour() {
		TourEliminatoire tour = this.listeToursEliminatoires.getLast();
		System.out.println("From Tournoi.remplirTour : Tour modifié avec "+tour.getListeMatchsTour().size()+" matchs, soit "+tour.getListeEquipesTour()+"équipes.");
	
		tour.setQualifOffice();
		int qualif = tour.getQualifOffice();
		// Le nombre de matchs correspond au nombre de paire(s) d'équipes
		int nbmatchs = (int) tour.getListeEquipesTour().size() / 2;

		System.out.println("Il y aura " + nbmatchs + " matchs dans ce tour : ");
		int j = 0;

		for (int i = 0; i < nbmatchs; i++) {
			Equipe e1, e2;

			// Verification de l'équipe 1
			if (j == qualif) {

				// Si l'équipe est qualifiée d'office, on prend le suivant
				j++;
			}
			e1 = tour.getListeEquipesTour().get(j);

			// On passe à l'équipe d'après dans la liste des équipes
			j++;

			// Vérification equipe 2
			if (j == qualif) {
				// Si l'équipe est qualifiée d'office, on prend le suivant
				j++;
			}
			e2 = tour.getListeEquipesTour().get(j);
			System.out.println("Phase du match :"
					+ tour.trouverPhaseTour(tour.getListeEquipesTour().size()));
			Match rencontre = new Match(e1, e2, tour.trouverPhaseTour(tour
					.getListeEquipesTour().size()));
			System.out.println(" >>> " + rencontre.toString() + " <<< ");
			tour.getListeMatchsTour().add(rencontre);
			this.addMatch(rencontre);
			j++;

		}
		
		System.out.println("From Tournoi.nouveauTour : Nouveau tour créé avec "+tour.getListeMatchsTour().size()+" matchs, soit "+tour.getListeEquipesTour().size()+"équipes.");


	}

	public void nouveauTour()
	{
		LinkedList<Equipe> Equipequalif = this.listeToursEliminatoires.getLast().equipesQualifiees();
		TourEliminatoire nouveauTour = new TourEliminatoire(Equipequalif);
		this.listeToursEliminatoires.add(nouveauTour);
		System.out.println("From Tournoi.nouveauTour : Nouveau tour créé avec "+nouveauTour.getListeMatchsTour().size()+" matchs, soit "+nouveauTour.getListeEquipesTour()+"équipes.");
	}

}
