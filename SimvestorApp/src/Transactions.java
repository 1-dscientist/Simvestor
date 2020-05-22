public class Transactions {
	private static Transaction[] transactions = {};
	public Transactions()
	{
		// Nothing
	}
	
	public static String listAllTransactions()
	{
		String listTransactions = "";
		for(int i=0; i<transactions.length; i++)
		{
			listTransactions += transactions[i].toStringTransaction() + "\n";
		}
		return listTransactions;
	}
	public void addTranscation()
	{
		
	}
	public int numberOfTransactions()
	{
		return transactions.length;
	}
	
}
