import java.util.Arrays;

public class Portfolio {
	
	private static Equity[] equities = {};
	
	public Portfolio() 
	{
		
	}
	
	public static void addEquity(String ticker, int quantity, double buyPrice)
	{
		equities = Arrays.copyOf(equities, equities.length + 1);
		equities[equities.length - 1] = new Equity(ticker, quantity, buyPrice);
	}
	
//	public static void main(String[] args)
//	{
//		addEquity("AAPL",5,200.00);
//		System.out.println(equities[0].getDisplayPercentage());
//	}
}
