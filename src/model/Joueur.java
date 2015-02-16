package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import tools.FilesTools;

public class Joueur {
	//Attributs
	private String prenom;
	private String nom;
	private String age;
	private EnumSexe sexejoueur;

	//public boolean capitaine;

	//Constructeurs
	public Joueur(){
		sexejoueur = Math.random()>= 0.5 ? EnumSexe.Femme : EnumSexe.Homme;
		JSONParser parser=new JSONParser();

		String stringFile;
		try {
			stringFile = FilesTools.readFile(System.getProperty("user.dir")+"//src//data//nom.json",StandardCharsets.UTF_8);
			Object obj = parser.parse(stringFile);
			JSONArray array = (JSONArray)obj;		
			this.nom = (String) (array.get((int)(Math.random()*array.size())));

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		if(sexejoueur == EnumSexe.Femme)
		{
			try {
				stringFile = FilesTools.readFile(System.getProperty("user.dir")+"//src//data//prenomfille.json",StandardCharsets.UTF_8);
				Object obj = parser.parse(stringFile);
				JSONArray array = (JSONArray)obj;		
				this.prenom = (String) (array.get((int)(Math.random()*array.size())));

			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}

		else
		{
			try {
				stringFile = FilesTools.readFile(System.getProperty("user.dir")+"//src//data//prenomhomme.json",StandardCharsets.UTF_8);
				Object obj = parser.parse(stringFile);
				JSONArray array = (JSONArray)obj;		
				this.prenom = (String) (array.get((int)(Math.random()*array.size())));

			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
	}


	public Joueur(EnumSexe sexe){


	}

	public Joueur(String prenom, String nom, String age, EnumSexe sexe, Equipe equipe){
		this.prenom=prenom;
		this.nom=nom;
		this.age=age;
		this.sexejoueur=sexe;

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

	public EnumSexe getSexe() {
		return sexejoueur;
	}

	public void setSexe(String sexe) {
		if (sexe == "Homme")
		{
			this.sexejoueur = EnumSexe.Homme;
		}

		if (sexe == "Femme")
		{
			this.sexejoueur = EnumSexe.Femme;
		}
		this.sexejoueur = EnumSexe.NA;
	}




	//Méthodes
	@Override
	public String toString(){
		return "Joueur: "+this.prenom+" "+this.nom+" Age: "+this.age+" Sexe: "+this.sexejoueur;
	}


}

