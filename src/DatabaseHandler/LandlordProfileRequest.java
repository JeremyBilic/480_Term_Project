package DatabaseHandler;

import Model.Landlord;

public class LandlordProfileRequest extends Request {
	private Landlord user;
	
	public LandlordProfileRequest(Landlord user) {
		this.user = user;
		response = new LandlordProfileResponse(user);
	}
	@Override
	public void request() {
		String query = "SELECT *"
				+ "FROM property"
				+ "WHERE uid =" + user.getId();
		RequestHandler.getInstance().queryDatabase(query, response);
	}

}
