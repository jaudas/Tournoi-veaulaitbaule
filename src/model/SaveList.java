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

import tools.FileFiltrage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class SaveList {

	public static void save(String nomListe, LinkedList <Equipe> listToSave) throws IOException
	{
		String fileNameHisto = System.getProperty("user.dir")+ "//src//data//historique//"+nomListe+".json";  

		Gson gson = new Gson();

		//Make Serial
		Writer osWriter = new OutputStreamWriter( new FileOutputStream(fileNameHisto));

		gson.toJson(Collections.synchronizedList(listToSave), osWriter);
		osWriter.close();
	}

	public static LinkedList<Equipe> loadTeams (String nomListe) throws IOException
	{
		String fileNameHisto = System.getProperty("user.dir")
				+ "//src//data//historique//"+nomListe;

		Gson gson = new Gson();

		Type listOfTeams = new TypeToken<LinkedList<Equipe>>(){}.getType();
	
		//Eat Serial

		Reader isReader = new InputStreamReader(new FileInputStream(fileNameHisto));
		List<Equipe> listFromJson = gson.fromJson(isReader, listOfTeams);
		List<Equipe> list2 = Collections.synchronizedList(listFromJson);
		isReader.close();

		LinkedList<Equipe> listeEquipes = new LinkedList<Equipe>();

		//On met les éléments de la List dans la LinkedList
		for (int i = 0; i<list2.size();i++)
			listeEquipes.add(list2.get(i));

		return listeEquipes;

	}

	public static void majStat(LinkedList<Equipe> listeEquipe)
	{//Fonction permettant de mettre à jour les statistiques globales des équipes
	
		Equipe temp;
		for (int i = 0; i<listeEquipe.size();i++)
		{
			temp = listeEquipe.get(i);
			temp.setHistoNbMatchJoue(temp.getHistoNbMatchJoue()+temp.getNbMatchJoue());
			temp.setHistoNbSetGagne(temp.getHistoNbSetGagne()+temp.getNbSetGagne());
			temp.setHistoNbSetPerdu(temp.getHistoNbSetPerdu()+temp.getNbSetPerdu());
			temp.setHistoNbVictoire(temp.getHistoNbVictoire()+temp.getNbVictoire());
		}

	}

	public static void resetStatTournoi(LinkedList<Equipe> liste)
	{//Fonction permettant d'effacer les statistiques du tournoi, avant d'enregistrer la liste des équipes
		Equipe temp;
		for (int i = 0; i<liste.size();i++)
		{
			temp = liste.get(i);
			temp.setNbMatchJoue(0);
			temp.setNbSetGagne(0);
			temp.setNbSetPerdu(0);
			temp.setNbVictoire(0);
		}
	}

	public static String[] getListeGroupeEquipes()
	{	
		// obtenir la liste de contenu du répertoire courant
        String[] dir = new java.io.File(System.getProperty("user.dir")+ "//src//data//historique//").list(new FileFiltrage( ));

        // Trier le résultat
        java.util.Arrays.sort(dir);
 
        return dir;
		
	}

}
