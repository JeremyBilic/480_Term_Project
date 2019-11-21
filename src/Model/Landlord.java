package Model;

public class Landlord extends User {
	
	private Listing ownedPropertyList;
	private String email;
	
	public Landlord(String firstName, String lastName, String email) {
		super(firstName, lastName);
		setEmail(email);
		setOwnedPropertyList(new Listing());
	}
	public Landlord(String firstName, String lastName, String email, Listing ownedPropertyList) {
		super(firstName, lastName);
		setEmail(email);
		setOwnedPropertyList(ownedPropertyList);
	}

	public Listing getOwnedPropertyList() {
		return ownedPropertyList;
	}

	public void setOwnedPropertyList(Listing ownedPropertyList) {
		this.ownedPropertyList = ownedPropertyList;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
