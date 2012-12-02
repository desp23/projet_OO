import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Numpad extends JPanel {
	private String[] nomBtn = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"CLR", "0", "ENTER" };
	private int[] coordXBtn = { 0, 104, 208, 0, 104, 208, 0, 104, 208, 0, 104,
			208 };
	private int[] coordYBtn = { 75, 75, 75, 179, 179, 179, 283, 283, 283, 387,
			387, 387 };
	private int dimensionXBtn = 100;
	private int dimensionYBtn = 100;
	private String couleurBtn = "btn_noir.png";
	private Bouton[] tableauBtn = new Bouton[nomBtn.length];
	private boolean refresh = false;
	private Label entreClavier = new Label(0, 0, 312, 75);
	private Fenetre f;

	Numpad(Fenetre f) {
		this.f = f;
		this.setPreferredSize(new Dimension(312, 491));
		this.setOpaque(false);
		this.add(entreClavier);
		for (int i = 0; i < nomBtn.length; i++) {
			tableauBtn[i] = new Bouton(nomBtn[i], coordXBtn[i], coordYBtn[i],
					dimensionXBtn, dimensionYBtn, couleurBtn);
			switch (i) {
			case 9:
				tableauBtn[i].addActionListener(new ClrTrouve());
				this.add(tableauBtn[i]);
				break;
			case 11:
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
		this.setBounds(484, 100, 312, 491);

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

	class ClrTrouve implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			entreClavier.setText("");
			entreClavier.repaint();
		}
	}

	class EnterTrouve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			validation();
			entreClavier.setText("");
		}
	}

	private void validation() {
		int identifiant = Integer.valueOf(entreClavier.getText()).intValue();
		if (identifiant == 1234) {
			Table table = new Table();
			f.getContentPane().removeAll();
			f.setContentPane(table);
			f.repaint();
			f.validate();
		}
	}

}
