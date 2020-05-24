// Author: Joshua Choi
// Date:   05/26/2020
// Rev:    02
// Notes:  Contains all the Methods similar between Equity and Transaction

public interface Investment 
{
	String getTicker();
	int getQuantity();
	double getBuyPrice();
	double getCurrentPrice();
	String getDisplayPrice();
	double getEquityValue();
	double getTotalProfit();
	double getGain();
	String getDisplayGain();
	void addTo(double buyPrice, int quantity);
	void subtractFrom(double sellPrice, int quantity);
}
