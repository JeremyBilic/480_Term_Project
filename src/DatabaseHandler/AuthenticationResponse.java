package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Address;
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
					user = new Renter(fname, lname, uid, subscribed, lastSeen);
				} else if (utype == 1) {
					String email = result.getString("email");
					user = new Landlord(fname, lname, uid, email);
				} else {
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
