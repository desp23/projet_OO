import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Client extends JPanel {
	private String[] nomBtn = { "Ajouter", "Supprimer", "Commande",
			"Imprimer facture" };
	private int[] coordXBtn = { 350, 485, 950, 950 };
	private int[] coordYBtn = { 615, 615, 25, 145 };
	private int[] dimensionXBtn = { 125, 125, 260, 260 };
	private int[] dimensionYBtn = { 60, 60, 100, 100 };
	private String[] couleurBtn = { "btn_bourgogne.png", "btn_bourgogne.png",
			"btn_noir.png", "btn_noir.png" };
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	String[] data = { "-pizza", "-spaghetti", "-pepsi" };
	private Font titreTable = new Font("Helvetica", Font.BOLD, 28);
	private Font descTable = new Font("Helvetica", Font.BOLD, 18);
	private String numTable = "";

	public Client(Fenetre f, String str) {
		numTable = str;
		Menu menu = new Menu(f, 1);
		this.add(menu);
		this.setLayout(null);
		Bouton client1 = new Bouton("Client 1", 350, 55, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client1);
		Bouton client2 = new Bouton("Client 2", 350, 125, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client2);
		Bouton client3 = new Bouton("Client 3", 350, 195, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client3);
		Bouton client4 = new Bouton("Client 4", 350, 265, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client4);
		Bouton client5 = new Bouton("Client 5", 350, 335, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client5);
		Bouton client6 = new Bouton("Client 6", 350, 405, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client6);
		Bouton client7 = new Bouton("Client 7", 350, 475, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client7);
		Bouton client8 = new Bouton("Client 8", 350, 545, 260, 60,
				"btn_noir.png", true, Color.WHITE);
		this.add(client8);
		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i], coordYBtn[i],
					dimensionXBtn[i], dimensionYBtn[i], couleurBtn[i], true, Color.WHITE);
			this.add(tableauBtn[i]);
		}
		List list = new List(data);
		Scroll scroll = new Scroll(list, 630, 55, 300, 500);
		this.add(scroll);
	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("clientBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.setColor(Color.black);
		g.fillRect(326, 25, 2, this.getHeight() - 75);
		g.setColor(Color.WHITE);
		g.setFont(titreTable);
		g.drawString("TABLE # " + numTable, 350, 35);
		g.setFont(descTable);
		g.drawString("Description :", 630, 35);
	}

}
