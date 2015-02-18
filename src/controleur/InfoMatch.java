package controleur;


import java.util.LinkedList;
import java.util.Scanner;






import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
		
	 
	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat du match:");
		  System.out.println("Score de "+match.getEquipeA().getNom()+" :");
		  String sA=sc.nextLine();
		  int scoreA=Exception.mauvaisNumero(sA);
		  
		  System.out.println("Score de "+match.getEquipeB().getNom()+" :");
		  String sB=sc.nextLine();
		  int scoreB=Exception.mauvaisNumero(sB);
		  
		  if (scoreA==scoreB){
			  System.out.println(" ! Les scores ne sont pas valides : égalité impossible au volley-ball.\nS'il vous plait ajoutez un autre resultat : ");
			  resultMatch(match);
		  }
		  		  
		  match.setScoreA(scoreA);
		  match.setScoreB(scoreB);
		  match.getGagnant().setNbVictoire(match.getGagnant().getNbVictoire()+1)  ;
	  }
	  
	  public static void selectionnerMatch(LinkedList<Match> listeMatchsTournoi){
		  System.out.println("Saisissez le numéro du match auquel vous souhaitez ajouter le score:");
		  String num=sc.nextLine();
		  int numero=Exception.mauvaisNumero(num);
		  
		  resultMatch(listeMatchsTournoi.get(numero-1));
		  
		  System.out.println("-- Match "+(numero)+" modifié : --");
		  System.out.println(listeMatchsTournoi.get(numero-1).toString());
		  System.out.println("Le gagnant du Match est : \n"+listeMatchsTournoi.get(numero).getGagnant().toString());		  
		  
	  }


}
