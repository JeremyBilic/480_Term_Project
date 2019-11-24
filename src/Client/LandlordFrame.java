package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	class PeriodicalReportButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}
