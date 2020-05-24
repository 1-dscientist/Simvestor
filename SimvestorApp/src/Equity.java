// Primary Author:Joshua Choi
// p7
// 5/24/20
// 35th and final commit
public interface Equity extends Investment 
	{
	
	boolean isEquity();
	void addToEquity(int quantity, double buyPrice);
	String toStringEquity();
	void subtractFromEquity(double sellPrice, int quantity);
	}
