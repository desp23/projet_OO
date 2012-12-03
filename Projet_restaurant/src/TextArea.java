import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextArea;

public class TextArea extends JTextArea {

	private String name;
	private int coordX;
	private int coordY;
	private Font f = new Font("Helvetica", 3, 18);

	public TextArea(int coordX, int coordY, int dimX, int dimY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.setBounds(coordX, coordY, dimX, dimY);
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setFont(f);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public Font getF() {
		return f;
	}

	public void setF(Font f) {
		this.f = f;
	}
}
