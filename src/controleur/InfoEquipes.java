package controleur;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import model.Equipe;
import model.Joueur;

public class InfoEquipes {
	  //Arraylist 
	  static ArrayList<Equipe> listeEquipe = new ArrayList<Equipe>();
	  static ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	  static Scanner sc = new Scanner(System.in);
	 
	  public static void main(String[] args) {
	      inscrireEquipes();
	   
	  } 
	 
	  public static void inscrireEquipes(){
	      //Attributes
		
		 String nom ;
		 String description;
		 
		 int nbJoueurs = 0;
	      
	      Equipe aux;
	      int i = 0, N;
	      //On demande le nombre d'equipes pa incrire 
	      do {
	          System.out.print("Nombre d'equipes: ");
	          N = sc.nextInt();
	      } while (N < 0);
	      sc.nextLine(); //Nettoyer le clavier
	      //On demande l'information de chaque equipe
	      //On demande la creation automatique des equipes ou l'option d'introduir l'information de caque equipe
	      int opt;
	      boolean option=false;
	      System.out.println("Vous voulez introduir l'information de chaque equipe(1) ou utilizer les equipes pour defaut(2)?");
	      opt=sc.nextInt();
	      while (option==false){
	    	  if(opt==2){
	    		  for (i = 1; i <= N; i++) {
	    	          //Creation d'un equipe aleatoire
	    	          //System.out.println("ID Equipe: " + i);
	    	          nom="";
	    			  char n='0'; 
	    	          Random rnd = new Random(); 
	    	          	for (int k=0; k < 5 ; k++) { 
	    	        	  n = (char)(rnd.nextDouble() * 26.0 + 65.0 ); 
	    	        	  nom += n;
	    	        	  
	    	          }	
	    	          description = "Equipe du veaulait";
	    	          nbJoueurs = 5;
	    	          option=true;
	    	          
	    	          aux = new Equipe(); //On cree l'object de l'Equipe aux(auxilier) pour aider a l'attribution des valeur
	    	          //On attribue un valor a chaque attribute
	    	          aux.setIdEquipe(i);
	    	          aux.setNom(nom);
	    	          aux.setDescription(description);
	    	          aux.setNbJoueurs(nbJoueurs);
	    	          aux.setListeJoueurs(listeJoueurs);
	    	         //On 
	    	          listeEquipe.add(aux);
	    	          nom="";
	    		  }
	    	  }
	    	  else if (opt==1){
	    		  for (i = 1; i <= N; i++) {
	    			  //On lit l'information de chaque equipe
	    			  System.out.println("ID Equipe: " + i);
	    			  System.out.println("  Nom: ");
	    			  nom = sc.nextLine();
	    			  sc.nextLine();
	    			  System.out.println("  Description: ");
	    			  description = sc.nextLine();
	    			  System.out.println("  Nombre de joueurs: ");
	    			  nbJoueurs = sc.nextInt();
	    			   
	    			  inscrireJoueurs(nbJoueurs);
	    			  option=true;
	    			   aux = new Equipe(); //On cree l'object de l'Equipe
	    		          //On attribue un valor a chaque attribute
	    		          aux.setIdEquipe(i);
	    		          aux.setNom(nom);
	    		          aux.setDescription(description);
	    		          aux.setNbJoueurs(nbJoueurs);
	    		          aux.setListeJoueurs(listeJoueurs);
	    		         //On 
	    		          listeEquipe.add(aux);
    		  }
	    	  }
      
	  }
	  
	  }  
	  
	  public static void inscrireJoueurs(int nbJoueurs){
	      //Attributes
		   String prenom;
		   String nomj;
		   String age;
		   String sexe;
		   Joueur aux;
	      int j;
	      
	      while (nbJoueurs < 0);
	      {sc.nextLine(); //Nettoyer le clavier
	      //On demande l'information de chaque equipe
	      	for (j = 1; j <= nbJoueurs; j++) {
		          //On lis l'information de chaque equip
		          System.out.println(" Joueur "+ j);
		          System.out.println("Prenom: ");
		          prenom = sc.nextLine();          
		          System.out.println(" Nom: ");
		          nomj = sc.nextLine();
		          System.out.println("Age: ");
		          age = sc.nextLine();          
		          System.out.println("Sexe: ");
		          sexe = sc.nextLine();
		          
		          aux = new Joueur(); //On cree l'object de l'Equipe
		          //On attribue un valor a chaque attribute
		          aux.setNom(nomj);
		          aux.setPrenom(prenom);
		          aux.setAge(age);
		          aux.setSexe(sexe);
		          
		         //On 
		          listeJoueurs.add(aux);
	      	}
	  	}
	}
	  
	  public static void modifierEquipes(ArrayList<Equipe> listeEquipe){
		  	 int idEquipe ;
			 String nom ;
			 String description;
			 int nbVictoire;
			 int nbButMarque;
			 int nbJoueurs;
			 System.out.println("Choisir l'equipe que vous voulez modifier:");
			 idEquipe=sc.nextInt();
			 System.out.println("Choisir l'information que vous voulez modifier:");
			 System.out.println("1. Nom: ");
			 System.out.println("2. Description: ");
			 System.out.println("3. Joueurs: ");
			 System.out.println("4. Eliminer equipe");
			 switch
			 case 
		  
		  
	  }
	  
}
