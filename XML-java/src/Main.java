import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import Model.ModelGenerateXsdFromXml;
import Model.ModelXPATH;
import View.ConnectionView;


public class Main {

	public static void main(String[] args) {
		//ConnectionView wc = new ConnectionView();
		
		/*ModelXPATH xpa  = new ModelXPATH();
		DOMParser dp = new DOMParser();
		try {
			dp.parse("database.xml");
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = dp.getDocument();
		
		xpa.setFichierXML(doc);
		xpa.setCommandeXPATH("//*");
		xpa.ExecuteCommand();
		
		System.out.println(xpa.getResultat());*/
		
		ModelGenerateXsdFromXml gene = new ModelGenerateXsdFromXml();
		gene.setFileNameInput("file");
		gene.setFileNameOutput("file");
		System.out.println(ModelGenerateXsdFromXml.GenerateXSD());
		
	}

}
