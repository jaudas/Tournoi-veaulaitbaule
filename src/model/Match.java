package model;

public class Match {
	// Attributs
	private Equipe equipeA;
	private Equipe equipeB;
	private int scoreA;
	private int scoreB;
	private int type;
	
	final int FINALE = -1;
	final int DEMIFINALE = -2;
	final int QUARTDEFINALE = -3;
	final int HUITIEMEDEFINALE = -4;
	final int SEIZIEMEDEFINALE = -5;
	final int TRENTEDEUXIEMEDEFINALE =-6;

	// Constructeurs
	public Match(Equipe equipeA, Equipe equipeB) {
		this.equipeA = equipeA;
		this.equipeA.ajouterMatchJoue();
		this.equipeB = equipeB;
		this.equipeB.ajouterMatchJoue();
		this.scoreA = 0;
		this.scoreB = 0;

	}
	
	public Match(Equipe equipeA, Equipe equipeB, int type) {
		this.equipeA = equipeA;
		this.equipeA.ajouterMatchJoue();
		this.equipeB = equipeB;
		this.equipeB.ajouterMatchJoue();
		this.scoreA = 0;
		this.scoreB = 0;
		this.type = type;
	}

	public Match() {
		super();
		this.scoreA = 0;
		this.scoreB = 0;
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
	
	public int getType()
	{
		return type;
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
				+ this.equipeB.getNom();//+"\nC'est un match de "+this.type;
		
	}

	public void ajouterScore(int scoreA, int scoreB) {
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}
	
	public boolean estJoue(){
		if ((this.scoreA == 0) && (this.scoreB == 0)){
			return false;
		}
		return true;
	}

}
