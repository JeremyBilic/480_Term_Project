package Model;

import java.util.ArrayList;

public class Manager extends User{

	private ArrayList<User> userList;
	private Listing propertyLists;
	
	public Manager(String firstName, String lastName, ArrayList<User> userList, Listing propertyLists)
	{
		super(firstName, lastName);
		this.setUserList(userList);
		this.setPropertyLists(propertyLists);
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public Listing getPropertyLists() {
		return propertyLists;
	}

	public void setPropertyLists(Listing propertyLists) {
		this.propertyLists = propertyLists;
	}
	
}
