package model;

public class Match {
	//Attributs
	private Equipe equipeA;
	private Equipe equipeB;
	private int scoreA;
	private int scoreB;


	//Constructeurs
	public Match(Equipe equipeA, Equipe  equipeB){
		this.equipeA=equipeA;
		this.equipeB=equipeB;
		this.scoreA=0;
		this.scoreB=0;
	}
	
	public Match()
	{
		
	}
	
	//Get et Set

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
	
	//Methodes
	public String toString(){
		return this.equipeA +" "+this.scoreA+"-"+this.scoreB+" "+this.equipeB;
	}

	public void ajouterScore(int scoreA, int scoreB)
	{
		this.scoreA=scoreA;
		this.scoreB=scoreB;
	}
	

}
