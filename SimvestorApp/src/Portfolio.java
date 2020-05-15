import java.util.Arrays;

public class Portfolio {

	private static Equity[] equities = {};

	private static double cash = 100000.00;

	public Portfolio() 
	{

	}

	public void addEquity(String ticker, int quantity, double buyPrice)
	{
		equities = Arrays.copyOf(equities, equities.length + 1);
		boolean exists = false;
		int existsEquityIndex = 0; // Initalization
		if (equities.length > 0) {
			for (int i = 0; i < equities.length; i++)
			{
				if (ticker == equities[i].getTicker())
				{
					if (exists == false) {
						exists = true;  
						existsEquityIndex = i;
					}
				}
			}
		}
		if (exists == true) {
			equities[existsEquityIndex].addToEquity(quantity, buyPrice);
			cash -= buyPrice*quantity;
		} else {
			equities[equities.length - 1] = new Stock(ticker, quantity, buyPrice, exists);
			cash -= buyPrice*quantity;
		}
	}

	public void removeEquity(String ticker, int quantity, double sellPrice)
	{

	}

	public int numberOfEquities()
	{
		return equities.length;
	}
	
	public static double getCash()
	{
		return cash;
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
	
	public static String getDisplayValue()
	{
		return "$"+Double.valueOf(getPortfolioValue())+"0";
	}
	
	public static String getDisplayCash()
	{
		return "$"+Double.valueOf(getCash())+"0";
	}
	
	public static String listAllEquities()
	{
		return null;
	}

//	public  void main(String[] args)
//	{
//		addEquity("AAPL",50,200.00);
//		addEquity("AAPL",50,200.00);
//		System.out.println(equities.length);
//		System.out.println(getPortfolioValue());
//	}
}

// Add method to remove equity
