package model;

import java.util.ArrayList;
import java.util.LinkedList;


public class TournoiParPoules extends Tournoi {
	int nbPoules;
	private ArrayList<Poule> listePoules = new ArrayList<Poule>();

	// Liste des équipes qualifiées

	// Constructeur
	public TournoiParPoules() {
		super();
	}

	public TournoiParPoules(LinkedList<Equipe> listeEq) {
		int nbeq = listeEq.size();
		super.listeEquipes = listeEq;

		// Calcul du nombre de poules necessaires
		int nbpoul = nbeq / 4;// Nb poules complètes

		if (nbeq % 4 != 0)// S'il reste des équipes
		{
			this.nbPoules = nbpoul + 1;
		} else {
			this.nbPoules = nbpoul;
		}
		// System.out.println("Le nombre de poules à créer est : " +
		// this.nbPoules);

		this.creerPoules();
	}

	// Méthodes
	@Override
	public String toString() {
		String str = super.toString()
				+ "Il est composé d'une phase de qualifications par poules de 4 équipes, puis d'une phase finale. \n Description : "
				+ super.description;
		return str;
	}

	// Créer les poules du tournoi
	public void creerPoules() {

		int cptPoules = this.nbPoules;
		int numPoule = 1;
		while (cptPoules > 0) {
			// On crée une liste vide d'équipes qui va être attribué à une poule
			ArrayList<Equipe> equipesPoule = new ArrayList<Equipe>();

			int ind = 0;

			while ((equipesPoule.size() < 4)
					&& (super.listeEquipes.isEmpty() == false)) {
				// Trouver une équipe au hasard dans la liste d'équipes
				ind = (int) ((Math.random()) * super.listeEquipes.size());

				// Ajouter l'équipe choisie dans une poule
				equipesPoule.add(super.listeEquipes.get(ind));

				// Suppression de l'équipe dans la liste des équipes du tournoi
				super.listeEquipes.remove(ind);
			}

			Poule poule = new Poule("Poule " + numPoule, equipesPoule, this,
					numPoule);
			if (poule != null) {
				listePoules.add(poule);
			}
			numPoule++;
			cptPoules--;
		}
		// On remplit de nouveau la liste des équipes du tournoi
		for (int cpt1 = 0; cpt1 < listePoules.size(); cpt1++) {
			for (int cpt2 = 0; cpt2 < listePoules.get(cpt1).getEquipesPoule()
					.size(); cpt2++) {
				super.listeEquipes.add(listePoules.get(cpt1).getEquipesPoule()
						.get(cpt2));
			}
		}
	}

	// Ordonner les équipes qualifiées pour les phases éliminatoires dans une
	// liste
	public void creerEqQualifiees() {
			
		this.classerEqPoules();
		LinkedList<Equipe> eqPhaseEliminatoire = new LinkedList<Equipe>();
		int ind = 0;
		// On ajoute la première équipe de la première poule
		eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule().get(0));

		while (ind < listePoules.size() - 1) {
			ind++;
			// On regarde s'il y a une deuxième équipe dans la poule suivante
			if (listePoules.get(ind).getEquipesPoule().size() > 1) {
				eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule()
						.get(1));
			}
			// On ajoute la première équipe de la poule suivante
			eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule()
					.get(0));
		}

		eqPhaseEliminatoire.add(listePoules.get(0).getEquipesPoule().get(1));

		TourEliminatoire tour1 = new TourEliminatoire(eqPhaseEliminatoire);
		this.listeToursEliminatoires.add(tour1);
	}

	public ArrayList<Poule> getListePoules() {
		return listePoules;
	}

	public void setListePoules(ArrayList<Poule> listePoules) {
		this.listePoules = listePoules;
	}

	// Classer chaque poule du tournoi
	public void classerEqPoules() {
		for (int ind = 0; ind < listePoules.size(); ind++) {
			listePoules.get(ind).classerEquipes();

		}
	}

}
