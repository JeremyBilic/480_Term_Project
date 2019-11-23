package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Address;
import Model.Fee;
import Model.Landlord;
import Model.Manager;
import Model.Property;

public class ManagerProfilePropertyResponse implements Response {
	Manager manager;
	
	public ManagerProfilePropertyResponse(Manager user) {
		manager = user;
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
				double fee = result.getDouble("fee");

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

				manager.getPropertyLists().addProperty(new Property(address, landlord, pid, state, numberOfBathrooms, numberOfBedrooms,
						type, furnished, new Fee(fee)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
