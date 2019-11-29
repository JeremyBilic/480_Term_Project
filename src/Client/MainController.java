package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		setListeners();
	}
	
	public void setSystem(PRMSystem prms) {
		this.prms = prms;
	}
	
	class SearchListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
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
						tableModel.addColumn("STREET");
						tableModel.addColumn("QUADRANT");
						tableModel.addColumn("CITY");
						tableModel.addColumn("PROVINCE");
						tableModel.addColumn("COUNTRY");
						tableModel.addColumn("TYPE");
						
						for(int i = 0; i < theListing.getProperties().size(); i++)
						{
							String[] propertyAttributes = new String[11];
							propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
							propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
							propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
							propertyAttributes[3] = theListing.getProperties().get(i).getState();
							propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
							propertyAttributes[5] = theListing.getProperties().get(i).getAddress().getStreet();
							propertyAttributes[6] = theListing.getProperties().get(i).getAddress().getQuadrant();
							propertyAttributes[7] = theListing.getProperties().get(i).getAddress().getCity();
							propertyAttributes[8] = theListing.getProperties().get(i).getAddress().getProvince();
							propertyAttributes[9] = theListing.getProperties().get(i).getAddress().getCountry();
							propertyAttributes[10] = theListing.getProperties().get(i).getType();
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
								prms.getRenterProfile((Renter)theUser);
								frame = new RegisteredRenterFrame();
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}
							else if(theUser.getType().equals("landlord"))
							{
								prms.getLandlordProfile((Landlord)theUser);
								frame = new LandlordFrame();
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}
							else
							{
								prms.getManagerProfile((Manager)theUser);
								frame = new ManagerFrame();
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}
							
							setListeners();
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
			if(!((Renter)theUser).isSubscribed()){

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
								
								String state;
								
								if(theDialog.getState().isEmpty()) {
									state = theDialog.getState();
								} else {
									state = "active";
								}
								
								Criteria theCriteria = new Criteria(theAddress, state, theDialog.getNumBathrooms(), 
										theDialog.getNumBedrooms(), theDialog.getPropertyType(), furnished);
								((Renter)theUser).setUserCriteria(theCriteria);
								prms.toggleSubscription((Renter)theUser);
								prms.getRenterProfile((Renter)theUser);

							}
	
						}
					});
				
				theDialog.setVisible(true);
			} else {
			prms.toggleSubscription((Renter)theUser);
			prms.getRenterProfile((Renter)theUser);
			}
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
				tableModel.addColumn("STREET");
				tableModel.addColumn("QUADRANT");
				tableModel.addColumn("CITY");
				tableModel.addColumn("PROVINCE");
				tableModel.addColumn("COUNTRY");
				tableModel.addColumn("TYPE");
				
				for(int i = 0; i < theListing.getProperties().size(); i++)
				{
					String[] propertyAttributes = new String[11];
					propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
					propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
					propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
					propertyAttributes[3] = theListing.getProperties().get(i).getState();
					propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
					propertyAttributes[5] = theListing.getProperties().get(i).getAddress().getStreet();
					propertyAttributes[6] = theListing.getProperties().get(i).getAddress().getQuadrant();
					propertyAttributes[7] = theListing.getProperties().get(i).getAddress().getCity();
					propertyAttributes[8] = theListing.getProperties().get(i).getAddress().getProvince();
					propertyAttributes[9] = theListing.getProperties().get(i).getAddress().getCountry();
					propertyAttributes[10] = theListing.getProperties().get(i).getType();
					tableModel.addRow(propertyAttributes);
				}
				
				frame.setTableModel(tableModel);
			}
		}
		
	}
	
	class ManagerManagePropertyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(frame.getTable().getSelectedRow() != -1)
			{
				Listing theListing = ((Manager)theUser).getPropertyLists();
				String state = JOptionPane.showInputDialog("Enter the new state:");
				theListing.getProperties().get(frame.getTable().getSelectedRow()).setState(state);
				prms.updateProperty(theListing.getProperties().get(frame.getTable().getSelectedRow()));
				prms.getManagerProfile((Manager)theUser);
			}
		}
		
	}
	
	class LandlordManagePropertyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(frame.getTable().getSelectedRow() != -1)
			{
				Listing theListing = ((Landlord)theUser).getOwnedPropertyList();
				String state = JOptionPane.showInputDialog("Enter the new state:");
				theListing.getProperties().get(frame.getTable().getSelectedRow()).setState(state);
				prms.updateProperty(theListing.getProperties().get(frame.getTable().getSelectedRow()));
				prms.getLandlordProfile((Landlord)theUser);
			}
		}
	}
	
	class PayFeesListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{		
		}
		
	}
	
	class RegisterPropertyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
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
						prms.getLandlordProfile((Landlord)theUser);
					}
				}
			});
			theDialog.setVisible(true);
		}
	}
	
	class ManageFeesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(frame.getTable().getSelectedRow() != -1)
			{
				Listing theListing = ((Manager)theUser).getPropertyLists();
				int fee = Integer.parseInt(JOptionPane.showInputDialog("Enter the new fee:"));
				prms.changeFee(new Fee(fee), theListing.getProperties().get(frame.getTable().getSelectedRow()));
				prms.getManagerProfile((Manager)theUser);
			}
		}
	}
	
	class PeriodicalReportListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			PeriodicalReportFrame theReportFrame = new PeriodicalReportFrame(prms.requestPeriodical());
			theReportFrame.setVisible(true);
		}
		
	}
	
	class ListUsersListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ArrayList<User> theListing = ((Manager)theUser).getUserList();
			
			tableModel = new DefaultTableModel();
			tableModel.addColumn("FIRST NAME");
			tableModel.addColumn("LAST NAME");
			tableModel.addColumn("ID");
			tableModel.addColumn("TYPE");
			for(int i = 0; i < theListing.size(); i++)
			{
				String[] propertyAttributes = new String[4];
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
			Listing theListing = ((Manager)theUser).getPropertyLists();
			
			tableModel = new DefaultTableModel();
			tableModel.addColumn("ID");
			tableModel.addColumn("# BEDROOMS");
			tableModel.addColumn("# BATHROOMS");
			tableModel.addColumn("STATE");
			tableModel.addColumn("FURNISHED");
			tableModel.addColumn("STREET");
			tableModel.addColumn("QUADRANT");
			tableModel.addColumn("CITY");
			tableModel.addColumn("PROVINCE");
			tableModel.addColumn("COUNTRY");
			tableModel.addColumn("FEE");
			tableModel.addColumn("TYPE");
			
			for(int i = 0; i < theListing.getProperties().size(); i++)
			{
				String[] propertyAttributes = new String[12];
				propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
				propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
				propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
				propertyAttributes[3] = theListing.getProperties().get(i).getState();
				propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
				propertyAttributes[5] = theListing.getProperties().get(i).getAddress().getStreet();
				propertyAttributes[6] = theListing.getProperties().get(i).getAddress().getQuadrant();
				propertyAttributes[7] = theListing.getProperties().get(i).getAddress().getCity();
				propertyAttributes[8] = theListing.getProperties().get(i).getAddress().getProvince();
				propertyAttributes[9] = theListing.getProperties().get(i).getAddress().getCountry();
				propertyAttributes[10] = String.valueOf(theListing.getProperties().get(i).getFee().getAmount());
				propertyAttributes[11] = theListing.getProperties().get(i).getType();
				tableModel.addRow(propertyAttributes);
			}
			
			frame.setTableModel(tableModel);
		}
	}
	
	class DisplayOwnedListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Listing theListing = ((Landlord)theUser).getOwnedPropertyList();
			
			tableModel = new DefaultTableModel();
			tableModel.addColumn("ID");
			tableModel.addColumn("# BEDROOMS");
			tableModel.addColumn("# BATHROOMS");
			tableModel.addColumn("STATE");
			tableModel.addColumn("FURNISHED");
			tableModel.addColumn("STREET");
			tableModel.addColumn("QUADRANT");
			tableModel.addColumn("CITY");
			tableModel.addColumn("PROVINCE");
			tableModel.addColumn("COUNTRY");
			tableModel.addColumn("FEE");
			tableModel.addColumn("TYPE");
			for(int i = 0; i < theListing.getProperties().size(); i++)
			{
				String[] propertyAttributes = new String[12];
				propertyAttributes[0] = String.valueOf(theListing.getProperties().get(i).getId());
				propertyAttributes[1] = String.valueOf(theListing.getProperties().get(i).getNumberOfBedrooms());
				propertyAttributes[2] = String.valueOf(theListing.getProperties().get(i).getNumberOfBathrooms());
				propertyAttributes[3] = theListing.getProperties().get(i).getState();
				propertyAttributes[4] = String.valueOf(theListing.getProperties().get(i).isFurnished());
				propertyAttributes[5] = theListing.getProperties().get(i).getAddress().getStreet();
				propertyAttributes[6] = theListing.getProperties().get(i).getAddress().getQuadrant();
				propertyAttributes[7] = theListing.getProperties().get(i).getAddress().getCity();
				propertyAttributes[8] = theListing.getProperties().get(i).getAddress().getProvince();
				propertyAttributes[9] = theListing.getProperties().get(i).getAddress().getCountry();
				propertyAttributes[10] = String.valueOf(theListing.getProperties().get(i).getFee().getAmount());
				propertyAttributes[11] = theListing.getProperties().get(i).getType();
				tableModel.addRow(propertyAttributes);
			}
			frame.setTableModel(tableModel);
		}
	}
	
	class EmailListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(frame.getTable().getSelectedRow() != -1)
			{
				EmailFrame theDialog = new EmailFrame();
				theDialog.setVisible(true);
			}
		}
	}
	
	public void setListeners()
	{
		frame.setSearchListener(new SearchListener());
		frame.setLoginListener(new LoginListener());
		frame.setSubscribeListener(new SubscribeListener());
		frame.setCheckSubscriptionListener(new CheckSubscriptionListener());
		frame.setManagerManagePropertyListener(new ManagerManagePropertyListener());
		frame.setLandlordManagePropertyListener(new LandlordManagePropertyListener());
		frame.setPayFeesListener(new PayFeesListener());
		frame.setRegisterPropertyListener(new RegisterPropertyListener());
		frame.setDisplayOwnedListener(new DisplayOwnedListener());
		frame.setManageFeesListener(new ManageFeesListener());
		frame.setPeriodicalReportListener(new PeriodicalReportListener());
		frame.setListUsersListener(new ListUsersListener());
		frame.setListPropertiesListener(new ListPropertiesListener());
		frame.setEmailListener(new EmailListener());
	}
}
