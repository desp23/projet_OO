import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Plan extends JPanel {
	private String[] nomBtn = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	private int[] coordX = { 395, 395, 395, 605, 605, 815, 815, 815, 1025, 1025 };
	private int[] coordY = { 70, 280, 490, 70, 280, 70, 280, 490, 70, 280 };
	private int dimensionXBtn = 150;
	private int dimensionYBtn = 150;
	private Font entree = new Font("Helvetica", Font.BOLD, 14);
	private Fenetre f;

	public Plan(Fenetre f) {
		this.f = f;
		Menu menu = new Menu(f, 1);
		this.add(menu);
		this.setLayout(null);

		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], coordX[i], coordY[i],
					dimensionXBtn, dimensionYBtn, "table.png", true,
					Color.BLACK);
			tableauBtn[i].setBorder(null);
			tableauBtn[i].addActionListener(new Action());
			this.add(tableauBtn[i]);
		}

	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("tableBg2.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.setColor(Color.GRAY);
		g.fillRect(346, 25, 885, 670);
		g.setColor(Color.black);
		g.setFont(entree);
		g.drawString("ENTRÉE", 655, 565);
		g.drawRect(346, 25, 885, 670);
		g.drawRect(347, 26, 883, 668);
		g.fillRect(326, 25, 2, this.getHeight() - 75);
		try {
			Image img2 = ImageIO.read(new File("toilette.png"));
			g.drawImage(img2, 1075, 540, 85, 85, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			Client clientTable = new Client(f, str);
			f.getContentPane().removeAll();
			f.setContentPane(clientTable);
			f.repaint();
			f.validate();
		}
	}
}
