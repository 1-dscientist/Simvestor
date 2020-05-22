public class Trader extends Stocks {

	// FIELDS
	private static String ticker;
	private static double price;
	private static int quantity;
	private static boolean buy;
	
	public static double cash = Portfolio.getCash();

	// CONSTRUCTOR
	
	public Trader(String ticker, double price)
	{
		this.ticker = ticker;
		this.price = price;
	}
	
	// METHODS
	
	public static void setType(boolean b)
	{
		buy = b;
	}
	
	public static void setQuantity(int n)
	{
		quantity = n;
	}
	
	public static void setTicker(String name)
	{
		ticker = name;
	}
	
	public static void setPrice(double dollars)
	{
		price = dollars;
	}
	
	public static void trade()
	{
		checkTrade();
		if (buy)
		{
			System.out.println(ticker);
			buy();
		} else if (!buy)
		{
			sell();
		}
	}
	
	private static void sell() {
		Portfolio.removeEquity(ticker, quantity, price);
		Transactions.addTranscation(ticker, quantity, price, false);
	}

<<<<<<< HEAD
	private static void buy() {
		Portfolio.addEquity(ticker, quantity, price);
		Transactions.addTranscation(ticker, quantity, price, true);
=======
	private void buy() {
		// Add to Portfolio
		// Add to Transactions
>>>>>>> 78bbe824321067b41eada4ebba1060f555dcda83
	}

	public static String checkTrade() 
	{
		if (buy)
		{
			if (cash < (price * quantity))
			{
				return "Not Enough Buying Power";
			}
		} else if (!buy)
		{
			// Check if equity exists to be sold
		}
		return "";
	}
	
	public String smartScore()
	{
		String score = null;
		// Use smart score class
		return score;
	}
	
	public void playSound() {
		
	}
<<<<<<< HEAD
	
//	public static void main(String[] args)
//	{
//		Portfolio.addEquity("AAPL", 50, 300.00);
//		Portfolio.addEquity("AAPL", 50, 310.00);
//		System.out.println(Portfolio.listAllEquities());
//	}
=======
>>>>>>> 78bbe824321067b41eada4ebba1060f555dcda83
}
