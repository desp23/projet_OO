
public class Gerant extends Employe{
	
	private void ajoutItemMenu() {
		
	}
	
	private void modifItemMenu() {
		
	}
	
	private void suppItemMenu(int id) {
		String query = "DELETE FROM itemMenu WHERE id = " + id;
		MoteurBdd bdd = new MoteurBdd();
		
		 // Afficher dans l'interface quand elle sera OP
		if (bdd.getResultFromQuery(query) == 0)
			System.out.println("L'item a bien été supprimé!");
		else
			System.out.println("Erreur : Contactez le support technique!");	
	}
	
}


