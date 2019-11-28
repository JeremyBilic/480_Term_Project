package DatabaseHandler;

import Model.Renter;

public class RenterProfileRequest extends Request{
	private Renter user;
	
	public RenterProfileRequest(Renter user) {
		this.user = user;
		response = new RenterProfileResponse();
	}
	@Override
	public void request() {
		String query = "SELECT *"
				+ "FROM property NATURAL JOIN user"
				+ "WHERE lastid > " + user.getLastSeenID();
		RequestHandler.getInstance().queryDatabase(query, response);
	}


}
