package model;

import java.util.LinkedList;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private int qualifOffice = -1;
	private LinkedList<Match> listeMatchTour = new LinkedList<Match>();

	// Constantes pour les phases d'un tournoi
	final static int PHASEPOULE = 0;
	final static int FINALE = 1;
	final static int DEMIFINALE = 2;
	final static int QUARTDEFINALE = 3;
	final static int HUITIEMEDEFINALE = 4;
	final static int SEIZIEMEDEFINALE = 5;
	final static int TRENTEDEUXIEMEDEFINALE = 6;

	public TourEliminatoire() {
		super();
	}

	public TourEliminatoire(LinkedList<Equipe> listeEq) {
		listeEquipesTour = listeEq;
	}

	public LinkedList<Equipe> getListeEquipesTour() {
		return listeEquipesTour;
	}

	public void setQualifOffice() {
		int indexEquipe = -1;

		// Indique la parité de la liste d'équipes
		int parite = this.listeEquipesTour.size() % 2;

		if (parite != 0) {
			indexEquipe = (int) (Math.random() * listeEquipesTour.size());
			System.out.println("L'équipe qualifiée d'office est : "
					+ listeEquipesTour.get(indexEquipe).getNom());
		}
		this.qualifOffice = indexEquipe;

	}

	public int trouverPhaseTour(int nbequipes) {
		if (nbequipes < 2)
			return -1;

		if (nbequipes == 2)
			return FINALE;

		if (nbequipes <= 4)
			return DEMIFINALE;

		if (nbequipes <= 8)
			return QUARTDEFINALE;

		if (nbequipes <= 16)
			return HUITIEMEDEFINALE;

		if (nbequipes <= 32)
			return SEIZIEMEDEFINALE;

		else
			return TRENTEDEUXIEMEDEFINALE;

	}

	public LinkedList<Equipe> equipesQualifiees() {
		LinkedList<Equipe> listeEqQualif = new LinkedList<Equipe>();

		// Si une equipe a ete qualifiée d'office, on l'ajoute à la liste des
		// équipes qualifiées
		if (this.qualifOffice != -1) {
			listeEqQualif.add(this.listeEquipesTour.get(qualifOffice));
		}

		// Pour chaque match, on ajoute le gagnant à la liste des équipes
		// qualifiées
		for (int i = 0; i < listeMatchTour.size(); i++) {
			listeEqQualif.add(listeMatchTour.get(i).getGagnant());
		}
	
		return listeEqQualif;
	}

	public int getQualifOffice() {
		return qualifOffice;
	}

	public LinkedList<Match> getListeMatchsTour() {
		return this.listeMatchTour;
	}

	public void setListeEquipes(LinkedList<Equipe> listeEquipes) {
		this.listeEquipesTour = listeEquipes;
	}

}
