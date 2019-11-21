package DatabaseHandler;

import java.sql.ResultSet;

public interface Response {
	abstract void parseResponse(ResultSet result);
}
