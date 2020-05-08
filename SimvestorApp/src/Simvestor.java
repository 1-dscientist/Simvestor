import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class Simvestor extends JFrame{
	
	private static JTextField textField;

	public Simvestor() {
		// Empty
	}
	
	private static void setup()
	{
		JFrame Simvestor = new JFrame("Simvestor");
		Simvestor.setBounds(300, 300, 1600, 900);
	    Simvestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Simvestor.setVisible(true);
	    Simvestor.setResizable(false);
	    Simvestor.getContentPane().setLayout(null);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Arial", Font.PLAIN, 50));
	    textField.setBounds(1000, 50, 500, 100);
	    Simvestor.getContentPane().add(textField);
	    textField.setColumns(10);
	}
	
	public static void main(String[] args)
	{
		setup();
	}
}
