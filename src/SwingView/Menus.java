package SwingView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Equipe;
import model.SaveList;
import model.TournoiEliminationDirecte;
import model.TournoiParPoules;


public class Menus{

public static void menuBienvenue() {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setMaximumSize(new Dimension(500, 500));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
	
		
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 600, 600, 600);
		frame.setLocationRelativeTo(null);
		PanelImagen1 p = new PanelImagen1();
		p.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.setContentPane(p);
		
		JLabel label = new JLabel("VOLLEY-BALL");
		label.setBounds(165, 130, 252, 52);
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Microsoft Tai Le", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: left;\"><html>Bienvenue dans le logiciel de gestion de tournoi de volley-ball. <P><html> Ce programme vous permet de : <P><html>- saisir les \u00E9quipes, joueurs et scores de votre tournoi de volley-ball  <P><html>- g\u00E9rer un tournoi par \u00E9limination directe ou par phase de poules  <P><html>- g\u00E9n\u00E9rer un tournoi avec des \u00E9quipes al\u00E9atoires <P>");
		instruction.setBounds(6, 183, 572, 192);
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		instruction.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		p.setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(instruction);
		

		//Creation des buttons
		JButton b1 = new JButton("Commencer le tournoi");
		b1.setBounds(206, 377, 187, 28);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.getContentPane().add(b1);
		b1.setMaximumSize(new Dimension(50, 28));
		b1.setMinimumSize(new Dimension(50, 28));
		b1.setPreferredSize(new Dimension(50, 28));
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Executer quand le buton est premu
                menuInscription();
                frame.setVisible(false);
            }
		});
		
		frame.setVisible(true);
}
                
      

	public static void menuInscription() {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 600, 600, 600);
		frame.setLocationRelativeTo(null);
		PanelImagen1 p = new PanelImagen1();
		p.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.setContentPane(p);
		

		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\"><html>Vous pouves choisir la creation automatique des  <P><html>equipes ou incrire les equipes manualment: <P>");
		instruction.setBounds(6, 171, 572, 143);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		p.setLayout(null);
		
		JLabel label = new JLabel("Inscription des équipes");
		label.setBounds(70, 112, 434, 50);
		p.add(label);
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Microsoft Tai Le", Font.BOLD, 38));
		label.setBackground(Color.WHITE);
		frame.getContentPane().add(instruction);
		
		JPanel buttons = new JPanel();
		buttons.setBounds(70, 375, 468, 66);
		buttons.setOpaque(false);
		
		frame.getContentPane().add(buttons);
		
		JButton b1 = new JButton("Création automatique des équipes");
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {   
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                listeEquipes=EquipesGUI.genererEquipes();
                frame.setVisible(false);
                EquipesGUI.menuEquipes(listeEquipes,true);
            }
        });   
	
	    JButton b2 = new JButton("Inscription manuelle des équipes");
	   
	    b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {   int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous ajouter la première équipe?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){ 
                	LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                	frame.setVisible(false);
                	EquipesGUI.newEquipe(listeEquipes,true);
               
                }else if(dialogResult==JOptionPane.NO_OPTION){
                	menuInscription();
                }
            }
        });   
		JButton b3 = new JButton("Utiliser une liste d'équipes enregistrée");
		b3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {   frame.dispose();
            	selectionerFitxer();
            	
               
            }
        }); 
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttons.add(b3);
		buttons.add(b1);
		buttons.add(b2);
		frame.setVisible(true);
		
}
	

public static void menuTournoi(LinkedList<Equipe> listeEquipes) {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 600, 600, 600);
		frame.setLocationRelativeTo(null);
		PanelImagen1 p = new PanelImagen1();
		p.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.setContentPane(p);
		JLabel label = new JLabel("Création du tournoi");
		label.setBounds(112, 106, 348, 110);
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Microsoft Tai Le", Font.BOLD, 38));
		label.setBackground(Color.WHITE);
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\"><html>Vous voulez g\u00E9rer un tournoi par \u00E9limination<P><html> directe ou par phase de poules?  <P><html> A partir de cet moment les equipes ne pouvant <P><html> pas \u00EAtre elimin\u00E9  seulment modifies. <P>");
		instruction.setBounds(-13, 159, 610, 241);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Microsoft Tai Le", Font.BOLD, 22));
		p.setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(instruction);
		
		//On cree un panel pour afficher tous les buttons
		JPanel buttons = new JPanel(new GridLayout(3,1));
		buttons.setBounds(164, 398, 275, 124);
		buttons.setOpaque(false);
		JButton b1 = new JButton("Retourner aux informations des équipes");
		b1.setMinimumSize(new Dimension(200, 30));
		b1.setMaximumSize(new Dimension(200, 30));
		b1.setPreferredSize(new Dimension(200, 30));
		
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            { EquipesGUI.menuEquipes(listeEquipes,true);
               
            }
		});
		JButton b2 = new JButton("Tournoi par poules");
		b2.setMinimumSize(new Dimension(200, 30));
		b2.setMaximumSize(new Dimension(200, 30));
		b2.setPreferredSize(new Dimension(200, 30));
		b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	TournoiParPoules tournoi = new TournoiParPoules(listeEquipes);
            	TournoiGUI.gestionTournoiParPoules(tournoi);
            	frame.setVisible(false);
            	
            }
		});
		JButton b3 = new JButton("Tournoi par élimination directe");
		b3.setMinimumSize(new Dimension(200, 30));
		b3.setMaximumSize(new Dimension(200, 30));
		b3.setPreferredSize(new Dimension(200, 30));
		b3.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {	TournoiEliminationDirecte tournoi = new TournoiEliminationDirecte(listeEquipes);
            	TournoiGUI.gestionTournoi(tournoi,0);
            	frame.setVisible(false);
            }
		});
		buttons.add(b3);
		buttons.add(b2);
		buttons.add(b1);
		frame.getContentPane().add(buttons);
		
		frame.setVisible(true);
	}



	public static void selectionerFitxer(){
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 600, 600, 600);
		frame.setLocationRelativeTo(null);
		PanelImagen1 p = new PanelImagen1();
		p.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.setContentPane(p);
		JLabel label = new JLabel("Selectioner la liste");
		label.setBounds(128, 164, 326, 50);
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Microsoft Tai Le", Font.BOLD, 38));
		label.setBackground(Color.WHITE);
		String dir1=System.getProperty("user.dir");
	          
		File dir = new File(dir1+"//src//data//historique");
		
		String[] listesEq = dir.list();
		String[] bookTitles = new String[listesEq.length];
	
			  for (int x=0;x<listesEq.length;x++){
				  
			    bookTitles[x]=listesEq[x];
			
		}
		JComboBox<String> documents = new JComboBox<String>(bookTitles);
		
		frame.getContentPane().add(documents);
		JButton create = new JButton("Séléctioner");
		create.setBounds(169, 386, 115, 39);
		create.setBackground(Color.LIGHT_GRAY); 
		 create.setForeground(Color.black);
		 create.setFocusable(false); 
		 create.addActionListener(new ActionListener() {
				 
				public void actionPerformed(ActionEvent e2){
					 	LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
					 		try {
								listeEquipes=SaveList.loadTeams(documents.getItemAt(documents.getSelectedIndex()));
								} catch (IOException e) {
								
									e.printStackTrace();
								}
					 			
					 			frame.dispose();
					 			EquipesGUI.menuEquipes(listeEquipes,true);
					 			
					 			}
					 			
				 		});
		p.setLayout(null);
		frame.getContentPane().add(create);
	    frame.getContentPane().add(label);
		documents.setBounds(250,300,100,30);
		documents.setFocusable(false);
		frame.getContentPane().add(documents);
		JButton cancel = new JButton("Annuler");
		cancel.setBounds(330, 386, 109, 39);
		cancel.setBackground(Color.LIGHT_GRAY); 
		cancel.setForeground(Color.black);
		cancel.setFocusable(false);
		cancel.addActionListener(new ActionListener() {
					 
				public void actionPerformed(ActionEvent e2){
					 	menuInscription();
				}
		});
		frame.getContentPane().add(cancel);
		frame.setVisible(true);
	}
	
	
		

}