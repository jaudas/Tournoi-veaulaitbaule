package model;

public enum EnumTypeMatch {
	/*Poule1("Poule 1", 1),
	Poule2("Poule 2", 2),
	Poule3("Poule 3", 3),
	Poule4("Poule 4", 4),
	Poule5("Poule 5", 5),
	Poule6("Poule 6", 6),
	Poule7("Poule 7", 7),
	Poule8("Poule 8", 8),
	Poule9("Poule 9", 9),
	Poule10("Poule 10", 10),
	Finale("Finale", -1),
	DemiFinale("Demie-finale", -2),
	QuartDeFinale("Quart de finale", -3),
	HuitiemeDeFinale("Huitième de finale", -4),
	SeiziemeDeFinale("Seizième de finale", -5),
	TrenteDeuxièmeDeFinale("Trente-deuxième de finale", -6);	
	*/
	Poule1(1),
	Poule2(2),
	Poule3(3),
	Poule4(4),
	Poule5(5),
	Poule6(6),
	Poule7(7),
	Poule8(8),
	Poule9(9),
	Poule10(10),
	Finale(-1),
	DemiFinale(-2),
	QuartDeFinale(-3),
	HuitiemeDeFinale(-4),
	SeiziemeDeFinale(-5),
	TrenteDeuxièmeDeFinale(-6);
	
	//private String nom ="";
	private int ID;
	
	//Constructeur
	/*EnumTypeMatch (String valNom, int valID){
		this.nom = valNom;
		this.ID = valID;		
	}*/
	
	EnumTypeMatch (int valID){
		this.ID = valID;		
	}
	
	public EnumTypeMatch traitementID (int ID)
	{
		EnumTypeMatch type;
		type = new EnumTypeMatch(ID);
		
		return type;
	}

	/*public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}*/

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	/*public String toString(){
		return this.nom;
	}*/
}
