import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import tools.LogXML;

import Model.ModelXPATH;
import View.ConnectionView;


public class Main {

	public static void main(String[] args) {
		
		ConnectionView wc = new ConnectionView();
		
		/* exemple utilisation XPATH
		ModelXPATH xpa  = new ModelXPATH();
		DOMParser dp = new DOMParser();
		try {
			dp.parse("file.xml");
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = dp.getDocument();
		
		xpa.setFichierXML(doc);
		xpa.setCommandeXPATH("//*");
		xpa.ExecuteCommand();
		
		System.out.println(xpa.getResultat());
		*/
		
		/*Exemple utilisation des logs
		LogXML.LogChangeValue("_user", "_typeOperation", "_base", "_table", "_field", "_oldValue", "_newValue");
		*/
	}

}
