package FrontEnd;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class PropertyInputBox extends JDialog implements ActionListener
{
	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textID;
	private JTextField textQuantity;
	private JTextField textPrice;
	private JTextField textSupplierID;
	private JButton okButton;
	private JButton cancelButton;
	
	public PropertyInputBox() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
	}

}
