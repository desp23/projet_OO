import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;


public class Label extends JLabel {
	private String name;
	private int coordX;
	private int coordY;
	private Font f = new Font("Helvetica", 5, 27);

	public Label (String text, int coordX, int coordY, int dimX, int dimY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.setBounds(coordX, coordY, dimX, dimY);
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setFont(f);
		this.setText(text);
	}

}
