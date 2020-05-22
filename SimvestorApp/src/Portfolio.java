import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Portfolio {

	private static List<Equity> equities = new ArrayList<Equity>();

	private static double cash = 100000.00;

	public Portfolio() 
	{

	}

	public static void addEquity(String ticker, int quantity, double buyPrice)
	{

		boolean same = false;
		int index = -1;
		for (int i = 0; i < equities.size(); i++)
		{
			if (same == false)
			{
				if (ticker.contentEquals((((Equity) equities.toArray()[i]).getTicker())))
				{
					same = true;
					index = i;
				}
			}
		}
		if (same == true) {
			((Equity) equities.toArray()[index]).addToEquity(quantity, buyPrice);
			cash -= buyPrice*quantity;
		} else {
			equities.add(new Stock(ticker, quantity, buyPrice));
			cash -= (quantity*buyPrice);
		}
	}

	public static void removeEquity(String ticker, int quantity, double sellPrice)
	{
		boolean same = false;
		int index = -1;
		for (int i = 0; i < equities.size(); i++)
		{
			if (!same)
			{
				if (ticker.contentEquals(((Equity) equities.toArray()[i]).getTicker()))
				{
					same = true;
					index = i;
				}
			}
		}
		if (same) {
			if (quantity == ((Equity) equities.toArray()[index]).getQuantity()) {
				equities.remove(index);
				cash += (quantity*sellPrice);
			} else {
				((Equity) equities.toArray()[index]).subtractFromEquity(sellPrice, quantity);
				cash += (quantity*sellPrice);
			}
		}
	}

	public int numberOfEquities()
	{
		return equities.size();
	}

	public static double getCash()
	{
		return cash;
	}

	public static double getPortfolioValue() 
	{
		double newValue = 0.0;
		for (int i = 0; i < equities.size(); i++)
		{
			newValue += ((Stock) equities.toArray()[i]).getEquityValue();
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
		String stringList = "";
		for (int i=0; i< equities.size(); i++)
		{
			stringList += ((Equity) equities.toArray()[i]).toStringEquity() + "\n";
		}
		return stringList;
	}


//	public static void main(String[] args)
//	{
//		addEquity("AAPL",50,200.00);
//		addEquity("AAPL",50,300.00);
//		System.out.println(equities.size());
//		System.out.println(listAllEquities());
//		System.out.println(getDisplayCash());
//	}
}

// Add method to remove equity
