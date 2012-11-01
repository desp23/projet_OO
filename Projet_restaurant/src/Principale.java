/*
 * AUPARAVANT TELECHARGER le plugin : http://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/3.7.2/sqlite-jdbc-3.7.2.jar
 * PLACER LE .jar DANS VOTRE DOSSIER lib/ext de votre dossier d'installation de votre jre
 * 
 */

// IMPORTATION DES LIBRAIRIES
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class Principale {
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			//Creation d'une instance de classe a partir de son nom complet
			Class.forName("org.sqlite.JDBC");

			// Initialisation de la connection : jdbc:sqlite:nom_du_fichier_sqlite.db
			con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
			
			// Instanciation de notre moteur de requetes
		    Statement statement = con.createStatement();
		    statement.setQueryTimeout(30);
		      
		    // Recuperation des resultats de la requete, et formulation de celle-ci
		    ResultSet result = statement.executeQuery("SELECT * FROM utilisateurs");
		      
		    // On parcourt notre tableau de resultat et on affiche en fonction des indices...
		    while (result.next()) {
		    	  System.out.println("id=" + result.getString("id"));
		    	  System.out.println("loginCode=" + result.getString("login_code"));
		    }
		    
		    
		    // Fermeture de la connection, du moteur et du resultat (important)
		    con.close();
		    result.close();
		    statement.close();
			
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}

	}

}