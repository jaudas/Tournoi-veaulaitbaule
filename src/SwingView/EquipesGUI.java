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

import model.Equipe;
import model.Joueur;

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
	
	 //array bidimencional de objetos con los datos de la tabla
	Object[][] data = new Object[listeEquipes.size()][4];
	 //array de String's con los títulos de las columnas
	 String[] columnNames = {"ID", "Nom", "Description","Joueurs"};
	 for (int i = 0; i < listeEquipes.size(); i++){
		 data[i][0]= listeEquipes.get(i).getIdEquipe();
		 data[i][1]= listeEquipes.get(i).getNom();
		 data[i][2]= listeEquipes.get(i).getDescription();
		 data[i][3]= "joueurs";
		 
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
	 panel3.add(affjequipe);
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
             newEquipe(listeEquipes);
             frame2.setVisible(false);
          }
     });   
	 affjequipe.addActionListener(new ActionListener() {
		 
         public void actionPerformed(ActionEvent e)
         {
             JoueursGUI.menuJoueurs(listeEquipes.get(2).getListeJoueurs());
             
          }
     });  
	
	 
}
public static void newEquipe(LinkedList <Equipe> listeEquipes) {
	 JTextField nom = new JTextField();
	 JTextField description = new JTextField();

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
	 panel2.setBorder(new TitledBorder("Inscrire un Equipe"));
	 panel2.add(new JLabel("Nom"));
	 panel2.add(nom);
	 panel2.add(new JLabel("Description"));
	 panel2.add(description);

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
		 			menuEquipes(listeEquipes);}
	 		});
	 create.addActionListener(new ActionListener() {
	 
		 	public void actionPerformed(ActionEvent e2){
		 			createEquipe(listeEquipes, nom, description);
		 			menuEquipes(listeEquipes);
		 			
		 			
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
private static void createEquipe(LinkedList <Equipe> listeEquipes, JTextField nom, JTextField description) {
String nomequipe = nom.getText();
String descriptionequipe = description.getText();
Equipe equipe = new Equipe();
equipe.setNom(nomequipe);
equipe.setDescription(descriptionequipe);
int i = listeEquipes.size();
equipe.setIdEquipe(i+1);
listeEquipes.add(equipe);
//int total = listeEquipes.addressBook.size();
//mainGUI.addressBook.get(total-1).printPersonInFile();

}

}
