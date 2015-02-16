package controleur;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;





import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tools.FilesTools;
import model.Equipe;
import model.Joueur;

public class InfoEquipes {
	//Arraylist 

	static Scanner sc = new Scanner(System.in);

	public static LinkedList<Equipe> inscrireEquipes(){
		LinkedList<Equipe> listeEquipe = new LinkedList<Equipe>();
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		//Attributes
		String nom ;
		String description;
		int nbJoueurs = 0;  
		Equipe aux; //Attribut auxilier pour remplir la liste des Equipes
		int i = 0;
		String N;
		int NE=0;
		//On demande le nombre d'equipes pa incrire 
		do {
			System.out.print("Nombre d'equipes: (ajouter une contrainte sur 40 équipes)");
			N = sc.nextLine();
			NE=exception(N);

		} while (NE < 0);

		//On demande l'information de chaque equipe
		//On demande la creation automatique des equipes ou l'option d'introduir l'information de caque equipe
		int opt;
		boolean option=false;

		System.out.println("Vous voulez introduir l'information de chaque equipe(1) ou utilizer les equipes pour defaut(2)?");
		opt=sc.nextInt();//Ajouter vérif saisie

		while (option==false){ 
			if(opt==2){
				System.out.println("Création automatique des Equipes: ");
				JSONParser parser=new JSONParser();
				String stringFileNomsEquipes;
				try {
					stringFileNomsEquipes = FilesTools.readFile (System.getProperty("user.dir")+"//src//data//nomequipe.json",StandardCharsets.UTF_8);
					Object parsedFile = parser.parse(stringFileNomsEquipes);
					JSONArray arrayNomsEquipe = (JSONArray)parsedFile;

					for (i = 1; i <= NE; i++) {

						description = "Equipe de veaulait";
						nbJoueurs = 6;
						listeJoueurs=inscrireJoueursAuto(nbJoueurs);
						option=true;

						//On cree l'objet temporaire "aux" de type Equipe pour aider a l'initialisation des valeurs
						//On attribue un valor a chaque attribute
						aux = new Equipe(arrayNomsEquipe);
						aux.setIdEquipe(i);
						//aux.setNom(nom); Le nom est donné directement dans la fonction
						aux.setDescription(description);
						aux.setNbJoueurs(nbJoueurs);
						aux.setListeJoueurs(listeJoueurs);
						listeEquipe.add(aux);

						nom="";
					}
				} catch (IOException | ParseException e) {
					e.printStackTrace();

				}
			}
			else if (opt==1){
				sc.nextLine();//Netoyer le clavier
				for (i = 1; i <= NE; i++) {
					//On lit l'information de chaque equipe
					System.out.println("ID Equipe: " + i);
					System.out.println("  Nom: ");
					nom = sc.nextLine();
					System.out.println("  Description: ");
					description = sc.nextLine();
					System.out.println("  Nombre de joueurs: ");
					String nJ = sc.nextLine();
					nbJoueurs=exception(nJ);
					listeJoueurs=inscrireJoueurs(nbJoueurs);
					option=true;
					aux = new Equipe(); //On cree l'object de l'Equipe
					//On attribue un valor a chaque attribute
					aux.setIdEquipe(i);
					aux.setNom(nom);
					aux.setDescription(description);
					aux.setNbJoueurs(nbJoueurs);
					aux.setListeJoueurs(listeJoueurs);

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

		while (nbJoueurs < 0);{
			//Nettoyer le clavier
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
	public static LinkedList<Joueur> inscrireJoueursAuto(int nbJoueurs){
		//Attributes
		Joueur aux;
		LinkedList<Joueur> listeJoueurs= new LinkedList<Joueur>();
		int j;

		while (nbJoueurs < 0);{

			//On demande l'information de chaque equipe
			for (j = 1; j <= nbJoueurs; j++) {
				//On cree l'object de l'Equipe, qui se rempli automatiquement
				aux = new Joueur(); 
				listeJoueurs.add(aux);
			}
		}
		return listeJoueurs;
	}

	public static void modifierEquipes(LinkedList<Equipe> listeEquipe){
		int idEquipe ;
		String nom="";
		String description;


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
			System.out.println("Choisir l'action que vous interese:");
			System.out.println("1. Ajouter un joueur: ");
			System.out.println("2. Modifier un joueur: ");
			System.out.println("3. Eliminer un joueur: ");
			int opt=sc.nextInt();
			switch (opt) {
			case 1:

				sc.nextLine();
				System.out.println("Ajouter un joueur");
				System.out.println("Prenom: ");
				String prenom = sc.nextLine(); 
				System.out.println(" Nom: ");
				String nomj = sc.nextLine();
				System.out.println("Age: ");
				String age = sc.nextLine(); 
				System.out.println("Sexe: ");
				String sexe = sc.nextLine();  
				Joueur aux = new Joueur(); //On cree l'object de l'Equipe
				//On attribue un valor a chaque attribute
				aux.setNom(nomj);
				aux.setPrenom(prenom);
				aux.setAge(age);
				aux.setSexe(sexe);  
				listeEquipe.get(idEquipe-1).getListeJoueurs().add(aux);
				break;
			case 2:
				modifierJoueur(listeEquipe.get(idEquipe).getListeJoueurs());
				break;
			case 3: 
				int nbJoueur=0;

				System.out.println("Choisir le joueur que vous voulez modifier:");
				nbJoueur=sc.nextInt();
				listeEquipe.get(idEquipe-1).getListeJoueurs().remove(nbJoueur);

				break;

			}
			break;

		case 3: 
			sc.nextLine();
			System.out.println("Description:");
			description=sc.nextLine();
			listeEquipe.get(idEquipe-1).setDescription(description);
			break;

		case 4: 

			listeEquipe.remove(idEquipe-1);
			break;

		default:
			System.out.println("Essayez une autre fois (Numero incorrecte)");
			modifierEquipes(listeEquipe);
			break;

		}


	}

	public static void modifierJoueur(LinkedList<Joueur> listeJoueurs ){

		String nom="";
		String prenom="";
		String age = "";
		String sexe ="";
		int nbJoueur=0;

		System.out.println("Choisir le joueur que vous voulez modifier:");
		nbJoueur=sc.nextInt();
		System.out.println("Choisir l'information que vous voulez modifier:");
		System.out.println("1. Nom: ");
		System.out.println("2. Prenom: ");
		System.out.println("3. Age: ");
		System.out.println("4. Sexe: ");
		int option=sc.nextInt();


		switch (option) {

		case 1:
			sc.nextLine();
			System.out.println("nom:");
			nom=sc.nextLine();
			listeJoueurs.get(nbJoueur-1).setNom(nom);
			break;
		case 2:
			sc.nextLine();
			System.out.println("Prenom:");
			prenom=sc.nextLine();
			listeJoueurs.get(nbJoueur-1).setPrenom(prenom);
			break;

		case 3: 
			sc.nextLine();
			System.out.println("Age: ");
			age=sc.nextLine();
			listeJoueurs.get(nbJoueur-1).setAge(age);
			break;
		case 4: 
			sc.nextLine();
			System.out.println("Sexe: ");
			sexe=sc.nextLine();
			listeJoueurs.get(nbJoueur-1).setSexe(sexe);
			break;

		default:
			System.out.println("Essayez une autre fois (Numero incorrecte)");
			modifierJoueur(listeJoueurs);
			break;

		}

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
