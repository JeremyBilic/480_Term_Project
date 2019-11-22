package DatabaseHandler;

import Model.Manager;

public class ManagerProfileRequest extends Request {
	private Manager user;
	
	public ManagerProfileRequest(Manager user) {
		this.user = user;
		response = new ManagerProfilePropertyResponse(user);
	}
	
	@Override
	public void request() {
		String query = "SELECT *"
				+ "FROM property, user";
		
		RequestHandler.getInstance().queryDatabase(query, response);
		
		response = new ManagerProfileUserResponse(user);
		
		query = "SELECT * "
				+ "FROM user";
		RequestHandler.getInstance().queryDatabase(query, response);
		
	}

}
