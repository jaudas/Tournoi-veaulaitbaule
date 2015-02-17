package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TournoiParPoules extends Tournoi {
	int nbPoules;
	private ArrayList<Poule> listePoules = new ArrayList<Poule>();
	//private ArrayList<Match> listeMatchs = new ArrayList<Match>();
	private LinkedList<Equipe> eqPhaseEliminatoire = new LinkedList<Equipe>();
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
	public void creerPoules() {

		int cptPoules = this.nbPoules;
		int numPoule = 1;
		while (cptPoules > 0) {
			// On cr�e une liste vide d'�quipes qui va �tre attribu� � une poule
			ArrayList<Equipe> equipesPoule = new ArrayList<Equipe>();

			int ind = 0;

			while ((equipesPoule.size() < 4) && (super.listeEquipes.isEmpty() == false)) {
				// Trouver une �quipe au hasard dans la liste d'�quipes
				ind = (int) ((Math.random()) * super.listeEquipes.size());
				//System.out.println(ind);


				// Ajouter l'�quipe choisie dans une poule
				equipesPoule.add(super.listeEquipes.get(ind));

				// System.out.println("Ajout de l'�quipe "+listeEquipes.get(ind).toString()+" dans la poule.");
				// listeEquipes.get(ind).toString();//Affichage de l'�quipe
				// s�lectionn�e pour la poule

				super.listeEquipes.remove(ind);// Suppression de l'�quipe dans la
											// liste des �quipes du tournoi
			}

			// System.out.println("Creation d'une poule");
			Poule poule = new Poule("Poule " + numPoule, equipesPoule, this, numPoule);
			if (poule != null) {
				listePoules.add(poule);
				// System.out.println("Poule "+numPoule+" ajout�e !");
			}
			numPoule++;
			cptPoules--;
		}
	}

	// Ordonner les �quipes qualifi�es pour les phases �liminatoires dans une
	// liste
	public void creerEqQualifiees() {
		int ind = 0;
		// On ajoute la premi�re �quipe de la premi�re poule
		eqPhaseEliminatoire.add(
				listePoules.get(ind).getEquipesPoule().get(0));

		while (ind < listePoules.size() - 1) {
			ind++;
			// On regarde s'il y a une deuxi�me �quipe dans la poule suivante
			if (listePoules.get(ind).getEquipesPoule().size() > 1) {
				eqPhaseEliminatoire.add(
						listePoules.get(ind).getEquipesPoule().get(1));
			}
			// On ajoute la premi�re �quipe de la poule suivante
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
