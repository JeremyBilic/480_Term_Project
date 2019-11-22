package DatabaseHandler;

public class AuthenticationRequest extends Request {

	private String username;
	private String password;
	
	public AuthenticationRequest(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void request() {
		
	}

}
