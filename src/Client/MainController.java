package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Address;
import Model.Criteria;
import Model.Fee;
import Model.Landlord;
import Model.Listing;
import Model.Manager;
import Model.Property;
import Model.Renter;
import Model.User;

public class MainController
{
	private UserFrame frame;
	private PRMSystem prms;
	private User theUser;
	private DefaultTableModel tableModel;
	
	public MainController(UserFrame theFrame)
	{
		frame = theFrame;
		
		frame.setSearchListener(new SearchListener());
		frame.setLoginListener(new LoginListener());
		frame.setSubscribeListener(new SubscribeListener());
		frame.setCheckSubscriptionListener(new CheckSubscriptionListener());
		frame.setManagePropertiesListener(new ManagePropertiesListener());
		frame.setPayFeesListener(new PayFeesListener());
		frame.setRegisterPropertyListener(new RegisterPropertyListener());
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
						
						tableModel = new DefaultTableModel();
						tableModel.addColumn("ID");
						tableModel.addColumn("# BEDROOMS");
						tableModel.addColumn("# BATHROOMS");
						tableModel.addColumn("STATE");
						tableModel.addColumn("FURNISHED");
						for(int i = 0; i < theListing.getProperties().size(); i++)
						{
							String[] propertyAttributes = new String[5];
							propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
							propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
							propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
							propertyAttributes[3] = theListing.getProperties().get(i).getState();
							propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
							tableModel.addRow(propertyAttributes);
						}
						
						frame.setTableModel(tableModel);
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
						((Renter)theUser).setUserCriteria(theCriteria);
						((Renter)theUser).setSubscribed(true);
						prms.toggleSubscription((Renter)theUser);
					}
				}
			});
			theDialog.setVisible(true);
		}
	}
	
	class CheckSubscriptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(((Renter)theUser).isSubscribed());
			{
				Listing theListing = ((Renter)theUser).filterList();
				
				tableModel = new DefaultTableModel();
				tableModel.addColumn("ID");
				tableModel.addColumn("# BEDROOMS");
				tableModel.addColumn("# BATHROOMS");
				tableModel.addColumn("STATE");
				tableModel.addColumn("FURNISHED");
				for(int i = 0; i < theListing.getProperties().size(); i++)
				{
					String[] propertyAttributes = new String[5];
					propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
					propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
					propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
					propertyAttributes[3] = theListing.getProperties().get(i).getState();
					propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
					tableModel.addRow(propertyAttributes);
				}
				
				frame.setTableModel(tableModel);
			}
		}
		
	}
	
	class ManagePropertiesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			tableModel = new DefaultTableModel();
			tableModel.addColumn("ID");
			tableModel.addColumn("# BEDROOMS");
			tableModel.addColumn("# BATHROOMS");
			tableModel.addColumn("STATE");
			tableModel.addColumn("FURNISHED");
			
			String[] propertyAttributes = new String[5];
			propertyAttributes[0] = "test";
			propertyAttributes[1] = "test";
			propertyAttributes[2] = "test";
			propertyAttributes[3] = "test";
			propertyAttributes[4] = "test";
			tableModel.addRow(propertyAttributes);
			frame.setTableModel(tableModel);
		}
		
	}
	
	class PayFeesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			String[] propertyAttributes = new String[5];
			propertyAttributes[0] = "test";
			propertyAttributes[1] = "test";
			propertyAttributes[2] = "test";
			propertyAttributes[3] = "test";
			propertyAttributes[4] = "test";
			tableModel.addRow(propertyAttributes);
			
		}
		
	}
	
	class RegisterPropertyListener implements ActionListener
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
						
						boolean furnished;
						
						if(theDialog.getFurnished().equals("Yes"))
						{
							furnished = true;
						}
						else
						{
							furnished = false;
						}
						
						Property theProperty = new Property(theAddress, (Landlord)theUser, 0, 
								theDialog.getState(), Integer.parseInt(theDialog.getNumBathrooms()), 
								Integer.parseInt(theDialog.getNumBedrooms()), theDialog.getPropertyType(), furnished, new Fee(100));
						
						prms.addProperty(theProperty);
					}
				}
			});
			theDialog.setVisible(true);
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
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			
			PeriodicalReportFrame theReportFrame = new PeriodicalReportFrame(prms.requestPeriodical());
			theReportFrame.setVisible(true);
		}
		
	}
	
	class ListUsersListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			
			ArrayList<User> theListing = ((Manager)theUser).getUserList();
			
			tableModel = new DefaultTableModel();
			tableModel.addColumn("FIRST NAME");
			tableModel.addColumn("LAST NAME");
			tableModel.addColumn("ID");
			tableModel.addColumn("TYPE");
			for(int i = 0; i < theListing.size(); i++)
			{
				String[] propertyAttributes = new String[5];
				propertyAttributes[0] = theListing.get(i).getFirstName();
				propertyAttributes[1] = theListing.get(i).getLastName();
				propertyAttributes[2] = String.valueOf(theListing.get(i).getId());
				propertyAttributes[3] = theListing.get(i).getType();
				tableModel.addRow(propertyAttributes);
			}
			
			frame.setTableModel(tableModel);
		}
		
	}
	
	class ListPropertiesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("test");
			
			Listing theListing = ((Manager)theUser).getPropertyLists();
			
			tableModel = new DefaultTableModel();
			tableModel.addColumn("ID");
			tableModel.addColumn("# BEDROOMS");
			tableModel.addColumn("# BATHROOMS");
			tableModel.addColumn("STATE");
			tableModel.addColumn("FURNISHED");
			for(int i = 0; i < theListing.getProperties().size(); i++)
			{
				String[] propertyAttributes = new String[5];
				propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
				propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
				propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
				propertyAttributes[3] = theListing.getProperties().get(i).getState();
				propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
				tableModel.addRow(propertyAttributes);
			}
			
			frame.setTableModel(tableModel);
		}
		
	}
}
