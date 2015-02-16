package model;
import java.util.Iterator;
import java.util.LinkedList;

public class Tournoi {
	//Attributs
	protected int nbEquipesInit;
	protected String description;
	protected LinkedList<Equipe> listeEquipes;
	protected LinkedList<TourEliminatoire> listeToursEliminatoires;
	protected LinkedList<Match> listeMatchs;
	
	//Get & Set
	public int getNbEquipesInit() {
		return nbEquipesInit;
	}
	public void setNbEquipesInit(int nbEquipesInit) {
		this.nbEquipesInit = nbEquipesInit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LinkedList<Equipe> getListeEquipes() {
		return this.listeEquipes;
	}
	public void setListeEquipes(LinkedList<Equipe> listeEquipes) {
		this.listeEquipes = listeEquipes;
	}
	
	public void addMatch(Match m) {
		this.listeMatchs.addLast(m);
	}

	//Methodes
	public String toString()
	{
		String str =("Le tournoi se compose de "+ nbEquipesInit+ " équipes. Les équipes encore en jeu sont les suivantes : ");

		Iterator<Equipe> iter = listeEquipes.iterator();
		while (iter.hasNext())
		{
			str = str + iter.next().getNom() + " ";
		}
		return str;
	}

	public void ajouterEquipe(Equipe e)
	{
		listeEquipes.add(e);
	}
	public void creerPoules(LinkedList<Equipe> listeEquipes) {
		// TODO Auto-generated method stub
		
	}


}
