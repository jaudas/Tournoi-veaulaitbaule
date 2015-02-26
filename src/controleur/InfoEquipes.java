package controleur;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

import model.Equipe;
import model.Joueur;
import model.SaveList;
import model.Tournoi;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tools.FilesTools;

public class InfoEquipes {
	//Arraylist 

	static Scanner sc = new Scanner(System.in);

	public static LinkedList<Equipe> inscrireEquipes() throws IOException{
		LinkedList<Equipe> listeEquipe = new LinkedList<Equipe>();
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		//Attributes
		String nom ;
		String description;
		int nbJoueurs = 0;  
		Equipe aux; //Attribut auxilier pour remplir la liste des Equipes
		int i = 0;
		String N;
		int NE = 0;
		String C;
		int CH = 0;


		//On demande l'information de chaque equipe
		//On demande la creation automatique des equipes ou l'option d'introduir l'information de caque equipe
		int opt;
		String OPT;
		boolean option=false;

		//System.out.println("Vous voulez introduir l'information de chaque equipe(1) ou utilizer les equipes pour defaut(2)?");
		//opt=sc.nextInt();//Ajouter vérif saisie

		while (option==false){ 
			do{
				System.out.println("Voulez-vous :\n- introduire les informations de chaque équipe manuellement (tapez 1) \n- utiliser les équipes par défaut (tapez 2) \n- utiliser une liste d'équipe enregistrée auparavent?");
				OPT=sc.nextLine();
				opt = Exception.mauvaisNumero(OPT);
				if ((opt != 1)&&(opt != 2)&&(opt!=3)){
					System.out.println("Saisie incorrecte !");
				}					
			}while ((opt != 1)&&(opt != 2)&&(opt!=3));

			switch (opt){
			case 1:
				System.out.println("-- Saisie manuelle des équipes du tournoi --");
				sc.nextLine();//Netoyer le clavier
				do {
					//On lit l'information de chaque equipe
					System.out.println("ID Equipe: " + i);
					System.out.println("  Nom: ");
					nom = sc.nextLine();
					System.out.println("  Description: ");
					description = sc.nextLine();
					System.out.println("  Nombre de joueurs: ");
					String nJ = sc.nextLine();
					nbJoueurs=Exception.mauvaisNumero(nJ);
					listeJoueurs=inscrireJoueurs(nbJoueurs);
					option=true;
					aux = new Equipe(); //On cree l'object de l'Equipe
					//On attribue un valor a chaque attribute
					aux.setIdEquipe(i);
					aux.setNom(nom);
					aux.setDescription(description);
					aux.setNbJoueurs(nbJoueurs);
					aux.setListeJoueurs(listeJoueurs);

					do{
						System.out.println("Ajouter une équipe supplémentaire? : 0.NON - 1.OUI");
						C = sc.nextLine();
						CH = Integer.parseInt(C);
						if ((CH != 0)||(CH != 1)){
							System.out.println("Choix invalide");
						}

					}while((CH != 0)||(CH != 1));


					listeEquipe.add(aux);
				}while (CH == 1);
				break;

			case 2: System.out.println("-- Création automatique des Equipes -- ");


			JSONParser parser=new JSONParser();
			String stringFileNomsEquipes;
			try {
				stringFileNomsEquipes = FilesTools.readFile(System.getProperty("user.dir")+"//src//data//nomequipes.json",StandardCharsets.UTF_8);
				Object parsedFile = parser.parse(stringFileNomsEquipes);
				JSONArray arrayNomsEquipe = (JSONArray)parsedFile;

				//On demande le nombre d'equipes à inscrire 
				do {
					System.out.print("Combien d'équipes voulez-vous générer automatiquement ? (Max "+arrayNomsEquipe.size()+") : ");
					N = sc.nextLine();

					NE=Exception.mauvaisNumero(N);

					if (NE>arrayNomsEquipe.size()){
						System.out.println("Veuillez saisir un nombre inférieur ou égal à "+arrayNomsEquipe.size()+" :");
					}
				} while ((NE < 0) || (NE > arrayNomsEquipe.size()));

				for (i = 1; i <= NE; i++) {
					nbJoueurs = 6;
					listeJoueurs=inscrireJoueursAuto(nbJoueurs);
					option=true;
					//On cree l'objet temporaire "aux" de type Equipe pour aider a l'initialisation des valeurs
					//On attribue un valor a chaque attribute
					aux = new Equipe(i,arrayNomsEquipe,nbJoueurs,listeJoueurs);
					listeEquipe.add(aux);
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

			break;


			case 3:
				System.out.println("Chargement des listes d'équipes déja existantes ! ");
			//	System.out.println(SaveList.getListeGroupeEquipes());
				listeEquipe = InfoEquipes.choixListeEquipe();
				
				option=true;

				break;

			default:
				System.out.println("Option incorrect!");
				break;
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
				aux = new Joueur(prenom, nomj, age, sexe); //On cree l'object de l'Equipe
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

	public static void questionModif(Tournoi tournoi){
		int rep;

		System.out.println("Souhaitez-vous modifier une équipe ? : 0.NON - 1.OUI");
		rep = sc.nextInt();		
		if (rep == 1){
			modifierEquipes(tournoi.getListeEquipes());
		}		
	}

	public static void modifierEquipes(LinkedList<Equipe> listeEquipe){
		int idEquipe ;
		String nom="";
		String description;


		System.out.println("Choisir l'equipe que vous voulez modifier:");
		idEquipe=sc.nextInt();
		System.out.println("Choisir l'information que vous voulez modifier:");
		System.out.println("1. Nom ");
		System.out.println("2. Joueurs ");
		System.out.println("3. Description ");
		System.out.println("4. Eliminer une équipe :");
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
			System.out.println("Choisir l'action qui vous interese:");
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
				Joueur aux = new Joueur(prenom, nomj, age, sexe);
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
			listeJoueurs.get(nbJoueur-1).convertSexe(sexe);
			break;

		default:
			System.out.println("Essayez une autre fois (Numero incorrecte)");
			modifierJoueur(listeJoueurs);
			break;

		}

	}

	public static LinkedList<Equipe> choixListeEquipe() throws IOException
	{
		LinkedList<Equipe> listeEquipeschargee = new LinkedList<Equipe>();
		String[] listeDocuments = SaveList.getListeGroupeEquipes();
	
		for (int i=0; i<listeDocuments.length; i++)
            System.out.println(i+" : "+listeDocuments[i]);
		
		int choix = -1;
		do {
			System.out.println("Veuillez saisir le numero de la liste à charger : ");
			choix = sc.nextInt();
		}
		while (choix < 0 && choix >listeDocuments.length);

		System.out.println("Vous allez charger la liste : "+listeDocuments[choix]);
		
		listeEquipeschargee = SaveList.loadTeams(listeDocuments[choix]);
		
		
		return listeEquipeschargee;
	}


}
