import java.text.DecimalFormat;

import com.jaunt.JNode;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class Stocks {

	// Fields
	private static final String API_KEY = "E3OKBSQ3LTVGCVYE";
	private static final String API_KEY_2 = "0M8I308CQIX4V57T";

	private static String baseLinkPrice = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=|TICKER|&interval=5min&apikey=|APIKEY|";
	private static String baseLinkSearch = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=|SEARCH|&apikey=|APIKEY|";
	private static String baseLinkDailyPrice = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=|TICKER|&apikey=|APIKEY|";

	private static final DecimalFormat ROUND = new DecimalFormat("0.00");

	// Constructor
	public Stocks() {
		// Empty Because this is used for research abt stocks
	}

	public static double getPrice(String ticker)
	{
		double price = 0;
		try{  
			UserAgent userAgent = new UserAgent();
			userAgent.sendGET(baseLinkPrice.replace("|TICKER|",ticker).replace("|APIKEY|",API_KEY));
			JNode node = userAgent.json.findFirst("4. close");
			price = Double.parseDouble(node.toString());
		}
		catch(JauntException e){
			System.err.println(e);
		}
		return price;
	}

	public static String getDisplayPrice(String ticker)
	{
		String formattedPrice = String.valueOf(ROUND.format(getPrice(ticker)));
		return "$" + formattedPrice;
	}

	// TODO
	public static String getCompanyName(String search) 
	{
		String result = null;
		String[] results = null;
		try{  
			UserAgent userAgent = new UserAgent();
			userAgent.sendGET(baseLinkSearch.replace("|SEARCH|",search).replace("|APIKEY|",API_KEY)); 
			JNode node = userAgent.json.findEach("2. name");
			result = node.toString();
			results = result.split(",");
			for (int i = 0; i < results.length; i++)
			{
				results[i] = results[i].replace("[","").replace("\"","").replace("]","");
			}
		}
		catch(JauntException e){
			System.err.println(e);
		}
		return results[0];
	}

	public static double getYdayPrice(String ticker)
	{
		String result = null;
		String[] results = null;
		try{  
			UserAgent userAgent = new UserAgent(); 
			userAgent.sendGET(baseLinkDailyPrice.replace("|TICKER|",ticker).replace("|APIKEY|",API_KEY));
			JNode node = userAgent.json.findEach("4. close");
			result = node.toString();
			results = result.split(",");
			for (int i = 0; i < results.length; i++)
			{
				results[i] = results[i].replace("[","").replace("\"","").replace("]","").replace(" ","");
			}
		} catch(JauntException e){
			System.err.println(e);
		}
		return Double.parseDouble(results[1]);
	}

	public static double getPercentChange(String ticker)
	{
		return ((getPrice(ticker)/getYdayPrice(ticker))-1)*100;
	}

	public static String getDisplayPercentChange(String ticker)
	{
		double change = ((getPrice(ticker)/getYdayPrice(ticker))-1)*100;
		String formattedChange = String.valueOf(ROUND.format(change));
		return formattedChange+"%";
	}
	
	public static double getPriceChange(String ticker)
	{
		return getPrice(ticker)-getYdayPrice(ticker);
	}
	
	public static String getDisplayPriceChange(String ticker)
	{
		double change = getPrice(ticker)-getYdayPrice(ticker);
		String formattedPrice = String.valueOf(ROUND.format(change));
		if (change>0)
		{
			return "+"+formattedPrice;
		} else {
			return "-"+formattedPrice;
		}
	}

	public static String searchMatch(String search) 
	{
		String result = null;
		String[] results = null;
		try{  
			UserAgent userAgent = new UserAgent();
			userAgent.sendGET(baseLinkSearch.replace("|SEARCH|",search).replace("|APIKEY|",API_KEY)); 
			JNode node = userAgent.json.findEach("1. symbol");
			result = node.toString();
			results = result.split(",");
			for (int i = 0; i < results.length; i++)
			{
				results[i] = results[i].replace("[","").replace("\"","").replace("]","").replace(" ","");
			}
		}
		catch(JauntException e){
			System.err.println(e);
		}
		return results[0];
	}

	public static void main(String[] args)
	{
//		System.out.println(getCompanyName("AAPL"));
//		System.out.println(searchMatch("apple"));
//		System.out.println(getDisplayPriceChange("AAPL"));
		System.out.println(getDisplayPercentChange("MSFT"));
//		System.out.println(getPrice("AAPL"));
	}
}
