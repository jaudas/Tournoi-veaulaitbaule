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


	public void creerTour(Tournoi t)
	{
		this.setQualifOffice();
		//Le nombre de matchs correspond au nombre de paire(s) d'�quipes
		int nbmatchs = (int)listeEquipesTour.size()/2;

		System.out.println("Il y aura " + nbmatchs + " matchs dans ce tour : ");
		int j = 0; 

		for (int i = 0; i<nbmatchs; i++)
		{
			Equipe e1, e2;//Les deux �quipes d'un match

			//Verification de l'�quipe 1
			if(j==qualifOffice)
			{
				
				//Si l'�quipe est qualifi�e d'office, on prend le suivant
				j++;
			}
			e1 = listeEquipesTour.get(j);
			

			//On passe � l'�quipe d'apr�s dans la liste des �quipes
			j++;
			
			//V�rification equipe 2
			if(j==qualifOffice)
			{
				//Si l'�quipe est qualifi�e d'office, on prend le suivant
				j++;
			}
			e2 = listeEquipesTour.get(j);
			
			Match rencontre = new Match(e1,e2);
			System.out.println(" >>> "+rencontre.toString()+" <<< ");
			this.listeMatchTour.add(rencontre);
			t.addMatch(rencontre);

			j++;

		}


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
			return SEIXIEMEDEFINALE;
		
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
			System.out.println("\n C'est parti pour les matchs !");
			listeMatchTour.get(i).setScoreAleatoire();
			System.out.println(" >>> "+listeMatchTour.get(i).toString()+" <<< -- Gagnant : " + listeMatchTour.get(i).getGagnant().getNom());
			listeEqQualif.add(listeMatchTour.get(i).getGagnant());
		}
		return listeEqQualif;
	}


	



}
