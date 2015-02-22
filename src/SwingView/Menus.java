package SwingView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Equipe;
import model.Joueur;
import model.Match;
import model.Poule;
import model.Tournoi;
import model.TournoiEliminationDirecte;
import model.TournoiParPoules;
import tools.FilesTools;
import controleur.InfoEquipes;


public class Menus{
public void menuBienvenue() {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Bonjour ! Bienvenue dans le logiciel de gestion de tournoi de volley-ball.");
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		label.setBackground(Color.WHITE);
		
		String text= "<html>Ce programme vous permet de : <P>" +
				 "<html>- saisir les équipes, joueurs et scores de votre tournoi de volley-ball  <P>"+
				 "<html>- gérer un tournoi par élimination directes ou par phase de poules  <P>"+
				 "<html>- générer un tournoi avec des équipes aléatoire <P>";
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\">"+text);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Arial", Font.ITALIC, 22));
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.getContentPane().add(instruction, BorderLayout.CENTER);
		
		
		
		
		
		JButton b1 = new JButton("Commencer le tournoi");
		frame.getContentPane().add(b1, BorderLayout.PAGE_END);
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Executer quand le buton est premu
                menuInscription();
            }
		});
		
		frame.setVisible(true);
}
                
      
	public void menuInscription() {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Inscription des equipes");
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		label.setBackground(Color.WHITE);
		
		String text= "<html>Vous pouves choisir la creation automatique des equipes <P>" +
				 "<html>ou incrire les equipes manualment: <P>";
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\">"+text);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Arial", Font.ITALIC, 22));
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.getContentPane().add(instruction, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new GridLayout(0, 1, 0, 3));
		
		frame.getContentPane().add(buttons, BorderLayout.PAGE_END);
		
		JButton b1 = new JButton("Creation automatique des equipes");
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                listeEquipes=genererEquipes();
                frame.setVisible(false);
                EquipesGUI.menuEquipes(listeEquipes);
                
            }
        });   
	
	    JButton b2 = new JButton("Inscription manuel des equipes");
	   
	    b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
      
            	//Execute when button is pressed
            	int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Vous voulez ajouter le premier equipe?","Warning",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){ 
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                frame.setVisible(false);
                
                
                EquipesGUI.newEquipe(listeEquipes);
               
                }else if(dialogResult==JOptionPane.NO_OPTION){
                	menuInscription();
                }
                
            }
        });   
	
		
		buttons.add(b1);
		buttons.add(b2);
		frame.setVisible(true);
		
}
	
public static void menuTournoi(LinkedList<Equipe> listeEquipes) {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Creation du tornoi");
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		label.setBackground(Color.WHITE);
		
		String text= "<html>Vous voulez gérer un tournoi par élimination<P>" +
				 "<html> directe ou par phase de poules?  <P>"+
				 "<html> A partir de cet moment les equipes ne pouvant pas être eliminé  <P>"+
				 "<html> seulment modifies. <P>";
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\">"+text);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Arial", Font.ITALIC, 22));
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.getContentPane().add(instruction, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new GridLayout(3,1));
		
		
		
		JButton b1 = new JButton("Retourner a l'info d'equipes");
		frame.getContentPane().add(b1, BorderLayout.PAGE_END);
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
               
            }
		});
		JButton b2 = new JButton("Tournoi par poules");
		frame.getContentPane().add(b2, BorderLayout.PAGE_END);
		b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	TournoiParPoules tournoi = new TournoiParPoules(listeEquipes);
            	
            	menuGestionTournoiParPoules(tournoi);
            	
            }
		});
		JButton b3 = new JButton("Tournoi par élimination directe");
		frame.getContentPane().add(b1, BorderLayout.PAGE_END);
		b3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {	Tournoi tournoi = new Tournoi();
            	tournoi = new TournoiEliminationDirecte(listeEquipes);
            	
            }
		});
		buttons.add(b3);
		buttons.add(b2);
		buttons.add(b1);
		frame.getContentPane().add(buttons, BorderLayout.PAGE_END);
		
		frame.setVisible(true);
}



public static void menuGestionTournoi(Tournoi tournoi) {
	
	JFrame frame = new JFrame("Tournoi du veaulait");
	frame.setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(500, 500, 500, 300);
	frame.setLocationRelativeTo(null);
	
	JLabel label = new JLabel("Grups");
	label.setHorizontalAlignment(0);
	label.setFont(new Font("Arial", Font.PLAIN, 34));
	label.setBackground(Color.WHITE);



	
	JPanel main = new JPanel(new GridLayout(1,2));
	
	//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
		Object[][] data = new Object[listeMatchs.size()][4];
		 //array de String's con los títulos de las columnas
		 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
		 for (int i = 0; i < listeMatchs.size() ; i++){
			 
			 data[i][0]= listeMatchs.get(i).getEquipeA().getNom();
			 data[i][1]= listeMatchs.get(i).getScoreA();
			 data[i][2]= listeMatchs.get(i).getScoreB();
			 data[i][3]= listeMatchs.get(i).getEquipeB().getNom();			
		 }
			 
		 
		 //se crea la Tabla
		 final JTable table = new JTable(data, columnNames);

		 table.setEnabled(false);
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(table); 
		 main.add(scrollPane);
		 
	JPanel buttons = new JPanel(new GridLayout (4,1));
	
	JButton b1 = new JButton("Saisir des résultat des matches joués");
	frame.getContentPane().add(b1, BorderLayout.CENTER);
	b1.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
           
        }
	});
	JButton b2 = new JButton("Afficher des résultat des match joués");
	frame.getContentPane().add(b2, BorderLayout.PAGE_END);
	b2.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
        	
        }
	});
	JButton b3 = new JButton("Afficher/Modifier des equipes");
	frame.getContentPane().add(b1, BorderLayout.PAGE_END);
	b3.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {	Tournoi tournoi = new Tournoi();
        	tournoi = new TournoiEliminationDirecte(tournoi.getListeEquipes());
        	
        }
	});
	buttons.add(b3);
	buttons.add(b2);
	buttons.add(b1);
	main.add(buttons);
	frame.add(main);
	main.setVisible(true);
	
	frame.setVisible(true);
}



public static void menuGestionTournoiParPoules(TournoiParPoules tournoi) {
	
	JFrame frame = new JFrame("Tournoi du veaulait");
	frame.setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(1000,1000,1000,1000);
	frame.setLocationRelativeTo(null);
	

	JPanel main = new JPanel(new GridLayout(2,1));
	
	
	
	ArrayList <Poule> listePoules = tournoi.getListePoules();
	int nbGP=listePoules.size();
	JPanel poules = new JPanel (new GridLayout(1,nbGP));
	for(int j=0; j<nbGP; j++){
	Poule pouleAffichage= listePoules.get(j);
	Object[][] data = new Object[pouleAffichage.getEquipesPoule().size()][1];
	 //array de String's con los títulos de las columnas
	 String[] columnNames = {"Group" + nbGP};
	 for (int i = 0; i < pouleAffichage.getEquipesPoule().size() ; i++){
		 
		 data[i][0]= pouleAffichage.getEquipesPoule().get(i).getNom();		
	 }
	
	
	 
	 //se crea la Tabla
	 final JTable table = new JTable(data, columnNames);

	 table.setEnabled(false);
	 JScrollPane scrollPane = new JScrollPane();
	 scrollPane.setViewportView(table); 
	 poules.add(scrollPane);
	}
	main.add(poules);

	
	
	JPanel gestor = new JPanel(new GridLayout(1,2));
	
	//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
		Object[][] data = new Object[listeMatchs.size()][4];
		 //array de String's con los títulos de las columnas
		 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
		 for (int i = 0; i < listeMatchs.size() ; i++){
			 
			 data[i][0]= listeMatchs.get(i).getEquipeA().getNom();
			 data[i][1]= listeMatchs.get(i).getScoreA();
			 data[i][2]= listeMatchs.get(i).getScoreB();
			 data[i][3]= listeMatchs.get(i).getEquipeB().getNom();			
		 }
			 
		 
		 //se crea la Tabla
		 final JTable table = new JTable(data, columnNames);

		 table.setEnabled(false);
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(table); 
		 gestor.add(scrollPane);
		 
	JPanel buttons = new JPanel(new GridLayout (4,1));
	
	JButton b1 = new JButton("Saisir des résultat des matches joués");
	

	b1.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
           
        }
	});
	JButton b2 = new JButton("Afficher des résultat des match joués");
	
	b2.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
        	
        }
	});
	JButton b3 = new JButton("Afficher/Modifier des equipes");

	b3.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {	Tournoi tournoi = new Tournoi();
        	tournoi = new TournoiEliminationDirecte(tournoi.getListeEquipes());
        	
        }
	});
	buttons.add(b3);
	buttons.add(b2);
	buttons.add(b1);
	gestor.add(buttons);
	gestor.setVisible(true);
	main.add(gestor);
	frame.getContentPane().add(main);
	main.setVisible(true);
    frame.setVisible(true);
}
	
	public static LinkedList<Equipe> genererEquipes(){
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
		JSONParser parser=new JSONParser();
		String stringFileNomsEquipes;
		try {
			stringFileNomsEquipes = FilesTools.readFile (System.getProperty("user.dir")+"//src//data//nomequipe.json",StandardCharsets.UTF_8);
			Object parsedFile = parser.parse(stringFileNomsEquipes);
			JSONArray arrayNomsEquipe = (JSONArray)parsedFile;
			int NE;
			int i;
			//On demande le nombre d'equipes à inscrire 
			do {
				NE = QuestionsDialogues.introNumero( "Combien d'équipes voulez-vous générer automatiquement ?: ");
				
				if (NE>arrayNomsEquipe.size()){
					
					NE =QuestionsDialogues.introNumero( "Trop d'equipes. Combien d'équipes voulez-vous générer automatiquement ?: ");
				
				}
			
				
			} while ((NE < 0) || (NE > arrayNomsEquipe.size()));
			
			for ( i = 1; i <= NE; i++) {

				String description = "Equipe de volley-ball";
				int nbJoueurs = 6;
				listeJoueurs=InfoEquipes.inscrireJoueursAuto(nbJoueurs);
				
				//On cree l'objet temporaire "aux" de type Equipe pour aider a l'initialisation des valeurs
				//On attribue un valor a chaque attribute
				Equipe aux = new Equipe(arrayNomsEquipe);
				aux.setIdEquipe(i);
				//aux.setNom(nom); Le nom est donné directement dans la fonction
				aux.setDescription(description);
				aux.setNbJoueurs(nbJoueurs);
				aux.setListeJoueurs(listeJoueurs);
				listeEquipes.add(aux);

				}
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	}
		return listeEquipes;
		
	}
		
	
	
	
	
	

	
	
	
public static void main(String[] args) {
Menus menu = new Menus();
javax.swing.SwingUtilities.invokeLater(new Runnable() {
public void run() { menu.menuBienvenue(); }
});
}
}