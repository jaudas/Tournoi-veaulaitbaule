package view;
import java.util.ArrayList;
import model.Equipe;
public class ConsoleView {

	
	  public static void afficherEquipes(ArrayList<Equipe> listeEquipe){      
	      for(int i = 0; i< listeEquipe.size(); i++)
	          System.out.println(listeEquipe.get(i)); 
	  }
	  
	 



}
