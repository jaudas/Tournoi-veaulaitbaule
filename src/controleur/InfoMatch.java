package controleur;


import java.util.Scanner;


import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
		
	 
	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat de match:");
		  System.out.println("Score "+match.getEquipeA().getNom()+" :");
		  int scoreA=sc.nextInt();
		  System.out.println("Score "+match.getEquipeB().getNom()+" :");
		  int scoreB=sc.nextInt();
		  if (scoreA==scoreB){
			  System.out.println("Les scores ne sont pas valids, si vous plait ajouter un autre resultat");
			  resultMatch(match);
		  }
		  match.setScoreA(scoreA);
		  match.setScoreB(scoreB);
		  
	  }
		

}
