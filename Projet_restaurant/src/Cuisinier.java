import java.sql.SQLException;

/**
 * Classe représentant le cuisinier et ses opérations
 * @author tristanfrascari
 * @version 1.0
 */
public class Cuisinier extends Employe {

	
	/**
	 * Permet d'afficher la commande d'un client
	 * @param clientId Defini l'ID du client dans la BDD
	 */
	public void voirCommande(int clientId) {
		
		String query = "SELECT type, nom, taille, prix FROM itemMenu INNER JOIN clients_has_itemMenu ON itemMenu.id = clients_has_itemMenu.itemMenu_id WHERE clients_has_itemMenu.clients_id = "+clientId;
		MoteurBdd bdd = new MoteurBdd();
		bdd.setResultFromQuery(query);
		
		System.out.println("\n**********************************");
		
		try {
			for (int i=1; i <= bdd.getResultMeta().getColumnCount(); i++)
				System.out.print("\t" + bdd.getResultMeta().getColumnName(i).toUpperCase() + "\t *");
		
			System.out.println("\n**********************************");
		
			while (bdd.getResult().next()) {
				for (int i=1; i<= bdd.getResultMeta().getColumnCount(); i++)
					System.out.print("\t" + bdd.getResult().getObject(i).toString() + "\t |");
			
				System.out.println("\n---------------------------------");
			}
		} catch (SQLException e) {
			System.err.println("Error SQLException Cuisinier.java voirCommande : " + e.getMessage());
		}
		bdd.closeBdd();
	}
}
