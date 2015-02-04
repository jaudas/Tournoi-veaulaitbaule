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
		indexEquipe = (int) (Math.random()*listeEquipesTour.size());	
		this.qualifOffice = indexEquipe;
	}


	public void CreerTour()
	{
		//Le nombre de matchs correspond au nombre de paire(s) d'équipes
		int nbmatchs = (int)listeEquipesTour.size()/2;
		LinkedList<Match> MatchTour = new LinkedList<Match>();


		for (int i = 0; i<nbmatchs;i++)
		{

			Equipe e1, e2;//Les deux équipes d'un match

			//Verification de l'équipe 1
			if(i!=qualifOffice)
			{
				//Si l'équipe n'est pas qualifiée d'office, on l'ajoute dans le match
				e1 = listeEquipesTour.get(i);
			}
			else 
			{
				//Sinon, on prend l'équipe suivante
				i++;
				e1 = listeEquipesTour.get(i);
			}

			//On passe à l'équipe d'après dans la liste des équipes
			i++;

			//Vérification de l'équipe 2
			if(i!=qualifOffice)
			{
				//Si l'équipe n'est pas qualifiée d'office, on l'ajoute dans le match
				e2 = listeEquipesTour.get(i);
			}
			else 
			{
				//Sinon, on prend l'équipe suivante
				i++;
				e2 = listeEquipesTour.get(i);
			}
			Match rencontre = new Match(e1,e2);
			MatchTour.add(rencontre);

		}
		this.listeMatchTour=MatchTour;
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
		for(int i = 0; i < listeEquipesTour.size(); i++)
		{
			listeEqQualif.add(listeMatchTour.get(i).getGagnant());
		}
		return listeEqQualif;
	}




}
