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
	
	/*class DoubleClickListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			{
				JTable t = (JTable) e.getSource();
				Point point = e.getPoint();
				int row = t.rowAtPoint(point);
				if(e.getClickCount() == 2 && t.getSelectedRow() != -1)
				{
					
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}*/
	
}
