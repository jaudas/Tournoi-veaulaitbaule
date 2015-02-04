package controleur;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


import model.Equipe;
import model.Joueur;
import view.ConsoleView;

public class InfoEquipes {
	  //Arraylist 
	
	  static Scanner sc = new Scanner(System.in);
	
	  
	  public static void main(String[] args) {
	    LinkedList<Equipe> listeEquipe= inscrireEquipes();
	   
		ConsoleView.afficherEquipes(listeEquipe);
		  for(int i = 0; i< listeEquipe.size(); i++){
			  ConsoleView.afficherJoueurs(i, listeEquipe.get(i).getListeJoueurs());
		  }
	      modifierEquipes(listeEquipe);
	      ConsoleView.afficherEquipes(listeEquipe);
	  } 
	 
	  public static LinkedList<Equipe> inscrireEquipes(){
		  LinkedList<Equipe> listeEquipe = new LinkedList<Equipe>();
		  LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
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
	    		  sc.nextLine();//Netoyer le clavier
	    		  for (i = 1; i <= N; i++) {
	    			  
	    			  //On lit l'information de chaque equipe
	    			  System.out.println("ID Equipe: " + i);
	    			  System.out.println("  Nom: ");
	    			  nom = sc.nextLine();
	    			
	    			  System.out.println("  Description: ");
	    			  description = sc.nextLine();
	    			 
	    			  System.out.println("  Nombre de joueurs: ");
	    			  
	    			  nbJoueurs = sc.nextInt();
	    			  
	    			   
	    			  listeJoueurs=inscrireJoueurs(nbJoueurs);
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
	  return listeEquipe;
	  }  
	  
	  public static LinkedList<Joueur> inscrireJoueurs(int nbJoueurs){
	      //Attributes
		   String prenom;
		   String nomj;
		   String age;
		   String sexe;
		   Joueur aux;
		   LinkedList<Joueur> listeJoueurs= new LinkedList<Joueur>();
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
		          
		          listeJoueurs.add(aux);
		          
	      	}
	  	}
		return listeJoueurs;
	}
	  
	  public static void modifierEquipes(LinkedList<Equipe> listeEquipe){
		  	 int idEquipe ;
			 String nom="";
			 String description;
			 int nbJoueurs;
			
			 System.out.println("Choisir l'equipe que vous voulez modifier:");
			 idEquipe=sc.nextInt();
			 System.out.println("Choisir l'information que vous voulez modifier:");
			 System.out.println("1. Nom: ");
			 System.out.println("2. Joueurs: ");
			 System.out.println("3. Description: ");
			 System.out.println("4. Eliminer equipe");
			 int option=sc.nextInt();
			 
			 
			 switch (option) {
			 
			 	case 1:
			 		sc.nextLine();
			 		System.out.println("nom:");
			 		nom=sc.nextLine();
			 		listeEquipe.get(idEquipe-1).setNom(nom);
			 	break;
				case 2:
			 		sc.nextLine();
			 		System.out.println("Nombre de joueurs:");
			 		nbJoueurs=sc.nextInt();
			 		listeEquipe.get(idEquipe-1).setNbJoueurs(nbJoueurs);
			 	break;
			 
				case 3: 
					sc.nextLine();
					System.out.println("Description:");
			 		description=sc.nextLine();
			 		listeEquipe.get(idEquipe-1).setDescription(description);
			 	break;
			
				default:
					System.out.println("Essayez une autre fois (Numero incorrecte)");
					modifierEquipes(listeEquipe);
				break;
			 		
			 }
		  
		  
	  }
	  

	  
}
