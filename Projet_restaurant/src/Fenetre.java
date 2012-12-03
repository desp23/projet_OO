import java.awt.Dimension;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	public Fenetre() {
		this.setTitle("SAGO - Système d'automatisation de gestion des opérations");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1280, 768));
		this.setMinimumSize(new Dimension(1280, 768));
		Accueil home = new Accueil(this);
		this.setContentPane(home);
		this.setVisible(true);
	}
}
