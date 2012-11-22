/**
 * Classe pour les opérations du gérant
 * @author tristanfrascari
 * @version 1.0
 *
 */
public class Gerant extends Employe{
	
	private void ajoutItemMenu() {
		
	}
	
	
	private void modifItemMenu() {
		
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
	}
	
}


