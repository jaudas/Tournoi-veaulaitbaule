package view;

import java.util.LinkedList;

import model.Equipe;
import model.Joueur;
public class ConsoleView {

	
	  public static void afficherEquipes(LinkedList<Equipe> listeEquipe){      
	      for(int i = 0; i< listeEquipe.size(); i++){
	          System.out.println(listeEquipe.get(i)); 
	      }
	  }
	  public static void afficherJoueurs(int idEquipe,LinkedList<Joueur> listeJoueurs){      
		  for(int i = 0; i< listeJoueurs.size(); i++)
	    	  System.out.println(listeJoueurs.get(i)); 
		  

	  }

}
