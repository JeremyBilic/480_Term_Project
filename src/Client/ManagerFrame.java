package Client;

public class ManagerFrame extends UserFrame
{	
	public ManagerFrame()
	{
		super();
		
		panel.remove(btnSearch);
		panel.remove(btnLogin);
		panel.remove(btnSubscribe);
		panel.remove(btnCheckSubscription);
		panel.remove(btnRegisterProperty);
		panel.remove(btnPayFees);
		panel.remove(btnDisplayOwned);
		panel.remove(btnEmail);
		panel.remove(btnLandlordManageProperty);
	}
	
}
