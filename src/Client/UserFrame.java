package Client;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;


public class UserFrame extends JFrame
{
	protected JPanel panel;
	
	protected JButton btnSearch;
	
	protected JList list;
	
	public UserFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
	}
	
	class DoubleClickListener implements MouseListener
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
		
	}
	
}

