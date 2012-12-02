import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Client extends JPanel {
	private String[] nomBtn = { "Ajouter", "Supprimer", "Commande",
			"Imprimer facture" };
	private int[] coordXBtn = { 350, 485, 950, 950 };
	private int[] coordYBtn = { 600, 600, 25, 145 };
	private int[] dimensionXBtn = { 125, 125, 260, 260 };
	private int[] dimensionYBtn = { 75, 75, 100, 100 };
	private String[] couleurBtn = {"btn_bourgogne.png","btn_bourgogne.png","btn_noir.png","btn_noir.png"};
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	String[] data = { "-pizza", "-spaghetti", "-pepsi" };

	public Client(Fenetre f) {
		Menu menu = new Menu();
		this.add(menu);
		this.setLayout(null);
		Bouton client1 = new Bouton("Client 1", 350, 25, 260, 60,"btn_noir.png");
		this.add(client1);
		Bouton client2 = new Bouton("Client 2", 350, 95, 260, 60,"btn_noir.png");
		this.add(client2);
		Bouton client3 = new Bouton("Client 3", 350, 165, 260, 60,"btn_noir.png");
		this.add(client3);
		Bouton client4 = new Bouton("Client 4", 350, 235, 260, 60,"btn_noir.png");
		this.add(client4);
		Bouton client5 = new Bouton("Client 5", 350, 305, 260, 60,"btn_noir.png");
		this.add(client5);
		Bouton client6 = new Bouton("Client 6", 350, 375, 260, 60,"btn_noir.png");
		this.add(client6);
		Bouton client7 = new Bouton("Client 7", 350, 445, 260, 60,"btn_noir.png");
		this.add(client7);
		Bouton client8 = new Bouton("Client 8", 350, 515, 260, 60,"btn_noir.png");
		this.add(client8);
		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i], coordYBtn[i],
					dimensionXBtn[i], dimensionYBtn[i], couleurBtn[i]);
			this.add(tableauBtn[i]);
		}
		List list = new List(data);
		Scroll scroll = new Scroll(list, 630, 25, 300, 550);
		this.add(scroll);
	}

	public void paintComponent(Graphics g) {

		/*try {
			Image img = ImageIO.read(new File("clientBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		g.setColor(Color.black);
		g.fillRect(326, 25, 2, this.getHeight() - 75);
	}

}
