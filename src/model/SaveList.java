package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import view.ConsoleView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controleur.InfoEquipes;

public class SaveList {

	public static void save(String nomListe, LinkedList <Equipe> listToSave) throws IOException
	{
		System.out.println("--- Serialize Started ---");
        String fileNameHisto = System.getProperty("user.dir")
        		+ "//src//data//historique//"+nomListe+".json";
        System.out.println("enregistré dans : " + fileNameHisto);
        

        Gson gson = new Gson();
       // Type listOfTestObject = new TypeToken<List<Equipe>>(){}.getType();

        //Make Serial
        System.out.println("test 2");

        Writer osWriter = new OutputStreamWriter( new FileOutputStream(fileNameHisto));
        
        //FileOutputStream output = new FileOutputStream(fileNameHisto);
        //Writer osWriter = new OutputStreamWriter(output);
 
        System.out.println("liste size : " + listToSave.size());

		gson.toJson(Collections.synchronizedList(listToSave), osWriter);
		osWriter.close();
		
		System.out.println("Fin Serialize");
		
		
		
	}
	
	public static LinkedList<Equipe> loadTeams (String nomListe) throws IOException
	{
		System.out.println("Deserialize Started");
        String fileNameHisto = System.getProperty("user.dir")
        		+ "//src//data//historique//"+nomListe+".json";
        System.out.println("enregistré dans : " + fileNameHisto);
        
        Gson gson = new Gson();
       
        Type listOfTestObject = new TypeToken<LinkedList<Equipe>>(){}.getType();
		//Eat Serial
        
        Reader isReader = new InputStreamReader(new FileInputStream(fileNameHisto));
        LinkedList<Equipe> listFromJson = gson.fromJson(isReader, listOfTestObject);
		List<Equipe> list2 = Collections.synchronizedList(listFromJson);
        isReader.close();
        
        LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();
        
        //On met les éléments de la List dans la LinkedList
        for (int i = 0; i<list2.size();i++)
        	listeEquipes.add(list2.get(i));
        
        System.out.println("Deserialize Ended ");
        
        return listeEquipes;
        
	}

	public static void main(final String[] args) throws IOException{
		LinkedList<Equipe> liste = InfoEquipes.inscrireEquipes();

		String s = "patate";
		save(s,liste);
		
		LinkedList<Equipe> listeapres = new LinkedList<Equipe>();
		
		listeapres = loadTeams(s);
		
		System.out.println("Avant : " );
		
		ConsoleView.afficherEquipesEtJoueurs(liste);
		System.out.println("Après : ");
	
		ConsoleView.afficherEquipesEtJoueurs(listeapres);
		
	}

}
