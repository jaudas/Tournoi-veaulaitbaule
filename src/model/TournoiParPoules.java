package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TournoiParPoules extends Tournoi {
	int nbPoules;
	private ArrayList<Poule> listePoules = new ArrayList<Poule>();
	//private ArrayList<Match> listeMatchs = new ArrayList<Match>();
	private LinkedList<Equipe> eqPhaseEliminatoire = new LinkedList<Equipe>();
	// Liste des équipes qualifiées


	// Constructeur
	public TournoiParPoules() {
		super();
	}

	public TournoiParPoules(LinkedList<Equipe> listeEq) {
		int nbeq=listeEq.size();
		super.listeEquipes = listeEq;

		// Calcul du nombre de poules necessaires
		int nbpoul = nbeq / 4;// Nb poules complètes
		
		if (nbeq % 4 != 0)// S'il reste des équipes
		{
			this.nbPoules = nbpoul + 1;
		} else {
			this.nbPoules = nbpoul;
		}
		//System.out.println("Le nombre de poules à créer est : " + this.nbPoules);
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

			while ((equipesPoule.size() < 4) && (super.listeEquipes.isEmpty() == false)) {
				// Trouver une équipe au hasard dans la liste d'équipes
				ind = (int) ((Math.random()) * super.listeEquipes.size());
				//System.out.println(ind);


				// Ajouter l'équipe choisie dans une poule
				equipesPoule.add(super.listeEquipes.get(ind));

				// System.out.println("Ajout de l'équipe "+listeEquipes.get(ind).toString()+" dans la poule.");
				// listeEquipes.get(ind).toString();//Affichage de l'équipe
				// sélectionnée pour la poule

				super.listeEquipes.remove(ind);// Suppression de l'équipe dans la
											// liste des équipes du tournoi
			}

			// System.out.println("Creation d'une poule");
			Poule poule = new Poule("Poule " + numPoule, equipesPoule, this, numPoule);
			if (poule != null) {
				listePoules.add(poule);
				// System.out.println("Poule "+numPoule+" ajoutée !");
			}
			numPoule++;
			cptPoules--;
		}
	}

	// Ordonner les équipes qualifiées pour les phases éliminatoires dans une
	// liste
	public void creerEqQualifiees() {
		int ind = 0;
		// On ajoute la première équipe de la première poule
		eqPhaseEliminatoire.add(
				listePoules.get(ind).getEquipesPoule().get(0));

		while (ind < listePoules.size() - 1) {
			ind++;
			// On regarde s'il y a une deuxième équipe dans la poule suivante
			if (listePoules.get(ind).getEquipesPoule().size() > 1) {
				eqPhaseEliminatoire.add(
						listePoules.get(ind).getEquipesPoule().get(1));
			}
			// On ajoute la première équipe de la poule suivante
			this.eqPhaseEliminatoire.add(
					listePoules.get(ind).getEquipesPoule().get(0));
		}

		this.eqPhaseEliminatoire.add(
				listePoules.get(0).getEquipesPoule().get(1));

	}

	public ArrayList<Poule> getListePoules() {
		return listePoules;
	}

	public void setListePoules(ArrayList<Poule> listePoules) {
		this.listePoules = listePoules;
	}

	// Déroulement d'un tournoi lors des phases de poules
	public void deroulementTournoiPoule() {

	}

	// Classer chaque poule du tournoi
	public ArrayList<Poule> classerEqPoules() {
		for (int ind = 0; ind < listePoules.size(); ind++) {
			listePoules.get(ind).classerEquipes();
		}
		return listePoules;
	}

	public LinkedList<Equipe> getEqPhaseEliminatoire() {
		return eqPhaseEliminatoire;
	}

	public void setEqPhaseEliminatoire(LinkedList<Equipe> eqPhaseEliminatoire) {
		this.eqPhaseEliminatoire = eqPhaseEliminatoire;
	}

	public static List<Equipe> getListEquipeDuTournoi(String...names) {//var-args
		List<Equipe> eDT = new ArrayList<Equipe> ();
		for(String name :names){
			eDT.add(new Equipe (name, (int) (Math.random() * 10), (int) (Math.random() * 10)));
		}
		return eDT;
	}

	/*public static void main(String[] arg) {
		List<Equipe> eDT = getListEquipeDuTournoi("Jaune","Bleu","Rouge","Vert","Cyan","Rose","Marron","Orange","Blanc","Noir");
		TournoiParPoules tournoi = new TournoiParPoules(eDT);

		tournoi.creerPoules(eDT);
		System.out.println("Fin création des poules.");
		tournoi.classerEqPoules();
		Poule pouleTest = tournoi.listePoules.get(0);
		Poule pouleTest2 = tournoi.listePoules.get(1);
		Poule pouleTest3 = tournoi.listePoules.get(2);

		System.out.println("Poule 1");
		for (int i = 0; i < pouleTest.getEquipesPoule().size(); i++) {
			System.out.println("Equipe " + i + ": "
					+ pouleTest.getEquipesPoule().get(i).getNom());
		}

		System.out.println("\nPoule 2");
		for (int i = 0; i < pouleTest2.getEquipesPoule().size(); i++) {
			System.out.println("Equipe " + i + ": "
					+ pouleTest2.getEquipesPoule().get(i).getNom());
		}

		System.out.println("\nPoule 3");
		for (int i = 0; i < pouleTest3.getEquipesPoule().size(); i++) {
			System.out.println("Equipe " + i + ": "
					+ pouleTest3.getEquipesPoule().get(i).getNom());
		}

		tournoi.creerEqQualifiees();
		System.out.println("\n--------------------------------\n");
		System.out.println("Equipes qualifiées : ");
		for (int i = 0; i < tournoi.getEqPhaseEliminatoire().size(); i++) {
			System.out.println("Equipe "
					+ tournoi.getEqPhaseEliminatoire().get(i).getIdEquipe()
					+ ": " + tournoi.getEqPhaseEliminatoire().get(i).getNom());
		}

		TourEliminatoire tourJeu;
		int compteurtour = 0;

		while (getEqPhaseEliminatoire().size() != 1) // Tant qu'il y a plus
														// d'une équipe en
		// jeu, alors on effectue un tournoi
		{

			// Creation d'un tour
			tourJeu = new TourEliminatoire(getEqPhaseEliminatoire());
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
			setEqPhaseEliminatoire(tourJeu.equipesQualifiees());
			System.out.println("\nFin du tour " + compteurtour);

		}
		System.out.println("Le super gagnant est : "
				+ getEqPhaseEliminatoire().getFirst());

	}*/
}
