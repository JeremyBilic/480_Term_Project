package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Address;
import Model.Criteria;
import Model.Landlord;
import Model.Listing;
import Model.Manager;
import Model.Property;
import Model.Renter;
import Model.User;

public class AuthenticationResponse implements Response{
	private User user;
	
	@Override
	public void parseResponse(ResultSet result) {
		try {

			while(result.next()) {
				String fname = result.getString("fname");
				String lname = result.getString("lname");
				int utype = result.getInt("utype");
				int uid = result.getInt("uid");

				
				if (utype == 0) {
					boolean subscribed = result.getBoolean("subscribed");
					int lastSeen = result.getInt("lastid");
					user.setType("renter");
					
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
					
					user = new Renter(fname, lname, uid, subscribed, lastSeen, 
							new Criteria(new Address(
									street,
									quadrant,
									city,
									province,
									country),
							state, 
							Integer.toString(numberOfBathrooms),
							Integer.toString(numberOfBedrooms),
							type,
							Boolean.toString(furnished).toLowerCase()));
					
				} else if (utype == 1) {
					String email = result.getString("email");
					user.setType("landlord");
					user = new Landlord(fname, lname, uid, email);
				} else {
					user.setType("manager");
					user = new Manager(fname, lname, uid);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void foundError() {
		user = null;
	}
	
	public User getUser() {
		return user;
	}

}
