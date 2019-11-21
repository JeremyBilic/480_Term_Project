package Model;

import java.util.ArrayList;

public class Listing {

	private ArrayList<Property> properties;

	public Listing()
	{
		setProperties(new ArrayList<Property>());
	}
	
	public Listing(ArrayList<Property> properties)
	{
		this.properties = properties;
	}
	
	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	
	public void addProperty(Property p)
	{
		properties.add(p);
	}
	
	public void removeProperty(Property p)
	{
		properties.remove(p);
	}
	
	public Property searchProperty(int id)
	{
		for(Property p : properties)
		{
			if(p.getId() == id)
			{
				return p;
			}
		}
		return null;
	}
}
