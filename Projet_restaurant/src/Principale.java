/*
 * AUPARAVANT TELECHARGER le plugin : http://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/3.7.2/sqlite-jdbc-3.7.2.jar
 * PLACER LE .jar DANS VOTRE DOSSIER lib/ext de votre dossier d'installation de votre jre
 * 
 */

// IMPORTATION DES LIBRAIRIES



public class Principale {
	public static void main(String[] args) {
	
		Cuisinier cui = new Cuisinier();
		
		cui.voirCommande(2);
	}

}