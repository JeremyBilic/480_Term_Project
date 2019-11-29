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
				+ ", cstate = \"" + renter.getUserCriteria().getState()
				+ "\" , cbathrooms = \"" + renter.getUserCriteria().getNumberOfBathrooms()
				+ "\" , cbedrooms = \"" + renter.getUserCriteria().getNumberOfBedrooms()
				+ "\" , ctype = \"" + renter.getUserCriteria().getType()
				+ "\" , cfurnished = \"" + renter.getUserCriteria().getFurnished()
				+ "\" , cstreet = \"" + renter.getUserCriteria().getAddress().getStreet()
				+ "\" , cquadrant = \"" + renter.getUserCriteria().getAddress().getQuadrant()
				+ "\" , ccity = \"" + renter.getUserCriteria().getAddress().getCity()
				+ "\" , cprovince = \"" + renter.getUserCriteria().getAddress().getProvince()
				+ "\" , ccountry = \"" + renter.getUserCriteria().getAddress().getCountry()
				+ "\""
				+ " WHERE uid = " + renter.getId();
		RequestHandler.getInstance().queryDatabase(query, response);
		
	}
	
}
