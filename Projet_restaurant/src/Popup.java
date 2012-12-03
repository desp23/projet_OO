import javax.swing.JOptionPane;


public class Popup extends JOptionPane{
	public Popup(String str){
		this.showMessageDialog(null, str, "Message", JOptionPane.INFORMATION_MESSAGE);
	}
}
