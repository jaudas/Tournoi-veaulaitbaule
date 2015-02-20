package controleur;


import java.util.LinkedList;
import java.util.Scanner;






import model.Match;


public class InfoMatch {
	 static Scanner sc = new Scanner(System.in);
	 
	  public static void selectionnerMatch(LinkedList<Match> listeMatchsTournoi){
		  boolean saisieCorrecte;
		  int numero;
		  
		  do{
			  saisieCorrecte = true;
			  System.out.println("Saisissez le num�ro du match auquel vous souhaitez ajouter le score:");
		
			  String num=sc.nextLine();
			  numero=Exception.mauvaisNumero(num);
			  
			  //Si l'utilisateur saisit un match qui a d�j� �t� jou�
			  if (listeMatchsTournoi.get(numero-1).estJoue()){
				  System.out.println("Le match "+numero+" a d�j� �t� jou�. Impossible de modifier son score !");
				  saisieCorrecte = false;
			  }
			  
			}while(saisieCorrecte == false);
		  
		  resultMatch(listeMatchsTournoi.get(numero-1));
		  
		  System.out.println("-- Match "+(numero)+" modifi� : --");
		  System.out.println(listeMatchsTournoi.get(numero-1).toString());
		  System.out.println("Le gagnant du Match est : \n"+listeMatchsTournoi.get(numero-1).getGagnant().toString());		  
		  
	  }

	  public static void resultMatch(Match match){
		  System.out.println("Ajouter le resultat du match:");
		  int scoreA = 0;
		  int scoreB = 0;
		  boolean scoresValides = true;
		  
		  do{  
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
			  scoresValides = true;
			  
			  if (scoreA==scoreB){
				  System.out.println(" ! Les scores ne sont pas valides : �galit� impossible au volley-ball.\nS'il vous plait ajoutez d'autres scores !");
				  scoresValides = false;
			  }
			  else if ((scoreA!=3)&&(scoreB!=3)){
				  System.out.println(" ! Aucune �quipe n'a atteint 3 sets gagn�s : cas impossible au volley-ball.\nS'il vous plait ajoutez d'autres scores !");
				  scoresValides = false;
			  }			  
		  }while(scoresValides == false);
		  
		  match.setScoreA(scoreA);
		  match.getEquipeA().setNbSetGagne(match.getEquipeA().getNbSetGagne()+scoreA);
		  
		  match.setScoreB(scoreB);
		  match.getEquipeB().setNbSetGagne(match.getEquipeB().getNbSetGagne()+scoreB);
		  
		  match.getGagnant().setNbVictoire(match.getGagnant().getNbVictoire()+1);
	  }
	  
}
