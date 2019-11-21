package FrontEnd;
import javax.swing.JButton;

public class RegisteredRenterFrame extends UserFrame
{
	JButton btnSubscribe;
	
	JButton btnCheckSubscription;
	
	public RegisteredRenterFrame()
	{
		super();
		
		btnSubscribe = new JButton("Change Subscription");
		panel.add(btnSubscribe);
		
		btnCheckSubscription = new JButton("Check Subscription");
		panel.add(btnCheckSubscription);
		
	}
}
