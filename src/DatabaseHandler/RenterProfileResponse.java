package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Address;
import Model.Landlord;
import Model.Property;
import Model.Renter;

public class RenterProfileResponse implements Response{
	private Renter renter;
	
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
				

				String fname = result.getString("fname");
				String lname = result.getString("lname");
				String email = result.getString("email");
				int lid = result.getInt("uid");

				Address address = new Address(street, quadrant, city, province, country);
				Landlord landlord = new Landlord(fname, lname, lid, email);


				renter.getNewPropertyList().addProperty(new Property(address, landlord, pid, state, numberOfBathrooms, numberOfBedrooms,
						type, furnished));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
