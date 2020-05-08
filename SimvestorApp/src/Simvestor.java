import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Simvestor extends JFrame{

	private static JTextField txtSearch;
	private static JButton btnReset;
	private static JTextField txtBalance;
	private static JButton btnReviewOrder;
	private static JTextField txtQuantity;
	private static JTextField txtCash;


	public Simvestor() {
		// Empty
	}

	private static void setup()
	{
		JFrame Simvestor = new JFrame("Simvestor");
		Simvestor.setBounds(300, 300, 1600, 900);
		Simvestor.getContentPane().setLayout(null);

		txtSearch = new JTextField("Search");
		txtSearch.setFont(new Font("Arial", Font.BOLD, 48));
		txtSearch.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e) {
				if (txtSearch.getText().equals("Search")) {
					txtSearch.setText("");
					txtSearch.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtSearch.getText().isEmpty()) {
					txtSearch.setForeground(Color.GRAY);
					txtSearch.setText("Search");
				}
			}
		});
		txtSearch.setBounds(1000, 50, 500, 100);
		txtSearch.setColumns(10);
		txtSearch.setVisible(true);
		Simvestor.getContentPane().add(txtSearch);

		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(Color.RED);
		btnReset.setFont(new Font("Arial", Font.BOLD, 24));
		btnReset.setBounds(1000, 800, 500, 50);
		btnReset.setVisible(true);
		Simvestor.getContentPane().add(btnReset);

		txtBalance = new JTextField();
		txtBalance.setBackground(new Color(144, 238, 144));
		txtBalance.setForeground(new Color(0, 0, 0));
		txtBalance.setFont(new Font("Arial", Font.PLAIN, 72));
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setEditable(false);
		txtBalance.setText(Portfolio.getDisplayValue());
		txtBalance.setBounds(50, 50, 400, 150);
		txtBalance.setColumns(10);
		txtBalance.setVisible(true);
		Simvestor.getContentPane().add(txtBalance);
		
		txtCash = new JTextField();
		txtCash.setBackground(new Color(144, 238, 144));
		txtCash.setForeground(new Color(0, 0, 0));
		txtCash.setFont(new Font("Arial", Font.PLAIN, 72));
		txtCash.setHorizontalAlignment(SwingConstants.CENTER);
		txtCash.setEditable(false);
		txtCash.setText(Portfolio.getDisplayCash());
		txtCash.setBounds(550, 50, 400, 150);
		txtCash.setColumns(10);
		txtCash.setVisible(true);
		Simvestor.getContentPane().add(txtCash);

		btnReviewOrder = new JButton("Review Order");
		btnReviewOrder.setFont(new Font("Arial", Font.BOLD, 48));
		btnReviewOrder.setBackground(new Color(255,221,60));
		btnReviewOrder.setBounds(1000, 650, 500, 100);
		btnReviewOrder.setVisible(true);
		Simvestor.getContentPane().add(btnReviewOrder);

		txtQuantity = new JTextField("Quantity");
		txtQuantity.setFont(new Font("Arial", Font.PLAIN, 24));
		txtQuantity.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e) {
				if (txtQuantity.getText().equals("Quantity")) {
					txtQuantity.setText("");
					txtQuantity.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtQuantity.getText().isEmpty()) {
					txtQuantity.setForeground(Color.GRAY);
					txtQuantity.setText("Quantity");
				}
			}
		});
		txtQuantity.setBounds(1000, 550, 500, 50);
		txtQuantity.setColumns(10);
		txtQuantity.setVisible(true);
		Simvestor.getContentPane().add(txtQuantity);

		Simvestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Simvestor.setVisible(true);
		Simvestor.setResizable(false);
		Simvestor.getContentPane().setLayout(null);
	}

	public static void main(String[] args)
	{
		setup();
	}
}
