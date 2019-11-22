package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Address;
import Model.Landlord;
import Model.Property;

public class LandlordProfileResponse implements Response{
	private Landlord landlord;
	
	public LandlordProfileResponse(Landlord landlord) {
		this.landlord = landlord;
	}
	
	@Override
	public void parseResponse(ResultSet result) {
		try {

			while(result.next()) {
				int pid = result.getInt("pid");
				String state = result.getString("state");
				int numberOfBathrooms = result.getInt("bathrooms");
				int numberOfBedrooms = result.getInt("bedrooms");
				String type = result.getString("type");
				boolean furnished = result.getBoolean("furnished");

				String street = result.getString("street");
				String quadrant = result.getString("quadrant");
				String city = result.getString("city");
				String province = result.getString("province");
				String country = result.getString("country");

				Address address = new Address(street, quadrant, city, province, country);

				landlord.getOwnedPropertyList().addProperty(new Property(address, landlord, pid, state, numberOfBathrooms, numberOfBedrooms,
						type, furnished));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
