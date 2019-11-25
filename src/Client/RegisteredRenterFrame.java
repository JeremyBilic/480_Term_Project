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
		panel.remove(btnManageProperty);
		panel.remove(btnPayFees);
		panel.remove(btnRegisterProperty);
		panel.remove(btnManageFees);
		panel.remove(btnPeriodicalReport);
		panel.remove(btnListUsers);
		panel.remove(btnListProperties);
		panel.remove(btnDisplayOwned);
	}
}
