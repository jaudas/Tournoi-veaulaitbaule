package SwingView;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;















import controleur.Randomator;
import model.Match;
import model.Poule;
import model.Tournoi;
import model.TournoiParPoules;





import java.awt.Toolkit;




public class TournoiGUI {

	
	public static void gestionTournoi(Tournoi tournoi, int matchesphant) {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TournoiGUI.class.getResource("/images/Volleyball.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1200,600,1200,600);
		frame.setLocationRelativeTo(null);

		JPanel main = new JPanel(new GridLayout(2,2));
		
		//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
	 
		int sizeTable= listeMatchs.size()-matchesphant;
		Object[][] data = new Object[sizeTable][4];
			 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
			 int j=0;
			
			 for (int k =(matchesphant); k < listeMatchs.size() ; k++){
						
						 data[j][0]= listeMatchs.get(k).getEquipeA().getNom();
						 data[j][1]= listeMatchs.get(k).getScoreA();
						 data[j][2]= listeMatchs.get(k).getScoreB();
						 data[j][3]= listeMatchs.get(k).getEquipeB().getNom();

						 j++;	 
					}
			 
			 Object[][] dataEquipes = new Object[(tournoi.getListeToursEliminatoires().getLast().getListeEquipesTour().size())][1];
			 for( int i=0;i<tournoi.getListeToursEliminatoires().getLast().getListeEquipesTour().size(); i++){
				 dataEquipes[i][0]=tournoi.getListeToursEliminatoires().getLast().getListeEquipesTour().get(i).getNom();
			 }
			 
			 boolean fin=false;
			 if (tournoi.getListeToursEliminatoires().getLast().getListeEquipesTour().size()==2){fin= true;}
	
			 final JTable table = new JTable(data, columnNames);

			 table.setEnabled(false);
			 table.setPreferredScrollableViewportSize(new Dimension(70, 70));
			 JScrollPane scrollPane = new JScrollPane();
			 scrollPane.setViewportView(table); 
			 JPanel infoMatches= new JPanel();
			 infoMatches.setLayout(new BoxLayout(infoMatches, BoxLayout.Y_AXIS));

			 JLabel titre = new JLabel ("Liste des matchs dans ce tour");

			 titre.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
			 infoMatches.add(titre);
			 infoMatches.add(scrollPane);
			 main.add(infoMatches);
			 
			 //Tablau d'equipes qualifiées

			String[] columnNamesE = {"Equipes"};
		 final JTable table2 = new JTable(dataEquipes, columnNamesE);

			 table.setEnabled(false);
			 JScrollPane scrollPane2 = new JScrollPane();
			 table2.setPreferredScrollableViewportSize(new Dimension(70, 70));
			 scrollPane2.setViewportView(table2); 
			 JPanel infoEquipes= new JPanel();
			 infoEquipes.setLayout(new BoxLayout(infoEquipes, BoxLayout.Y_AXIS));

			 JLabel titre2 = new JLabel ("Liste des équipes dans ce tour");
			 titre2.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
			 infoEquipes.add(titre2);
			 infoEquipes.add(scrollPane2);
			 main.add(infoEquipes);
			 
	

		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton b5 = new JButton("Générer des résultats automatiquement");
		b5.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	
	        	Randomator.tirageMatchsGeneres(tournoi.getListeMatchs());
	        	frame.dispose();
	        
	        	TournoiGUI.gestionTournoi(tournoi,matchesphant);
	   	
	        }
		});
		int matchesjoues1=0;
		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
		if (tournoi.getListeMatchs().get(i).estJoue()==true){
			matchesjoues1++;
		}

		if(matchesjoues1 == tournoi.getListeMatchs().size()){
			JButton b4 = new JButton ("Générer la prochaine phase du tournoi");
			b4.setBackground(Color.BLUE);
			b4.setForeground(Color.white);
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e){		        
		       
		        	tournoi.getListeToursEliminatoires().getLast().equipesQualifiees(tournoi);
		        	tournoi.nouveauTour();
		        	tournoi.remplirTour();
		        	frame.dispose();
		        	int matchesjoues=0;
		    		for(int i=0; i<tournoi.getListeMatchs().size(); i++){
		    		if (tournoi.getListeMatchs().get(i).estJoue()==true){
		    			matchesjoues++;
		    		}
		    		}
		         	TournoiGUI.gestionTournoi(tournoi,matchesjoues);}		        	
		        
			});
			buttons.add(b4);
		}

		if(fin==true && matchesjoues1 == tournoi.getListeMatchs().size()){
			JButton b4 = new JButton ("Fin du tournoi");
			b4.setBackground(Color.BLUE);
			b4.setForeground(Color.white);
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e)

		        {	frame.dispose();
		        	TournoiGUI.finTournoi(tournoi);}
		        
			});
			buttons.add(b4);
		}
		
		
		buttons.add(b5);
		
		JPanel buttonsResults = new JPanel (new BorderLayout());
		buttonsResults.add(saisirResultats(tournoi,false, frame,matchesphant),BorderLayout.CENTER);
		buttonsResults.add(buttons,BorderLayout.PAGE_END);

		main.add(buttonsResults);

		main.add(StadistiquesGUI.afficherStatTournoi(tournoi, false));
		frame.getContentPane().add(main);
		
	    frame.setVisible(true);
	    
	}



	public static void gestionTournoiParPoules(TournoiParPoules tournoi) {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1200,600,1200,600);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));

		frame.setLocationRelativeTo(null);


		JPanel main = new JPanel(new GridLayout(1,2));
				
		//Afficher des Equipes de chaque Poule
		ArrayList <Poule> listePoules = tournoi.getListePoules();
		int nbGP=listePoules.size();
		
		JPanel poules = new JPanel( );
		poules.setRequestFocusEnabled(false);
		poules.setLayout(new BoxLayout(poules, BoxLayout.Y_AXIS));
		
		for(int j=0; j<nbGP; j++){
			JPanel group = new JPanel();
			group.setLayout(new BoxLayout(group, BoxLayout.X_AXIS));
			Poule pouleAffichage= listePoules.get(j);
			Object[][] data = new Object[4][1];
			
			String[] columnNames = {"Group" +(j+1)};
				for (int i = 0; i < pouleAffichage.getEquipesPoule().size() ; i++){
			 
						data[i][0]= pouleAffichage.getEquipesPoule().get(i).getNom();		
				}
			
				JTable table = new JTable(data, columnNames);
				table.setEnabled(false);
				table.setPreferredScrollableViewportSize(new Dimension(30, 30));
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);	
				group.add(scrollPane);
			
		
		 //Afficher des matche de chaque group
		 LinkedList <Match> listeMatchs = new LinkedList <Match>();
		 listeMatchs= tournoi.getListeMatchs();
		 Object[][] datamatches = new Object[6][4];
		
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
		table2.setEnabled(false);
	
		JScrollPane scrollPane2 = new JScrollPane();
		table2.setPreferredScrollableViewportSize(new Dimension(170, 100));
		scrollPane2.setViewportView(table2);
		group.add(scrollPane2);
		poules.add(group);
		
		}
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setViewportView(poules);
		main.add(scrollPane3);
		
		
		
		JPanel gestor = new JPanel(new GridLayout(2,1));
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		

	
	
	
		JButton b5 = new JButton("Générer automatiquement les résultats des poules");
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
			JButton b4 = new JButton ("Génerer la prochain phase du tournoi");
			b4.setBackground(Color.BLUE);
			b4.setForeground(Color.white);
			b4.addActionListener(new ActionListener() {
				 
		        public void actionPerformed(ActionEvent e)
		        {		int matchesPhase=0;
	    			for(int i=0; i<tournoi.getListeMatchs().size(); i++){
	    				if (tournoi.getListeMatchs().get(i).estJoue()==true){
	    					matchesPhase++;
	    				}
	    			}
		        	tournoi.creerEqQualifiees();
		        	tournoi.remplirTour();
		        	frame.dispose();
		         	TournoiGUI.gestionTournoi(tournoi, matchesPhase);
		         	
		        }
			});
			buttons.add(b4);
		}
		
		
		buttons.add(b5);
		
		gestor.add(StadistiquesGUI.afficherStatTournoi(tournoi, true));
		
		JPanel buttonsResults = new JPanel (new BorderLayout());
		
		gestor.setVisible(true);
		buttonsResults.add(saisirResultats(tournoi,true, frame, 0),BorderLayout.CENTER);
		buttonsResults.add(buttons,BorderLayout.PAGE_END);
		
		gestor.add(buttonsResults);
		main.add(gestor);
		
		frame.getContentPane().add(main);
		main.setVisible(true);
	    frame.setVisible(true);
	    
	    
	}
	
	
	
	public static JPanel saisirResultats(Tournoi tournoi, boolean poules, JFrame frame, int matchesPhaseAnt)
	{
	
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JLabel saisirR = new JLabel("Saisir des résultats:");
		saisirR.setHorizontalAlignment(0);
		JLabel qMatch = new JLabel("Choisir le match: ");
		saisirR.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
		main.add(saisirR);
		main.add(qMatch);
		
		int j=0;
		String[] bookTitles = new String[tournoi.getListeMatchs().size()-matchesPhaseAnt];
		for(int i=matchesPhaseAnt; i<tournoi.getListeMatchs().size(); i++){
			
		bookTitles[j]=tournoi.getListeMatchs().get(i).getEquipeA().getNom()+'-'+tournoi.getListeMatchs().get(i).getEquipeB().getNom();
		j++;
		}
		 JComboBox<String> match = new JComboBox<>(bookTitles);
		 
		 main.add(match);
		 
		 
		 String[] bookTitles2 = new String[]{"3-0","3-1","3-2","2-3","1-3","0-3"};
			
		 JComboBox<String> results= new JComboBox<>(bookTitles2);
		 main.add(match);
		
		 JLabel qResult = new JLabel ("Résult:");
		 main.add(qResult);
		 main.add(results);
		 JButton create = new JButton("Guarder résultat!");
		
		 JPanel options = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 options.add(create);
		
		 main.add(options);
		 
	
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		frame.setVisible(false);
			 		int Nmatch = match.getSelectedIndex()+matchesPhaseAnt;
			 		int RMatch = results.getSelectedIndex();
			 		switch((RMatch+1)){
			 		case 1: tournoi.getListeMatchs().get(Nmatch).setScoreA(3);
			 				tournoi.getListeMatchs().get(Nmatch).setScoreB(0);
			 				break;
			 		case 2: tournoi.getListeMatchs().get(Nmatch).setScoreA(3);
	 						tournoi.getListeMatchs().get(Nmatch).setScoreB(1);
	 						break;
			 		case 3: tournoi.getListeMatchs().get(Nmatch).setScoreA(3);
	 						tournoi.getListeMatchs().get(Nmatch).setScoreB(2);
	 						break;
			 		case 4: tournoi.getListeMatchs().get(Nmatch).setScoreA(2);
	 						tournoi.getListeMatchs().get(Nmatch).setScoreB(3);
	 						break;
			 		case 5: tournoi.getListeMatchs().get(Nmatch).setScoreA(1);
	 						tournoi.getListeMatchs().get(Nmatch).setScoreB(3);
	 						break;
			 		case 6: tournoi.getListeMatchs().get(Nmatch).setScoreA(0);
			 		   		tournoi.getListeMatchs().get(Nmatch).setScoreB(3);
			 				break;
			 				}
			 		
			 		if(poules==true){
			 			gestionTournoiParPoules((TournoiParPoules) tournoi);
			 		}else{
			 			
			 			gestionTournoi(tournoi,matchesPhaseAnt);}
			 		
			 		
			 		
			 		
			 			}
		 		});
		return main;
	}
	

public static void finTournoi(Tournoi tournoi) {
		
		JFrame frame = new JFrame("Tournoi de volley-ball");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TournoiGUI.class.getResource("/images/Volleyball.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1200,600,1200,600);
		frame.setLocationRelativeTo(null);

		JPanel main = new JPanel(new BorderLayout());
		
		//array bidimencional de objetos con los datos de la tabla
	  	LinkedList <Match> listeMatchs = new LinkedList <Match>();
	  	listeMatchs= tournoi.getListeMatchs();
	 
		
		Object[][] data = new Object[listeMatchs.size()][4];

			 String[] columnNames = {"Equipe A", "Set", "Set"," Equipe B"};
			
			
			 for (int k =0; k < listeMatchs.size() ; k++){
						
						 data[k][0]= listeMatchs.get(k).getEquipeA().getNom();
						 data[k][1]= listeMatchs.get(k).getScoreA();
						 data[k][2]= listeMatchs.get(k).getScoreB();
						 data[k][3]= listeMatchs.get(k).getEquipeB().getNom();

							 
					}

	
			 final JTable table = new JTable(data, columnNames);

			 table.setEnabled(false);
			 table.setPreferredScrollableViewportSize(new Dimension(70, 70));
			 JScrollPane scrollPane = new JScrollPane();
			 scrollPane.setViewportView(table);
			 JPanel infoMatches= new JPanel();
			 infoMatches.setLayout(new BoxLayout(infoMatches, BoxLayout.Y_AXIS));
			 JLabel titre = new JLabel ("Liste de matches ");
			 titre.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
			 infoMatches.add(titre);
			 infoMatches.add(scrollPane);
			 main.add(infoMatches,BorderLayout.PAGE_START);
			 
			 //Tablaux d'equipes qualifiés

		JPanel buttons = new JPanel();

		JButton b5 = new JButton("Nouveau tournoi");
		b5.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {	frame.dispose();
	        	Menus.menuBienvenue();
    			}

		});
		
	
	
		buttons.add(b5);

		main.add(StadistiquesGUI.afficherStatTournoi(tournoi, false),BorderLayout.CENTER);
		
		JPanel butEtGagnant = new JPanel(new GridLayout(2,1));
		
		JLabel gagnant = new JLabel("Gagnant: "+ tournoi.getListeMatchs().getLast().getGagnant().getNom());
		gagnant.setHorizontalAlignment(0);
		gagnant.setFont(new Font("Microsoft Tai Le", Font.BOLD, 40));
		butEtGagnant.add(gagnant);
		butEtGagnant.add(buttons);
		main.add(butEtGagnant,BorderLayout.AFTER_LAST_LINE);
		frame.getContentPane().add(main);
		
	    frame.setVisible(true);
	   
	}


}




