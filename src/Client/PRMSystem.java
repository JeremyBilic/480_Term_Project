package Client;

import Model.*;
import DatabaseHandler.*;

public class PRMSystem {
	private MainController mController;
	
	public void setController(MainController mController) {
		this.mController = mController;
	}
	
	public void addProperty(Property prop) {
		ManagePropertyStateRequest req = new ManagePropertyStateRequest(prop);
		req.setAdd();
		req.request();
	}
	
	public void removeProperty(Property prop) {
		ManagePropertyStateRequest req = new ManagePropertyStateRequest(prop);
		req.setRemove();
		req.request();
	}
	
	public void updateProperty(Property prop) {
		ManagePropertyStateRequest req = new ManagePropertyStateRequest(prop);
		req.setUpdate();
		req.request();
	}
	
	public Listing search(Criteria crit) {
		SearchCriteriaRequest req = new SearchCriteriaRequest(crit);
		req.request();
		return req.getResponse();
	}
	
	public void toggleSubscription(Renter user) {
		ToggleRequest req = new ToggleRequest(user);
		req.request();
	}
	
	public void getRenterProfile(Renter user) {
		RenterProfileRequest req = new RenterProfileRequest(user);
		req.request();
	}
	
	public void getManagerProfile(Manager user) {
		ManagerProfileRequest req = new ManagerProfileRequest(user);
		req.request();
	}
	
	public void getLandlordProfile(Landlord user) {
		LandlordProfileRequest req = new LandlordProfileRequest(user);
		req.request();
	}
	
	public void changeFee(Fee fee, Property prop) {
		ChangeFeeRequest req = new ChangeFeeRequest(fee, prop);
		req.request();
	}
	
	//Return a null user if the authentication failed
	public User authentication(String username, String password) {
		AuthenticationRequest req = new AuthenticationRequest(username, password);
		req.request();
		return req.getUser();
	}
	
	public Periodical requestPeriodical() {
		PeriodicalReportRequest req = new PeriodicalReportRequest();
		req.request();
		return req.getPeriodical();
	}
}
