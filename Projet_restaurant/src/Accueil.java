import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JPanel;

public class Accueil extends JPanel {
	private Font msgBienvenue = new Font("Helvetica", Font.BOLD+Font.ITALIC, 27);
	private Font msgIdentifier = new Font("Helvetica", Font.PLAIN, 18);
	private Font version = new Font("Arial", Font.PLAIN, 12);
	
	public Accueil(Fenetre f) {
		this.setLayout(null);
		Numpad pad = new Numpad(f, 796, 100);
		this.add(pad);
	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("accueilBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.setFont(msgBienvenue);
		g.setColor(Color.WHITE);
		g.drawString("Bienvenue au Système d'automatisation", 100, 100);
		g.drawString("de gestion des opérations", 100, 125);
		g.setFont(msgIdentifier);
		g.drawString("Veuillez vous identifier svp", 100, 275);
		g.setFont(version);
		g.drawString("Version 1.0", 1180, 715);
	}
}
