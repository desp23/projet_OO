import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	private Accueil home = new Accueil(this);
	private Client client = new Client(this);
	
	public Fenetre() {
		this.setTitle("SAGO - Syst�me d'automatisation de gestion des op�rations");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(1280,768));
		this.setContentPane(home);
		this.setVisible(true);
	}

	public void setFenetreActive(JPanel table) {
		this.setContentPane(table);
	}
}