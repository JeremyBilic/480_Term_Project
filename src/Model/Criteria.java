package Model;

public class Criteria {

	private Address address;
	private String state;
	private String numberOfBathrooms;
	private String numberOfBedrooms;
	private String type;
	private String furnished;
	
	public Criteria(Address address, String state,
			String numberOfBathrooms, String numberOfBedrooms, String type, String furnished)
	{
		this.setAddress(address);
		this.setState(state);
		this.setNumberOfBathrooms(numberOfBathrooms);
		this.setNumberOfBedrooms(numberOfBedrooms);
		this.setType(type);
		this.setFurnished(furnished);
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(String numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public String getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(String numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFurnished() {
		return furnished;
	}

	public void setFurnished(String furnished) {
		this.furnished = furnished;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
}








