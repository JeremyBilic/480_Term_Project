package FrontEnd;
import javax.swing.JButton;

public class LandlordFrame extends UserFrame
{
	private JButton btnManageProperties;
	
	private JButton btnPayFees;
	
	
	public LandlordFrame()
	{
		super();
		
		btnManageProperties = new JButton("Manage Properties");
		panel.add(btnManageProperties);
		
		btnPayFees = new JButton("Pay Fees");
		panel.add(btnPayFees);
		
	}
}
