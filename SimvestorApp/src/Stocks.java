import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		Scanner scan = null;
		@SuppressWarnings("deprecation")
		String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + java.net.URLEncoder.encode(ticker) + "&apikey=E3OKBSQ3LTVGCVYE";

		try {
			String response = "";

			URL reader = new URL(url);
			scan = new Scanner(reader.openStream());

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				response += line + "\n";
			}

			//System.out.println(response);
			
			String[] lines = response.split("\n");
			for (int i = 0; i < lines.length; i++)
			{
				if (lines[i].contains("05. price")) {
					price = Double.parseDouble(lines[i].split(": \"")[1].split("\",")[0]);
				}
			}
			
			/*

			NOTE:
			If you'd like to pull an image from online, that is possible to do using the ImageIO class. It would look something like:
			
			Image downloadedImage = ImageIO.read(new URL("URL OF THE IMAGE TO DOWNLOAD"));
"
			 */

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
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
		String name = null;
		Scanner scan = null;
		@SuppressWarnings("deprecation")
		String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + java.net.URLEncoder.encode(search) + "&apikey=E3OKBSQ3LTVGCVYE";

		try {
			String response = "";

			URL reader = new URL(url);
			scan = new Scanner(reader.openStream());

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				response += line + "\n";
			}

			// System.out.println(response);
			
			String[] lines = response.split("\n");
			for (int i = 0; i < 5; i++)
			{
				if (lines[i].contains("2. name")) {
					name = lines[i].split(": \"")[1].split("\",")[0];
				}
			}
			/*

			NOTE:
			If you'd like to pull an image from online, that is possible to do using the ImageIO class. It would look something like:
			
			Image downloadedImage = ImageIO.read(new URL("URL OF THE IMAGE TO DOWNLOAD"));
"
			 */

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
		return name;
	}

//	public static double getYdayPrice(String ticker)
//	{
//		String result = null;
//		String[] results = null;
//		try{  
//			UserAgent userAgent = new UserAgent(); 
//			userAgent.sendGET(baseLinkDailyPrice.replace("|TICKER|",ticker).replace("|APIKEY|",API_KEY));
//			JNode node = userAgent.json.findEach("4. close");
//			result = node.toString();
//			results = result.split(",");
//			for (int i = 0; i < results.length; i++)
//			{
//				results[i] = results[i].replace("[","").replace("\"","").replace("]","").replace(" ","");
//			}
//		} catch(JauntException e){
//			System.err.println(e);
//		}
//		return Double.parseDouble(results[1]);
//	}

//	public static double getPercentChange(String ticker)
//	{
//		return ((getPrice(ticker)/getYdayPrice(ticker))-1)*100;
//	}
//
//	public static String getDisplayPercentChange(String ticker)
//	{
//		double change = ((getPrice(ticker)/getYdayPrice(ticker))-1)*100;
//		String formattedChange = String.valueOf(ROUND.format(change));
//		return formattedChange+"%";
//	}
//
//	public static double getPriceChange(String ticker)
//	{
//		return getPrice(ticker)-getYdayPrice(ticker);
//	}

//	public static String getDisplayPriceChange(String ticker)
//	{
//		double change = getPrice(ticker)-getYdayPrice(ticker);
//		String formattedPrice = String.valueOf(ROUND.format(change));
//		if (change>0)
//		{
//			return "+"+formattedPrice;
//		} else {
//			return "-"+formattedPrice;
//		}
//	}

	public static String searchMatch(String search) 
	{
		String ticker = null;
		Scanner scan = null;
		@SuppressWarnings("deprecation")
		String url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + java.net.URLEncoder.encode(search) + "&apikey=E3OKBSQ3LTVGCVYE";

		try {
			String response = "";

			URL reader = new URL(url);
			scan = new Scanner(reader.openStream());

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				response += line + "\n";
			}

			// System.out.println(response);
			
			String[] lines = response.split("\n");
			for (int i = 0; i < 4; i++)
			{
				if (lines[i].contains("1. symbol")) {
					ticker = lines[i].split(": \"")[1].split("\",")[0];
				}
			}
			/*

			NOTE:
			If you'd like to pull an image from online, that is possible to do using the ImageIO class. It would look something like:
			
			Image downloadedImage = ImageIO.read(new URL("URL OF THE IMAGE TO DOWNLOAD"));
"
			 */

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
		return ticker;
	}

	public static void main(String[] args)
	{
		//		System.out.println(getCompanyName("AAPL"));
		//		System.out.println(searchMatch("apple"));
		//		System.out.println(getDisplayPriceChange("AAPL"));
		//System.out.println(getDisplayPercentChange("MSFT"));
		//		System.out.println(getPrice("AAPL"));
	}
}
