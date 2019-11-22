package Client;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;

import Model.Address;
import Model.Criteria;

public class RenterFrame extends UserFrame
{
	private JButton btnLogin;
	
	public RenterFrame()
	{
		super();
		
		btnSearch.addActionListener(new SearchButtonListener());
		
		btnLogin = new JButton("Login");
		panel.add(btnLogin);
	}
	
	class SearchButtonListener implements ActionListener
	{
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
					}
				}
			});
			theDialog.setVisible(true);
		}
	}
	
	
	
	class DoubleClickListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			{
				JTable t = (JTable) e.getSource();
				Point point = e.getPoint();
				int row = t.rowAtPoint(point);
				if(e.getClickCount() == 2 && t.getSelectedRow() != -1)
				{
					
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
}
