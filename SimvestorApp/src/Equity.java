import java.text.DecimalFormat;

public class Equity extends Stocks{

	// Fields
	private String ticker;
	private int quantity;
	private double buyPrice;
	
	private static final DecimalFormat ROUND = new DecimalFormat("0.00");

	// Constructor
	public Equity(String ticker, int quantity, double buyPrice) {
		// TODO Auto-generated constructor stub
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
	
	private double getCurrentPriceOfStock()
	{
		return super.getPrice(ticker);
	}
	
	public String getDisplayPriceOfStock()
	{
		return super.getDisplayPrice(ticker);
	}
	
	public double getEquityValue()
	{
		return (double) getCurrentPriceOfStock() * quantity;
	}
	
	public double getPercentage()
	{
		return (getCurrentPriceOfStock()/buyPrice)-1;
	}
	
	public String getDisplayPercentage()
	{
		return String.valueOf(ROUND.format(getPercentage())) + "%";
	}
	
	
}
