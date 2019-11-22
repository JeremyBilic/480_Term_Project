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
				+ "FROM authentication, user "
				+ "WHERE authentication.username = \"" + username
				+ "\" AND authentication.password = \"" + password
				+ "\" AND authentication.uid = user.uid";
		
		int status = RequestHandler.getInstance().queryDatabase(query, response);
		
		if (status != 0) {
			response.foundError();
		}
		
	}
	
	public User getUser() {
		return response.getUser();
	}
}
