package controleur;


import java.util.Scanner;




import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
		
	 
	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat de match:");
		  System.out.println("Score "+match.getEquipeA().getNom()+" :");
		  String sA=sc.nextLine();
		  int scoreA=Exception.mauvaisNumero(sA);
		  System.out.println("Score "+match.getEquipeB().getNom()+" :");
		  String sB=sc.nextLine();
		  int scoreB=Exception.mauvaisNumero(sB);
		  if (scoreA==scoreB){
			  System.out.println("Les scores ne sont pas valides, s'il vous plait ajoutez un autre resultat : ");
			  resultMatch(match);
		  }
		  
		  
		  match.setScoreA(scoreA);
		  match.setScoreB(scoreB);
		  match.getGagnant().setNbVictoire(match.getGagnant().getNbVictoire()+1)  ;
		 
	  }
	  
	

}
