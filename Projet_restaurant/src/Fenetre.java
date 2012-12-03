import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	public Fenetre() {
		this.setTitle("SAGO - Système d'automatisation de gestion des opérations");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1280,768));
		this.setMinimumSize(new Dimension(1280,768));
		Accueil home = new Accueil(this);
		//Facturation facture = new Facturation(this);
		this.setContentPane(home);
		this.setVisible(true);
	}

	public void setFenetreActive(JPanel table) {
		this.setContentPane(table);
	}
}
