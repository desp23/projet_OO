import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <b>Classe d'operations de la base de donnees<b>
 * <p>Elle est caracterisee par les informations suivantes :
 * <ul>
 * <li>Un objet de type Connection qui fait le lien avec la BDD</li>
 * <li>Un objet de type Statement qui s'occupe des requetes</li>
 * <li>Un objet de type ResultSet qui comprend les resultats de requetes</li>
 * <li>Un objet de type ResultSetMetaData qui comprend les tailles de resultats</li>
 * </ul>
 * </p>
 * @author tristanfrascari
 * @version 1.0
 */

public class MoteurBdd {

	private Connection con = null;
	private Statement statement = null;
	private ResultSet result = null;
	private ResultSetMetaData resultMeta = null;
	
	/**
	 * Constructeur MoteurBdd
	 * <p>
	 * A la construction, on initialise les objets Connection et Statement en s'assurant qu'il n'y ai aucune erreurs
	 * </p>
	 */
	public MoteurBdd() {
		
		try {
			//Creation d'une instance de classe a partir de son nom complet
			Class.forName("org.sqlite.JDBC");

			// Initialisation de la connection
			this.con = DriverManager.getConnection("jdbc:sqlite:restaurant.sqlite");
			
			// Instanciation de notre moteur de requetes
		    this.statement = con.createStatement();
		    this.statement.setQueryTimeout(30);

		} catch (ClassNotFoundException e) {
			System.err.println("Exception ClassNotFound Connection SQL : " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception SQLException Connection SQL : " + e.getMessage());
		}
	}
	
	/**
	 * Effectue une requete et assigne le resultat de cette requete a l'objet de type ResultSet
	 * ainsi que les tailles de resultats a l'objet de type ResultSetMetaData
	 * 
	 * @param query
	 * 				La requete a executer
	 * @return		
	 * 				0 si tout va bien, -1 si une exception a ete levee
	 */
	public int setResultFromQuery(String query) {
		try {
			this.result = this.statement.executeQuery(query);
			this.resultMeta = result.getMetaData();
			return 0;
		} catch (SQLException e) {
			System.err.println("Exception getResultFromQuery : " + e.getMessage());
			return -1;
		}
	}
	
	
	/**
	 * Ferme toutes les connections
	 * <p>
	 * Il est INDISPENSABLE d'appeler cette methode apres avoir utilise l'objet en question
	 * </p>
	 */
	
	public void closeBdd() {
		try {
			this.con.close();
			this.statement.close();
			this.result.close();
		} catch (Exception e) {
			System.err.println("Exception closeBdd : " + e.getMessage());
		}
	}

	public ResultSet getResult() {
		return result;
	}

	public ResultSetMetaData getResultMeta() {
		return resultMeta;
	}
	
	
}
