package SwingView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.TitledBorder;










import model.EnumSexe;
import model.Equipe;
import model.Joueur;

public class JoueursGUI{

	public static void menuJoueurs(LinkedList<Equipe> listeEquipes, int chEqp) {
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur> ();
		listeJoueurs=listeEquipes.get(chEqp-1).getListeJoueurs();
		JButton addJoueur = new JButton ("Ajouter un joueur");
		JButton modJoueur = new JButton ("Modifier le joueur");
		JButton elimJoueur = new JButton ("Eliminer le joueur");
		JButton returnEqp = new JButton ("Returner à l'info d'equipe");
		JLabel chequipe = new JLabel ("Choisir un joueur");
		JTextField idJoueur= new JTextField();
		JPanel panel1 = new JPanel();
		
		 //Creation de tablau avec les joueurs
		 Object[][] data = new Object[listeJoueurs.size()][5];
		 String[] columnNames = {"IdJoueur", "Prenom", "Nom","Age","Sexe"};
		 for (int i = 0; i < listeJoueurs.size(); i++){
			 data[i][0]= i+1;
			 data[i][1]= listeJoueurs.get(i).getPrenom();
			 data[i][2]= listeJoueurs.get(i).getNom();
			 data[i][3]= listeJoueurs.get(i).getAge();
			 data[i][4]= listeJoueurs.get(i).getSexe();
			 
		 }
		 final JTable table = new JTable(data, columnNames);
		 table.setEnabled(false);
		 //On ajoute la table à un ScrollPane
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(table); 
		 JPanel panel3 = new JPanel(new GridLayout(2,3));
		 panel3.add(chequipe);
		 panel3.add(idJoueur);
		 panel1.add(addJoueur);
		 panel3.add(modJoueur);
		 panel3.add(elimJoueur);
		 panel3.add(returnEqp);

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
		 addJoueur.addActionListener(new ActionListener() { 
	         public void actionPerformed(ActionEvent e)
	         {
	             newJoueur(listeEquipes,chEqp);
	             frame.setVisible(false);             
	         }
	     });   
		 
		 modJoueur.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {   
	             modifierJoueurs(listeEquipes, chEqp,idJoueur);
	          }
		 });
		 elimJoueur.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {	 eliminerJoueur(listeEquipes, chEqp, idJoueur);
	             frame.setVisible(false);
	             menuJoueurs(listeEquipes, chEqp);
	          }
		 });
		 
		 returnEqp.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 { frame.setVisible(false);
			   EquipesGUI.menuEquipes(listeEquipes);
			 }
		 });
		
		 
	}
	
	public static void newJoueur(LinkedList<Equipe> listeEquipes, int chEqp) {
		
		JTextField prenom = new JTextField();
		JTextField nom = new JTextField();
		JTextField age = new JTextField();
	
		// Buttons
		JButton create = new JButton("Creer Joueur");
		JButton cancel = new JButton("Canceler");
		create.setBackground(Color.LIGHT_GRAY); // background and colour for
		create.setForeground(Color.black);
		cancel.setBackground(Color.LIGHT_GRAY); // background and colour for
		cancel.setForeground(Color.black);
		create.setFocusable(false); // disable auto focus
		cancel.setFocusable(false);
		
		String[] bookTitles = new String[] {"Femme", "Homme", "N/A"};
		JComboBox<String> chSexe = new JComboBox<>(bookTitles);
	//panel1
		 JPanel panel1 = new JPanel();
	//Panel pour l'introduction d'info
		 JPanel panel2 = new JPanel(new GridLayout(4, 2));
		 panel2.setBorder(new TitledBorder("Inscrire un Joueur"));
		 panel2.add(new JLabel("Prenom"));
		 panel2.add(prenom);
		 panel2.add(new JLabel("Nom"));
		 panel2.add(nom);
		 panel2.add(new JLabel("Age"));
		 panel2.add(age);
		 panel2.add(new JLabel("Sexe"));
		 panel2.add(chSexe);
		 //panel pour les butons
		 JPanel panel3 = new JPanel(new BorderLayout());
		 	JPanel p3_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 	p3_1.add(create);
		 	p3_1.add(cancel);
		 panel3.add(p3_1, BorderLayout.CENTER);

		 JFrame frame = new JFrame();
		 cancel.addActionListener(new ActionListener() {
			 
			 	public void actionPerformed(ActionEvent e2){
			 			JOptionPane.showMessageDialog(null, "your information will be lost");
			 			frame.setVisible(false);
			 			menuJoueurs(listeEquipes, chEqp);}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur> ();
			 		 	listeJoueurs=listeEquipes.get(chEqp).getListeJoueurs();
			 			createJoueur(listeJoueurs, prenom, nom, age, chSexe);
			 			frame.setVisible(false);
			 			listeEquipes.get(chEqp-1).setListeJoueurs(listeJoueurs);
			 			menuJoueurs(listeEquipes,chEqp);			 			
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
	

	private static void createJoueur(LinkedList <Joueur> listeJoueurs, JTextField prenom, JTextField nom, JTextField age, JComboBox<String> chSexe) {
		String prenomj = prenom.getText();
		String nomj = nom.getText();
		String agej = age.getText();
			String ageJnb = Integer.toString(QuestionsDialogues.mauvaisNumero(agej, "Age incorrect"));
		String selectSexe = (String) chSexe.getSelectedItem();
		
		Joueur joueur = new Joueur(prenomj,nomj,ageJnb,selectSexe);
		listeJoueurs.add(joueur);
	
	}
	
	
	private static void eliminerJoueur(LinkedList <Equipe> listeEquipes, int idEnb, JTextField idJoueur) {
		String NJ= idJoueur.getText();
		int NJj= QuestionsDialogues.mauvaisNumero(NJ, "Choisir l'equipe à eliminer!");
	
		listeEquipes.get(idEnb-1).getListeJoueurs().remove(NJj-1);

	}
	
	
	
	
	public static void modifierJoueurs(LinkedList <Equipe> listeEquipes, int idEnb, JTextField idJoueur) {
		String NJ= idJoueur.getText();
		int NJj= QuestionsDialogues.mauvaisNumero(NJ, "Choisir l'equipe à eliminer!");

		JTextField prenom = new JTextField();
		JTextField nom = new JTextField();
		JTextField age = new JTextField();
		
		String[] bookTitles = new String[] {"Femme", "Homme", "N/A"};
		JComboBox<String> chSexe = new JComboBox<>(bookTitles);
		 
		nom.setText(listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getNom());
		prenom.setText(listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getPrenom());
		age.setText(listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getAge());
		
			if (listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getSexe()== EnumSexe.Femme)
			{
				chSexe.setSelectedItem("Femme");
			}
	
			if (listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getSexe()== EnumSexe.Homme)
			{
				chSexe.setSelectedItem("Homme");
			}
			if (listeEquipes.get(idEnb-1).getListeJoueurs().get(NJj-1).getSexe()== EnumSexe.NA)
			{
				chSexe.setSelectedItem("N/A");
			}
			
		// Buttons
		 JButton create = new JButton("Save");
		 JButton cancel = new JButton("Cancel");
		 create.setBackground(Color.LIGHT_GRAY); 
		 create.setForeground(Color.black);
		 cancel.setBackground(Color.LIGHT_GRAY); 
		 cancel.setForeground(Color.black);
		 create.setFocusable(false); 
		 cancel.setFocusable(false);

		 JPanel panel1 = new JPanel();
	//panel2 for Inputs
		 JPanel panel2 = new JPanel(new GridLayout(4, 2));
		 panel2.setBorder(new TitledBorder("Modifier un Joueur"));
		 panel2.add(new JLabel("Nom"));
		 panel2.add(nom);
		 panel2.add(new JLabel("Prenom"));
		 panel2.add(prenom);
		 panel2.add(new JLabel("Age"));
		 panel2.add(age);
		 panel2.add(new JLabel("Sexe"));
		 panel2.add(chSexe);
	
		 //panel3 for buttons
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
			 			menuJoueurs(listeEquipes, idEnb);
			 			}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		String nomj = nom.getText();
			 		String prenomj = prenom.getText();
			 		String agej = age.getText();
			 		String selecteSexe= (String) chSexe.getSelectedItem();	 		
			 		String ageJnb = Integer.toString(QuestionsDialogues.mauvaisNumero(agej, "Age incorrect"));
			 		
			 		listeEquipes.get(idEnb-1).getListeJoueurs().remove(NJj-1);
			 		listeEquipes.get(idEnb-1).getListeJoueurs().add(NJj-1, new Joueur(nomj,prenomj,ageJnb,selecteSexe));
			 		
			 		frame.setVisible(false);
			 		JOptionPane.showMessageDialog(null,"Your entry is successfully added");
			 		menuJoueurs(listeEquipes, idEnb);
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
