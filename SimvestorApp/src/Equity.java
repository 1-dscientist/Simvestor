public interface Equity extends Investment {
	boolean isEquity();
	void addToEquity(int quantity, double buyPrice);
	String toStringEquity();
}
