package model;

import java.util.ArrayList;

public class Equipe {
	//Attributs
	private int idEquipe;
	private String nom;
	private String description;
	private int nbVictoire;
	private int nbMatchJoue;
	private int nbSetGagne;
	private ArrayList <Joueur> listeJoueurs;

	//Constructeurs
	public Equipe (){
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
	}

	public Equipe(String nom) {
		super();
		this.nom = nom;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
	}

	public Equipe(int idEquipe, String nom, String description, ArrayList<Joueur> listeJoueurs) {
		super();
		this.idEquipe = idEquipe;
		this.nom = nom;
		this.description = description;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.listeJoueurs = listeJoueurs;
	}
	
	public Equipe(int idEquipe, String nom, String description, int nbVictoire, int nbButMarque, int nbMatchJoue,ArrayList<Joueur> listeJoueurs) {
		super();
		this.idEquipe = idEquipe;
		this.nom = nom;
		this.description = description;
		this.nbVictoire = nbVictoire;
		this.nbSetGagne = nbButMarque;
		this.nbMatchJoue = nbMatchJoue;
		this.listeJoueurs = listeJoueurs;
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

	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	



}
