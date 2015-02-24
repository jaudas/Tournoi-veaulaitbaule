package SwingView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import controleur.Randomator;
import model.Match;
import model.Poule;
import model.Tournoi;
import model.TournoiEliminationDirecte;
import model.TournoiParPoules;


public class TournoiGUI {

	public static void gestionTournoi(Tournoi tournoi, int matchesjoues) {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
	
		JPanel main = new JPanel(new GridLayout(1,2));
		
		//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
	 
		
		Object[][] data = new Object[(listeMatchs.size()-matchesjoues)][4];
			 //array de String's con los títulos de las columnas
			 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
			 int j=0;
			 for (int k =(matchesjoues); k < listeMatchs.size() ; k++){
						
						 data[j][0]= listeMatchs.get(k).getEquipeA().getNom();
						 data[j][1]= listeMatchs.get(k).getScoreA();
						 data[j][2]= listeMatchs.get(k).getScoreB();
						 data[j][3]= listeMatchs.get(k).getEquipeB().getNom();
						j++;
					}
			 boolean fin=false;
			 if (j==1){fin= true;}
			 
	 
			 //se crea la Tabla
			 final JTable table = new JTable(data, columnNames);

			 table.setEnabled(false);
			 JScrollPane scrollPane = new JScrollPane();
			 scrollPane.setViewportView(table); 
			 main.add(scrollPane);
		
	

		
		JPanel buttons = new JPanel(new GridLayout (5,1));
		
		JButton b1 = new JButton("Saisir des résultat des matches joués");
		

		b1.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	saisirResultats(tournoi,false);
	        	frame.setVisible(false);
	        }
		});
		JButton b2 = new JButton("Generer la fin du tournoi");
		
		b2.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	
	        }
		});
		JButton b3 = new JButton("Afficher/Modifier des equipes");

		b3.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	EquipesGUI.menuEquipes(tournoi.getListeEquipes());
	        	
	        }
		});
		JButton b5 = new JButton("Génere des resultats automatiquement");
		b5.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {		int matchesjoues=0;
    			for(int i=0; i<tournoi.getListeMatchs().size(); i++){
    				if (tournoi.getListeMatchs().get(i).estJoue()==true){
    					matchesjoues++;
    				}
    			}
	        	Randomator.tirageMatchsGeneres(tournoi.getListeMatchs());
	        	frame.setVisible(false);
	        
	        	TournoiGUI.gestionTournoi(tournoi,matchesjoues);
	   	
	        }
		});
		int matchesjoues1=0;
		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
		if (tournoi.getListeMatchs().get(i).estJoue()==true){
			matchesjoues1++;
		}
		}
		if(matchesjoues1 == tournoi.getListeMatchs().size()){
			JButton b4 = new JButton ("Generer la prochain phase du tournoi");
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e){		        
		       
		        	tournoi.getListeToursEliminatoires().getLast().equipesQualifiees(tournoi);
		        	tournoi.remplirTour();
		        	tournoi.nouveauTour();
		        	int matchesjoues=0;
		    		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
		    		if (tournoi.getListeMatchs().get(i).estJoue()==true){
		    			matchesjoues++;
		    		
		    		}
		         	TournoiGUI.gestionTournoi(tournoi,matchesjoues);}		        	
		        }
			});
			buttons.add(b4);
		}
		if(fin==true){
			JButton b4 = new JButton ("Fin tournoi");
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e)
		        
		    
		        {TournoiGUI.fin(tournoi);}
		        
			});
			buttons.add(b4);
		}
		buttons.add(b3);
		buttons.add(b5);
		buttons.add(b2);
		buttons.add(b1);
		
		main.add(buttons);
		main.add(StadistiquesGUI.afficherStatTournoi(tournoi, false));
		frame.getContentPane().add(main);
		main.setVisible(true);
	    frame.setVisible(true);
	    frame.pack();
	}


	public static void gestionTournoiParPoules(TournoiParPoules tournoi) {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1000,1000,1000,1000);
		frame.setLocationRelativeTo(null);


		JPanel main = new JPanel(new GridLayout(2,1));
		
		
		//Afficher des Equipes de chaque Poule
		ArrayList <Poule> listePoules = tournoi.getListePoules();
		int nbGP=listePoules.size();
		int filas= nbGP/4;
		
		JPanel poules = new JPanel (new GridLayout(filas,4));
		
		for(int j=0; j<nbGP; j++){
		JPanel group = new JPanel (new GridLayout (2,1));
		Poule pouleAffichage= listePoules.get(j);
		Object[][] data = new Object[4][1];
		 //array de String's con los títulos de las columnas
		 String[] columnNames = {"Group" +(j+1)};
		 for (int i = 0; i < pouleAffichage.getEquipesPoule().size() ; i++){
			 
			 data[i][0]= pouleAffichage.getEquipesPoule().get(i).getNom();		
		 }
		 final JTable table = new JTable(data, columnNames);

		 table.setEnabled(false);
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(table); 
		 group.add(scrollPane);
		//Afficher des matche de chaque group
		 LinkedList <Match> listeMatchs = new LinkedList <Match>();
		 listeMatchs= tournoi.getListeMatchs();
		 Object[][] datamatches = new Object[6][4];
		//array de String's con los títulos de las columnas
		 String[] columnNamesmatches = {"Equipe A", "Set", "Set"," Equipe B"};
			 
		int p;
		if(j==0){
			p=0;}
		else{
			p = (j*6);}
		if (listeMatchs.size()>p){
			 for (int k = p; k <(6+p) ; k++){ 
				 if ((listeMatchs.size()) > k){
					 datamatches[k-p][0]= listeMatchs.get(k).getEquipeA().getNom();			 
					 datamatches[k-p][1]= listeMatchs.get(k).getScoreA();		 
					 datamatches[k-p][2]= listeMatchs.get(k).getScoreB();		 
					 datamatches[k-p][3]= listeMatchs.get(k).getEquipeB().getNom();	
				 }else{
					 datamatches[k-p][0]= "-";
					 datamatches[k-p][1]= "-"; 
					 datamatches[k-p][2]= "-";
					 datamatches[k-p][3]= "-";
				 }
			 }
		 }
			
		//se crea la Tabla
		
		JTable table2 = new JTable(datamatches, columnNamesmatches);
		table2.setEditingColumn(0);
		table2.setEditingColumn(3); 
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setViewportView(table2); 
		group.add(scrollPane2);
		poules.add(group);
		
		}
		main.add(poules);
		
		
		
		JPanel gestor = new JPanel(new GridLayout(1,2));
	 
		JPanel buttons = new JPanel(new GridLayout (5,1));
		
		JButton b1 = new JButton("Saisir des résultat des matches joués");
		

		b1.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	saisirResultats(tournoi,true);
	        	frame.setVisible(false);
	        }
		});
		JButton b2 = new JButton("Generer la fin du tournoi");
		
		b2.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	
	        }
		});
		JButton b3 = new JButton("Afficher/Modifier des equipes");

		b3.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	EquipesGUI.menuEquipes(tournoi.getListeEquipes());
	        	
	        }
		});
		JButton b5 = new JButton("Génere des resultats automatiquement");
		b5.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	Randomator.tirageMatchsGeneres(tournoi.getListeMatchs());
	        	frame.setVisible(false);
	        	TournoiGUI.gestionTournoiParPoules(tournoi);
	        	
	        }
		});
		
		int matchesjoues=0;
		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
		if (tournoi.getListeMatchs().get(i).estJoue()==true){
			matchesjoues++;
		}
		}
		if(matchesjoues == tournoi.getListeMatchs().size()){
			JButton b4 = new JButton ("Generer la prochain phase du tournoi");
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e)
		        {		int matchesjoues=0;
	    			for(int i=0; i<tournoi.getListeMatchs().size(); i++){
	    				if (tournoi.getListeMatchs().get(i).estJoue()==true){
	    					matchesjoues++;
	    				}
	    			}
		        	tournoi.creerEqQualifiees();
		        	tournoi.remplirTour();
		        	tournoi.nouveauTour();
		        
		         	TournoiGUI.gestionTournoi((TournoiParPoules) tournoi, matchesjoues);		        	
		        }
			});
			buttons.add(b4);
		}
		buttons.add(b3);
		buttons.add(b5);
		buttons.add(b2);
		buttons.add(b1);
		gestor.add(StadistiquesGUI.afficherStatTournoi(tournoi, true));
		gestor.add(buttons);
		gestor.setVisible(true);
		main.add(gestor);
		
		frame.getContentPane().add(main);
		main.setVisible(true);
	    frame.setVisible(true);
	    frame.pack();
	}
	
	
	
	public static void saisirResultats(Tournoi tournoi, boolean poules)
	{
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,200,200,200);
		frame.setLocationRelativeTo(null);
		
		JPanel main = new JPanel(new GridLayout (5,1));
		
		JLabel qMatch = new JLabel("Choisir le match: ");
		main.add(qMatch);
	
		String[] bookTitles = new String[tournoi.getListeMatchs().size()];
		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
			if(tournoi.getListeMatchs().get(i).estJoue()==false){
		bookTitles[i]=tournoi.getListeMatchs().get(i).getEquipeA().getNom()+'-'+tournoi.getListeMatchs().get(i).getEquipeB().getNom();
		}
		}
		 JComboBox<String> match = new JComboBox<>(bookTitles);
		 
		 main.add(match);
		 
		 JLabel qResult = new JLabel ("Résult:");
		 main.add(qResult);
		 
		 JPanel saisirScore = new JPanel (new GridLayout(1,2));
		 JTextField score1 = new JTextField();
		 JTextField score2 = new JTextField();
		 
		 saisirScore.add(score1);
		 saisirScore.add(score2);
		 main.add(saisirScore);
		 
		 JButton create = new JButton("Save");
		 JButton cancel = new JButton("Cancel");
		 JPanel options = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 options.add(create);
		 options.add(cancel);
		 main.add(options);
		 
		 cancel.addActionListener(new ActionListener() {
			 
			 	public void actionPerformed(ActionEvent e2){
			 			JOptionPane.showMessageDialog(null, "your information will be lost");
			 			frame.setVisible(false);
			 			;}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		String sA = score1.getText();
			 		String sB = score2.getText();
			 		int scoreA=QuestionsDialogues.mauvaisNumero(sA,"numero incorrect");
			 		int scoreB=QuestionsDialogues.mauvaisNumero(sB,"numero incorrect");
			 		int Nmatch = match.getSelectedIndex();
			 		tournoi.getListeMatchs().get(Nmatch).setScoreA(scoreA);
			 		tournoi.getListeMatchs().get(Nmatch).setScoreB(scoreB);
			 		if(poules==true){
			 			gestionTournoiParPoules((TournoiParPoules) tournoi);
			 		}else{
			 			
			 			int matchesjoues=0;
			 			for(int i=0; i<tournoi.getListeMatchs().size(); i++){
			 			if (tournoi.getListeMatchs().get(i).estJoue()==true){
			 				matchesjoues++;
			 			}
			 			}
			 			gestionTournoi(tournoi,matchesjoues);}
			 		frame.setVisible(false);
			 		
			 		
			 		
			 			}
		 		});
		 frame.add(main);
		 frame.setVisible(true);
	}
	
	public static void modifierResultats(Tournoi tournoi, boolean poules)
	{
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,200,200,200);
		frame.setLocationRelativeTo(null);
		
		JPanel main = new JPanel(new GridLayout (5,1));
		
		JLabel qMatch = new JLabel("Choisir le match: ");
		main.add(qMatch);
	
		String[] bookTitles = new String[tournoi.getListeEquipes().size()];
		for(int i=0; i<tournoi.getListeEquipes().size(); i++){	
		bookTitles[i]=tournoi.getListeMatchs().get(i).getEquipeA().getNom()+'-'+tournoi.getListeMatchs().get(i).getEquipeB().getNom();
		}
		
		 JComboBox<String> match = new JComboBox<>(bookTitles);
		 
		 main.add(match);
		 
		 JLabel qResult = new JLabel ("Résult:");
		 main.add(qResult);
		 
		 JPanel saisirScore = new JPanel (new GridLayout(1,2));
		 JTextField score1 = new JTextField();
		 JTextField score2 = new JTextField();
		 int i = match.getSelectedIndex();
		 score1.setText(Integer.toString(tournoi.getListeMatchs().get(i).getScoreA()));
		 score1.setText(Integer.toString(tournoi.getListeMatchs().get(i).getScoreA()));
		
		 saisirScore.add(score1);
		 saisirScore.add(score2);
		 main.add(saisirScore);
		 
		 JButton create = new JButton("Save");
		 JButton cancel = new JButton("Cancel");
		 JPanel options = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 options.add(create);
		 options.add(cancel);
		 main.add(options);
		 
		 cancel.addActionListener(new ActionListener() {
			 
			 	public void actionPerformed(ActionEvent e2){
			 			JOptionPane.showMessageDialog(null, "your information will be lost");
			 			frame.setVisible(false);
			 			;}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		
			 		String sA = score1.getText();
			 		String sB = score2.getText();
			 		int scoreA=QuestionsDialogues.mauvaisNumero(sA,"numero incorrect");
			 		int scoreB=QuestionsDialogues.mauvaisNumero(sB,"numero incorrect");
			 		int Nmatch = match.getSelectedIndex();
			 		tournoi.getListeMatchs().get(Nmatch).setScoreA(scoreA);
			 		tournoi.getListeMatchs().get(Nmatch).setScoreB(scoreB);
			 		if(poules==true){
			 			gestionTournoiParPoules((TournoiParPoules) tournoi);
			 		}else{
			 			int matchesjoues=0;
			 			for(int i=0; i<tournoi.getListeMatchs().size(); i++){
			 			if (tournoi.getListeMatchs().get(i).estJoue()==true){
			 				matchesjoues++;
			 			}
			 			}gestionTournoi(tournoi,matchesjoues);}
			 		frame.setVisible(false);

			 			}
		 		});
		 frame.add(main);
		 frame.setVisible(true);
	}





	public static void fin(Tournoi tournoi) {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
	
		JPanel main = new JPanel(new GridLayout(1,2));
		
		//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
	 
		
		Object[][] data = new Object[listeMatchs.size()][4];
			 //array de String's con los títulos de las columnas
			 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
			 
			 for (int k =0; k < listeMatchs.size() ; k++){
						
						 data[k][0]= listeMatchs.get(k).getEquipeA().getNom();
						 data[k][1]= listeMatchs.get(k).getScoreA();
						 data[k][2]= listeMatchs.get(k).getScoreB();
						 data[k][3]= listeMatchs.get(k).getEquipeB().getNom();
					
					}
			
			 
	 
			 //se crea la Tabla
			 final JTable table = new JTable(data, columnNames);

			 table.setEnabled(false);
			 JScrollPane scrollPane = new JScrollPane();
			 scrollPane.setViewportView(table); 
			 main.add(scrollPane);
		
	

		
		JPanel buttons = new JPanel(new GridLayout (5,1));
		JLabel gn = new JLabel("L'equipe gangant est");
		JButton b1 = new JButton("Commançer un autre tournoi");

		b1.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	Menus.menuBienvenue();
	        	
	        }
		});
		JButton b2 = new JButton("Sortir");

		b2.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	frame.setVisible(false);
	        	
	        }
		});
	
	
	
		JButton b3 = new JButton("Afficher des equipes");

		b3.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	EquipesGUI.menuEquipes(tournoi.getListeEquipes());
	        	
	        }
		});
		buttons.add(gn);
		buttons.add(b3);
		
		buttons.add(b2);
		buttons.add(b1);
		
		main.add(buttons);
		main.add(StadistiquesGUI.afficherStatTournoi(tournoi, false));
		frame.getContentPane().add(main);
		main.setVisible(true);
	    frame.setVisible(true);
	    frame.pack();
	}
}




