package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TournoiParPoules extends Tournoi {
	int nbPoules;
	private ArrayList<Poule> listePoules = new ArrayList<Poule>();
	//private ArrayList<Match> listeMatchs = new ArrayList<Match>();
	private static LinkedList<Equipe> eqPhaseEliminatoire = new LinkedList<Equipe>();
	// Liste des �quipes qualifi�es


	// Constructeur
	public TournoiParPoules() {
		super();
	}

	public TournoiParPoules(LinkedList<Equipe> listeEq) {
		int nbeq=listeEq.size();
		super.listeEquipes = listeEq;

		// Calcul du nombre de poules necessaires
		int nbpoul = nbeq / 4;// Nb poules compl�tes
		System.out.println("Reste : " + (nbeq % 4));
		if (nbeq % 4 != 0)// S'il reste des �quipes
		{
			this.nbPoules = nbpoul + 1;
		} else {
			this.nbPoules = nbpoul;
		}
		//System.out.println("Le nombre de poules � cr�er est : " + this.nbPoules);
	}

	// M�thodes
	@Override
	public String toString() {
		String str = super.toString()
				+ "Il est compos� d'une phase de qualifications par poules de 4 �quipes, puis d'une phase finale. \n Description : "
				+ super.description;
		return str;
	}

	// Cr�er les poules du tournoi
	public ArrayList<Poule> creerPoules(List<Equipe> listeEquipes) {
		int cptPoules = this.nbPoules;
		int numPoule = 1;
		while (cptPoules > 0) {
			// On cr�e une liste vide d'�quipes qui va �tre attribu� � une poule
			ArrayList<Equipe> equipesPoule = new ArrayList<Equipe>();

			int ind = 0;

			while ((equipesPoule.size() < 4) && (listeEquipes.isEmpty() == false)) {
				// Trouver une �quipe au hasard dans la liste d'�quipes
				ind = (int) ((Math.random()) * listeEquipes.size());
				//System.out.println(ind);

				// Ajouter l'�quipe choisie dans une poule
				equipesPoule.add(listeEquipes.get(ind));

				// System.out.println("Ajout de l'�quipe "+listeEquipes.get(ind).toString()+" dans la poule.");
				// listeEquipes.get(ind).toString();//Affichage de l'�quipe
				// s�lectionn�e pour la poule

				listeEquipes.remove(ind);// Suppression de l'�quipe dans la
											// liste des �quipes du tournoi
			}

			// System.out.println("Creation d'une poule");
			Poule poule = new Poule("Poule " + numPoule + "", equipesPoule, super.listeMatchs, numPoule);
			if (poule != null) {
				listePoules.add(poule);
				// System.out.println("Poule "+numPoule+" ajout�e !");
			}
			numPoule++;
			cptPoules--;
		}

		return listePoules;
	}

	// Ordonner les �quipes qualifi�es pour les phases �liminatoires dans une
	// liste
	public LinkedList<Equipe> creerEqQualifiees() {
		int ind = 0;
		//System.out.println(listePoules.size());

		/*
		 * while (ind<listePoules.size()-1){
		 * eqPhaseEliminatoire.add(listePoules.
		 * get(ind).getEquipesPoule().get(0));
		 * System.out.println("Equipe ajoutee : "
		 * +listePoules.get(ind).getEquipesPoule().get(0).getNom());
		 * 
		 * //S'il y a une poule suivante dans la liste & S'il y a une �quipe 2
		 * dans la poule suivante de la liste if
		 * (listePoules.get(ind+1).getEquipesPoule().get(1) != null){
		 * System.out.println("Debut de l'ajout");
		 * eqPhaseEliminatoire.add(listePoules
		 * .get(ind+1).getEquipesPoule().get(1));
		 * System.out.println("Equipe ajoutee aussi : "
		 * +listePoules.get(ind+1).getEquipesPoule().get(1).getNom());
		 * 
		 * } ind ++; }
		 */
		// On ajoute la premi�re �quipe de la premi�re poule
		getEqPhaseEliminatoire().add(
				listePoules.get(ind).getEquipesPoule().get(0));

		while (ind < listePoules.size() - 1) {
			ind++;
			// On regarde s'il y a une deuxi�me �quipe dans la poule suivante
			if (listePoules.get(ind).getEquipesPoule().size() > 1) {
				getEqPhaseEliminatoire().add(
						listePoules.get(ind).getEquipesPoule().get(1));
			}
			// On ajoute la premi�re �quipe de la poule suivante
			getEqPhaseEliminatoire().add(
					listePoules.get(ind).getEquipesPoule().get(0));
		}

		getEqPhaseEliminatoire().add(
				listePoules.get(0).getEquipesPoule().get(1));
		// System.out.println("Ajout de la derniere equipe ! "+listePoules.get(0).getEquipesPoule().get(1));

		// System.out.println(eqPhaseEliminatoire.size());
		return getEqPhaseEliminatoire();
	}

	public ArrayList<Poule> getListePoules() {
		return listePoules;
	}

	public void setListePoules(ArrayList<Poule> listePoules) {
		this.listePoules = listePoules;
	}

	// D�roulement d'un tournoi lors des phases de poules
	public void deroulementTournoiPoule() {

	}

	// Classer chaque poule du tournoi
	public ArrayList<Poule> classerEqPoules() {
		for (int ind = 0; ind < listePoules.size(); ind++) {
			listePoules.get(ind).classerEquipes();
		}
		return listePoules;
	}

	public static LinkedList<Equipe> getEqPhaseEliminatoire() {
		return eqPhaseEliminatoire;
	}

	public static void setEqPhaseEliminatoire(LinkedList<Equipe> eqPhaseEliminatoire) {
		TournoiParPoules.eqPhaseEliminatoire = eqPhaseEliminatoire;
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
		System.out.println("Fin cr�ation des poules.");
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
		System.out.println("Equipes qualifi�es : ");
		for (int i = 0; i < tournoi.getEqPhaseEliminatoire().size(); i++) {
			System.out.println("Equipe "
					+ tournoi.getEqPhaseEliminatoire().get(i).getIdEquipe()
					+ ": " + tournoi.getEqPhaseEliminatoire().get(i).getNom());
		}

		TourEliminatoire tourJeu;
		int compteurtour = 0;

		while (getEqPhaseEliminatoire().size() != 1) // Tant qu'il y a plus
														// d'une �quipe en
		// jeu, alors on effectue un tournoi
		{

			// Creation d'un tour
			tourJeu = new TourEliminatoire(getEqPhaseEliminatoire());
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
			tourJeu.creerTour();
			System.out.println("Matchs g�n�r�s ! ");

			// On mets � jour la liste des �quipes en jeu
			setEqPhaseEliminatoire(tourJeu.equipesQualifiees());
			System.out.println("\nFin du tour " + compteurtour);

		}
		System.out.println("Le super gagnant est : "
				+ getEqPhaseEliminatoire().getFirst());

	}*/
}
