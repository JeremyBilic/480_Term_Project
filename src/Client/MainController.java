package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Address;
import Model.Criteria;
import Model.Listing;
import Model.User;

public class MainController
{
	private UserFrame frame;
	private PRMSystem prms;
	private User theUser;
	
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
	
	public void setSystem(PRMSystem prms) {
		this.prms = prms;
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
						
						Listing theListing = prms.search(theCriteria);
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
						theUser = prms.authentication(theDialog.getUsername(), theDialog.getPassword());
						
						if(theUser != null)
						{
							frame.dispose();
							
							if(theUser.getType().equals("renter"))
							{
								frame = new RegisteredRenterFrame();
							}
							else if(theUser.getType().equals("landlord"))
							{
								frame = new LandlordFrame();
							}
							else
							{
								frame = new ManagerFrame();
							}
							
							frame.setVisible(true);
						}
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
