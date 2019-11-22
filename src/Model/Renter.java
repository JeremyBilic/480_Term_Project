package Model;

public class Renter extends User {
	
	private Listing newPropertyList;
	private boolean subscribed;
	
	public Renter(String firstName, String lastName, int id, boolean subscribed, Listing newPropertyList)
	{
		super(firstName, lastName, id);
		this.setSubscribed(subscribed);
		this.newPropertyList = newPropertyList;
	}
	
	public Renter(String firstName, String lastName, int id, boolean subscribed)
	{
		super(firstName, lastName, id);
		this.setSubscribed(subscribed);
		this.newPropertyList = new Listing();
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
}
