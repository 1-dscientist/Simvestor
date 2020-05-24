// Primary Author:Joshua Choi
// p7
// 5/24/20
// 35th and final commit
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
	// lists all transactions by adding up all transactions in a for loop until it exceeds the number of transactions size and returns
	public static String listAllTransactions()
	{
		String listTransactions = "";
		for(int i=0; i<transactions.size(); i++)
		{
			listTransactions += ((Transaction) transactions.toArray()[i]).toStringTransaction() + "\n";
		}
		return listTransactions;
	}
	// adds transaction according to ticker, quantity,  price and whether it is a buying action or a selling action
	public static void addTransaction(String ticker, int quantity, double price, boolean active)
	{
		transactions.add(new Stock(ticker, quantity, price, active));
	}
	// reset method called, removes all transaction
	public static void reset()
	{
		transactions.removeAll(transactions);
	}
	// returns number of transactions
	public int numberOfTransactions()
	{
		return transactions.size();
	}
	
}
