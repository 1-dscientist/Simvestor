// Author: Rushil Jayant
// Date:   05/26/2020
// Rev:    02
// Notes:  All File Handling will be done using this class

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// File Name Portfolio.txt and Transactions.txt

public class FileHandler {
	// FIELDS
	private final static String portfolioData = "Portfolio.txt";
	private final static String transactionData = "Transactions.txt";
	private final static String buyingPowerData = "BuyingPower.txt";

	private String portfolio;
	private String transactions;
	private double buyingPower;

	// writes portfolio data using equities by FileWriter
	public void writePortfolioData()
	{
		portfolio = Portfolio.listAllEquities();
		try {

			FileWriter fw = new FileWriter(portfolioData);
			fw.write(portfolio);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// reads portfolio data through a scanner
	public static String readPortfolioData()
	{
		String out = "";

		try {

			FileReader fr = new FileReader(portfolioData);
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(fr);


			while(scan.hasNextLine()) {
				out += scan.nextLine() + "\n";
			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
	// writes transaction data like the portfolio data
	public void writeTransactionData()
	{
		transactions = Transactions.listAllTransactions();
		try {

			FileWriter fw = new FileWriter(transactionData);
			fw.write(transactions);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// reads transaction data through scanner, just like the portfolio
	public String readTransactionData()
	{
		String out = "";

		try {

			FileReader fr = new FileReader(transactionData);
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(fr);


			while(scan.hasNextLine()) {
				out += scan.nextLine() + "\n";
			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}

	// Writes the buying power to the BuyingPower.txt
	public void writeBuyingPower()
	{
		buyingPower = Portfolio.getCash();
		try {

			FileWriter fw = new FileWriter(buyingPowerData);
			fw.write(Double.toString(buyingPower));
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads the buying power to the BuyingPower.txt
	public double readBuyingPower()
	{
		String out = "";

		try {

			FileReader fr = new FileReader(buyingPowerData);
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(fr);


			while(scan.hasNextLine()) {
				out += scan.nextLine() + "\n";
			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return Double.parseDouble(out);
	}

	//  takes the data stored in the Portfolio.txt and Transactions.txt and parses it into usable formats
	public void parseData()
	{
		try {
			// Transaction Data
			for (int i = 0; i < (readTransactionData().split("\n").length); i++)
			{
				boolean active = false;
				int quantity;
				double price;
				String ticker;
				if ((readTransactionData().split("\n")[i].split(" ")[0]) == "PURCHASED")
				{
					active = true;
				} else if ((readTransactionData().split("\n")[i].split(" ")[0]) == "SOLD")
				{
					active = false;
				}
				quantity = Integer.parseInt(readTransactionData().split("\n")[i].split(" ")[1]);
				ticker = readTransactionData().split("\n")[i].split(" ")[4];
				price = Double.parseDouble(readTransactionData().split("\n")[i].split(" ")[6].substring(1));
				Transactions.addTransaction(ticker, quantity, price, active);

			}

			// Portfolio Data
			for (int i = 0; i < (readPortfolioData().split("\n").length); i++)
			{
				int quantity;
				double price;
				String ticker;
				quantity = Integer.parseInt(readPortfolioData().split("\n")[i].split(" ")[0]);
				ticker = readPortfolioData().split("\n")[i].split(" ")[3];
				price = Double.parseDouble(readPortfolioData().split("\n")[i].split(" ")[5].substring(1));
				Portfolio.addEquity(ticker, quantity, price);
			} 

			Portfolio.setCash(readBuyingPower());

		} catch (ArrayIndexOutOfBoundsException ex)
		{
			// System.out.println("");
		} catch (NumberFormatException ex)
		{

		}
	}
	// using arrays , returns list tickers
	public static List<String> listOfTickers()
	{
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < (readPortfolioData().split("\n").length); i++)
		{
			String name = readPortfolioData().split("\n")[i].split(" ")[3];
			list.add(name);
		}
		return list;
	}
	// resets every data user changed, equivalent to erasing all data in the txt file
	public void reset()
	{
		try {

			FileWriter fw = new FileWriter(portfolioData);
			fw.write("");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {

			FileWriter fw = new FileWriter(transactionData);
			fw.write("");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Portfolio.reset();
		Transactions.reset();
		readPortfolioData();
		readTransactionData();
		Portfolio.setCash(100000.00);
	}
	//
	//		public static void main(String[] args)
	//		{
	//			System.out.println(listOfTickers().toString());
	//		}
}
