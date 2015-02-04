package model;


import java.util.LinkedList;

public class Equipe {
	//Attributs
	private int idEquipe;
	private String nom;
	private String description;
	private int nbJoueurs;
	private int nbVictoire;
	private int nbMatchJoue;
	private int nbSetGagne;
	private LinkedList<Joueur> listeJoueurs;

	//Constructeurs
	public Equipe (){
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
	}

	public Equipe(String nom) {
		super();
		this.nom = nom;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
	}

	public Equipe(int idEquipe, String nom, String description, LinkedList<Joueur> listeJoueurs) {
		super();
		this.idEquipe = idEquipe;
		this.nom = nom;
		this.description = description;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.listeJoueurs = null;
	}
	
	public Equipe(int idEquipe, String nom, String description, int nbVictoire, int nbButMarque, int nbMatchJoue,LinkedList<Joueur> listeJoueurs) {
		super();
		this.idEquipe = idEquipe;
		this.nom = nom;
		this.description = description;
		this.nbVictoire = nbVictoire;
		this.nbSetGagne = nbButMarque;
		this.nbMatchJoue = nbMatchJoue;
		this.setListeJoueurs(listeJoueurs);
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
			return "Equipe ID: "+this.idEquipe +"   Nom: "+this.nom+"   Nombre de joueurs: "+this.nbJoueurs+"   Description: "+this.description +  " Joueurs: " +this.listeJoueurs;
			

		}


	

}