import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Trader extends Stocks {

	// FIELDS
	private String ticker;
	private double price;
	private int quantity;
	private boolean buy;
	
	public double cash = Portfolio.getCash();

	// CONSTRUCTOR
	
	public Trader(String ticker, double price)
	{
		this.ticker = ticker;
		this.price = price;
	}
	
	// METHODS
	
	public void setType(boolean buy)
	{
		this.buy = buy;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void trade()
	{
		checkTrade();
		if (buy)
		{
			buy();
		} else if (!buy)
		{
			sell();
		}
	}
	
	private void sell() {
		// Remove from Portfolio
		// Add to Transactions
	}

	private void buy() {
		Portfolio.addEquity(ticker, quantity, price);
		// Add to Portfolio
		// Add to Transactions
	}

	public String checkTrade() 
	{
		if (buy)
		{
			if (cash < (price * quantity))
			{
				return "Not Enough Buying Power";
			}
		} else if (!buy)
		{
			// Check if equity exists to be sold
		}
		return "";
	}
	
	public String smartScore()
	{
		String score = null;
		// Use smart score class
		return score;
	}
	
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
				System.out.print("ERROR");
			}
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		playSound();
//	}
}
