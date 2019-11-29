package DatabaseHandler;

import Model.Listing;
import Model.Renter;

public class RenterProfileRequest extends Request{
	private Renter user;
	
	public RenterProfileRequest(Renter user) {
		this.user = user;
		response = new RenterProfileResponse(user);
	}
	@Override
	public void request() {
		user.setNewPropertyList(new Listing());
		if(user.isSubscribed()) {
			String query = "SELECT * "
					+ "FROM property NATURAL JOIN user "
					+ "WHERE pid > " + user.getLastSeenID();
			RequestHandler.getInstance().queryDatabase(query, response);
		}
	}


}
