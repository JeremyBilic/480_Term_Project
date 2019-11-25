package Client;
import javax.swing.JButton;

public class RegisteredRenterFrame extends UserFrame
{
	JButton btnSubscribe;
	
	JButton btnCheckSubscription;
	
	public RegisteredRenterFrame()
	{
		super();
		
		panel.remove(btnLogin);
		panel.remove(btnManageProperties);
		panel.remove(btnPayFees);
		panel.remove(btnManageFees);
		panel.remove(btnPeriodicalReport);
		panel.remove(btnListUsers);
		panel.remove(btnListProperties);
	}
}
