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

	public Accueil(Fenetre f) {
		this.setLayout(null);
		Numpad pad = new Numpad(f);
		this.add(pad);
	}

	public void paintComponent(Graphics g) {
		/*try {
			Image img = ImageIO.read(new File("accueilBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
