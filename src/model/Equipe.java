package model;

import java.util.LinkedList;

public class Equipe implements Comparable<Equipe> {
	//Attributs
	private static int compteur=1;
	private int idEquipe;
	private String nom;
	private String description;
	private int nbJoueurs;
	private int nbVictoire;
	private int nbMatchJoue;
	private int nbSetGagne;
	private LinkedList <Joueur> listeJoueurs;

	//Constructeurs
	public Equipe (){
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
		this.idEquipe = compteur;
		compteur ++;
	}

	public Equipe(String nom) {
		super();
		this.nom = nom;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
		this.idEquipe = compteur;
		compteur ++; 
	}

	public Equipe(String nom, String description, LinkedList<Joueur> listeJoueurs) {
		super();
		this.nom = nom;
		this.description = description;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.listeJoueurs = listeJoueurs;
		this.idEquipe = compteur;
		compteur ++;
		this.idEquipe = compteur;
		compteur ++;
	}
	
	public Equipe(String nom,  int nbVictoire, int nbSets) {
		super();
		this.nom = nom;
		this.description = "rien";
		this.nbVictoire = nbVictoire;
		this.nbSetGagne = nbSets;
		this.nbMatchJoue = 0;
		this.listeJoueurs = null;
		this.idEquipe = compteur;
		compteur ++;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbJoueurs() {
			return nbJoueurs;
	}
	
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs= nbJoueurs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbVictoire() {
		return nbVictoire;
	}

	public void setNbVictoire(int nbVictoire) {
		this.nbVictoire = nbVictoire;
	}

	public int getNbMatchJoue() {
		return nbMatchJoue;
	}

	public void setNbMatchJoue(int nbMatchJoue) {
		this.nbMatchJoue = nbMatchJoue;
	}

	public int getNbSetGagne() {
		return nbSetGagne;
	}

	public void setNbSetGagne(int nbSetGagne) {
		this.nbSetGagne = nbSetGagne;
	}

	public LinkedList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	  
	//Méthodes
		@Override
		public String toString(){
			return "Equipe ID: "+this.idEquipe +"   Nom: "+this.nom+"   Nombre de joueurs: "+this.nbJoueurs+"   Description: "+this.description;

		}
	
		//Calculer le score de chaque équipe selon le nombre de victoires
		public int getScore (){
			return nbVictoire*3;			
		}

		@Override
		public int compareTo(Equipe eq2) {
			//Comparaion des équipes selon leurs nombres de victoire
			if (getScore() > eq2.getScore()){
				return -1;
			}
			else if (getScore() < eq2.getScore()){
				return 1;
			}
			else if (getScore() == eq2.getScore()){
				//Comparaison des équipes selon leurs nombres de sets gagnés
				if (getNbSetGagne() > eq2.getNbSetGagne()){
					return -1;
				}
				else if (getNbSetGagne() < eq2.getNbSetGagne()){
					return 1;
				}
				return 0;
			}
			return 0;
		}

}