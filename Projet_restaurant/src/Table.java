import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Table extends JPanel {
	private String[] nomBtn = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	private int CoordX = 350;
	private int CoordY = 25;
	private int dimensionXBtn = 100;
	private int dimensionYBtn = 100;
	private String couleurBtn = "btn_noir.png";

	public Table() {
		Menu menu = new Menu();
		this.add(menu);
		this.setLayout(null);
		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], CoordX, CoordY,
					dimensionXBtn, dimensionYBtn, couleurBtn);
			this.add(tableauBtn[i]);
			if (i % 5 == 0 && i != 0) {
				CoordY += 104;
				CoordX = 350;
			} else {
				CoordX += 104;
			}
		}
		Bouton plan = new Bouton("Plan des tables", 500, 400, 325, 100, "btn_noir.png");
		this.add(plan);
	}

	public void paintComponent(Graphics g) {
		/*try {
			Image img = ImageIO.read(new File("tableBg.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		g.setColor(Color.black);
		g.fillRect(326, 25, 2, this.getHeight() - 75);
	}
}