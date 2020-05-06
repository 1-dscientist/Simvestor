import java.text.DecimalFormat;

import com.jaunt.JNode;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class Stocks {

	// Fields
	private static final String API_KEY = "E3OKBSQ3LTVGCVYE";
	
	private static String baseLinkPrice = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=|TICKER|&interval=5min&apikey=|APIKEY|";
	private static String baseLinkSearch = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=|SEARCH|&apikey=|APIKEY|";
	
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
			JNode node = userAgent.json.findFirst("1. open");
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
	public static String getCompanyName(String ticker) {
		return null;
	}
	
	// TODO
	public String getLastRefreshed(String ticker) {
		return null;
	}
	
	public static String[] searchMatches(String search) {
		String result = null;
		String[] results = null;
		try{  
			UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
			userAgent.sendGET(baseLinkSearch.replace("|SEARCH|",search).replace("|APIKEY|",API_KEY));   //send request
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
		return results;
	}
}
