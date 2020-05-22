import java.util.Arrays;

public class Portfolio {

	private static Equity[] equities = {};

	private static double cash = 100000.00;

	public Portfolio() 
	{

	}

	public void addEquity(String ticker, int quantity, double buyPrice)
	{
<<<<<<< HEAD
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
=======
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
>>>>>>> 78bbe824321067b41eada4ebba1060f555dcda83
				}
			}
		}
		if (exists == true) {
			equities[existsEquityIndex].addToEquity(quantity, buyPrice);
			cash -= buyPrice*quantity;
		} else {
<<<<<<< HEAD
			equities.add(new Stock(ticker, quantity, buyPrice));
			cash -= (quantity*buyPrice);
=======
			equities[equities.length - 1] = new Stock(ticker, quantity, buyPrice, exists);
			cash -= buyPrice*quantity;
>>>>>>> 78bbe824321067b41eada4ebba1060f555dcda83
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
		String stringList = "";
		for (int i=0; i< equities.length; i++)
		{
			stringList += equities[i].toStringEquity() + "\n";
		}
		return stringList;
	}

<<<<<<< HEAD
//	public static void main(String[] args)
//	{
//		addEquity("AAPL",50,200.00);
//		addEquity("AAPL",50,300.00);
//		System.out.println(equities.size());
//		System.out.println(listAllEquities());
//		System.out.println(getDisplayCash());
=======
//	public  void main(String[] args)
//	{
//		addEquity("AAPL",50,200.00);
//		addEquity("AAPL",50,200.00);
//		System.out.println(equities.length);
//		System.out.println(getPortfolioValue());
>>>>>>> 78bbe824321067b41eada4ebba1060f555dcda83
//	}
}

// Add method to remove equity
