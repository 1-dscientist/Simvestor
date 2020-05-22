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
}
