package Client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Periodical;
import Model.Property;

public class PeriodicalReportFrame extends JFrame
{
protected JTextArea txtr;
	
	public PeriodicalReportFrame(Periodical report)
	{
		this.setSize(400, 300);
		setTitle("Periodical Report");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		txtr = new JTextArea();
		txtr.setEditable(false);
		txtr.append("Number of houses listed: " + String.valueOf(report.getNumHousesListed()) + "\n");
		txtr.append("Number of houses rented: " + String.valueOf(report.getNumHousesRented()) + "\n");
		txtr.append("Total number of active listing: " + String.valueOf(report.getNumActiveListing()) + "\n\n");
		
		for(int i = 0; i < report.getHousesRented().size(); i++)
		{
			Property p = report.getHousesRented().get(i);
			txtr.append("Landlord name: " + p.getOwner().getFirstName() + " " + p.getOwner().getLastName() + "\n");
			txtr.append("Houses ID number: " + p.getId() + "\n");
			txtr.append("Address: " + p.getAddress().getStreet() + ", " + p.getAddress().getQuadrant() + " " + 
			p.getAddress().getCity() + ", " + p.getAddress().getProvince() + ", " + p.getAddress().getCountry() + "\n\n");
		}
		
		
		getContentPane().add(txtr, BorderLayout.CENTER);
	}
}
