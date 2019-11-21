package FrontEnd;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PropertyFrame extends JFrame
{
	protected JPanel panel;
	
	protected JTextArea txtrTest;
	
	public PropertyFrame() {
		setTitle("View Property Details");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		txtrTest = new JTextArea();
		getContentPane().add(txtrTest, BorderLayout.CENTER);
	}

}
