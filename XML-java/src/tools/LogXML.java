/**
 * 
 */
package tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Florent
 *
 */
public class LogXML {
	
	/**
	 * Caractère de séparation des info du log
	 */
	private final static char SEPARATOR = ' ';

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification d'une valeur
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifiée
	 * @param _table nom de la table modifiée
	 * @param _field nom du champ modifié
	 * @param _oldValue ancienne valeur (laisser vide si insertion)
	 * @param _newValue nouvelle valeur
	 */
	public static void LogChangeValue(String _user, String _typeOperation, String _base, String _table,
			String _field, String _oldValue, String _newValue) {

		StringBuilder sb_LogLine = new StringBuilder();
		
		sb_LogLine.append(_user + SEPARATOR);
		sb_LogLine.append(_typeOperation + SEPARATOR);
		sb_LogLine.append(_base + SEPARATOR);
		sb_LogLine.append(_table + SEPARATOR);
		sb_LogLine.append(_field + SEPARATOR);
		sb_LogLine.append(_oldValue + SEPARATOR);
		sb_LogLine.append(_newValue + SEPARATOR);
		
		WriteLogLine(sb_LogLine.toString());		
	}

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification d'une table
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifiée
	 * @param _table nom de la table modifiée
	 * @param _oldField nom de l'ancien champ (laisser vide si insertion)
	 * @param _newField nom du nouveau champ
	 */
	public static void LogChangeTable(String _user, String _typeOperation, String _base, String _table,
			String _oldField, String _newField) {

		StringBuilder sb_LogLine = new StringBuilder();

		sb_LogLine.append(_user + SEPARATOR);
		sb_LogLine.append(_typeOperation + SEPARATOR);
		sb_LogLine.append(_base + SEPARATOR);
		sb_LogLine.append(_table + SEPARATOR);
		sb_LogLine.append(_oldField + SEPARATOR);
		sb_LogLine.append(_newField + SEPARATOR);
		
		WriteLogLine(sb_LogLine.toString());
	}

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification de la base de données
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifiée
	 * @param _oldTable nom de l'ancienne table (laisser vide si création)
	 * @param _newTable nom de la nouvelle table
	 */
	public static void LogChangeDatebase(String _user, String _typeOperation, String _base, String _oldTable,
			String _newTable) {

		StringBuilder sb_LogLine = new StringBuilder();

		sb_LogLine.append(_user + SEPARATOR);
		sb_LogLine.append(_typeOperation + SEPARATOR);
		sb_LogLine.append(_base + SEPARATOR);
		sb_LogLine.append(_oldTable + SEPARATOR);
		sb_LogLine.append(_newTable + SEPARATOR);
		
		WriteLogLine(sb_LogLine.toString());
	}
	
	/**
	 * Fonction d'écriture d'une ligne dans le log
	 * @param _lineToWrite
	 */
	private static void WriteLogLine(String _lineToWrite) {
		
		String logFileOfToday = LogFileOfToday();
		FileWriter out;
		String completeLogLine = BuildCompleteLogLine(_lineToWrite);
		
		try {
			
			out = new FileWriter(logFileOfToday,true);
	        out.write(completeLogLine);
	        out.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Fonction de construction de la ligne de log
	 * @param _lineToWrite
	 * @return
	 */
	private static String BuildCompleteLogLine(String _lineToWrite) {

		StringBuilder sb_CompleteLogLine = new StringBuilder();
		sb_CompleteLogLine.append("\n");
		
		sb_CompleteLogLine.append(BuildingDateStamp() + SEPARATOR);
		sb_CompleteLogLine.append(BuildingTimeStamp() + SEPARATOR);
		sb_CompleteLogLine.append(_lineToWrite);
		
		return sb_CompleteLogLine.toString();
	}

	/**
	 * Fabrication de la partie heure
	 * @return
	 */
	private static String BuildingTimeStamp(){
		
		StringBuilder str_TimeStamp = new StringBuilder();
		Date date_TimeStamp = new Date();
		
		DateFormat df_TimeStamp = new SimpleDateFormat("hh:mm:ss");
		str_TimeStamp.append(df_TimeStamp.format(date_TimeStamp));
		
		return str_TimeStamp.toString();
	}
	
	/**
	 * Fabrication de la partie date
	 * @return
	 */
	private static String BuildingDateStamp(){
		
		StringBuilder str_TimeStamp = new StringBuilder();
		Date date_TimeStamp = new Date();
		
		DateFormat df_TimeStamp = new SimpleDateFormat("yyyy-MM-dd");
		str_TimeStamp.append(df_TimeStamp.format(date_TimeStamp));
		
		return str_TimeStamp.toString();
	}
	
	/**
	 * Création du fichier de l'og s'il n'existe pas déjà
	 * @param _fileName
	 * @return
	 */
	private static String CreateFile(String _fileName){
		
		File fileToCreate = new File(_fileName);
		
		try {
			if (! fileToCreate.exists()){
				fileToCreate.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return _fileName;
	}
	
	/**
	 * Fonction pour nommer le fichier et le créer
	 * @return
	 */
	private static String LogFileOfToday(){
		
		String logFileName = BuildingDateStamp() + ".txt";
		CreateFile(logFileName);

		return logFileName;
	}
}
