package DatabaseHandler;

import java.util.ArrayList;

import Model.Listing;
import Model.Manager;
import Model.User;

public class ManagerProfileRequest extends Request {
	private Manager user;
	
	public ManagerProfileRequest(Manager user) {
		this.user = user;
		response = new ManagerProfilePropertyResponse(user);
	}
	
	@Override
	public void request() {
		user.setPropertyLists(new Listing());
		user.setUserList(new ArrayList<User>());
		
		String query = "SELECT * "
				+ "FROM property NATURAL JOIN user";
		
		RequestHandler.getInstance().queryDatabase(query, response);
		
		response = new ManagerProfileUserResponse(user);
		
		query = "SELECT * "
				+ "FROM user";
		RequestHandler.getInstance().queryDatabase(query, response);
		
	}

}
