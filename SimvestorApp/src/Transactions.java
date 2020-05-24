// Author: Joshua Choi
// Date:   05/26/2020
// Rev:    02
// Notes:  Contains all the Transactions for the Paper Trading game

import java.util.ArrayList;
import java.util.List;

public class Transactions 
{
	// Fields
	private static List<Transaction> transactions = new ArrayList<Transaction>();

	public Transactions()
	{
		// Nothing
	}

	// Lists all transactions by adding up all transactions in a for loop until it exceeds the number of transactions size and returns an ArrayList of transactions
	public static String listAllTransactions()
	{
		String listTransactions = "";
		for(int i=0; i<transactions.size(); i++)
		{
			listTransactions += ((Transaction) transactions.toArray()[i]).toStringTransaction() + "\n";
		}
		return listTransactions;
	}

	// Adds transaction according to ticker, quantity,  price and whether it is a buying action or a selling action
	public static void addTransaction(String ticker, int quantity, double price, boolean active)
	{
		transactions.add(new Stock(ticker, quantity, price, active));
	}

	// Removes all the Transactions
	public static void reset()
	{
		transactions.removeAll(transactions);
	}
}