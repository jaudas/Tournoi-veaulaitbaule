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
		
		int parite = this.listeEquipesTour.size()%2;
		
		if(parite!=0)
		{
			indexEquipe = (int) (Math.random()*listeEquipesTour.size());
			System.out.println("L'équipe qualifiée d'office est : " + listeEquipesTour.get(indexEquipe).getNom());
		}
		else
		{
			System.out.println("Pas d'équipe qualifiée automatiquement... :( ");
		}
		this.qualifOffice = indexEquipe;
		
	}


	public void creerTour()
	{
		//Le nombre de matchs correspond au nombre de paire(s) d'équipes
		int nbmatchs = (int)listeEquipesTour.size()/2;
		LinkedList<Match> matchTour = new LinkedList<Match>();

		System.out.println("Il y aura " + nbmatchs + " matchs dans ce tour : ");
		int j = 0; 

		for (int i = 0; i<nbmatchs; i++)
		{
			Equipe e1, e2;//Les deux équipes d'un match

			//Verification de l'équipe 1
			if(j==qualifOffice)
			{
				
				//Si l'équipe est qualifiée d'office, on prend le suivant
				j++;
			}
			e1 = listeEquipesTour.get(j);
			

			//On passe à l'équipe d'après dans la liste des équipes
			j++;
			
			//Vérification equipe 2
			if(j==qualifOffice)
			{
				//Si l'équipe est qualifiée d'office, on prend le suivant
				j++;
			}
			e2 = listeEquipesTour.get(j);
			
			Match rencontre = new Match(e1,e2);
			System.out.println(" >>> "+rencontre.toString()+" <<< ");
			//rencontre.setScoreAleatoire();
			matchTour.add(rencontre);
			
			j++;

		}
		this.listeMatchTour=matchTour;
	}

	public LinkedList<Equipe> equipesQualifiees()
	{
		LinkedList<Equipe> listeEqQualif = new LinkedList<Equipe>();

		//Si une equipe a ete qualifiée d'office, on l'ajoute à la liste des équipes qualifiées
		if (this.qualifOffice != -1)
		{
			listeEqQualif.add(this.listeEquipesTour.get(qualifOffice));
		}
		
		//Pour chaque match, on ajoute le gagnant à la liste des équipes qualifiées 
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
