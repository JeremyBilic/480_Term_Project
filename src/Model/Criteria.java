package Model;

import java.util.ArrayList;

public class Criteria {

	private Address address;
	private String state;
	private String numberOfBathrooms;
	private String numberOfBedrooms;
	private String type;
	private String furnished;
	
	public Criteria(Address address, String state,
			String numberOfBathrooms, String numberOfBedrooms, 
			String type, String furnished)
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
	
	public boolean fitsInCriteria(Property p)
	{
		boolean fitsCriteria = true;
		if(!(this.getAddress().getStreet().equals(p.getAddress().getStreet()) && !this.getAddress().getStreet().isEmpty()))
		{
			fitsCriteria = false;
		}
		else if(!(this.getAddress().getCity().equals(p.getAddress().getStreet()) && !this.getAddress().getCity().isEmpty()))
		{
			fitsCriteria = false;
		}
		else if(!(this.getAddress().getQuadrant().equals(p.getAddress().getStreet()) && !this.getAddress().getQuadrant().isEmpty()))
		{
			fitsCriteria = false;
		}
		else if(!(this.getAddress().getCountry().equals(p.getAddress().getCountry())) && !this.getAddress().getCountry().isEmpty())
		{
			fitsCriteria = false;
		}
		else if(!(this.getAddress().getProvince().equals(p.getAddress().getProvince())) && !this.getAddress().getProvince().isEmpty())
		{
			fitsCriteria = false;
		}
		else if(!this.getFurnished().isEmpty())
		{
			if(this.getFurnished().equals("true") && !p.isFurnished())
			{
				fitsCriteria = false;
			}
			if(this.getFurnished().equals("false") && p.isFurnished())
			{
				fitsCriteria = false;
			}
		}
		else if((Integer.parseInt(this.getNumberOfBathrooms()) != p.getNumberOfBathrooms()) && !this.getNumberOfBathrooms().isEmpty())
		{
			fitsCriteria = false;
		}
		else if((Integer.parseInt(this.getNumberOfBedrooms()) != p.getNumberOfBedrooms()) && !this.getNumberOfBedrooms().isEmpty())
		{
			fitsCriteria = false;
		}
		else if((this.getType()).equals(p.getType()) && !this.getType().isEmpty())
		{
			fitsCriteria = false;
		}
		else if((this.getState().equals(p.getState()) && !this.getState().isEmpty()))
		{
			fitsCriteria = false;
		}
		return fitsCriteria;
		
	}
	
}








