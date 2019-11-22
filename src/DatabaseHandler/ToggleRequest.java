package DatabaseHandler;

import Model.Renter;

public class ToggleRequest extends Request{
	private Renter renter;
	
	public ToggleRequest(Renter renter) {
		this.renter = renter;
		response = new ToggleResponse();
	}
	
	@Override
	public void request() {
		String query = "UPDATE user SET subscribed = " + !renter.isSubscribed()
				+ "WHERE uid = " + renter.getId();
		RequestHandler.getInstance().queryDatabase(query, response);
		
	}
	
}
