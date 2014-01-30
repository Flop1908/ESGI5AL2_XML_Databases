/**
 * 
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Florent
 * 
 */
public class ModelGenerateXsdFromXml {

	private static String fileNameInput = "";
	private static String fileNameOutput = "";

	/**
	 * Fonction de génération du XSD
	 * @return
	 */
	public static boolean GenerateXSD() {

		boolean conversionOK = false;
		String[] ligneDeCommande;

		// Vérif fichier d'entré renseigné
		if (fileNameInput.isEmpty())
			conversionOK = false;

		// Vérif fichier de sortie renseigné
		else if (fileNameOutput.isEmpty())
			conversionOK = false;

		else {
			//Création de la ligne de commande
			ligneDeCommande = BuildCommandLine(getFileNameInput(),
					getFileNameOutput()).split("[ ]");

		 try {
		 	//Envoi de la commande
		 	ProcessBuilder pb=new ProcessBuilder(ligneDeCommande);
		 	Process process=pb.start();
            conversionOK = true;

	        } catch (Exception e) {
	            e.printStackTrace(System.err);
	        }
			
		}
		return conversionOK;
	}

	/**
	 * Fonction de construction de la ligne de commande
	 * @param _fileNameInput Fichier xml d'entrée
	 * @param _fileNameOutput Fichier xsd de sortie
	 * @return
	 */
	private static String BuildCommandLine(String _fileNameInput,
			String _fileNameOutput) {

		StringBuilder sb_CommandLine = new StringBuilder();
		String cheminComplet = FindAbsolutePath();
		
		//On ajoute le chemin complet pour etre sur du bon déroulement
		sb_CommandLine.append("java -jar ");
		sb_CommandLine.append("\"" + cheminComplet + "trang.jar\" ");
		sb_CommandLine.append("\"" + cheminComplet + getFileNameInput() + "\" ");
		sb_CommandLine.append("\"" + cheminComplet + getFileNameOutput() + "\"");

		return sb_CommandLine.toString();
	}

	private static String FindAbsolutePath() {

		File trangJar = new File("trang.jar");
		String absolutePath = trangJar.getAbsolutePath();
		
		//On récupère le chemin complet sans le nom de fichier
		absolutePath = absolutePath.substring(0, absolutePath.indexOf(trangJar.getName()));
		
		return absolutePath;
	}

	/**
	 * @return the fileNameInput
	 */
	public static String getFileNameInput() {
		return fileNameInput;
	}

	/**
	 * @param fileNameInput
	 *            the fileNameInput to set
	 */
	public void setFileNameInput(String fileNameInput) {
		if (fileNameInput.endsWith(".xml")) this.fileNameInput = fileNameInput;
		else this.fileNameInput = fileNameInput + ".xml";
	}

	/**
	 * @return the fileNameOutput
	 */
	public static String getFileNameOutput() {
		return fileNameOutput;
	}

	/**
	 * @param fileNameOutput
	 *            the fileNameOutput to set
	 */
	public void setFileNameOutput(String fileNameOutput) {
		if (fileNameOutput.endsWith(".xsd")) this.fileNameOutput = fileNameOutput;
		else this.fileNameOutput = fileNameOutput + ".xsd";
	}

}
