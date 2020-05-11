import java.text.DecimalFormat;

public class Stock extends Stocks implements Equity, Transaction {

	private String ticker;
	private int quantity;
	private double buyPrice;
	
	private static final DecimalFormat ROUND = new DecimalFormat("0.00");
	
	@Override
	public String getTicker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBuyPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCurrentPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDisplayPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEquityValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalProfit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getGain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDisplayGain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addToEquity(int quantity, double buyPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toStringEquity() {
		// TODO Auto-generated method stub
		return null;
	}

}
