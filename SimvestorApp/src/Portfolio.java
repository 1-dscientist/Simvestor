// Author: Rushil Jayant
// Date:   05/26/2020
// Rev:    02
// Notes:  Contains all the Transactions for the Paper Trading game

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Portfolio {
// Fields
	private static List<Equity> equities = new ArrayList<Equity>();
	private static double cash = 100000.00;
	// empty constructor
	public Portfolio() 
	{

	}
	// adds equity in respect to the ticker, quantity, buy price input
	public static void addEquity(String ticker, int quantity, double buyPrice)
	{
		boolean same = false;
		int index = -1;
		try {
			{
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
			}
			if (same == true) {
				((Equity) equities.toArray()[index]).addToEquity(quantity, buyPrice);
				cash -= buyPrice*quantity;
			} else {
				equities.add(new Stock(ticker, quantity, buyPrice));
				cash -= (quantity*buyPrice);
			}
		} catch (NullPointerException ex) {
			equities.add(new Stock(ticker, quantity, buyPrice));
			cash -= (quantity*buyPrice);
		}
	}
	// removes equity according to ticker , quantity , and sellprice
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

	// returns cash
	public static double getCash()
	{
		return cash;
	}
	
	public static void setCash(double buyingPower)
	{
		cash = buyingPower;
	}
	// returns portfolio by adding the new value into the string
	public static double getPortfolioValue() 
	{
		double newValue = 0.0;
		try
		{
			for (int i = 0; i < equities.size(); i++)
			{
				newValue += ((Stock) equities.toArray()[i]).getEquityValue();
			}
			return newValue + cash;
		} catch (NullPointerException ex) {
			return cash;
		}
	}
	// returns display value
	public static String getDisplayValue()
	{
		return "$"+Double.valueOf(getPortfolioValue())+"0";
	}
	// returns string display cash
	public static String getDisplayCash()
	{
		return "$"+Double.valueOf(getCash())+"0";
	}
	// list all equities by using a for loop that adds strings of equity until i gets bigger than the size
	public static String listAllEquities()
	{
		String stringList = "";
		for (int i=0; i< equities.size(); i++)
		{
			stringList += ((Equity) equities.toArray()[i]).toStringEquity() + "\n";
		}
		return stringList;
	}
	// removes every equity, start over again at 100000.00 cash
	public static void reset()
	{
		equities.removeAll(equities);
		cash = 100000.00;
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
