package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginBox extends JDialog implements ActionListener
{
	private JTextField username;
	private JTextField password;
	private JButton btnEnter;
	private JButton btnCancel;
	
	public LoginBox() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLogIn = new JLabel("Log In");
		panel.add(lblLogIn);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("OK");
		panel.add(btnEnter);
		btnEnter.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setActionCommand("CANCEL");
		panel.add(btnCancel);
		btnCancel.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		username = new JTextField();
		username.setBounds(208, 17, 130, 26);
		panel_2.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(208, 55, 130, 26);
		panel_2.add(password);
		password.setColumns(10);
		
		JLabel lblEnterUsername = new JLabel("Enter username:");
		lblEnterUsername.setBounds(6, 22, 190, 16);
		panel_2.add(lblEnterUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter password:");
		lblEnterPassword.setBounds(6, 60, 190, 16);
		panel_2.add(lblEnterPassword);
	}
	
	public String getUsername()
	{
		return username.getText();
	}
	
	public String getPassword()
	{
		return password.getText();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.dispose();
	}
	
	public void setFrameListener(ActionListener frameListener)
	{
		btnEnter.addActionListener(frameListener);
		btnCancel.addActionListener(frameListener);
	}
	
}
