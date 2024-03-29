package Client;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;


public class UserFrame extends JFrame
{
	protected JPanel panel;
	
	protected JButton btnSearch;
	protected JButton btnLogin;
	protected JButton btnSubscribe;
	protected JButton btnCheckSubscription;
	protected JButton btnManagerManageProperty;
	protected JButton btnLandlordManageProperty;
	protected JButton btnPayFees;
	protected JButton btnRegisterProperty;
	protected JButton btnDisplayOwned;
	protected JButton btnManageFees;
	protected JButton btnPeriodicalReport;
	protected JButton btnListUsers;
	protected JButton btnListProperties;
	protected JButton btnEmail;
	
	protected JTable table;
	
	public UserFrame() {
		this.setSize(700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		btnEmail = new JButton("Send Email");
		panel.add(btnEmail);
		
		btnLogin = new JButton("Login");
		panel.add(btnLogin);
		
		btnSubscribe = new JButton("Change Subscription");
		panel.add(btnSubscribe);
		
		btnCheckSubscription = new JButton("Check Subscription");
		panel.add(btnCheckSubscription);
		
		btnManagerManageProperty = new JButton("Manage Property");
		panel.add(btnManagerManageProperty);
		
		btnLandlordManageProperty = new JButton("Manage Property");
		panel.add(btnLandlordManageProperty);
		
		btnRegisterProperty = new JButton("Register Property");
		panel.add(btnRegisterProperty);
		
		btnPayFees = new JButton("Pay Fees");
		panel.add(btnPayFees);
		
		btnDisplayOwned = new JButton("Display Owned Properties");
		panel.add(btnDisplayOwned);
		
		btnManageFees = new JButton("Manage Fees");
		panel.add(btnManageFees);
		
		btnPeriodicalReport = new JButton("Periodical Report");
		panel.add(btnPeriodicalReport);
		
		btnListUsers = new JButton("List Users");
		panel.add(btnListUsers);
		
		btnListProperties = new JButton("List Properties");
		panel.add(btnListProperties);
	}
	
	public void setSearchListener(ActionListener listener)
	{
		btnSearch.addActionListener(listener);
	}
	
	public void setLoginListener(ActionListener listener)
	{
		btnLogin.addActionListener(listener);
	}
	
	public void setSubscribeListener(ActionListener listener)
	{
		btnSubscribe.addActionListener(listener);
	}
	
	public void setCheckSubscriptionListener(ActionListener listener)
	{
		btnCheckSubscription.addActionListener(listener);
	}
	
	public void setManagerManagePropertyListener(ActionListener listener)
	{
		btnManagerManageProperty.addActionListener(listener);
	}
	
	public void setLandlordManagePropertyListener(ActionListener listener)
	{
		btnLandlordManageProperty.addActionListener(listener);
	}
	
	public void setPayFeesListener(ActionListener listener)
	{
		btnPayFees.addActionListener(listener);
	}
	
	public void setRegisterPropertyListener(ActionListener listener)
	{
		btnRegisterProperty.addActionListener(listener);
	}
	
	public void setManageFeesListener(ActionListener listener)
	{
		btnManageFees.addActionListener(listener);
	}
	
	public void setPeriodicalReportListener(ActionListener listener)
	{
		btnPeriodicalReport.addActionListener(listener);
	}
	
	public void setListUsersListener(ActionListener listener)
	{
		btnListUsers.addActionListener(listener);
	}
	
	public void setListPropertiesListener(ActionListener listener)
	{
		btnListProperties.addActionListener(listener);
	}
	
	public void setDisplayOwnedListener(ActionListener listener)
	{
		btnDisplayOwned.addActionListener(listener);
	}
	
	public void setEmailListener(ActionListener listener)
	{
		btnEmail.addActionListener(listener);
	}
	
	public void setTableModel(DefaultTableModel tableModel)
	{
		table.setModel(tableModel);
	}
	
	public JTable getTable()
	{
		return table;
	}
	
}

