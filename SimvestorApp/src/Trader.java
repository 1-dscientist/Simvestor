public class Trader extends Stocks {

	// FIELDS
	private String ticker;
	private double price;
	private int quantity;
	private boolean buy;
	
	public double cash = Portfolio.getCash();

	// CONSTRUCTOR
	
	public Trader(String ticker, double price)
	{
		this.ticker = ticker;
		this.price = price;
	}
	
	// METHODS
	
	public void setType(boolean buy)
	{
		this.buy = buy;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void trade()
	{
		checkTrade();
		if (buy)
		{
			buy();
		} else if (!buy)
		{
			sell();
		}
	}
	
	private void sell() {
		// Remove from Portfolio
		// Add to Transactions
	}

	private void buy() {
		// Add to Portfolio
		// Add to Transactions
	}

	public String checkTrade() 
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
}
