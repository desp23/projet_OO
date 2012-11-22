import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class MoteurBdd {

	private Connection con = null;
	private Statement statement = null;
	ResultSet result = null;
	
	public MoteurBdd() {
		
		try {
			//Creation d'une instance de classe a partir de son nom complet
			Class.forName("org.sqlite.JDBC");

			// Initialisation de la connection
			this.con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
			
			// Instanciation de notre moteur de requetes
		    this.statement = con.createStatement();
		    this.statement.setQueryTimeout(30);

		} catch (ClassNotFoundException e) {
			System.err.println("Exception ClassNotFound Connection SQL : " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception SQLException Connection SQL : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println("Exception no2 Connection SQL : " + e.getMessage());
			}
		}
	}
	
	public int getResultFromQuery(String query) {
		try {
			result = this.statement.executeQuery(query);
			return 0;
		} catch (SQLException e) {
			System.err.println("Exception getResultFromQuery : " + e.getMessage());
			return -1;
		}
	}
	
	public void closeBdd() {
		try {
			this.con.close();
			this.statement.close();
			this.result.close();
		} catch (Exception e) {
			System.err.println("Exception closeBdd : " + e.getMessage());
		}
	}
}
