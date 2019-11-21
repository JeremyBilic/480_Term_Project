package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestHandler {
	private Connection conn;
	private static RequestHandler instance;

	private RequestHandler() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/toolshop", "toolServer", "toolServer.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static RequestHandler getInstance() {
		if (instance == null) {
			instance = new RequestHandler();
		}
		return instance;
	}
	
	public int queryDatabase(String query, Response response) {
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			response.parseResponse(result);
			
		} catch (SQLException e) {
			return e.getErrorCode();
		}
		
		return 0;
	}

}