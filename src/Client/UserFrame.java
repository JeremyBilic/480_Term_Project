package Client;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	
}

