import java.awt.Dimension;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private String[] nomBtn = { "ADMINISTRATION", "TABLE", "FACTURATION",
			"DÉCONNEXION" };
	private int[] coordXBtn = { 25, 25, 25, 25 };
	private int[] coordYBtn = { 25, 200, 375, 550 };
	private int dimensionXBtn = 280;
	private int dimensionYBtn = 125;
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];

	public Menu(int selection) {
		this.setPreferredSize(new Dimension(322, 768));
		for (int i = 0; i < nomBtn.length; i++) {
			if (selection == i) {
				tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i],
						coordYBtn[i], dimensionXBtn, dimensionYBtn,
						"btn_selection.png", false);
			} else {
				tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i],
						coordYBtn[i], dimensionXBtn, dimensionYBtn,
						"btn_noir.png", true);
			}

			this.add(tableauBtn[i]);
			this.setOpaque(false);
			this.setLayout(null);
			this.setBounds(0, 0, 305, 768);
		}
	}
}
