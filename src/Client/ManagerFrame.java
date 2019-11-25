package Client;

public class ManagerFrame extends UserFrame
{	
	public ManagerFrame()
	{
		super();
		
		panel.remove(btnLogin);
		panel.remove(btnSubscribe);
		panel.remove(btnCheckSubscription);
		panel.remove(btnManageProperties);
		panel.remove(btnPayFees);
	}
	
}
