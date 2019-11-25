package Model;

public class Renter extends User {
	
	private Listing newPropertyList;
	private boolean subscribed;
	private int lastSeenID;
	
	public Renter(String firstName, String lastName, int id, boolean subscribed, int lastSeenID, Listing newPropertyList)
	{
		super(firstName, lastName, id);
		this.setSubscribed(subscribed);
		this.newPropertyList = newPropertyList;
		this.setLastSeenID(lastSeenID);
		this.type = "renter";
	}
	
	public Renter(String firstName, String lastName, int id, boolean subscribed, int lastSeenID)
	{
		super(firstName, lastName, id);
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
}
