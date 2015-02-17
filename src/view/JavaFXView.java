package view;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.LinkedList;




import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import tools.FilesTools;
import controleur.InfoEquipes;
import model.Equipe;
import model.Joueur;
import javafx.stage.Stage;             // |
import javafx.scene.Group;             // |\ Librerías necesarias
import javafx.scene.Scene;             
import javafx.application.Application; // |
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class JavaFXView extends Application {
	 private TableView table = new TableView();
 
	public static void main(String[] args) {
		//Pour ejecuter l'application
		launch(args);
		
	}
 
	
	public void start( Stage primaryStage ){
		Group root = new Group();
		Scene scene = new Scene( root, 500, 500 );
		primaryStage.setTitle("Tournoi de veaulaitbaule");
		primaryStage.setScene( scene );
		
		//Creation de text
		Text bienvenu=new Text(150,150,"Bienvenu au gestor du tournois de veaulait");
		
		//Creation boton
		Button butonInscrireEquipes = new Button("Inscrire des equipes");
		butonInscrireEquipes.setDefaultButton(true);
		butonInscrireEquipes.setLayoutX(190);
		butonInscrireEquipes.setLayoutY(225);
		butonInscrireEquipes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	root.getChildren().remove(butonInscrireEquipes);
				root.getChildren().remove(bienvenu);
				//Creation de text
				Text aleatoireOuManual=new Text(150,150,"Crear un tournoi aleatoire ou inscrire manualment des equipes?");
				Button butonAleatoire= new Button("Generer des equipes aleatoire");
				
				butonAleatoire.setDefaultButton(true);
				butonAleatoire.setLayoutX(190);
				butonAleatoire.setLayoutY(225);
				butonAleatoire.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	afficherEquipesAleatoire();
				    }
				});
				
				Button butonManual = new Button("Inscrire des equipes");
				butonManual.setDefaultButton(true);
				butonManual.setLayoutX(190);
				butonManual.setLayoutY(225);
				butonManual.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	afficherEquipesAleatoire();
				    }
				});
				root.getChildren().add(butonAleatoire);
				root.getChildren().add(aleatoireOuManual);
				root.getChildren().add(butonManual);
		    }
		   
		    });
		
		
		//Se agrega el boton
		root.getChildren().add(butonInscrireEquipes);
		root.getChildren().add(bienvenu);
		//Para mostrar la visible, semejante al setVisible(true)
		primaryStage.show();		
	}
	
	public void afficherEquipesAleatoire(){
		Group group = new Group();
		Scene scene = new Scene(group);
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("List d'equipes");
		secondaryStage.setWidth(400);
		secondaryStage.setHeight(500);
		
		
 
		ObservableList<Equipe> listeEquipes = FXCollections.observableArrayList();{
			int NE=12;
			for (int i = 1; i <= NE; i++) {
			Equipe equipe= new Equipe();
			genererEquipe(i,equipe);
			}
			
		}
				
		table.setEditable(true);
		table.setMinWidth(200);
 
		TableColumn firstNameCol = new TableColumn<Equipe, String>("ID equipe");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("idEquipe"));
		firstNameCol.setMinWidth(140);
		TableColumn lastNameCol = new TableColumn("Nom");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom"));
		lastNameCol.setMinWidth(140);
		TableColumn phoneCol = new TableColumn("Joueurs");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nbJoueurs"));
		phoneCol.setMinWidth(100);
 
		table.setItems(listeEquipes);
		table.getColumns().addAll(firstNameCol, lastNameCol, phoneCol);
 
		group.getChildren().add(table);
 
		secondaryStage.setScene(scene);
		secondaryStage.show();
	}
	
	
	public static void genererEquipe(int i, Equipe equipe){
		LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();   
		//Attributes
		String description;
		int nbJoueurs = 0;  		
		System.out.println("Création automatique des Equipes: ");
		JSONParser parser=new JSONParser();
		String stringFileNomsEquipes;
		try {
			stringFileNomsEquipes = FilesTools.readFile (System.getProperty("user.dir")+"//src//data//nomequipe.json",StandardCharsets.UTF_8);
			Object parsedFile = parser.parse(stringFileNomsEquipes);
			JSONArray arrayNomsEquipe = (JSONArray)parsedFile;
			description = "Equipe de veaulait";
			nbJoueurs = 6;
			listeJoueurs=InfoEquipes.inscrireJoueursAuto(nbJoueurs);
			//On cree l'objet temporaire "aux" de type Equipe pour aider a l'initialisation des valeurs
			//On attribue un valor a chaque attribute
			Equipe equipe1 = new Equipe(arrayNomsEquipe);
			equipe1.setIdEquipe(i);
			//aux.setNom(nom); Le nom est donné directement dans la fonction
			equipe1.setDescription(description);
			equipe1.setNbJoueurs(nbJoueurs);
			equipe1.setListeJoueurs(listeJoueurs);
			equipe=equipe1;			

		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
			}
		
		
		
		
	
	}
 
}