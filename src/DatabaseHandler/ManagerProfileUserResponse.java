package DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Manager;
import Model.User;

public class ManagerProfileUserResponse implements Response {
	private Manager manager;
	public ManagerProfileUserResponse(Manager user) {
		manager = user;
	}

	@Override
	public void parseResponse(ResultSet result) {
		try {

			while(result.next()) {
				String fname = result.getString("fname");
				String lname = result.getString("lname");
				int uid = result.getInt("uid");
				int type = result.getInt("utype");


				User user = new User(fname, lname, uid);
				if (type == 0) {
					user.setType("renter");
				} else if (type == 1) {
					user.setType("landlord");
				} else {
					user.setType("manager");
				}
				manager.getUserList().add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
