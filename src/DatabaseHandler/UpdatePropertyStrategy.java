package DatabaseHandler;

import Model.Property;

public class UpdatePropertyStrategy implements ManagementStrategy {

	@Override
	public String createQuery(Property property) {
		String query = "UPDATE property "
				+ "SET state = \"" + property.getState()
				+ "\", bathrooms = " + property.getNumberOfBathrooms()
				+ ", bedrooms = " + property.getNumberOfBedrooms()
				+ ", type = \"" + property.getType()
				+ "\", furnished = " + property.isFurnished()
				+ ", street = \"" + property.getAddress().getStreet()
				+ "\", quadrant = \"" + property.getAddress().getQuadrant()
				+ "\", province = \"" + property.getAddress().getProvince()
				+ "\", country = \"" + property.getAddress().getCountry()
				+ "\", uid = " + property.getOwner().getId()
				+ ", city = \"" + property.getAddress().getCity()
				+ "\" WHERE pid = " + property.getId();
		return query;
	}
}

