package DatabaseHandler;

import java.util.ArrayList;

import Model.Periodical;
import Model.Property;

public class PeriodicalReportRequest extends Request{
	Periodical periodical;
	PeriodicalReportResponse response;
	
	public PeriodicalReportRequest() {
		response = new PeriodicalReportResponse();
	}
	
	@Override
	public void request() {
		String query = "SELECT * "
				+ "FROM property NATURAL JOIN user";
		RequestHandler.getInstance().queryDatabase(query, response);
		int numListed = response.getCount();
		
		query = "SELECT * "
				+ "FROM property NATURAL JOIN user "
				+ "WHERE state = \"rented\"";
		RequestHandler.getInstance().queryDatabase(query, response);
		ArrayList<Property> rentedProps = new ArrayList<Property>();
		int numRented = response.getCount();
		
		query = "SELECT * "
				+ "FROM property NATURAL JOIN user"
				+ "WHERE state = \"active\"";
		RequestHandler.getInstance().queryDatabase(query, response);
		int numActive = response.getCount();
		
		periodical = new Periodical(numListed, numRented, numActive, rentedProps);
		
	}
	
	public Periodical getPeriodical() {
		return periodical;
	}

}
