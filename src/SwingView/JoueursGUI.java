package SwingView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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


import model.Joueur;

public class JoueursGUI{

public static void menuJoueurs(LinkedList<Joueur> listeJoueurs) {
	
	JButton addequipe = new JButton ("Ajouter un joueur");
	JButton modfequipe = new JButton ("Modifier le joueur");
	JButton elimequipe = new JButton ("Eliminer le joueur");

	JButton gtournoi = new JButton ("Returner à l'info d'equipe");
	JLabel chequipe = new JLabel ("Choisir un joueur");
	JTextField chIdEquipe = new JTextField();
	JPanel panel1 = new JPanel();
	
	 //array bidimencional de objetos con los datos de la tabla
	Object[][] data = new Object[listeJoueurs.size()][5];
	 //array de String's con los títulos de las columnas
	 String[] columnNames = {"IdJoueur", "Prenom", "Nom","Age","Sexe"};
	 for (int i = 0; i < listeJoueurs.size(); i++){
		 data[i][0]= i+1;
		 data[i][1]= listeJoueurs.get(i).getPrenom();
		 data[i][2]= listeJoueurs.get(i).getNom();
		 data[i][3]= listeJoueurs.get(i).getAge();
		 data[i][4]= listeJoueurs.get(i).getSexe();
		 
	 }
	 //se crea la Tabla
	 final JTable table = new JTable(data, columnNames);
	 /*table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		    JTable table =(JTable) me.getSource();
		    

		       if (me.getClickCount() == 2 && table.getSelectedColumn()==3) {
		    	   int i= table.getSelectedRow();
		    	   LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
		    	   listeJoueurs=listeEquipes.get(i).getListeJoueurs();
		    	   menuJoueurs(listeJoueurs);
		    	  
		     }
		 }
		});*/
	 table.setEnabled(false);
	 JScrollPane scrollPane = new JScrollPane();
	 scrollPane.setViewportView(table); 
	 JPanel panel3 = new JPanel(new GridLayout(2,3));
	 panel3.add(chequipe);
	 panel3.add(chIdEquipe);
	 panel1.add(addequipe);
	 panel3.add(modfequipe);
	 panel3.add(elimequipe);
	 
	 panel3.add(gtournoi);
	
	 //Creamos un JscrollPane y le agregamos la JTable
	 JFrame frame2 = new JFrame();
	 frame2.setBackground(Color.WHITE);
	 frame2.setBounds(500, 500, 500, 300);
	 frame2.setLocationRelativeTo(null);
	 frame2.getContentPane().add(panel1,BorderLayout.PAGE_START);
	 frame2.getContentPane().add(scrollPane,BorderLayout.CENTER);
	 frame2.getContentPane().add(panel3,BorderLayout.PAGE_END);
	 frame2.setLocationRelativeTo(null);
	 frame2.setVisible(true);
	 
	 //Button actions
	 addequipe.addActionListener(new ActionListener() {
		 
         public void actionPerformed(ActionEvent e)
         {

             newJoueur(listeJoueurs);
             frame2.setVisible(false);
             
             
         }
     });   
	
	 
}
public static void newJoueur(LinkedList <Joueur> listeJoueurs) {
	 JTextField prenom = new JTextField();
	 JTextField nom = new JTextField();

	// Buttons
	 JButton create = new JButton("Create");
	 JButton cancel = new JButton("Cancel");
	 //style
	 create.setBackground(Color.LIGHT_GRAY); // background and colour for
	 //buttons
	 create.setForeground(Color.black);
	 cancel.setBackground(Color.LIGHT_GRAY); // background and colour for
	 //buttons
	 cancel.setForeground(Color.black);
	 create.setFocusable(false); // disable auto focus
	 cancel.setFocusable(false);
	
/*
* Panel setup
* ----------------------------------------------------------
*/
//panel1
	 JPanel panel1 = new JPanel();
//panel2 for Inputs
	 JPanel panel2 = new JPanel(new GridLayout(3, 2));
	 panel2.setBorder(new TitledBorder("Inscrire un Joueur"));
	 panel2.add(new JLabel("Prenom"));
	 panel2.add(prenom);
	 panel2.add(new JLabel("Nom"));
	 panel2.add(nom);

	 //panel3 for buttons
	 JPanel panel3 = new JPanel(new BorderLayout());
	 //inside panel3
	 JPanel p3_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	 p3_1.add(create);
	 p3_1.add(cancel);
	 panel3.add(p3_1, BorderLayout.CENTER);
	 //add Panels to the frame
	 JFrame addframe = new JFrame();
	 cancel.addActionListener(new ActionListener() {
		 
		 	public void actionPerformed(ActionEvent e2){
		 			JOptionPane.showMessageDialog(null, "your information will be lost");
		 			addframe.setVisible(false);
		 			menuJoueurs(listeJoueurs);}
	 		});
	 create.addActionListener(new ActionListener() {
	 
		 	public void actionPerformed(ActionEvent e2){
		 			createJoueur(listeJoueurs, prenom, nom);
		 			menuJoueurs(listeJoueurs);
		 			
		 			
		 			JOptionPane.showMessageDialog(null,"Your entry is successfully added");
		 			}
	 		});
	 addframe.add(panel1, BorderLayout.NORTH);
	 addframe.add(panel2, BorderLayout.CENTER);
	 addframe.add(panel3, BorderLayout.SOUTH);
	 addframe.setBackground(Color.WHITE);
     addframe.setBounds(500, 500, 500, 300);
     addframe.setLocationRelativeTo(null);
	 addframe.setVisible(true);
	 

	}

/*
* Create Method to instantiate an object
* ----------------------------------------------------------*/
private static void createJoueur(LinkedList <Joueur> listeJoueurs, JTextField prenom, JTextField nom) {
String prenomj = prenom.getText();
String nomj = nom.getText();
Joueur joueur = new Joueur();
joueur.setPrenom(prenomj);
joueur.setNom(nomj);
listeJoueurs.add(joueur);
//int total = listeEquipes.addressBook.size();
//mainGUI.addressBook.get(total-1).printPersonInFile();

}

}
