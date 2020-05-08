import java.util.Arrays;

public class Portfolio {
	
	private static Equity[] equities = {};
	
	private static double cash = 100000.00;
	
	public Portfolio() 
	{
		
	}
	
	public static void addEquity(String ticker, int quantity, double buyPrice)
	{
		equities = Arrays.copyOf(equities, equities.length + 1);
		equities[equities.length - 1] = new Equity(ticker, quantity, buyPrice);
		cash -= buyPrice*quantity;
	}
	
	public static void removeEquity(String ticker, int quantity, double sellPrice)
	{
		
	}
	
	public static int numberOfEquities()
	{
		return equities.length;
	}
	
	public static double getPortfolioValue() 
	{
		double newValue = 0.0;
		for (int i = 0; i < equities.length; i++)
		{
			newValue += equities[i].getEquityValue();
		}
		return newValue + cash;
	}
	
//	public static void main(String[] args)
//	{
//		addEquity("AAPL",50,200.00);
//		addEquity("MSFT",10,100.00);
//		System.out.println(equities[0].getCurrentPriceOfStock());
//		System.out.println(equities[1].getCurrentPriceOfStock());
//		System.out.println(getPortfolioValue());
//	}
}

// Add method to remove equity
// When there are two stocks with same name: what should be done
