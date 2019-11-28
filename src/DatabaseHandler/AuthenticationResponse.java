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
					//user.setType("renter");
					
					String state = result.getString("cstate");
					String numberOfBathrooms = result.getString("cbathrooms");
					String numberOfBedrooms = result.getString("cbedrooms");
					String type = result.getString("ctype");
					String furnished = result.getString("cfurnished");

					String street = result.getString("cstreet");
					String quadrant = result.getString("cquadrant");
					String city = result.getString("ccity");
					String province = result.getString("cprovince");
					String country = result.getString("ccountry");
					
					user = new Renter(fname, lname, uid, subscribed, lastSeen, 
							new Criteria(new Address(
									street,
									quadrant,
									city,
									province,
									country),
							state, 
							numberOfBathrooms,
							numberOfBedrooms,
							type,
							furnished.toLowerCase()));
					
				} else if (utype == 1) {
					String email = result.getString("email");
					//user.setType("landlord");
					user = new Landlord(fname, lname, uid, email);
				} else {
					//user.setType("manager");
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
