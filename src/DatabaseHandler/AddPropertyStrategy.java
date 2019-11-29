package DatabaseHandler;

import Model.Property;

public class AddPropertyStrategy implements ManagementStrategy{

	@Override
	public String createQuery(Property property) {
		String query = "INSERT INTO property (state, bathrooms, bedrooms, type, furnished, street, quadrant, province, country, uid, city, fee) "
					+ "VALUES (\"" + property.getState()
					+ "\", " + property.getNumberOfBathrooms()
					+ ", " + property.getNumberOfBedrooms()
					+ ", \"" + property.getType()
					+ "\", " + property.isFurnished()
					+ ", \"" + property.getAddress().getStreet()
					+ "\", \"" + property.getAddress().getQuadrant()
					+ "\", \"" + property.getAddress().getProvince()
					+ "\", \""+ property.getAddress().getCountry()
					+ "\", "+ property.getOwner().getId()
					+ ", \"" + property.getAddress().getCity() 
					+ "\", " + property.getFee().getAmount() + ");";
		return query;
	}
	
}
