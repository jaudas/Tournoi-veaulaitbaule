package SwingView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Equipe;



public class EquipesGUI{

	public static void menuEquipes(LinkedList<Equipe> listeEquipes) {
		 
		JButton addequipe = new JButton ("Ajouter un equipe");
		JButton modfequipe = new JButton ("Modifier l'equipe");
		JButton elimequipe = new JButton ("Eliminer l'equipe");
		JButton affjequipe = new JButton ("Afficher les joueurs de l'equipe");
		JButton gtournoi = new JButton ("Generer tournois");
		JLabel chequipe = new JLabel ("Choisir un equipe");
		JTextField chIdEquipe = new JTextField();
		JPanel panel1 = new JPanel();
		
		 //Creation du tableu pour afficher des equipes
		 Object[][] data = new Object[listeEquipes.size()][4];
		 String[] columnNames = {"ID", "Nom", "Description"," Nb Joueurs"};
		 for (int i = 0; i < listeEquipes.size(); i++){
			 listeEquipes.get(i).setIdEquipe(i+1);
			 data[i][0]= listeEquipes.get(i).getIdEquipe();
			 data[i][1]= listeEquipes.get(i).getNom();
			 data[i][2]= listeEquipes.get(i).getDescription();
			 if (listeEquipes.get(i).getListeJoueurs()==null){data[i][3]=0;
			 }else{data[i][3]= listeEquipes.get(i).getListeJoueurs().size();
			 }
			
		 }
		 JTable table = new JTable(data, columnNames);
		 table.setEnabled(false); //Table non editable
		 //On ajoute la table à un scrollePane
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(table); 
		 //On cree un panel pour ajouter les butons
		 JPanel panel3 = new JPanel(new GridLayout(2,3));
		 panel3.add(chequipe);
		 panel3.add(chIdEquipe);
		 panel1.add(addequipe);
		 panel3.add(modfequipe);
		 panel3.add(elimequipe);
		 panel3.add(affjequipe);
		 panel3.add(gtournoi);
		
		 //On cree un frame pour ajouter tous les objets de la fenetre
		 JFrame frame = new JFrame();
		 frame.setBackground(Color.WHITE);
		 frame.setBounds(500, 500, 500, 300);
		 frame.setLocationRelativeTo(null);
		 frame.getContentPane().add(panel1,BorderLayout.PAGE_START);
		 frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		 frame.getContentPane().add(panel3,BorderLayout.PAGE_END);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 
		 //Button actions
		 addequipe.addActionListener(new ActionListener() {
			 
	         public void actionPerformed(ActionEvent e)
	         {
	             newEquipe(listeEquipes);
	             frame.setVisible(false);
	          }
	     });   
		 affjequipe.addActionListener(new ActionListener() {
			 
	         public void actionPerformed(ActionEvent e)
	         {	frame.setVisible(false);
	         	String idE = chIdEquipe.getText();
	     		int idEnb= QuestionsDialogues.mauvaisNumero(idE, "Choisir l'equipe à modifier!");
	        	if(listeEquipes.get(idEnb-1).getNbJoueurs()==0){   	//Execute when button is pressed
	         		int dialogButton = JOptionPane.YES_NO_OPTION;
	         		int dialogResult = JOptionPane.showConfirmDialog (null, "Vous voulez ajouter le premier joueur?","Warning",dialogButton);
	         		if(dialogResult == JOptionPane.YES_OPTION){ 
	         			JoueursGUI.newJoueur(listeEquipes,idEnb);
	     
	         		}else if(dialogResult==JOptionPane.NO_OPTION){
	            	menuEquipes(listeEquipes);
	         		}
	        	}else{JoueursGUI.menuJoueurs(listeEquipes, idEnb);}   
	          }
	     });  
		 modfequipe.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {  
	             modifierEquipe(listeEquipes, chIdEquipe);
	          }
		 });
		 elimequipe.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {	eliminerEquipe(listeEquipes, chIdEquipe);
	            frame.setVisible(false);
	            menuEquipes(listeEquipes);
	          }
		 });
		 gtournoi.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 { 
			   Menus.menuTournoi(listeEquipes);
			   frame.setVisible(false);
			 }
		 });
		 
	}
	
	
	public static void newEquipe(LinkedList <Equipe> listeEquipes) {
		 JTextField nom = new JTextField();
		 JTextField description = new JTextField();

		// Buttons
		 JButton create = new JButton("Ajouter");
		 JButton cancel = new JButton("Cancel");
		 create.setBackground(Color.LIGHT_GRAY); // background and colour for
		 create.setForeground(Color.black);
		 cancel.setBackground(Color.LIGHT_GRAY); // background and colour for
		 cancel.setForeground(Color.black);
		 create.setFocusable(false); // disable auto focus
		 cancel.setFocusable(false);

		 JPanel panel1 = new JPanel();
		 //Panel pour l'introducition des donnés
		 JPanel panel2 = new JPanel(new GridLayout(3, 2));
		 panel2.setBorder(new TitledBorder("Inscrire un Equipe"));
		 panel2.add(new JLabel("Nom"));
		 panel2.add(nom);
		 panel2.add(new JLabel("Description"));
		 panel2.add(description);
		 //Panel pour les buttons
		 JPanel panel3 = new JPanel(new BorderLayout());
		 //inside panel3
		 JPanel p3_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 p3_1.add(create);
		 p3_1.add(cancel);
		 panel3.add(p3_1, BorderLayout.CENTER);
		 
		 JFrame frame = new JFrame();
		
		 cancel.addActionListener(new ActionListener() {
			 
			 	public void actionPerformed(ActionEvent e2){
			 			JOptionPane.showMessageDialog(null, "your information will be lost");
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes);}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 			createEquipe(listeEquipes, nom, description, listeEquipes.size());
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes);
			 			JOptionPane.showMessageDialog(null,"Your entry is successfully added");
			 			}
		 		});
	
		 frame.add(panel1, BorderLayout.NORTH);
		 frame.add(panel2, BorderLayout.CENTER);
		 frame.add(panel3, BorderLayout.SOUTH);
		 frame.setBackground(Color.WHITE);
	     frame.setBounds(500, 500, 500, 300);
	     frame.setLocationRelativeTo(null);
		 frame.setVisible(true);

	}

/*
* Create Method to instantiate an object
* ----------------------------------------------------------*/
	private static void createEquipe(LinkedList <Equipe> listeEquipes, JTextField nom, JTextField description,  int i) 
	{	//On lis les infos
		String nomequipe = nom.getText();
		String descriptionequipe = description.getText();
		//Creation d'equipe
		Equipe equipe = new Equipe();
		equipe.setNom(nomequipe);
		equipe.setDescription(descriptionequipe);
		equipe.setIdEquipe(i+1);
		listeEquipes.add(equipe);
	}

	private static void eliminerEquipe(LinkedList <Equipe> listeEquipes, JTextField idEquipe) 
	{
		String idE = idEquipe.getText();
		int idEnb= QuestionsDialogues.mauvaisNumero(idE, "Choisir l'equipe à eliminer!");
		listeEquipes.remove(idEnb-1);

	}




	public static void modifierEquipe(LinkedList <Equipe> listeEquipes, JTextField idEquipe) {
		String idE = idEquipe.getText();
		int idEnb= QuestionsDialogues.mauvaisNumero(idE, "Choisir l'equipe à modifier!");

		JTextField nom = new JTextField();
		JTextField description = new JTextField();
		nom.setText(listeEquipes.get(idEnb-1).getNom());
		description.setText(listeEquipes.get(idEnb-1).getDescription());
		
		// Buttons
		 JButton create = new JButton("Modifier");
		 JButton cancel = new JButton("Canceler");
		 create.setBackground(Color.LIGHT_GRAY); 
		 create.setForeground(Color.black);
		 cancel.setBackground(Color.LIGHT_GRAY); 
		 cancel.setForeground(Color.black);
		 create.setFocusable(false); 
		 cancel.setFocusable(false);

		 JPanel panel1 = new JPanel();
		 //Panel pour l'introduction des donnes
		 JPanel panel2 = new JPanel(new GridLayout(3, 2));
		 panel2.setBorder(new TitledBorder("Modifier un Equipe"));
		 panel2.add(new JLabel("Nom"));
		 panel2.add(nom);
		 panel2.add(new JLabel("Description"));
		 panel2.add(description);
	
		 //panel pour les buttons
		 JPanel panel3 = new JPanel(new BorderLayout());
		 //inside panel3
		 JPanel p3_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 p3_1.add(create);
		 p3_1.add(cancel);
		 panel3.add(p3_1, BorderLayout.CENTER);
		 //add Panels to the frame
		 JFrame frame = new JFrame();
		 cancel.addActionListener(new ActionListener() {
			 
			 	public void actionPerformed(ActionEvent e2){
			 			JOptionPane.showMessageDialog(null, "your information will be lost");
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes);
			 			}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		String nomequipe = nom.getText();
			 		String descriptionequipe = description.getText();
			 		listeEquipes.get(idEnb-1).setNom(nomequipe);
			 		listeEquipes.get(idEnb-1).setDescription(descriptionequipe);
			 		frame.setVisible(false);
			 		JOptionPane.showMessageDialog(null,"Your entry is successfully added");
			 		menuEquipes(listeEquipes);
			 		}
		 		});
		 frame.add(panel1, BorderLayout.NORTH);
		 frame.add(panel2, BorderLayout.CENTER);
		 frame.add(panel3, BorderLayout.SOUTH);
		 frame.setBackground(Color.WHITE);
	     frame.setBounds(500, 500, 500, 300);
	     frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 	
		}
	
	}
