import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Simvestor extends JFrame{

	public Simvestor() {
		// Empty
	}
	
	public static void main(String[] args)
	{
		JFrame Simvestor = new JFrame("Simvestor");
		Simvestor.setBounds(300, 300, 1600, 900);
	    Simvestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Simvestor.setVisible(true);
	}
}
