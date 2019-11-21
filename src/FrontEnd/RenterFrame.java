package FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class RenterFrame extends UserFrame
{
	private JButton btnLogin;
	
	public RenterFrame()
	{
		super();
		
		btnSearch.addActionListener(new SearchButtonListener());
		
		btnLogin = new JButton("Login");
		panel.add(btnLogin);
	}
	
	class SearchButtonListener implements ActionListener
	{
		
		
		/*public void actionPerformed(ActionEvent e)
		{
			RenterPropertyFrame propertyFrame = new RenterPropertyFrame();
			propertyFrame.setVisible(true);
		}*/
	}
	
	class DoubleClickListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
}
