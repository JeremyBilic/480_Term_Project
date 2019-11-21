package FrontEnd;
import javax.swing.JButton;

public class RenterPropertyFrame extends PropertyFrame
{
	public RenterPropertyFrame()
	{
		super();
		
		JButton btnEmailLandlord = new JButton("Email Landlord");
		panel.add(btnEmailLandlord);
	}
}
