import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton {

	private String name;
	private Image img;
	private Font f = new Font("Helvetica", 5, 18);
	private Color color;

	public Bouton(String str, int coordX, int coordY, int dimX, int dimY, String nomBtn, boolean enabled, Color color) {
		super(str);
		this.color = color;
		this.setBounds(coordX, coordY, dimX, dimY);
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.name = str;
		this.setFont(f);
		this.setEnabled(enabled);
		try {
			img = ImageIO.read(new File(nomBtn));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20,
				Color.cyan, true);
		g2d.setPaint(gp);
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.setColor(color);
		int nameLength = g.getFontMetrics().stringWidth(name);
		int nameHeigth = g.getFontMetrics().getHeight();
		g2d.drawString(this.name, (this.getWidth() / 2) - (nameLength / 2),
				((this.getHeight() / 2) + (nameHeigth / 4)));
	}
}
