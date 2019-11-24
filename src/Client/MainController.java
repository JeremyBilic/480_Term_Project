package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Address;
import Model.Criteria;

public class MainController
{
	private UserFrame frame;
	
	public MainController(UserFrame theFrame)
	{
		frame = theFrame;
		
		frame.setSearchListener(new SearchListener());
		frame.setLoginListener(new LoginListener());
		frame.setSubscribeListener(new SubscribeListener());
		frame.setCheckSubscriptionListener(new CheckSubscriptionListener());
		frame.setManagePropertiesListener(new ManagePropertiesListener());
		frame.setPayFeesListener(new PayFeesListener());
		frame.setManageFeesListener(new ManageFeesListener());
		frame.setPeriodicalReportListener(new PeriodicalReportListener());
		frame.setListUsersListener(new ListUsersListener());
		frame.setListPropertiesListener(new ListPropertiesListener());
	}
	
	class SearchListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			PropertyInputBox theDialog = new PropertyInputBox();
			theDialog.setFrameListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					String action = evt.getActionCommand();
					if(action.equals("OK"))
					{
						Address theAddress = new Address(theDialog.getStreet(), theDialog.getQuadrant(), 
								theDialog.getCity(), theDialog.getProvince(), theDialog.getCountry());
						
						String furnished;
						
						if(theDialog.getFurnished().equals("Yes"))
						{
							furnished = "TRUE";
						}
						else if(theDialog.getFurnished().equals("No"))
						{
							furnished = "FALSE";
						}
						else
						{
							furnished = "";
						}
						
						Criteria theCriteria = new Criteria(theAddress, theDialog.getState(), theDialog.getNumBathrooms(), 
								theDialog.getNumBedrooms(), theDialog.getPropertyType(), furnished);
					}
				}
			});
			theDialog.setVisible(true);
		}
	}
	
	class LoginListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			LoginBox theDialog = new LoginBox();
			theDialog.setFrameListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					String action = evt.getActionCommand();
					if(action.equals("OK"))
					{
						
					}
				}
			});
			theDialog.setVisible(true);
		}	
	}
	
	class SubscribeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			
		}
		
	}
	
	class CheckSubscriptionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class ManagePropertiesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class PayFeesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class ManageFeesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class PeriodicalReportListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class ListUsersListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
	
	class ListPropertiesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			
		}
		
	}
}
