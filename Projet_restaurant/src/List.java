import java.awt.Font;
import javax.swing.JList;


public class List extends JList<Object>{
	
	private Font f = new Font("Helvetica", 3, 18);
	
	public List(Object[] data){
		super(data);
		this.setFont(f);
	}

}
