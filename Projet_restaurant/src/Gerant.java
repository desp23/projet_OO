import java.sql.SQLException;

/**
 * Classe pour les opérations du gérant
 * @author tristanfrascari
 * @version 1.1
 *
 */
public class Gerant extends Employe{
	
	
	/**
	 * Permet d'ajouter un element au menu
	 * @param type Defini le type de l'item : ne peux prendre que 2 valeurs : aliment ou boisson
	 * @param nom Defini le nom de l'item : 25 caracteres max
	 * @param taille Defini la taille de l'item (regulier, grand, petit, 11oz...)
	 * @param prix Defini le prix de l'item (avant les taxes)
	 */
	private void ajoutItemMenu(String type, String nom, String taille, String prix) {
		String query = "INSERT INTO itemMenu (type, nom, taille, prix) VALUES ('"+type+"','"+nom+"','"+taille+"','"+prix+"')";
		MoteurBdd bdd = new MoteurBdd();
		
		// Afficher dans l'interface quand elle sera OP
		if (bdd.setResultFromQuery(query) == 0)
			System.out.println("L'item a bien été ajouté!");
		else
			System.out.println("Erreur : Contactez le support technique!");
		
		bdd.closeBdd();
	}
	
	
	/**
	 * Permet de modifier un element du menu
	 * @param id Defini l'id dans la BDD de l'item a modifier
	 * @param type Defini le type de l'item : ne peut prendre que deux valeurs : aliment ou boisson
	 * @param nom Defini le nouveau nom de l'item (25 caracteres max)
	 * @param taille Defini la nouvelle taille de l'item (regulier, petit, grand etc...)
	 * @param prix Defini le nouveau prix de l'item
	 */
	private void modifItemMenu(int id, String type, String nom, String taille, String prix) {
		String query = "UPDATE itemMenu SET type = '"+type+"', nom = '"+nom+"', taille = '"+taille+"', prix = '"+prix+"' WHERE id = "+id;
		MoteurBdd bdd = new MoteurBdd();
		
		// Afficher dans l'interface quand elle sera OP
		if (bdd.setResultFromQuery(query) == 0)
			System.out.println("L'item a bien été modifié!");
		else
			System.out.println("Erreur : Contactez le support technique!");
		
		bdd.closeBdd();
	}
	
	/**
	 * Permet de supprimer un element du menu
	 * @param id 
	 * 				Defini l'id dans la BDD de l'item à supprimer
	 */
	private void suppItemMenu(int id) {
		String query = "DELETE FROM itemMenu WHERE id = " + id;
		MoteurBdd bdd = new MoteurBdd();
		
		 // Afficher dans l'interface quand elle sera OP
		if (bdd.setResultFromQuery(query) == 0)
			System.out.println("L'item a bien été supprimé!");
		else
			System.out.println("Erreur : Contactez le support technique!");
		
		bdd.closeBdd();
	}
	
	/**
	 * Permet de modifier une facture
	 * @param id Defini l'id de la facture en BDD
	 * @param prcRabait Represente le rabais a appliquer en pourcetage
	 */
	private void rabaisFacture(int id, int prcRabais) {
		double prix = 0;
		double rabais = prcRabais / 100;
		String query = "SELECT prix FROM factures WHERE id = "+id;
		MoteurBdd bdd = new MoteurBdd();
		
		bdd.setResultFromQuery(query);
		try {
			prix = Double.valueOf(bdd.result.getObject(1).toString());
		} catch (NumberFormatException e) {
			System.err.println("Erreur NumberFormatException : "+e.getMessage());
		} catch (SQLException e) {
			System.err.println("Erreur SQLException : "+e.getMessage());
		}
		prix -= (prix * rabais);
		query = "UPDATE factures SET prix = '"+prix+"' WHERE id = "+id;
		
		if (bdd.setResultFromQuery(query) == 0)
			System.out.println("Le rabais a bien été appliqué. Le nouveau prix est :"+prix+"$");
		else
			System.out.println("Erreur : Contactez le support technique!");
		bdd.closeBdd();
	}
	
}


