package SwingView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Equipe;
import model.Joueur;
import tools.FilesTools;
import controleur.InfoEquipes;


public class FirstMenu{
	public void bienvenu() {
		
		JFrame frame = new JFrame("Tournoi du veaulait");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 500, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Bienvenu au tournoi du veaulait");
		label.setHorizontalAlignment(0);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		label.setBackground(Color.WHITE);
		
		String text= "<html>Vous pouves choisir la creation automatique des equipes <P>" +
				 "<html>ou incrire les equipes manualment: <P>";
		
		JLabel instruction= new JLabel("<html><div style=\"text-align: center;\">"+text);
		instruction.setHorizontalAlignment(0);
	
		instruction.setFont(new Font("Arial", Font.ITALIC, 22));
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.getContentPane().add(instruction, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new GridLayout(0, 1, 0, 3));
		
		frame.getContentPane().add(buttons, BorderLayout.PAGE_END);
		
		JButton b1 = new JButton("Creation automatique des equipes");
		b1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                listeEquipes=genererEquipes();
                frame.setVisible(false);
                EquipesGUI.menuEquipes(listeEquipes);
                
            }
        });   
	
	    JButton b2 = new JButton("Inscription manuel des equipes");
	   
	    b2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
      
            	//Execute when button is pressed
            	int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Vous voulez ajouter le premier equipe?","Warning",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){ 
                LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
                frame.setVisible(false);
                
                
                EquipesGUI.newEquipe(listeEquipes);
               
                }else if(dialogResult==JOptionPane.NO_OPTION){
                	bienvenu();
                }
                
            }
        });   
	
		
		buttons.add(b1);
		buttons.add(b2);
		frame.setVisible(true);
		
}
	
	public static LinkedList<Equipe> genererEquipes(){
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
		JSONParser parser=new JSONParser();
		String stringFileNomsEquipes;
		try {
			stringFileNomsEquipes = FilesTools.readFile (System.getProperty("user.dir")+"//src//data//nomequipe.json",StandardCharsets.UTF_8);
			Object parsedFile = parser.parse(stringFileNomsEquipes);
			JSONArray arrayNomsEquipe = (JSONArray)parsedFile;
			int NE;
			int i;
			//On demande le nombre d'equipes à inscrire 
			do {
				NE = QuestionsDialogues.introNumero( "Combien d'équipes voulez-vous générer automatiquement ?: ");
				
				if (NE>arrayNomsEquipe.size()){
					
					NE =QuestionsDialogues.introNumero( "Trop d'equipes. Combien d'équipes voulez-vous générer automatiquement ?: ");
				
				}
			
				
			} while ((NE < 0) || (NE > arrayNomsEquipe.size()));
			
			for ( i = 1; i <= NE; i++) {

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

				}
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	}
		return listeEquipes;
		
	}
		
	
	
	
	
	
	public void menuJoueurs(LinkedList<Joueur> listeJoueurs) {
		 
		 //array bidimencional de objetos con los datos de la tabla
		Object[][] data = new Object[listeJoueurs.size()][4];
		 //array de String's con los títulos de las columnas
		 String[] columnNames = {"Prenom", "Nom", "Age", "Sexe"};
		 for (int i = 0; i < listeJoueurs.size(); i++){
			 data[i][0]= listeJoueurs.get(i).getPrenom();
			 data[i][1]= listeJoueurs.get(i).getNom();
			 data[i][2]= listeJoueurs.get(i).getAge();
			 data[i][3]= listeJoueurs.get(i).getSexe();
		 }
		 //se crea la Tabla
		 final JTable table = new JTable(data, columnNames);
		 table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 table.setEnabled(false);
		 //Creamos un JscrollPane y le agregamos la JTable
		 JFrame frame3 = new JFrame();
		 frame3.setBackground(Color.WHITE);
		 
		 frame3.setBounds(500, 500, 500, 300);
		 frame3.setLocationRelativeTo(null);
		 JScrollPane scrollPane = new JScrollPane();
		 //Agregamos el JScrollPane al contenedor
		 //scrollPane.getContentPane().add(table, BorderLayout.CENTER);
		 scrollPane.setViewportView(table); 
		 scrollPane.setBounds(500, 500, 500, 300);
		 frame3.getContentPane().add(scrollPane,BorderLayout.CENTER);
		 frame3.setLocationRelativeTo(null);
		 frame3.setVisible(true);
		 //manejamos la salida
	}
	
	
	
	
public static void main(String[] args) {
FirstMenu menu = new FirstMenu();
javax.swing.SwingUtilities.invokeLater(new Runnable() {
public void run() { menu.bienvenu(); }
});
}
}