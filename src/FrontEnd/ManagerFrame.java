package FrontEnd;
import javax.swing.JButton;

public class ManagerFrame extends UserFrame
{
	public ManagerFrame()
	{
		super();
		
		JButton btnManageFees = new JButton("Manage Fees");
		panel.add(btnManageFees);
		
		JButton btnPeriodicalReport = new JButton("Periodical Report");
		panel.add(btnPeriodicalReport);
		
		
	}
}
