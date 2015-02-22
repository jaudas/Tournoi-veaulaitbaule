package model;

public class Match {
	// Attributs
	private Equipe equipeA;
	private Equipe equipeB;
	private int scoreA;
	private int scoreB;
	private int type;

	final int POULE = 0;
	final int FINALE = 1;
	final int DEMIFINALE = 2;
	final int QUARTDEFINALE = 3;
	final int HUITIEMEDEFINALE = 4;
	final int SEIZIEMEDEFINALE = 5;
	final int TRENTEDEUXIEMEDEFINALE = 6;

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

	public int getType() {
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
		// Pas d'égalité possible au volley, donc il y a toujours un gagnant dans un match
		if (scoreA > scoreB) {
			return this.equipeA;
		} else {
			return this.equipeB;
		}
	}

	public void setScoreAleatoire() {
		int score1 = (int)(Math.random() * 3);
		int score2 = 3;

		boolean tirage = Math.random() >= 0.5;
		if (tirage == true)
			ajouterScore(score1, score2);
		else
			ajouterScore(score2, score1);
		
	}

	// Methodes
	public String toString() {
		if (this.estJoue() == true){
		return this.equipeA.getNom() + " " + this.scoreA + "-" + this.scoreB + " "
				+ this.equipeB.getNom() + " --- Gagnant : " + getGagnant().getNom();
		}
		else
			return this.equipeA.getNom() + " - " + this.equipeB.getNom();
	}

	public void ajouterScore(int scoreA, int scoreB) {
		this.scoreA = scoreA;
		equipeA.setNbSetGagne(equipeA.getNbSetGagne()+scoreA);
		this.scoreB = scoreB;
		equipeB.setNbSetGagne(equipeB.getNbSetGagne()+scoreB);
			
		if (scoreA > scoreB){
			this.equipeA.setNbVictoire(this.equipeA.getNbVictoire()+1);
		}
		else{
			this.equipeB.setNbVictoire(this.equipeB.getNbVictoire()+1);
		}
	}


	public boolean estJoue() {
		if ((this.scoreA == 0) && (this.scoreB == 0)) {
			return false;
		} else
			return true;

	}

}
