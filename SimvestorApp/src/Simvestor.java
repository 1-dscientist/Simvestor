// Primary Author:Rushil Jayant
// p7
// 5/24/20
// 35th and final commit
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.List;

@SuppressWarnings("serial")
public class Simvestor extends JFrame{
	// FIELDS
	private JTextField txtSearch;
	private JButton btnReset;
	public static JTextField txtBalance;
	private JTextField txtQuantity;
	private JTextField txtCash;
	private JButton btnBuy;
	private JButton btnSell;
	private JTextField txtAccountValue;
	private JTextField txtBuyingPower;
	private JTextField txtPortfolio;
	private JTextField txtTransactions;

	private JTextArea portfolioList;
	private JTextArea transactionList;
	private JTextField txtTicker;
	private JTextField txtPrice;
	private JTextField txtName;

	private JButton tradeButton;
	private final int x = 2;
	private int quantity;
	private String ticker;
	private double price;

	private FileHandler fileHandler = new FileHandler();


	public Simvestor() {
		// Empty
	}

	@SuppressWarnings("unchecked")
	// sets up program, creates frame window
	private void setup()
	{
		fileHandler.parseData();
		JFrame Simvestor = new JFrame("Simvestor");
		Simvestor.setBounds(300/x, 300/x, 775, 475);
		Simvestor.getContentPane().setLayout(null);

		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(Color.RED);
		btnReset.setFont(new Font("Arial", Font.BOLD, 24/x));
		btnReset.setBounds(1000/x, 800/x, 500/x, 50/x);
		btnReset.setVisible(true);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileHandler.reset();
				portfolioList.setText("");
				transactionList.setText("");
				txtCash.setText(Portfolio.getDisplayCash());
				txtBalance.setText(Portfolio.getDisplayValue());
			}
		});
		Simvestor.getContentPane().add(btnReset);

		txtBalance = new JTextField();
		txtBalance.setBackground(new Color(144, 238, 144));
		txtBalance.setForeground(new Color(0, 0, 0));
		txtBalance.setFont(new Font("Arial", Font.PLAIN, 72/x));
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setEditable(false);
		txtBalance.setText(Portfolio.getDisplayValue());
		txtBalance.setBounds(50/x, 50/x, 400/x, 150/x);
		txtBalance.setColumns(10);
		txtBalance.setVisible(true);
		Simvestor.getContentPane().add(txtBalance);

		txtCash = new JTextField();
		txtCash.setBackground(new Color(144, 238, 144));
		txtCash.setForeground(new Color(0, 0, 0));
		txtCash.setFont(new Font("Arial", Font.PLAIN, 72/x));
		txtCash.setHorizontalAlignment(SwingConstants.CENTER);
		txtCash.setEditable(false);
		txtCash.setText(Portfolio.getDisplayCash());
		txtCash.setBounds(550/x, 50/x, 400/x, 150/x);
		txtCash.setColumns(10);
		txtCash.setVisible(true);
		Simvestor.getContentPane().add(txtCash);


		tradeButton = new JButton("Trade");
		tradeButton.setFont(new Font("Arial", Font.BOLD, 48/x));
		tradeButton.setBackground(new Color(255,221,60));
		tradeButton.setBounds(1000/x, 650/x, 500/x, 100/x);
		tradeButton.setVisible(true);
		tradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Trader.checkTrade()) {
				Trader.trade();
				Trader.playSound();
				price = 0;
				ticker = "";
				quantity = 0;
				txtCash.setText(Portfolio.getDisplayCash());
				txtBalance.setText(Portfolio.getDisplayValue());
				portfolioList.setText(Portfolio.listAllEquities());
				transactionList.setText(Transactions.listAllTransactions());
				fileHandler.writePortfolioData();
				fileHandler.writeTransactionData();
			} else {
					JOptionPane.showMessageDialog(tradeButton, "PROBLEM");
				}
			}});
		Simvestor.getContentPane().add(tradeButton);


		txtQuantity = new JTextField("Quantity");
		txtQuantity.setFont(new Font("Arial", Font.PLAIN, 24/x));
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
		txtQuantity.setBounds(1000/x, 550/x, 500/x, 50/x);
		txtQuantity.setColumns(10);
		txtQuantity.setVisible(true);
		txtQuantity.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				try {
					int quantity = Integer.parseInt(txtQuantity.getText());
					Trader.setQuantity(quantity);
				}
				catch (NullPointerException ex) {
					// System.out.println("");
				}
				catch (NumberFormatException ex)
				{
					// System.out.println("");
				}
			}
		});
		Simvestor.getContentPane().add(txtQuantity);

		btnBuy = new JButton("Buy");
		btnBuy.setFont(new Font("Arial", Font.BOLD, 24/x));
		btnBuy.setBackground(new Color(144, 238, 144));
		btnBuy.setForeground(new Color(0, 0, 0));
		btnBuy.setBounds(1000/x, 450/x, 250/x, 50/x);
		btnBuy.setVisible(true);
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Trader.setType(true);
			}

		});
		Simvestor.getContentPane().add(btnBuy);

		btnSell = new JButton("Sell");
		btnSell.setForeground(Color.BLACK);
		btnSell.setFont(new Font("Arial", Font.BOLD, 24/x));
		btnSell.setBackground(new Color(255, 99, 71));
		btnSell.setBounds(1250/x, 450/x, 250/x, 50/x);
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trader.setType(false);
			}
		});
		Simvestor.getContentPane().add(btnSell);

		txtAccountValue = new JTextField();
		txtAccountValue.setEditable(false);
		txtAccountValue.setText("Account Value");
		txtAccountValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccountValue.setFont(new Font("Arial", Font.BOLD, 24/x));
		txtAccountValue.setBackground(new Color(211, 211, 211));
		txtAccountValue.setBounds(50/x, 200/x, 400/x, 50/x);
		txtAccountValue.setColumns(10);
		txtAccountValue.setVisible(true);
		Simvestor.getContentPane().add(txtAccountValue);

		txtBuyingPower = new JTextField();
		txtBuyingPower.setText("Buying Power");
		txtBuyingPower.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuyingPower.setFont(new Font("Arial", Font.BOLD, 24/x));
		txtBuyingPower.setEditable(false);
		txtBuyingPower.setColumns(10);
		txtBuyingPower.setBackground(new Color(211, 211, 211));
		txtBuyingPower.setBounds(550/x, 200/x, 400/x, 50/x);
		txtBuyingPower.setVisible(true);
		Simvestor.getContentPane().add(txtBuyingPower);

		txtPortfolio = new JTextField();
		txtPortfolio.setText("Portfolio");
		txtPortfolio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPortfolio.setFont(new Font("Arial", Font.BOLD, 24/x));
		txtPortfolio.setEditable(false);
		txtPortfolio.setColumns(10);
		txtPortfolio.setBackground(new Color(211, 211, 211));
		txtPortfolio.setBounds(50/x, 300/x, 400/x, 50/x);
		txtPortfolio.setVisible(true);
		Simvestor.getContentPane().add(txtPortfolio);

		txtTransactions = new JTextField();
		txtTransactions.setText("Transactions");
		txtTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransactions.setFont(new Font("Arial", Font.BOLD, 24/x));
		txtTransactions.setEditable(false);
		txtTransactions.setColumns(10);
		txtTransactions.setBackground(new Color(211, 211, 211));
		txtTransactions.setBounds(550/x, 300/x, 400/x, 50/x);
		txtTransactions.setVisible(true);
		Simvestor.getContentPane().add(txtTransactions);

		portfolioList = new JTextArea(Portfolio.listAllEquities());
		portfolioList.setFont(new Font("Arial", Font.BOLD, 14/x));
		portfolioList.setEditable(false);
		portfolioList.setBounds(50/x,350/x,400/x,500/x);
		Simvestor.getContentPane().add(portfolioList);


		transactionList = new JTextArea(Transactions.listAllTransactions());
		transactionList.setFont(new Font("Arial", Font.BOLD, 12/x));
		transactionList.setBounds(550/x,350/x,400/x,500/x);
		transactionList.setEditable(false);
		Simvestor.getContentPane().add(transactionList);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPrice.setFont(new Font("Arial", Font.PLAIN, 48/x));
		txtPrice.setText("");
		txtPrice.setBounds(1250/x, 150/x, 250/x, 150/x);
		Simvestor.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);

		txtTicker = new JTextField();
		txtTicker.setEditable(false);
		txtTicker.setText("");
		txtTicker.setFont(new Font("Arial", Font.BOLD, 72/x));
		txtTicker.setColumns(10);
		txtTicker.setBounds(1000/x, 150/x, 250/x, 150/x);
		Simvestor.getContentPane().add(txtTicker);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.BOLD, 24/x));
		txtName.setText("");
		txtName.setEditable(false);
		txtName.setBounds(1000/x, 300/x, 500/x, 50/x);
		Simvestor.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtSearch = new JTextField("Search");
		txtSearch.setFont(new Font("Arial", Font.BOLD, 24/x));
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
		txtSearch.setBounds(1000/x, 50/x, 500/x, 50/x);
		txtSearch.setColumns(10);
		txtSearch.setVisible(true);
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txtSearch.getText();
				String ticker = Stocks.searchMatch(search);
				txtName.setText(Stocks.getCompanyName(search));
				txtPrice.setText(Stocks.getDisplayPrice(ticker));
				txtTicker.setText(ticker);
				Trader.setTicker(ticker);
				Trader.setPrice(Stocks.getPrice(ticker));
			}});
		Simvestor.getContentPane().add(txtSearch);

		Simvestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Simvestor.setVisible(true);
		Simvestor.setResizable(false);
		Simvestor.getContentPane().setLayout(null);
	}
	// main method run this class by java application
	public static void main(String[] args)
	{
		Simvestor simvestor = new Simvestor();
		simvestor.setup();
	}
}