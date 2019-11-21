package Model;

public class Fee {

	private double amount;
	
	public Fee(double amount)
	{
		this.setAmount(amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void addToAmount(double amount)
	{
		this.amount += amount;
	}
}
