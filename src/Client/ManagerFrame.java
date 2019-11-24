package Client;
import javax.swing.JButton;
import javax.swing.JList;

import Model.Address;
import Model.Criteria;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerFrame extends UserFrame
{
	private JButton btnManageFees;
	private JButton btnPeriodicalReport;
	private JButton btnListUsers;
	private JButton btnListProperties;
	
	public ManagerFrame()
	{
		super();
		
		btnManageFees = new JButton("Manage Fees");
		panel.add(btnManageFees);
		
		btnPeriodicalReport = new JButton("Periodical Report");
		panel.add(btnPeriodicalReport);
		
		btnListUsers = new JButton("List Users");
		panel.add(btnListUsers);
		
		btnListProperties = new JButton("List Properties");
		panel.add(btnListProperties);
		
	}
	
	class ManageFeesButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class PeriodicalReportButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class ListUsersButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class ListPropertiesButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}
