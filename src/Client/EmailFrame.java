package Client;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

public class EmailFrame extends JFrame implements ActionListener
{
	protected JPanel northPanel;
	protected JPanel southPanel;
	
	protected JTextArea txtrTest;
	
	protected JButton btnSend;
	private JButton btnSendEmail;
	
	public EmailFrame()
	{
		this.setSize(500, 300);
		setTitle("Send Email");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);
		
		txtrTest = new JTextArea();
		getContentPane().add(txtrTest, BorderLayout.CENTER);
		
		southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(this);
		southPanel.add(btnSendEmail);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

}
