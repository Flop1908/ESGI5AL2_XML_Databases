/**
 * 
 */
package Model;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

/**
 * @author Florent
 *
 */
public class ModelXPATH {
	
	private Document fichierXML;
	private String commandeXPATH;
	private String resultat;

	public void ExecuteCommand() {
		try{
			//création du XPath 
			XPathFactory fabrique = XPathFactory.newInstance();
			XPath xpath = fabrique.newXPath();
			
			//évaluation de l'expression XPath
			XPathExpression exp = xpath.compile(commandeXPATH);
			setResultat(exp.evaluate(fichierXML));
			
			System.out.println(resultat);
		}catch(XPathExpressionException xpee){
			xpee.printStackTrace();
		}
	}

	/**
	 * @return the fichierXML
	 */
	public Document getFichierXML() {
		return fichierXML;
	}

	/**
	 * @param fichierXML the fichierXML to set
	 */
	public void setFichierXML(Document fichierXML) {
		this.fichierXML = fichierXML;
	}

	/**
	 * @return the commandeXPATH
	 */
	public String getCommandeXPATH() {
		return commandeXPATH;
	}

	/**
	 * @param commandeXPATH the commandeXPATH to set
	 */
	public void setCommandeXPATH(String commandeXPATH) {
		this.commandeXPATH = commandeXPATH;
	}

	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * @param resultat the resultat to set
	 */
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	
}
