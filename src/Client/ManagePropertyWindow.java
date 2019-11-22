package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagePropertyWindow extends JDialog implements ActionListener
{
	private JTextField state;
	private JTextField numBathrooms;
	private JTextField numBedrooms;
	private JTextField type;
	private JTextField city;
	private JTextField country;
	private JTextField province;
	private JTextField quadrant;
	private JTextField street;
	private JComboBox furnished;
	private JButton btnEnter;
	private JButton btnCancel;
	
	public ManagePropertyWindow() {
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("OK");
		panel.add(btnEnter);
		btnEnter.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Property is furnished?");
		lblNewLabel.setBounds(6, 162, 175, 16);
		panel_2.add(lblNewLabel);
		
		state = new JTextField();
		state.setBounds(193, 5, 182, 26);
		panel_2.add(state);
		state.setColumns(10);
		
		numBathrooms = new JTextField();
		numBathrooms.setBounds(193, 43, 182, 26);
		panel_2.add(numBathrooms);
		numBathrooms.setColumns(10);
		
		numBedrooms = new JTextField();
		numBedrooms.setBounds(193, 81, 182, 26);
		panel_2.add(numBedrooms);
		numBedrooms.setColumns(10);
		
		type = new JTextField();
		type.setBounds(193, 119, 182, 26);
		panel_2.add(type);
		type.setColumns(10);
		
		city = new JTextField();
		city.setBounds(193, 270, 175, 26);
		panel_2.add(city);
		city.setColumns(10);
		
		country = new JTextField();
		country.setBounds(193, 195, 175, 26);
		panel_2.add(country);
		country.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the property state:");
		lblNewLabel_1.setBounds(6, 10, 175, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter no. of bathrooms:");
		lblNewLabel_2.setBounds(6, 48, 175, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter no. of bedrooms:");
		lblNewLabel_3.setBounds(6, 86, 175, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblEnterTheProperty = new JLabel("Enter the property type:");
		lblEnterTheProperty.setBounds(6, 124, 168, 16);
		panel_2.add(lblEnterTheProperty);
		
		String[] furnishedChoices = {"Any", "Yes", "No"};
		
		furnished = new JComboBox(furnishedChoices);
		furnished.setBounds(193, 158, 182, 27);
		panel_2.add(furnished);
		
		province = new JTextField();
		province.setBounds(193, 233, 175, 26);
		panel_2.add(province);
		province.setColumns(10);
		
		JLabel lblEnterCountry = new JLabel("Enter country:");
		lblEnterCountry.setBounds(6, 200, 168, 16);
		panel_2.add(lblEnterCountry);
		
		JLabel lblEnterProvince = new JLabel("Enter province:");
		lblEnterProvince.setBounds(6, 238, 175, 16);
		panel_2.add(lblEnterProvince);
		
		JLabel lblEnterCity = new JLabel("Enter city:");
		lblEnterCity.setBounds(6, 275, 175, 16);
		panel_2.add(lblEnterCity);
		
		JLabel lblEnterQuadrant = new JLabel("Enter quadrant:");
		lblEnterQuadrant.setBounds(6, 313, 175, 16);
		panel_2.add(lblEnterQuadrant);
		
		quadrant = new JTextField();
		quadrant.setBounds(193, 308, 175, 26);
		panel_2.add(quadrant);
		quadrant.setColumns(10);
		
		street = new JTextField();
		street.setBounds(193, 346, 175, 26);
		panel_2.add(street);
		street.setColumns(10);
		
		JLabel lblEnterStreet = new JLabel("Enter street:");
		lblEnterStreet.setBounds(6, 351, 168, 16);
		panel_2.add(lblEnterStreet);
		
	}
	
	public String getState()
	{
		return state.getText();
	}
	
	public String getNumBathrooms()
	{
		return numBathrooms.getText();
	}
	
	public String getNumBedrooms()
	{
		return numBedrooms.getText();
	}
	
	public String getPropertyType()
	{
		return type.getText();
	}
	
	public String getFurnished()
	{
		return (String) furnished.getSelectedItem();
	}
	
	public String getCountry()
	{
		return country.getText();
	}
	
	public String getProvince()
	{
		return province.getText();
	}
	
	public String getQuadrant()
	{
		return quadrant.getText();
	}
	
	public String getCity()
	{
		return city.getText();
	}
	
	public String getStreet()
	{
		return street.getText();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.dispose();
	}
	
	public void setFrameListener(ActionListener frameListener)
	{
		btnEnter.addActionListener(frameListener);
		btnCancel.addActionListener(frameListener);
	}
}
