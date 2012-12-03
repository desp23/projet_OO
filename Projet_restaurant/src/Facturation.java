import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Facturation extends JPanel {
	private String total = "312.24";
	private String dollar = " $";
	private Font f = new Font("Helvetica", Font.BOLD, 27);

	public Facturation(Fenetre f) {
		this.setLayout(null);
		Menu menu = new Menu(2);
		this.add(menu);
		Numpad pad = new Numpad(f, 952, 100);
		this.add(pad);
		Label totalFacture = new Label(total+dollar, 625, 74, 204, 70);
		totalFacture.setOpaque(true);
		totalFacture.setHorizontalAlignment(JLabel.CENTER);
		this.add(totalFacture);
	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("facturationBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.setColor(Color.black);
		g.fillRect(326, 25, 2, this.getHeight() - 75);
		g.fillRect(640, 75, 130, 2);
		g.setFont(f);
		g.drawString("Total de la facture:", 625, 25);
	}

}
