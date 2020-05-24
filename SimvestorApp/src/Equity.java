// Author: Joshua Choi
// Date:   05/26/2020
// Rev:    02
// Notes:  IS-An Equity which describes Stock class

public interface Equity extends Investment 
{
	boolean isEquity();
	void addToEquity(int quantity, double buyPrice);
	String toStringEquity();
	void subtractFromEquity(double sellPrice, int quantity);
}
