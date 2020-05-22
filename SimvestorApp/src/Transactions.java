import java.util.ArrayList;
import java.util.List;

public class Transactions {
	private static List<Transaction> transactions = new ArrayList<Transaction>();
	public Transactions()
	{
		// Nothing
	}
	
	public static String listAllTransactions()
	{
		String listTransactions = "";
		for(int i=0; i<transactions.size(); i++)
		{
			listTransactions += ((Transaction) transactions.toArray()[i]).toStringTransaction() + "\n";
		}
		return listTransactions;
	}
	public static void addTranscation(String ticker, int quantity, double price, boolean active)
	{
		transactions.add(new Stock(ticker, quantity, price, active));
	}
	
	public static void reset()
	{
		transactions.removeAll(transactions);
	}
	
	public int numberOfTransactions()
	{
		return transactions.size();
	}
	
}
