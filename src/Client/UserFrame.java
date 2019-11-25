package Client;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DatabaseHandler.SearchCriteriaRequest;
import DatabaseHandler.SearchCriteriaResponse;
import Model.Address;
import Model.Criteria;
import Model.Property;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;


public class UserFrame extends JFrame
{
	protected JPanel panel;
	protected JPanel panelCenter;
	
	protected JButton btnSearch;
	protected JButton btnLogin;
	protected JButton btnSubscribe;
	protected JButton btnCheckSubscription;
	protected JButton btnManageProperties;
	protected JButton btnPayFees;
	protected JButton btnManageFees;
	protected JButton btnPeriodicalReport;
	protected JButton btnListUsers;
	protected JButton btnListProperties;
	
	protected JTable table;
	
	protected DefaultListModel listModel;
	
	public UserFrame() {
		this.setSize(700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		btnLogin = new JButton("Login");
		panel.add(btnLogin);
		
		btnSubscribe = new JButton("Change Subscription");
		panel.add(btnSubscribe);
		
		btnCheckSubscription = new JButton("Check Subscription");
		panel.add(btnCheckSubscription);
		
		btnManageProperties = new JButton("Manage Properties");
		panel.add(btnManageProperties);
		
		btnPayFees = new JButton("Pay Fees");
		panel.add(btnPayFees);
		
		btnManageFees = new JButton("Manage Fees");
		panel.add(btnManageFees);
		
		btnPeriodicalReport = new JButton("Periodical Report");
		panel.add(btnPeriodicalReport);
		
		btnListUsers = new JButton("List Users");
		panel.add(btnListUsers);
		
		btnListProperties = new JButton("List Properties");
		panel.add(btnListProperties);
		/*
		listModel = new DefaultListModel();
		list = new JList(listModel);
		getContentPane().add(list, BorderLayout.CENTER);
		*/
		//list = new JList();
		//getContentPane().add(list, BorderLayout.CENTER);
		
		/*JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);*/
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
	
	public void setManagePropertiesListener(ActionListener listener)
	{
		btnManageProperties.addActionListener(listener);
	}
	
	public void setPayFeesListener(ActionListener listener)
	{
		btnPayFees.addActionListener(listener);
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
	
	public void setTableModel(DefaultTableModel tableModel)
	{
		table.setModel(tableModel);
	}
	
}

