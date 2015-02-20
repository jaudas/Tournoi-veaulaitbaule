package controleur;


import java.util.LinkedList;
import java.util.Scanner;






import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
		
	 
	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat du match:");
		  int scoreA = 0;
		  int scoreB = 0;
		  
		  do{
			  System.out.println("Score de "+match.getEquipeA().getNom()+" :");
			  String sA=sc.nextLine();
			  scoreA=Exception.mauvaisNumero(sA);
			  if (scoreA>3){
				  System.out.println("Un score au volley-ball ne peut �tre sup�rieur � 3. Score incorrect.");
			  }
		  }while (scoreA>3);
		  
		  do{
			  System.out.println("Score de "+match.getEquipeB().getNom()+" :");
			  String sB=sc.nextLine();
			  scoreB=Exception.mauvaisNumero(sB);
			  if (scoreB>3){
				  System.out.println("Un score au volley-ball ne peut �tre sup�rieur � 3. Score incorrect.");
			  }
		  }while (scoreB>3);
		  		  
		  if (scoreA==scoreB){
			  System.out.println(" ! Les scores ne sont pas valides : �galit� impossible au volley-ball.\nS'il vous plait ajoutez un autre resultat : ");
			  resultMatch(match);
		  }
		  		  
		  match.setScoreA(scoreA);
		  match.setScoreB(scoreB);
		  match.getGagnant().setNbVictoire(match.getGagnant().getNbVictoire()+1)  ;
	  }
	  
	  public static void selectionnerMatch(LinkedList<Match> listeMatchsTournoi){
		  System.out.println("Saisissez le num�ro du match auquel vous souhaitez ajouter le score:");
		  String num=sc.nextLine();//Ajouter v�rification de saisie !!!
		  int numero=Exception.mauvaisNumero(num);
		  
		  resultMatch(listeMatchsTournoi.get(numero-1));
		  
		  System.out.println("-- Match "+(numero)+" modifi� : --");
		  System.out.println(listeMatchsTournoi.get(numero-1).toString());
		  System.out.println("Le gagnant du Match est : \n"+listeMatchsTournoi.get(numero-1).getGagnant().toString());		  
		  
	  }


}
