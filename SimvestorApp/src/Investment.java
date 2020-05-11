public interface Investment {
	String getTicker();
	int getQuantity();
	double getBuyPrice();
	double getCurrentPrice();
	String getDisplayPrice();
	double getEquityValue();
	double getTotalProfit();
	double getGain();
	String getDisplayGain();
}
