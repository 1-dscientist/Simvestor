
import java.text.DecimalFormat;

public class Stock extends Stocks implements Equity, Transaction {

	private String ticker;
	private int quantity;
	private double buyPrice;
	private boolean active;
	
	private double currentPrice; 
	
	private static final DecimalFormat ROUND = new DecimalFormat("0.00");
	// constructor
	public Stock(String ticker, int quantity, double buyPrice, boolean active)
	{
		this.ticker = ticker;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.active = active;
	}
	
	public Stock(String ticker, int quantity, double buyPrice)
	{
		this.ticker = ticker;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
	}
	@Override
	// gets ticker
	public String getTicker()
	{
		return ticker;
	}
	
	@Override
	// gets quantity
	public int getQuantity()
	{
		return quantity;
	}
	//gets buy price
	public double getBuyPrice()
	{
		return buyPrice;
	}
	// gets current price
	@Override
	public double getCurrentPrice()
	{
		currentPrice = super.getPrice(ticker);
		return currentPrice;
	}
	// gets display price
	@Override
	public String getDisplayPrice() {
		String displayPrice = super.getDisplayPrice(ticker);
		return displayPrice;
	}
	// gets equity value
	@Override
	public double getEquityValue() {
		// TODO Auto-generated method stub
		return (double) getCurrentPrice() * quantity;
	}
	// gets total profit by subtracting buy price * quantity
	@Override
	public double getTotalProfit() {
		// TODO Auto-generated method stub
		return getEquityValue()-(buyPrice*quantity);
	}
	
	public String getTotalDisplayProfit() {
		// TODO Auto-generated method stub
		return "$" + ROUND.format(getEquityValue()-(buyPrice*quantity));
	}
	// gets gain
	@Override
	public double getGain() {
		// TODO Auto-generated method stub
		return 0;
	}
	// gets display gain
	@Override
	public String getDisplayGain() {
		// TODO Auto-generated method stub
		return ROUND.format(getEquityValue()/(buyPrice*quantity)) + "%";
	}
	// checks transaction
	@Override
	public boolean isTransaction() {
		// TODO Auto-generated method stub
		return false;
	}
	// checks equity
	@Override
	public boolean isEquity() {
		// TODO Auto-generated method stub
		return false;
	}
	// adds to equity
	@Override
	public void addToEquity(int quantity, double buyPrice) {
		// TODO Auto-generated method stub
		this.buyPrice = ((quantity*buyPrice)+(this.quantity*this.buyPrice))/(this.quantity+quantity);
		this.quantity += quantity;
	}
	// to string
	@Override
	public String toStringEquity() {
		return "| " + ticker + " | " + Integer.toString(quantity) + " | " + Double.toString(buyPrice) + " | " + getDisplayPrice() + " | " + getTotalDisplayProfit() + " | " + getDisplayGain(); 
	}
	// transaction to string
	@Override
	public String toStringTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	// adds 
	public void addTo(double buyPrice, int quantity) {
		// TODO Auto-generated method stub
		
	}
	// subtracts
	@Override
	public void subtractFrom(double sellPrice, int quantity) {
		// TODO Auto-generated method stub
		
	}

}