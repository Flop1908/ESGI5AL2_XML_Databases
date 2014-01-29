package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionWS {

	public Boolean Connection(String pseudo, String password) throws IOException
	{
		String URLauth = creationURL(pseudo,password);
		URL oracle = new URL(URLauth);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        
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
}
