package model;

public class Joueur {
	//Attributs
	private String prenom;
	private String nom;
	private String age;
	private String sexe;
	
	//public boolean capitaine;

	//Constructeurs
	public Joueur(){
	}

	public Joueur(String prenom, String nom, String age, String sexe, Equipe equipe){
		this.prenom=prenom;
		this.nom=nom;
		this.age=age;
		this.sexe=sexe;
		
	}
	
	//Getteur et Setteurs 
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	

	//Méthodes
	@Override
	public String toString(){
		return "Joueur: "+this.prenom+" "+this.nom+" Age: "+this.age+" Sexe: "+this.sexe;

	}
	




}