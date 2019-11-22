package Client;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JTable;

import Model.Address;
import Model.Criteria;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;


public class UserFrame extends JFrame
{
	protected JPanel panel;
	
	protected JButton btnSearch;
	
	protected JList list;
	
	public UserFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		btnSearch.addActionListener(new SearchButtonListener());
		
		list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
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
}

