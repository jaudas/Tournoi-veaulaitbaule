package model;

import java.util.LinkedList;

public class TourEliminatoire {
	private LinkedList<Equipe> listeEquipesTour;
	private int qualifOffice = -1;
	private LinkedList<Match> listeMatchTour = new LinkedList<Match>();
	
	
	final int FINALE = -1;
	final int DEMIFINALE = -2;
	final int QUARTDEFINALE = -3;
	final int HUITIEMEDEFINALE = -4;
	final int SEIZIEMEDEFINALE = -5;
	final int TRENTEDEUXIEMEDEFINALE =-6;

	public TourEliminatoire()
	{
		super();
	}

	public TourEliminatoire(LinkedList<Equipe> listeEq)
	{
		listeEquipesTour = listeEq;
	}

	public LinkedList<Equipe> getListeEquipesTour() {
		return listeEquipesTour;
	}

	public void setQualifOffice()
	{
		int indexEquipe = -1;

		//Indique la parit� de la liste d'�quipes 
		int parite = this.listeEquipesTour.size()%2;

		if(parite!=0)
		{
			indexEquipe = (int) (Math.random()*listeEquipesTour.size());
			System.out.println("L'�quipe qualifi�e d'office est : " + listeEquipesTour.get(indexEquipe).getNom());
		}
		else
		{
			System.out.println("Pas d'�quipe qualifi�e automatiquement... :( ");
		}
		this.qualifOffice = indexEquipe;

	}

	public int trouverPhaseTour(int nbequipes)
	{
		if (nbequipes<2)
			return 0;

		if (nbequipes==2)
			return FINALE;

		if (nbequipes<=4)
			return DEMIFINALE;

		if (nbequipes <=8)
			return QUARTDEFINALE;

		if (nbequipes <=16)
			return HUITIEMEDEFINALE;

		if (nbequipes <=32)
			return SEIZIEMEDEFINALE;

		else return TRENTEDEUXIEMEDEFINALE;

	}

	public LinkedList<Equipe> equipesQualifiees()
	{
		LinkedList<Equipe> listeEqQualif = new LinkedList<Equipe>();

		//Si une equipe a ete qualifi�e d'office, on l'ajoute � la liste des �quipes qualifi�es
		if (this.qualifOffice != -1)
		{
			listeEqQualif.add(this.listeEquipesTour.get(qualifOffice));
		}

		//Pour chaque match, on ajoute le gagnant � la liste des �quipes qualifi�es 
		for(int i = 0; i < listeMatchTour.size(); i++)
		{
			System.out.println("\n From TourEliminatoire : G�n�rons les �quipes qualifi�es en analysant les r�sultats de la manche!");
			System.out.println(" >>> "+listeMatchTour.get(i).toString()+" <<< -- Gagnant : " + listeMatchTour.get(i).getGagnant().getNom());
			listeEqQualif.add(listeMatchTour.get(i).getGagnant());
		}
		return listeEqQualif;
	}
	
	
	public int getQualifOffice()
	{
		return qualifOffice;
	}
	
	public LinkedList<Match> getListeMatchsTour()
	{
		return this.listeMatchTour;
	}

}
