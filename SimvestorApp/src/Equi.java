import java.text.DecimalFormat;

public class Equi extends Stocks{

	// Fields
	private String ticker;
	private int quantity;
	private double buyPrice;
	
	private static final DecimalFormat ROUND = new DecimalFormat("0.00");

	// Constructor
	public Equi(String ticker, int quantity, double buyPrice) {
		// TODO Auto-generated constructor stub
		this.ticker = ticker;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
	}
	
	// Methods
	
	public String getTicker()
	{
		return ticker;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getBuyPrice()
	{
		return buyPrice;
	}
	
	public void addToEquity(int quantity, double buyPrice)
	{
		this.buyPrice = ((quantity*buyPrice)+(this.quantity*this.buyPrice))/(this.quantity+quantity);
		this.quantity += quantity;
	}
	
	public double getCurrentPriceOfStock()
	{
		return super.getPrice(ticker);
	}
	
	public String getDisplayPrice()
	{
		return super.getDisplayPrice(ticker);
	}
	
	public double getEquityValue()
	{
		return (double) getCurrentPriceOfStock() * quantity;
	}
	
	public double getTotalProfit()
	{
		return getEquityValue()-(buyPrice*quantity);
	}
	
	public double getPercentage()
	{
		return ((getCurrentPriceOfStock()/buyPrice)*100)-100;
	}
	
	public String getDisplayPercentage()
	{
		return String.valueOf(ROUND.format(getPercentage())) + "%";
	}
	
	public String getDisplayDaysGain()
	{
		return super.getDisplayPercentChange(ticker);
	}
	
	public String getDisplayDaysChange()
	{
		return super.getDisplayPriceChange(ticker);
	}
	
	public String toString()
	{
		return "| "+ticker+" | "+quantity+" | $"+Double.valueOf(buyPrice)+" | $"+getDisplayPrice()+" | $"+Double.valueOf(getTotalProfit())+" | "+getDisplayPercentage() + " |";
	}
	
}

// Add a to string method