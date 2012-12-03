import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Numpad extends JPanel {
	private String[] nomBtn = { "CLR", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "0", ".", "ENTER" };
	private int[] coordXBtn = { 208, 0, 104, 208, 0, 104, 208, 0, 104, 208, 0,
			104, 208 };
	private int[] coordYBtn = { 0, 75, 75, 75, 179, 179, 179, 283, 283, 283,
			387, 387, 387 };
	private int[] dimensionXBtn = { 100, 100, 100, 100, 100, 100, 100, 100,
			100, 100, 100, 100, 100, 100 };
	private int[] dimensionYBtn = { 70, 100, 100, 100, 100, 100, 100, 100,
			100, 100, 100, 100, 100, 100 };
	private String couleurBtn = "btn_noir.png";
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	private boolean refresh = false;
	private Label entreClavier = new Label("", 0, 0, 204, 70);
	private Fenetre f;

	Numpad(Fenetre f, int coordX, int coordY) {
		this.f = f;
		this.setPreferredSize(new Dimension(312, 491));
		this.setOpaque(false);
		entreClavier.setOpaque(true);
		entreClavier.setHorizontalAlignment(JLabel.CENTER);
		this.add(entreClavier);
		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i], coordYBtn[i],
					dimensionXBtn[i], dimensionYBtn[i], couleurBtn, true, Color.WHITE);
			switch (i) {
			case 0:
				tableauBtn[i].addActionListener(new ClrTrouve());
				this.add(tableauBtn[i]);
				break;
			case 11:
				tableauBtn[i].addActionListener(new PointTrouve());
				this.add(tableauBtn[i]);
				break;
			case 12:
				tableauBtn[i].addActionListener(new EnterTrouve());
				this.add(tableauBtn[i]);
				break;
			default:
				tableauBtn[i].addActionListener(new ChiffreTrouve());
				this.add(tableauBtn[i]);
				break;
			}
		}
		this.setLayout(null);
		this.setBounds(coordX, coordY, 312, 491);
	}

	class ChiffreTrouve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			if (refresh) {
				refresh = false;
			} else {
				if (!entreClavier.getText().equals(""))
					str = entreClavier.getText() + str;
			}
			entreClavier.setText(str);
		}
	}
	
	class PointTrouve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			if (refresh) {
				refresh = false;
			} else {
				if (!entreClavier.getText().equals(""))
					str = entreClavier.getText() + str;
			}
			entreClavier.setText(str);
		}
	}

	class ClrTrouve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			entreClavier.setText("");
			entreClavier.repaint();
			f.validate();
		}
	}

	class EnterTrouve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			validation();
			entreClavier.setText("");
		}
	}

	private void validation() {
		double identifiant = Double.valueOf(entreClavier.getText())
				.doubleValue();
		if (identifiant == 1234) {
			Table table = new Table(f);
			f.getContentPane().removeAll();
			f.setContentPane(table);
			f.repaint();
			f.validate();
		} else {
			Popup erreur = new Popup("Identifiant invalide, veuillez recommencer");
			entreClavier.setText("");
		}
	}

}
