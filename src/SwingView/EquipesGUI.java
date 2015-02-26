package SwingView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tools.FilesTools;
import controleur.InfoEquipes;
import model.Equipe;
import model.Joueur;



public class EquipesGUI{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void menuEquipes(LinkedList<Equipe> listeEquipes, boolean elimEqp) {
		 
		JButton addequipe = new JButton ("Ajouter un equipe");
		JButton modfequipe = new JButton ("Modifier l'equipe");
		JButton elimequipe = new JButton ("Eliminer l'equipe");
		JButton affjequipe = new JButton ("Afficher les joueurs de l'equipe");
		JButton gtournoi = new JButton ("Generer tournois");
		gtournoi.setBackground(Color.BLUE);
		gtournoi.setForeground(Color.white);
		
		JLabel chequipe = new JLabel ("Choisir un equipe");
		JPanel panel1 = new JPanel();
		
		String[] bookTitles = new String[listeEquipes.size()];
		for(int i=0; i<listeEquipes.size(); i++){
		bookTitles[i]=listeEquipes.get(i).getNom();
		
		}
		 JComboBox<String> chIdEquipe = new JComboBox<>(bookTitles);
		 
		 //Creation du tableu pour afficher des equipes
		 Object[][] data = new Object[listeEquipes.size()][3];
		 String[] columnNames = { "Nom", "Description"," Nb Joueurs"};
		 for (int i = 0; i < listeEquipes.size(); i++){
			 listeEquipes.get(i).setIdEquipe(i+1);
			 
			 data[i][0]= listeEquipes.get(i).getNom();
			 data[i][1]= listeEquipes.get(i).getDescription();
			 if (listeEquipes.get(i).getListeJoueurs()==null){data[i][2]="Sans information";
			 }else{data[i][2]= listeEquipes.get(i).getListeJoueurs().size();
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
		 if(elimEqp==true){panel3.add(elimequipe);}
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
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 
		 //Button actions
		 addequipe.addActionListener(new ActionListener() {
			 
	         public void actionPerformed(ActionEvent e)
	         {
	             newEquipe(listeEquipes,elimEqp);
	             frame.setVisible(false);
	          }
	     });   
		 affjequipe.addActionListener(new ActionListener() {
			 
	         public void actionPerformed(ActionEvent e)
	         {	frame.setVisible(false);
	         	int idE =chIdEquipe.getSelectedIndex();
	     		
	        	if(listeEquipes.get(idE).getNbJoueurs()==0){   	//Execute when button is pressed
	         		int dialogButton = JOptionPane.YES_NO_OPTION;
	         		int dialogResult = JOptionPane.showConfirmDialog (null, "Vous voulez ajouter le premier joueur?","Warning",dialogButton);
	         		if(dialogResult == JOptionPane.YES_OPTION){ 
	         			JoueursGUI.newJoueur(listeEquipes,idE,true,elimEqp);
	     
	         		}else if(dialogResult==JOptionPane.NO_OPTION){
	            	menuEquipes(listeEquipes,elimEqp);
	         		}
	        	}else{JoueursGUI.menuJoueurs(listeEquipes, idE,elimEqp);}   
	          }
	     });  
		 modfequipe.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {  
	             modifierEquipe(listeEquipes, chIdEquipe,elimEqp);
	          }
		 });
		 elimequipe.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	         {	eliminerEquipe(listeEquipes, chIdEquipe);
	            frame.setVisible(false);
	            menuEquipes(listeEquipes,elimEqp);}
	          
		 });
		 gtournoi.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 { 
			   Menus.menuTournoi(listeEquipes);
			   frame.setVisible(false);
			 }
		 });
		 
	}
	
	
	public static void newEquipe(LinkedList <Equipe> listeEquipes,boolean elimEqp) {
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
			 			JOptionPane.showMessageDialog(null, "Votre information ne sera pas ajouté!");
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes,elimEqp);}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 			createEquipe(listeEquipes, nom, description);
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes,elimEqp);
			 			JOptionPane.showMessageDialog(null,"Information correctement ajouté!");
			 			}
		 		});
	
		 frame.getContentPane().add(panel1, BorderLayout.NORTH);
		 frame.getContentPane().add(panel2, BorderLayout.CENTER);
		 frame.getContentPane().add(panel3, BorderLayout.SOUTH);
		 frame.setBackground(Color.WHITE);
	     frame.setBounds(500, 500, 500, 300);
	     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
	     frame.setLocationRelativeTo(null);
		 frame.setVisible(true);

	}

/*
* Create Method to instantiate an object
* ----------------------------------------------------------*/
	private static void createEquipe(LinkedList <Equipe> listeEquipes, JTextField nom, JTextField description) 
	{	//On lis les infos
		String nomequipe = nom.getText();
		String descriptionequipe = description.getText();
		//Creation d'equipe
		Equipe equipe = new Equipe();
		equipe.setNom(nomequipe);
		equipe.setDescription(descriptionequipe);
		
		listeEquipes.add(equipe);
	}

	private static void eliminerEquipe(LinkedList <Equipe> listeEquipes, JComboBox<String> idEquipe) 
	{
		int idE = idEquipe.getSelectedIndex();
		
		listeEquipes.remove(idE);

	}




	public static void modifierEquipe(LinkedList <Equipe> listeEquipes, JComboBox<String> idEquipe,boolean elimEqp) {
		int idE = idEquipe.getSelectedIndex();
		

		JTextField nom = new JTextField();
		JTextField description = new JTextField();
		nom.setText(listeEquipes.get(idE).getNom());
		description.setText(listeEquipes.get(idE).getDescription());
		
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
			 			JOptionPane.showMessageDialog(null, "Votre information ne sera pas ajoutée!");
			 			frame.setVisible(false);
			 			menuEquipes(listeEquipes,elimEqp);
			 			}
		 		});
		 create.addActionListener(new ActionListener() {
		 
			 	public void actionPerformed(ActionEvent e2){
			 		String nomequipe = nom.getText();
			 		String descriptionequipe = description.getText();
			 		listeEquipes.get(idE).setNom(nomequipe);
			 		listeEquipes.get(idE).setDescription(descriptionequipe);
			 		frame.setVisible(false);
			 		JOptionPane.showMessageDialog(null,"Information correctement ajoutée!");
			 		menuEquipes(listeEquipes,elimEqp);
			 		}
		 		});
		 frame.getContentPane().add(panel1, BorderLayout.NORTH);
		 frame.getContentPane().add(panel2, BorderLayout.CENTER);
		 frame.getContentPane().add(panel3, BorderLayout.SOUTH);
		 frame.setBackground(Color.WHITE);
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menus.class.getResource("/images/Volleyball.jpg")));
	     frame.setBounds(500, 500, 500, 300);
	     frame.setLocationRelativeTo(null);
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

			//On demande le nombre d'equipes à inscrire 
 
			  int NE=0;
			  boolean numOK=false;
			  do{
				  try{
					  NE=Integer.parseInt(JOptionPane.showInputDialog( new JFrame(),"Combien d'equipes vous voulez génerer?","Question", JOptionPane.QUESTION_MESSAGE));
					  numOK=true;
				  }
				  catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Mauvais num!");
					numOK=false;
				  }
			  }while(!numOK);
			
			  if (NE > arrayNomsEquipe.size()) {
					numOK=false;
				  do{
					  try{
						  NE=Integer.parseInt(JOptionPane.showInputDialog( new JFrame(),"Trop d'equipes! Combien d'equipes vous voulez génerer?","Question", JOptionPane.QUESTION_MESSAGE));
						  numOK=true;
					  }
					  catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Mauvais num!");
						numOK=false;
					  }
				  }while(!numOK);
				}
			
			for (int i = 1; i <= NE; i++) {
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
				System.out.println(aux.toString());
				}
		
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return listeEquipes;
		
	}
	
}
