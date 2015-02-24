package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tools.FilesTools;

public class Equipe implements Comparable<Equipe> {
	// Attributs
	private int idEquipe;
	private String nom;
	private String description;
	private int nbJoueurs;
	private int nbVictoire;

	private int nbSetGagne;
	private int nbSetPerdu;
	private int nbMatchJoue;
	private LinkedList<Joueur> listeJoueurs;

	private int histoNbSetGagne;
	private int histoNbSetPerdu;
	private int histoNbMatchJoue;
	private int histoNbVictoire;

	// Constructeurs
	public Equipe() {
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbSetPerdu = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
		this.listeJoueurs = null;
		this.histoNbSetGagne = 0;
		this.histoNbSetPerdu = 0;
		this.histoNbMatchJoue = 0;
		this.histoNbVictoire = 0;
	}

	public Equipe(JSONArray listeNom) {
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbSetPerdu = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
		this.listeJoueurs = null;

		this.histoNbSetGagne = 0;
		this.histoNbSetPerdu = 0;
		this.histoNbMatchJoue = 0;
		this.histoNbVictoire = 0;

		// Ajout du nom, depuis une liste de couleurs stockées dans un JSON
		int idnom = (int) (Math.random() * listeNom.size());
		this.nom = (String) (listeNom.get(idnom));
		listeNom.remove(idnom);
	}

	public Equipe(int i, JSONArray listeNom, int nbJoueurs,
			LinkedList<Joueur> listeJoueurs) {
		super();
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.idEquipe = i;
		this.nbSetPerdu = 0;
		this.nbJoueurs = nbJoueurs;
		this.listeJoueurs = listeJoueurs;

		this.histoNbSetGagne = 0;
		this.histoNbSetPerdu = 0;
		this.histoNbMatchJoue = 0;
		this.histoNbVictoire = 0;


		// Ajout du nom, depuis une liste de couleurs stockées dans un JSON
		int idnom = (int) (Math.random() * listeNom.size());
		this.nom = (String) (listeNom.get(idnom));
		listeNom.remove(idnom);

		JSONParser parser = new JSONParser();
		String stringFileNomsEquipes;
		try {
			stringFileNomsEquipes = FilesTools.readFile(
					System.getProperty("user.dir")
					+ "//src//data//Embleme.json",
					StandardCharsets.UTF_8);
			Object parsedFile = parser.parse(stringFileNomsEquipes);
			JSONArray arrayEmblemes = (JSONArray) parsedFile;

			int embleme = (int) (Math.random() * arrayEmblemes.size());
			this.description = (String) ("L'embleme de cet équipe est : " + (arrayEmblemes
					.get(embleme)));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

	public Equipe(String nom) {
		super();
		this.nom = nom;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
		this.nbJoueurs = 0;
	}

	public Equipe(int idEquipe, String nom, String description,
			LinkedList<Joueur> listeJoueurs) {
		super();
		this.idEquipe = idEquipe;
		this.nom = nom;
		this.description = description;
		this.nbVictoire = 0;
		this.nbSetGagne = 0;
		this.nbMatchJoue = 0;
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

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
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

	public void ajouterMatchJoue() {
		this.nbMatchJoue++;
	}

	public int getNbSetPerdu() {
		return nbSetPerdu;
	}

	public void setNbSetPerdu(int i) {
		this.nbSetPerdu = i;
	}


	public int getHistoNbSetGagne() {
		return histoNbSetGagne;
	}

	public void setHistoNbSetGagne(int histoNbSetGagne) {
		this.histoNbSetGagne = histoNbSetGagne;
	}

	public int getHistoNbSetPerdu() {
		return histoNbSetPerdu;
	}

	public void setHistoNbSetPerdu(int histoNbSetPerdu) {
		this.histoNbSetPerdu = histoNbSetPerdu;
	}

	public int getHistoNbMatchJoue() {
		return histoNbMatchJoue;
	}

	public void setHistoNbMatchJoue(int histoNbMatchJoue) {
		this.histoNbMatchJoue = histoNbMatchJoue;
	}

	public int getHistoNbVictoire() {
		return histoNbVictoire;
	}

	public void setHistoNbVictoire(int histoNbVictoire) {
		this.histoNbVictoire = histoNbVictoire;
	}

	// Méthodes
	@Override
	public String toString() {
		return "Equipe n°: " + this.idEquipe + "   Nom: " + this.nom
				+ "   Nombre de joueurs: " + this.nbJoueurs
				+ "   \nDescription: " + this.description + ".";

	}

	// Calculer le score de chaque équipe selon le nombre de victoires
	public int getScore() {
		return nbVictoire * 3;
	}

	public int calculGoalAverage()
	{
		return this.nbSetGagne - this.nbSetPerdu;
	}

	@Override
	public int compareTo(Equipe eq2) {
		// Comparaion des équipes selon leurs nombres de victoire
		if (this.getNbVictoire() > eq2.getNbVictoire()) {
			return -1;
		} else if (this.getNbVictoire() < eq2.getNbVictoire()) {
			return 1;
		} else if (this.getNbVictoire() == eq2.getNbVictoire()) {
			// Comparaison des équipes selon leurs nombres de sets gagnés
			if (this.getNbSetGagne() > eq2.getNbSetGagne()) {
				return -1;
			} else if (this.getNbSetGagne() < eq2.getNbSetGagne()) {
				return 1;
			}
			else if (this.getNbSetGagne() == eq2.getNbSetGagne()) {
				// Comparaison des équipes selon leurs goal average
				if (this.calculGoalAverage() > eq2.calculGoalAverage()) {
					return -1;
				} else if (this.calculGoalAverage() < eq2.calculGoalAverage()) {
					return 1;
				}
			}
		}
		// Si les deux équipes ont le même nombre de victoires et de sets
		// gagnés, ainsi quele meme goal averag
		// on tire au sort l'équipe qui est classée avant l'autre
		return (Math.random() >= 0.5 ? 1 : -1);
	}

}