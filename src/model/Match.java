package model;

public class Match {
	// Attributs
	private Equipe equipeA;
	private Equipe equipeB;
	private int scoreA;
	private int scoreB;
	private boolean joue;

	// Constructeurs
	public Match(Equipe equipeA, Equipe equipeB) {
		this.equipeA = equipeA;
		this.equipeA.ajouterMatchJoue();
		this.equipeB = equipeB;
		this.equipeB.ajouterMatchJoue();
		this.scoreA = 0;
		this.scoreB = 0;
		this.joue = false;
	}

	public Match() {
		super();
		this.scoreA = 0;
		this.scoreB = 0;
		this.joue = false;
	}

	// Get et Set

	public Equipe getEquipeA() {
		return equipeA;
	}

	public void setEquipeA(Equipe equipeA) {
		this.equipeA = equipeA;
	}

	public Equipe getEquipeB() {
		return equipeB;
	}

	public void setEquipeB(Equipe equipeB) {
		this.equipeB = equipeB;
	}

	public int getScoreA() {
		return scoreA;
		
	}

	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}

	public int getScoreB() {
		return scoreB;
	}

	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}

	public Equipe getGagnant() {
		// Pas d'égalité possible au volley
		if (scoreA > scoreB) {
			return equipeA;
		} else {
			return equipeB;
		}

	}

	public void setScoreAleatoire() {
		scoreA = (int) (Math.random() * 10);
		scoreB = (int) (Math.random() * 10);
	}

	// Methodes
	public String toString() {
		return this.equipeA.getNom() + " " + this.scoreA + "-" + this.scoreB + " "
				+ this.equipeB.getNom();
	}

	public void ajouterScore(int scoreA, int scoreB) {
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}

}
