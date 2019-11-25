package Model;

import java.util.ArrayList;

public class Renter extends User {
	
	private Listing newPropertyList;
	private boolean subscribed;
	private int lastSeenID;
	private Criteria userCriteria;
	
	public Renter(String firstName, String lastName, int id, boolean subscribed, int lastSeenID, Criteria userCriteria, Listing newPropertyList)
	{
		super(firstName, lastName, id);
		this.userCriteria = userCriteria;
		this.setSubscribed(subscribed);
		this.newPropertyList = newPropertyList;
		this.setLastSeenID(lastSeenID);
		this.type = "renter";
	}
	
	public Renter(String firstName, String lastName, int id, boolean subscribed, int lastSeenID, Criteria userCriteria)
	{
		super(firstName, lastName, id);
		this.userCriteria = userCriteria;
		this.setSubscribed(subscribed);
		this.setLastSeenID(lastSeenID);
		this.newPropertyList = new Listing();
		this.type = "renter";
	}

	public Listing getNewPropertyList() {
		return newPropertyList;
	}

	public void setNewPropertyList(Listing newPropertyList) {
		this.newPropertyList = newPropertyList;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public int getLastSeenID() {
		return lastSeenID;
	}

	public void setLastSeenID(int lastSeenID) {
		this.lastSeenID = lastSeenID;
	}
	
	public Listing filterList()
	{
		Listing filteredList = new Listing(new ArrayList<Property>());
		for (Property p : newPropertyList.getProperties())
		{
			if(userCriteria.fitsInCriteria(p))
			{
				filteredList.addProperty(p);
			}
		}
		return filteredList;
	}

	public Criteria getUserCriteria() {
		return userCriteria;
	}

	public void setUserCriteria(Criteria userCriteria) {
		this.userCriteria = userCriteria;
	}
	
}
