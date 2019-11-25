package Model;

import java.util.ArrayList;

public class Periodical {

	private int numHousesListed;
	private int numHousesRented;
	private int numActiveListing;
	ArrayList<Property> housesRented;
	
	public Periodical(int numHousesListed, int numHousesRented, int numActiveListing,
			ArrayList<Property> housesRented)
	{
		this.setNumHousesListed(numHousesListed);
		this.setNumHousesRented(numHousesRented);
		this.setNumActiveListing(numActiveListing);
		this.housesRented = housesRented;
	}

	public int getNumHousesListed() {
		return numHousesListed;
	}

	public void setNumHousesListed(int numHousesListed) {
		this.numHousesListed = numHousesListed;
	}

	public int getNumHousesRented() {
		return numHousesRented;
	}

	public void setNumHousesRented(int numHousesRented) {
		this.numHousesRented = numHousesRented;
	}

	public int getNumActiveListing() {
		return numActiveListing;
	}

	public void setNumActiveListing(int numActiveListing) {
		this.numActiveListing = numActiveListing;
	}
	
	public ArrayList<Property> getHousesRented()
	{
		return housesRented;
	}
}
