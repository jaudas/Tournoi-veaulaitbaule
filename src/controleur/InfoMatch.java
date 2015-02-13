package controleur;


import java.util.Scanner;




import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
		
	 
	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat de match:");
		  System.out.println("Score "+match.getEquipeA().getNom()+" :");
		  String sA=sc.nextLine();
		  int scoreA=exception(sA);
		  System.out.println("Score "+match.getEquipeB().getNom()+" :");
		  String sB=sc.nextLine();
		  int scoreB=exception(sB);
		  if (scoreA==scoreB){
			  System.out.println("Les scores ne sont pas valides, s'il vous plait ajoutez un autre resultat : ");
			  resultMatch(match);
		  }
		  
		  
		  match.setScoreA(scoreA);
		  match.setScoreB(scoreB);
		  match.getGagnant().setNbVictoire(match.getGagnant().getNbVictoire()+1)  ;
		 
	  }
	  
	  public static int exception(String str){
		  
		  int num=0;
			try{
		        	num=Integer.parseInt(str);
		    	}catch(NumberFormatException ex){
		        	System.out.println("Ce n'est pas un numero!  ");
		        	System.out.println("Veuillez saisir un nombre :");
		        	str=sc.nextLine();
		        	exception(str);
		        	
		    	}
			num=Integer.parseInt(str);
	 return  num; 
	  } 
		

}
