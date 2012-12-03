import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class Menu extends JPanel {
	private String[] nomBtn = { "ADMINISTRATION", "TABLE", "FACTURATION",
			"DÉCONNEXION" };
	private int[] coordXBtn = { 25, 25, 25, 25 };
	private int[] coordYBtn = { 25, 200, 375, 550 };
	private int dimensionXBtn = 280;
	private int dimensionYBtn = 125;
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	private Fenetre f;

	public Menu(Fenetre f, int selection) {
		this.f = f;
		this.setPreferredSize(new Dimension(322, 768));
		for (int i = 0; i < nomBtn.length; i++) {
			if (selection == i) {
				tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i],
						coordYBtn[i], dimensionXBtn, dimensionYBtn,
						"btn_selection.png", false, Color.WHITE);
			} else {
				tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i],
						coordYBtn[i], dimensionXBtn, dimensionYBtn,
						"btn_noir.png", true, Color.WHITE);
			}
			switch (i) {
			case 0:
				tableauBtn[i].addActionListener(new menuAdministration());
				this.add(tableauBtn[i]);
				break;
			case 1:
				tableauBtn[i].addActionListener(new menuTable());
				this.add(tableauBtn[i]);
				break;
			case 2:
				tableauBtn[i].addActionListener(new menuFacturation());
				this.add(tableauBtn[i]);
				break;
			case 3:
				tableauBtn[i].addActionListener(new menuDeconnect());
				this.add(tableauBtn[i]);
				break;
			}
			this.setOpaque(false);
			this.setLayout(null);
			this.setBounds(0, 0, 305, 768);
		}
	}
	
	class menuAdministration implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Administration admin = new Administration(f);
			setFenetre(admin);
		}
	}
	
	class menuTable implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Table table = new Table(f);
			setFenetre(table);
		}
	}
	
	class menuFacturation implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Facturation facture = new Facturation(f);
			setFenetre(facture);
		}
	}
	
	class menuDeconnect implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Accueil home = new Accueil(f);
			setFenetre(home);
		}
	}
	
	public void setFenetre(Container fenetreActive){
		f.getContentPane().removeAll();
		f.setContentPane(fenetreActive);
		f.repaint();
		f.validate();
	}
}
