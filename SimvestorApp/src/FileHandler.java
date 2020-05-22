import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// File Name Portfolio.txt and Transactions.txt

public class FileHandler {

	private final String portfolioData = "Portfolio.txt";
	private final String transactionData = "Transactions.txt";

	private String portfolio;
	private String transactions;

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

	public String readPortfolioData()
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
			Transactions.addTranscation(ticker, quantity, price, active);

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
		} catch (ArrayIndexOutOfBoundsException ex)
		{
			// System.out.println("");
		} catch (NumberFormatException ex)
		{
			
		}
	}

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
	}

	//	public static void main(String[] args)
	//	{
	//		FileHandler fileHandler = new FileHandler();
	//		for (int i = 0; i < (fileHandler.readPortfolioData().split("\n").length); i++)
	//		{
	//			System.out.println(fileHandler.readPortfolioData().split("\n")[i].split(" ")[5]);
	//		}
	//	}
}
