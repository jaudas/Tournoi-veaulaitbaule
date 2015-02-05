package view;

import java.util.LinkedList;

import model.Equipe;
import model.Joueur;
import model.Match;
public class ConsoleView {

	
	  public static void afficherEquipesEtJoueurs(LinkedList<Equipe> listeEquipe){      
	      for(int i = 0; i< listeEquipe.size(); i++){
	          System.out.println(listeEquipe.get(i));
	          afficherJoueurs(i-1, listeEquipe.get(i).getListeJoueurs());
	      }
	  }
	  public static void afficherEquipes(LinkedList<Equipe> listeEquipe){      
	      for(int i = 0; i< listeEquipe.size(); i++){
	          System.out.println(listeEquipe.get(i));
	         
	      }
	  }
	  public static void afficherJoueurs(int idEquipe,LinkedList<Joueur> listeJoueurs){      
		  for(int i = 0; i< listeJoueurs.size(); i++){
			  int nbJoueur=i+1;
	    	  System.out.println(nbJoueur+". " + listeJoueurs.get(i)); 
		  }
	  }
	  public static void afficherMatch(LinkedList<Match> listeMatch){      
	      for(int i = 0; i< listeMatch.size(); i++){
	          System.out.println(listeMatch.get(i)); 
	      }
	  }

}
