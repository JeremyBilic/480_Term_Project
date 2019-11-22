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

				User user = new User(fname, lname, uid);
				manager.getUserList().add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
