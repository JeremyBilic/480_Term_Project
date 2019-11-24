package Model;

public class Property {

	private Address address;
	private Landlord owner;
	private int id;
	private String state;
	private int numberOfBathrooms;
	private int numberOfBedrooms;
	private String type;
	private boolean furnished;
	private Fee fee;
	
	public Property(Address address, Landlord owner, int id, String state,
			int numberOfBathrooms, int numberOfBedrooms, String type, boolean furnished, Fee fee)
	{
		this.setAddress(address);
		this.setOwner(owner);
		this.setId(id);
		this.setState(state);
		this.setNumberOfBathrooms(numberOfBathrooms);
		this.setNumberOfBedrooms(numberOfBedrooms);
		this.setType(type);
		this.setFurnished(furnished);
		this.setFee(fee);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Landlord getOwner() {
		return owner;
	}

	public void setOwner(Landlord owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}
			
	
}
