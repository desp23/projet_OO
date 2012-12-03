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
	/*private String[] nomBtn = { "Crédi", "Débit", "Comptant" };
	private int[] coordXBtn = { 350, 485, 950, 950 };
	private int[] coordYBtn = { 615, 615, 25, 145 };
	private int[] dimensionXBtn = { 125, 125, 260, 260 };
	private int[] dimensionYBtn = { 60, 60, 100, 100 };
	private String[] couleurBtn = { "btn_bourgogne.png", "btn_bourgogne.png",
			"btn_noir.png", "btn_noir.png" };
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];*/
	private Font f = new Font("Helvetica", Font.BOLD, 27);

	public Facturation(Fenetre f) {
		this.setLayout(null);
		Menu menu = new Menu(f, 2);
		this.add(menu);
		Numpad pad = new Numpad(f, 952, 100);
		this.add(pad);
		Label totalFacture = new Label(total + dollar, 625, 100, 204, 70);
		totalFacture.setOpaque(true);
		totalFacture.setHorizontalAlignment(JLabel.CENTER);
		this.add(totalFacture);

		Bouton facture1 = new Bouton("1", 350, 55, 100, 100, "btn_noir.png",
				true, Color.WHITE);
		this.add(facture1);

		Bouton facture2 = new Bouton("2", 350, 158, 100, 100, "btn_noir.png",
				true, Color.WHITE);
		this.add(facture2);

		Bouton facture3 = new Bouton("3", 350, 261, 100, 100, "btn_noir.png",
				true, Color.WHITE);
		this.add(facture3);

		Bouton facture4 = new Bouton("4", 350, 364, 100, 100, "btn_noir.png",
				true, Color.WHITE);
		this.add(facture4);
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
		g.drawString("Total de la facture:", 625, 75);
	}

}
