package controleur;

import java.util.LinkedList;

import model.Equipe;
import model.Match;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private LinkedList<Match> listeMatchTour;
	int qualifOffice;
	
	public TourEliminatoire()
	{
		super();
		qualifOffice = -1;
	}
	
	
	public void CreerTour()
	{
		/*UTILISER PLUtOT LE DERNIER = LE QUALIFIE DOFFICE
		if (listeEquipesTour.size()%2 != 0)
		{
			qualifOffice = (int) (Math.random()*listeEquipesTour.size()); 
		}
		int i = 0;
		while(i<(int)listeEquipesTour.size())
		{
			if(i!=qualifOffice && i+1 != qualifOffice)
			{
				Match m = new Match(listeEquipesTour.get(i),listeEquipesTour.get(i+1)); 
				listeMatchTour.add(m);
				i=+2;
			}
			else if (i==qualifOffice)
			{
				Match m = new Match(listeEquipesTour.get(i+1),listeEquipesTour.get(i+2)); 
				listeMatchTour.add(m);
				i=+3;
			}
			else if (i+1==qualifOffice)
			{
				Match m = new Match(listeEquipesTour.get(i),listeEquipesTour.get(i+2)); 
				listeMatchTour.add(m);
				i=+3;
			}
			
			
		}*/
	}
	

}
