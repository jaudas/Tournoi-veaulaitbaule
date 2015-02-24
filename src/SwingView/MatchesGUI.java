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



public class MatchesGUI{

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
		 
	 
	 //se crea la Tabla
	 final JTable table = new JTable(data, columnNames);

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
         {frame2.setVisible(false);
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
         {    frame2.setVisible(false);
             modifierEquipe(listeEquipes, chIdEquipe);
             
            
          }
	 });
	 elimequipe.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
         {	eliminerEquipe(listeEquipes, chIdEquipe);
             frame2.setVisible(false);
             menuEquipes(listeEquipes);
          }
	 });
	 gtournoi.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
		 { Menus.menuTournoi();
		 frame2.setVisible(false);
		 }
	 });
	 
}
public static void newEquipe(LinkedList <Equipe> listeEquipes) {
	 JTextField nom = new JTextField();
	 JTextField description = new JTextField();
	 

		

	// Buttons
	 JButton create = new JButton("Save");
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
		 			createEquipe(listeEquipes, nom, description, listeEquipes.size());
		 			addframe.setVisible(false);
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
private static void createEquipe(LinkedList <Equipe> listeEquipes, JTextField nom, JTextField description,  int i) {
String nomequipe = nom.getText();
String descriptionequipe = description.getText();

Equipe equipe = new Equipe();
equipe.setNom(nomequipe);
equipe.setDescription(descriptionequipe);

equipe.setIdEquipe(i+1);
listeEquipes.add(equipe);



}

private static void eliminerEquipe(LinkedList <Equipe> listeEquipes, JTextField idEquipe) {
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
	 JButton create = new JButton("Save");
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
	 panel2.setBorder(new TitledBorder("Modifier un Equipe"));
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
		 			menuEquipes(listeEquipes);
		 			}
	 		});
	 create.addActionListener(new ActionListener() {
	 
		 	public void actionPerformed(ActionEvent e2){
		 		String nomequipe = nom.getText();
		 		String descriptionequipe = description.getText();
		 		listeEquipes.get(idEnb-1).setNom(nomequipe);
		 		listeEquipes.get(idEnb-1).setDescription(descriptionequipe);
		 		addframe.setVisible(false);
		 		JOptionPane.showMessageDialog(null,"Your entry is successfully added");
		 		menuEquipes(listeEquipes);
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

}
