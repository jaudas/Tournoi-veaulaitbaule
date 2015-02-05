package model;

import java.util.ArrayList;

public class TournoiParPoules extends Tournoi {
	int nbPoules;
	ArrayList<Poule> listePoules = new ArrayList<Poule>();
	ArrayList<Equipe> eqPhaseEliminatoire = new ArrayList<Equipe>();//Liste des équipes qualifiées pour les phases finales 

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
		int nbpoul = nbeq/4;//Nb poules complètes
		System.out.println("Reste : "+(nbeq%4));
		if (nbeq%4 != 0)//S'il reste des équipes
		{
			this.nbPoules = nbpoul+1;
		}
		else
		{
			this.nbPoules = nbpoul;
		}
		System.out.println("Le nombre de poules à créer est : "+this.nbPoules);
	
		/*
		LinkedList<Equipe> listEq = new LinkedList<Equipe>();
		super.listeEquipesEnJeu = listEq;

		LinkedList<Match> listMatch = new LinkedList<Match>();
		super.listeMatchs = listMatch;
		*/
	}
	

	//Méthodes
	@Override
	public String toString()
	{
		String str = super.toString() + "Il est composé d'une phase de qualifications par poules de 4 équipes, puis d'une phase finale. \n Description : " + super.description;
		return str;
	}

		//Créer les poules du tournoi
	public ArrayList<Poule> creerPoules(ArrayList<Equipe> listeEquipes)
	{		
		int cptPoules = this.nbPoules;
		int numPoule=1;
		while (cptPoules>0){ 
			//On crée une liste vide d'équipes qui va être attribué à une poule
			ArrayList<Equipe> equipesPoule = new ArrayList<Equipe>() ;
			
			int ind=0;
			
			while ((equipesPoule.size()<4) && (listeEquipes.isEmpty() == false))
			{
				//Trouver une équipe au hasard dans la liste d'équipes
				ind = (int) ((Math.random())*listeEquipes.size());
				System.out.println(ind);

				//Ajouter l'équipe choisie dans une poule
				equipesPoule.add(listeEquipes.get(ind));
				
				
				System.out.println("Ajout de l'équipe "+listeEquipes.get(ind).toString()+" dans la poule.");
				//listeEquipes.get(ind).toString();//Affichage de l'équipe sélectionnée pour la poule
				
				listeEquipes.remove(ind);//Suppression de l'équipe dans la liste des équipes du tournoi
			}			
			
			//System.out.println("Creation d'une poule");
			Poule poule = new Poule ("Poule "+numPoule+"", equipesPoule);
			if (poule!=null)
			{
				listePoules.add(poule);
				System.out.println("Poule "+numPoule+" ajoutée !");
			}
			numPoule ++;
			cptPoules --;
		}

		return listePoules;
	}
	
	//Ordonner les équipes qualifiées pour les phases éliminatoires dans une liste
	public ArrayList<Equipe> creerEqQualifiees (){		
		int ind=0;
		System.out.println(listePoules.size());
		
		/*
		while (ind<listePoules.size()-1){
			eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule().get(0));
			System.out.println("Equipe ajoutee : "+listePoules.get(ind).getEquipesPoule().get(0).getNom());
			
			//S'il y a une poule suivante dans la liste & S'il y a une équipe 2 dans la poule suivante de la liste	
			if (listePoules.get(ind+1).getEquipesPoule().get(1) != null){
				System.out.println("Debut de l'ajout");
				eqPhaseEliminatoire.add(listePoules.get(ind+1).getEquipesPoule().get(1));
				System.out.println("Equipe ajoutee aussi : "+listePoules.get(ind+1).getEquipesPoule().get(1).getNom());
							
			}
			ind ++;	
		}
		*/
		//On ajoute la première équipe de la première poule
		eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule().get(0));
		
		while(ind<listePoules.size()-1){
			ind ++;
			//On regarde s'il y a une deuxième équipe dans la poule suivante
			if(listePoules.get(ind).getEquipesPoule().size()>1){
				eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule().get(1));
			}
			//On ajoute la première équipe de la poule suivante
			eqPhaseEliminatoire.add(listePoules.get(ind).getEquipesPoule().get(0));
		}
		
		eqPhaseEliminatoire.add(listePoules.get(0).getEquipesPoule().get(1));
		System.out.println("Ajout de la derniere equipe ! "+listePoules.get(0).getEquipesPoule().get(1));
		
		System.out.println(eqPhaseEliminatoire.size());
		return eqPhaseEliminatoire;
	}
	
	//Déroulement d'un tournoi lors des phases de poules
	public void deroulementTournoiPoule(){
		
	}
	
	//Classer chaque poule du tournoi
	public ArrayList<Poule> classerEqPoules (){
		for (int ind = 0; ind <listePoules.size(); ind++ ){
			listePoules.get(ind).classerEquipes();
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
		//Equipe e10 = new Equipe ("Noir", 4, 5);
		
		ArrayList<Equipe> eDT = new ArrayList<Equipe> ();
		eDT.add(e1);
		eDT.add(e2);
		eDT.add(e3);
		eDT.add(e4);
		eDT.add(e5);
		eDT.add(e6);
		eDT.add(e7);
		eDT.add(e8);
		eDT.add(e9);
		//eDT.add(e10);
		
		TournoiParPoules tournoi = new TournoiParPoules (eDT.size(), "Tournoi numero 1");
		
		tournoi.creerPoules(eDT);
		System.out.println("Fin création des poules.");	
		tournoi.classerEqPoules();
		Poule pouleTest = tournoi.listePoules.get(0);
		Poule pouleTest2 = tournoi.listePoules.get(1);
		Poule pouleTest3 = tournoi.listePoules.get(2);
		
		System.out.println("Poule 1");
		for (int i=0; i<pouleTest.getEquipesPoule().size(); i++){
			System.out.println("Equipe "+i+": "+pouleTest.getEquipesPoule().get(i).getNom());
		}
		
		System.out.println("\nPoule 2");
		for (int i=0; i<pouleTest2.getEquipesPoule().size(); i++){
			System.out.println("Equipe "+i+": "+pouleTest2.getEquipesPoule().get(i).getNom());
		}
		
		System.out.println("\nPoule 3");
		for (int i=0; i<pouleTest3.getEquipesPoule().size(); i++){
			System.out.println("Equipe "+i+": "+pouleTest3.getEquipesPoule().get(i).getNom());
		}
		
		tournoi.creerEqQualifiees();
		for (int i=0; i< tournoi.eqPhaseEliminatoire.size(); i++){
			System.out.println("Equipe "+i+": "+tournoi.eqPhaseEliminatoire.get(i).toString());
		}
		
	}
}
