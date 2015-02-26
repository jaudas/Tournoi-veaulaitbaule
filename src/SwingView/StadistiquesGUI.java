package SwingView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Collections;

import model.Equipe;
import model.Tournoi;

public class StadistiquesGUI {
	
	public static JPanel afficherStatTournoi(Tournoi t, boolean poule){
	
	
	JPanel main = new JPanel(new GridLayout(2,1));
	
	String phTour;
	int nbequipes=0;
	if(poule == true){
		phTour= "Poule";
		
	}else{ nbequipes=t.getListeToursEliminatoires().getLast().getListeEquipesTour().size();
	
		if (nbequipes < 2){
			phTour="";
		}

		else if (nbequipes == 2){
			phTour="Finale";
		}

		else if (nbequipes <= 4){
			phTour="Demi-finale";
		}
		else if(nbequipes <= 8){
			phTour="Quart de finale";
		}
		else if (nbequipes <= 16){
			phTour="Huitième de finale";
		}
		else if (nbequipes <= 32){
			phTour="Seixième de finale";
		}
		else {phTour="Trente-deuxième de finale";
		}
	}
	
	
	JLabel itournoi = new JLabel("Information tournoi");
	itournoi.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
	JLabel phasetournoi = new JLabel("Phase tournoi:"+phTour);
	
	JLabel equipestour = new JLabel("Equipes dans ce tour:"+nbequipes);
	JLabel equipestotals = new JLabel("Total d'équipes inscrites:"+t.getListeEquipes().size());
	JButton infoEquipes = new JButton("Afficher/Modifier des Equipes");
	infoEquipes.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {	EquipesGUI.menuEquipes(t.getListeEquipes(),false);
        	
        }
	});
	JPanel infoTournoi = new JPanel ();
	infoTournoi.setLayout(new BoxLayout(infoTournoi, BoxLayout.Y_AXIS));
	infoTournoi.add(itournoi);
	infoTournoi.add(phasetournoi);
	if(poule==false){infoTournoi.add(equipestour);}
	infoTournoi.add(equipestotals);
	if(poule==false){int parite = t.getListeToursEliminatoires().getLast().getListeEquipesTour().size() % 2;
		if ((parite != 0)){JLabel eqQoffice= new JLabel("Equipe qualifiée d'office: "+t.getListeToursEliminatoires().getLast().getListeEquipesTour().get(t.getListeToursEliminatoires().getLast().getQualifOffice()).getNom());
			infoTournoi.add(eqQoffice);}
	}

	
	infoTournoi.add(infoEquipes);
	main.add(infoTournoi);
	
	 //Creation du tableu pour afficher info equipes
	
	LinkedList<Equipe> eqTriees = t.getListeEquipes();
	Collections.sort(eqTriees);
	
	 Object[][] data = new Object[t.getListeEquipes().size()][7];
	 String[] columnNames = {"Classement", "Nom", "Matchs"," Victoires", "Pourcentage vicoitre","Sets gagnés", "Goal Average"};
	 for (int i = 0; i < t.getListeEquipes().size(); i++){
		 Equipe eqTemp = eqTriees.get(i);
		 data[i][0]= i+1;
		 data[i][1]= eqTemp.getNom();
		 data[i][2]= eqTemp.getNbMatchJoue();
		 data[i][3]=eqTemp.getNbVictoire();
		 data[i][4]=eqTemp.calculerPourcentageVictoire();
		 data[i][5]=eqTemp.getNbSetGagne();
		 data[i][6]=eqTemp.calculGoalAverage();
		 
		
	 }
	 JTable table = new JTable(data, columnNames);
	 table.setEnabled(false); //Table non editable
	 //On ajoute la table à un scrollePane
	 JScrollPane scrollPane = new JScrollPane();
	 scrollPane.setViewportView(table); 
	 main.add(scrollPane);
	 return main;
	}
}

	
	


