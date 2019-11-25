package Client;

public class LandlordFrame extends UserFrame
{
	public LandlordFrame()
	{
		super();
		
		panel.remove(btnSearch);
		panel.remove(btnLogin);
		panel.remove(btnSubscribe);
		panel.remove(btnCheckSubscription);
		panel.remove(btnManageFees);
		panel.remove(btnPeriodicalReport);
		panel.remove(btnListUsers);
		panel.remove(btnListProperties);
		panel.remove(btnEmail);
		
	}
}
