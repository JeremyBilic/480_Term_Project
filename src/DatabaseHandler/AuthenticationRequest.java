package DatabaseHandler;

import Model.User;

public class AuthenticationRequest extends Request{
	private String username;
	private String password;
	private AuthenticationResponse response;
	
	public AuthenticationRequest(String uname, String pword) {
		username = uname;
		password = pword;
		response = new AuthenticationResponse();
	}
	
	@Override
	public void request() {
		String query = "SELECT *"
				+ "FROM authentication NATURAL JOIN user "
				+ "WHERE username = \"" + username
				+ "\" AND password = \"" + password + "\"";
		
		int status = RequestHandler.getInstance().queryDatabase(query, response);
		
		if (status != 0) {
			response.foundError();
		}
		
		if(getUser() != null && getUser().getType() == "renter") {
			query = "UPDATE user SET lastid = (SELECT MAX(pid) from property) WHERE uid = " + getUser().getId();
			RequestHandler.getInstance().queryDatabase(query, new AuthenticationResponse());
		}
	}
	
	public User getUser() {
		return response.getUser();
	}
}
