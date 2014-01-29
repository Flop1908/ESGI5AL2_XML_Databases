/**
 * 
 */
package tools;

/**
 * @author Florent
 *
 */
public class LogXML {

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification d'une valeur
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifi�e
	 * @param _table nom de la table modifi�e
	 * @param _field nom du champ modifi�
	 * @param _oldValue ancienne valeur (laisser vide si insertion)
	 * @param _newValue nouvelle valeur
	 */
	public static void LogChangeValue(String _user, String _typeOperation, String _base, String _table,
			String _field, String _oldValue, String _newValue) {
				
	}

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification d'une table
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifi�e
	 * @param _table nom de la table modifi�e
	 * @param _oldField nom de l'ancien champ (laisser vide si insertion)
	 * @param _newField nom du nouveau champ
	 */
	public static void LogChangeTable(String _user, String _typeOperation, String _base, String _table,
			String _oldField, String _newField) {
				
	}

	/**
	 * Fonction permettant de mettre a jour le journal avec la modification de la base de donn�es
	 * @param _user nom de l'utilisateur qui modifie
	 * @param _typeOperation type de modification
	 * @param _base nom de la base modifi�e
	 * @param _oldTable nom de l'ancienne table (laisser vide si cr�ation)
	 * @param _newTable nom de la nouvelle table
	 */
	public static void LogChangeDatebase(String _user, String _typeOperation, String _base, String _oldTable,
			String _newTable) {
	}
}
