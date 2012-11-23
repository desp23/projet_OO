/**
 * Classe representant un serveur du restaurant
 * @author tristanfrascari
 * @version 1.0
 */
public class Serveur extends Employe {

	/**
	 * Permet d'assigner une table au serveur
	 * @param tableId Id de la table dans la BDD
	 */
	public void choisirTable(int tableId) {
		String query = "INSERT INTO utilisateurs_has_tables (utilisateurs_id, tables_id) VALUES("+this.id+", "+tableId+")";
		MoteurBdd bdd = new MoteurBdd();
		
		if (bdd.setResultFromQuery(query) != 0)
			System.out.println("Erreur : Veuillez contacter le support technique!");	
		bdd.closeBdd();
	}
}
