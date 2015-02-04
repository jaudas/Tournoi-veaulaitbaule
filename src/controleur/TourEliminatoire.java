package controleur;

import java.util.LinkedList;

import model.Equipe;
import model.Match;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private LinkedList<Match> listeMatchTour;
	private int qualifOffice = -1;
	
	public TourEliminatoire()
	{
		super();
	}
	
	public void setQualifOffice()
	{
		int indexEquipe = 0;
		indexEquipe = (int) (Math.random()*listeEquipesTour.size());	
		this.qualifOffice = indexEquipe;
		
	}
	
	
	
	public void CreerTour()
	{
		int nbmatchs = listeEquipesTour.size()%2;
		LinkedList<Match> MatchTour = new LinkedList<Match>();
		
		for (int i = 0; i<nbmatchs;i++)	
		{
			Equipe e1 = listeEquipesTour.get(i);
			Equipe e2 = listeEquipesTour.get(i++);
			Match rencontre = new Match(e1,e2);
			i++;
			MatchTour.add(rencontre);
			
		}
		this.listeMatchTour=MatchTour;

	}
	

}
