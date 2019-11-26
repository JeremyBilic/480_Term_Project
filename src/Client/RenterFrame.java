package Client;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

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
