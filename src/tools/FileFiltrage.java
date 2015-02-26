package tools;

import java.io.File;
import java.io.FilenameFilter;

public class FileFiltrage implements FilenameFilter {
	
	public boolean accept(File rep, String fichier) {

		if (fichier.endsWith(".json"))
			return true;

		return false;
	}

}
