package controleur;

import java.util.LinkedList;

import model.Equipe;
import model.Match;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private LinkedList<Match> listeMatchTour;
	int qualifOffice = -1;
	
	public TourEliminatoire()
	{
		super();
	}
	
	public int setQualifOffice()
	{
		int indexEquipe = 0;
		indexEquipe = (int) (Math.random()*listeEquipesTour.size());	
		return indexEquipe;
		
	}
	public void CreerTour()
	{
		int j = listeEquipesTour.size();
		int i = 0;
		
		if (listeEquipesTour.size()%2 !=0)
		{
			qualifOffice = setQualifOffice();
		}
		
		
	}
	

}
