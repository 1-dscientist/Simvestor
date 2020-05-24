// Primary Author: Rushil Jayant 
// pop up: Joshua Choi
// p7
// 5/24/20
// 35th and final commit
import java.util.List;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Trader extends Stocks {

	// FIELDS
	private static String ticker;
	private static double price;
	private static int quantity;
	private static boolean buy;
	private static FileHandler fileHandler;

	public static double cash = Portfolio.getCash();

	// CONSTRUCTOR

	public Trader(String ticker, double price)
	{
		this.ticker = ticker;
		this.price = price;
	}

	// METHODS
	// sets buy to b;
	public static void setType(boolean b)
	{
		buy = b;
	}
	// sets quantity to n
	public static void setQuantity(int n)
	{
		quantity = n;
	}
	// sets ticker to name
	public static void setTicker(String name)
	{
		ticker = name;
	}
	// sets price to dollars
	public static void setPrice(double dollars)
	{
		price = dollars;
	}
	// depending on the input, calls sell() or buy() accordingly
	public static void trade()
	{
		if (buy)
		{
			buy();
		} else if (!buy)
		{
			sell();
		}
	}
	// if selling, removes the specific stock to equity and adds the log to transaction
	private static void sell() {
		Portfolio.removeEquity(ticker, quantity, price);
		Transactions.addTransaction(ticker, quantity, price, false);
	}

	// if buying, adds the specific stock to equity and adds the log to trasaction
	private static void buy() {
		Portfolio.addEquity(ticker, quantity, price);
		Transactions.addTransaction(ticker, quantity, price, true);
	}
	// checks problem and returns problem if called
	public static String checkProblem() 
	{
		return "PROBLEM";
	}
	// checks if the user is eligible(cash enough , tickers exist) and if eligible the authentication returns true
	public static boolean checkTrade()
	{
		boolean auth = true;
		try 
		{
		if (buy)
		{
			if (cash < (price * quantity))
			{
				auth = false;
			}
		} else if (!buy)
		{
			boolean exists = false;
			int index = 0;
			for (int i = 0; i < FileHandler.listOfTickers().size(); i++)
			{
				if (!((String) FileHandler.listOfTickers().toArray()[i]).contentEquals(ticker))
				{
					if (i == (FileHandler.listOfTickers().size()-1))
					{
						exists = false;
						auth = false;
					}
				}
				else {
					index = i;
					exists = true;
				}
			} 
			if (exists)
			{
				if (Integer.parseInt(FileHandler.readPortfolioData().split("\n")[index].split(" ")[0]) < quantity)
				{
					auth = false;
				}
			}
		}
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			auth = false;
		}
		return auth;
	}

	// plays the apple pay sound if transaction is completed
	public static void playSound() 
	{
		try 
		{
			File musicPath = new File("ApplePaySound.wav");

			if (musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();

				Thread.sleep(clip.getMicrosecondLength()/1000);
			} 
			else
			{
				// System.out.print("ERROR");
			}
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
