import java.awt.Dimension;
import javax.swing.JScrollPane;

public class Scroll extends JScrollPane {

	public Scroll(List list, int coordX, int coordY, int dimX, int dimY) {
		super(list);
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setBounds(coordX, coordY, dimX, dimY);
	}

}
