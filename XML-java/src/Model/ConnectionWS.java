package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionWS {

	public Boolean Connection(String pseudo, String password) throws IOException
	{
		String URLauth = creationURL(pseudo,password);
		URL url = new URL(URLauth);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
        
        String reponseWSauth = null;
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        	reponseWSauth += inputLine;
        in.close();
        
        return gestionConnection(reponseWSauth);
	}

	private String creationURL(String pseudo, String password) {
		
		StringBuilder str_Build = new StringBuilder();
		str_Build.append("http://localhost:82/XML/wsauth.php?login=");
		str_Build.append(pseudo);
		str_Build.append("&password=");
		str_Build.append(password);
			
		return str_Build.toString();
	}

	private Boolean gestionConnection(String reponseWSauth) {
		
		Boolean reponse = false;
		
		if (reponseWSauth.contains("<etat_connexion>OK</etat_connexion>"))
		{
			//garder les infos de la connection
			reponse = true;
		}
		
		return reponse;
	}
	
	
	public void GetXML(User user) throws IOException
	{
		
		String URLxml = creationURLXML(user.GetPseudo());
		URL url = new URL(URLxml);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
        
        String reponseWSxml = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        	reponseWSxml += inputLine;
        in.close();
        
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("database.xml")));
        	// normalement si le fichier n'existe pas, il est crée à la racine du projet
        	writer.write(reponseWSxml);
    	 
        	writer.close();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
        
	}
	
	private String creationURLXML(String user)
	{
		StringBuilder str_Build = new StringBuilder();
		str_Build.append("http://localhost:82/XML/database_");
		str_Build.append(user);
		str_Build.append(".xml");
			
		return str_Build.toString();
	}
}
