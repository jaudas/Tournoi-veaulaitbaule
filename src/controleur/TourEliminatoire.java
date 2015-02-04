package controleur;

import java.util.LinkedList;

import model.Equipe;
import model.Match;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private LinkedList<Match> listeMatchTour;
	private int qualifOffice;
	
	public TourEliminatoire()
	{
		super();
	}
	
	public void setQualifOffice()
	{
		int indexEquipe = -1;
		//indexEquipe = (int) (Math.random()*listeEquipesTour.size());	
		
		//Si il y a un nombre impaire d'équipes, alors le dernier de la liste est qualifié d'office
		if(listeEquipesTour.size()%2!=0)
		{
			indexEquipe = listeEquipesTour.size();
		}
		this.qualifOffice = indexEquipe;
		
	}
	
	
	
	public void CreerTour()
	{
		//Le nombre de matchs correspond au nombre de paire(s) d'équipes
		int nbmatchs = (int)listeEquipesTour.size()/2;
		LinkedList<Match> MatchTour = new LinkedList<Match>();
		
		
		for (int i = 0; i<nbmatchs;i++)
		{
			//On récupère les deux équipes suivante
			Equipe e1 = listeEquipesTour.get(i);
			Equipe e2 = listeEquipesTour.get(i++);
			Match rencontre = new Match(e1,e2);
			i++;
			MatchTour.add(rencontre);
			
		}
		this.listeMatchTour=MatchTour;
		

	}
	

}
