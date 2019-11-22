package Client;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.BorderLayout;

public class ManagerFrame extends UserFrame
{
	public ManagerFrame()
	{
		super();
		
		JButton btnManageFees = new JButton("Manage Fees");
		panel.add(btnManageFees);
		
		JButton btnPeriodicalReport = new JButton("Periodical Report");
		panel.add(btnPeriodicalReport);
		
		JButton btnListUsers = new JButton("List Users");
		panel.add(btnListUsers);
		
		JButton btnListProperties = new JButton("List Properties");
		panel.add(btnListProperties);
		
		
	}
}
