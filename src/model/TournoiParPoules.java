package model;

import java.util.ArrayList;
import controleur.Poule;

import controleur.Poule;


public class TournoiParPoules extends Tournoi {
	int nbPoules;
	ArrayList<Poule> listePoules = new ArrayList<Poule>();

	//Constructeur
	public TournoiParPoules()
	{
		super();
	}

	public TournoiParPoules(int nbeq, String descr)
	{
		super.nbEquipesInit= nbeq;
		super.description = descr;

		//Calcul du nombre de poules necessaires
		int nbpoul = nbeq/4;//Nb poules compl�tes
		System.out.println("Reste : "+(nbeq%4));
		if (nbeq%4 != 0)//S'il reste des �quipes
		{
			this.nbPoules = nbpoul+1;
		}
		else
		{
			this.nbPoules = nbpoul;
		}
		System.out.println("Le nombre de poules � cr�er est : "+this.nbPoules);
	
		/*
		LinkedList<Equipe> listEq = new LinkedList<Equipe>();
		super.listeEquipesEnJeu = listEq;

		LinkedList<Match> listMatch = new LinkedList<Match>();
		super.listeMatchs = listMatch;
		*/
	}
	

	//M�thodes
	@Override
	public String toString()
	{
		String str = super.toString() + "Il est compos� d'une phase de qualifications par poules de 4 �quipes, puis d'une phase finale. \n Description : " + super.description;
		return str;
	}

		//Cr�er les poules du tournoi
	public ArrayList<Poule> creerPoules(ArrayList<Equipe> listeEquipes)
	{		
		int cptPoules = this.nbPoules;
		int numPoule=1;
		while (cptPoules>0){ 
			//On cr�e une liste vide d'�quipes qui va �tre attribu� � une poule
			ArrayList<Equipe> equipesPoule = new ArrayList<Equipe>() ;
			
			int ind=0;
			
			while ((equipesPoule.size()<4) && (listeEquipes.isEmpty() == false))
			{
				//Trouver une �quipe au hasard dans la liste d'�quipes
				ind = (int) ((Math.random())*listeEquipes.size());
				System.out.println(ind);

				//Ajouter l'�quipe choisie dans une poule
				equipesPoule.add(listeEquipes.get(ind));
				
				
				System.out.println("Ajout de l'�quipe "+listeEquipes.get(ind).toString()+" dans la poule.");
				//listeEquipes.get(ind).toString();//Affichage de l'�quipe s�lectionn�e pour la poule
				
				listeEquipes.remove(ind);//Suppression de l'�quipe dans la liste des �quipes du tournoi
			}			
			
			//System.out.println("Creation d'une poule");
			Poule poule = new Poule ("Poule "+numPoule+"", equipesPoule);
			if (poule!=null)
			{
				listePoules.add(poule);
				System.out.println("Poule "+numPoule+" ajout�e !");
			}
			numPoule ++;
			cptPoules --;
		}

		return listePoules;
	}
	
	public static void main (String [] arg){
		Equipe e1 = new Equipe ("Jaune", 4, 6);
		Equipe e2 = new Equipe ("Bleu", 3, 7);
		Equipe e3 = new Equipe ("Rouge", 5, 4);
		Equipe e4 = new Equipe ("Vert", 0, 3);
		Equipe e5 = new Equipe ("Cyan", 1, 2);
		Equipe e6 = new Equipe ("Rose", 1, 3);
		Equipe e7 = new Equipe ("Marron", 2, 4);
		Equipe e8 = new Equipe ("Orange", 6, 6);
		Equipe e9 = new Equipe ("Blanc", 0, 2);
		Equipe e10 = new Equipe ("Noir", 4, 5);
		
		ArrayList<Equipe> eDT = new ArrayList<Equipe> ();
		//eDT.add(e1);
		//eDT.add(e2);
		//eDT.add(e3);
		eDT.add(e4);
		eDT.add(e5);
		eDT.add(e6);
		//eDT.add(e7);
		//eDT.add(e8);
		eDT.add(e9);
		//eDT.add(e10);
		
		TournoiParPoules tournoi = new TournoiParPoules (eDT.size(), "Tournoi numero 1");
		
		tournoi.creerPoules(eDT);
		System.out.println("Fin cr�ation des poules.");	
		Poule pouleTest = tournoi.listePoules.get(0);
		pouleTest.classerEquipes();
		for (int i=0; i<pouleTest.getEquipesPoule().size(); i++){
			System.out.println("Equipe "+i+": "+pouleTest.getEquipesPoule().get(i).getNom());
		}		
		
	}
}
