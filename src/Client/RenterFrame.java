package Client;

public class RenterFrame extends UserFrame
{
	public RenterFrame()
	{
		super();
		
		panel.remove(btnSubscribe);
		panel.remove(btnCheckSubscription);
		panel.remove(btnManagerManageProperty);
		panel.remove(btnLandlordManageProperty);
		panel.remove(btnPayFees);
		panel.remove(btnRegisterProperty);
		panel.remove(btnManageFees);
		panel.remove(btnPeriodicalReport);
		panel.remove(btnListUsers);
		panel.remove(btnListProperties);
		panel.remove(btnDisplayOwned);
	}
}
