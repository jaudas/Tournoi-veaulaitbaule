package model;


import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import model.Equipe;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SaveList {

	JSONParser parser = new JSONParser();

	public static void save(String nomListe, LinkedList <Equipe> listToSave) throws IOException, org.json.simple.parser.ParseException, ParseException
	{
		JSONObject obj = new JSONObject();
		//JSONArray list = (JSONArray)listToSave;

		//Nom de la liste + liste d'équipe
		for(int i=0; i<listToSave.size();i++)
		{
			obj.put("Nom :",listToSave.get(i).getNom());
			obj.put("Descriptions :", listToSave.get(i).getDescription());
			obj.put("Joueurs : ", listToSave.get(i).getListeJoueurs());
			obj.put("Nombre de matchs joués", listToSave.get(i).getHistoNbMatchJoue());
			obj.put("Nombre de Victoires", listToSave.get(i).getHistoNbVictoire());
			obj.put("Nombre de Sets Gagnés", listToSave.get(i).getHistoNbSetGagne());
			obj.put("Nombre de Sets Perdus", listToSave.get(i).getHistoNbSetPerdu());
		}
		
		


		StringWriter out = new StringWriter();
		obj.writeJSONString(out);

 		String jsonText = obj.toJSONString();
		System.out.print(jsonText);


		try {

			FileWriter file = new FileWriter(System.getProperty("user.dir")+ "//src//data//historique//"+nomListe+".json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
