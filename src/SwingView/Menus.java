package SwingView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Equipe;
import model.Joueur;
import model.TournoiEliminationDirecte;
import model.TournoiParPoules;
import tools.FilesTools;
import controleur.InfoEquipes;


public class Menus{
public static void menuBienvenue() {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
	
		
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 600, 600, 600);
		frame.setLocationRelativeTo(null);
		PanelImagen p = new PanelImagen();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(p);
		
		JLabel label = new JLabel("VOLLEY-BALL");
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Arial", Font.BOLD, 34));
		label.setBackground(Color.WHITE);
		
		String text= "<html>Bienvenue dans le logiciel de gestion de tournoi de volley-ball. <P>"+
				 "<html> Ce programme vous permet de : <P>" +
				 "<html>- saisir les équipes, joueurs et scores de votre tournoi de volley-ball  <P>"+
				 "<html>- gérer un tournoi par élimination directes ou par phase de poules  <P>"+
				 "<html>- générer un tournoi avec des équipes aléatoire <P>";
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: left;\">"+text);
		
	
		instruction.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.getContentPane().add(instruction, BorderLayout.CENTER);
		

		//Creation des buttons
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
                
      
	public static void menuInscription() {
		
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
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                listeEquipes=genererEquipes();
                frame.setVisible(false);
                EquipesGUI.menuEquipes(listeEquipes);
            }
        });   
	
	    JButton b2 = new JButton("Inscription manuel des equipes");
	   
	    b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {   int dialogButton = JOptionPane.YES_NO_OPTION;
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
		
		//On cree un panel pour afficher tous les buttons
		JPanel buttons = new JPanel(new GridLayout(3,1));
		JButton b1 = new JButton("Retourner a l'info d'equipes");
		
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            { EquipesGUI.menuEquipes(listeEquipes);
               
            }
		});
		JButton b2 = new JButton("Tournoi par poules");
		b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	TournoiParPoules tournoi = new TournoiParPoules(listeEquipes);
            	TournoiGUI.gestionTournoiParPoules(tournoi);
            	
            }
		});
		JButton b3 = new JButton("Tournoi par élimination directe");
		b3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {	TournoiEliminationDirecte tournoi = new TournoiEliminationDirecte(listeEquipes);
            	TournoiGUI.gestionTournoi(tournoi,0);
            }
		});
		buttons.add(b3);
		buttons.add(b2);
		buttons.add(b1);
		frame.getContentPane().add(buttons, BorderLayout.PAGE_END);
		
		frame.setVisible(true);
}
	
	public static LinkedList<Equipe> genererEquipes(){
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
		JSONParser parser=new JSONParser();
		String stringFileNomsEquipes;
		try {
			stringFileNomsEquipes = FilesTools.readFile(System.getProperty("user.dir")+"//src//data//nomequipes.json",StandardCharsets.UTF_8);
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