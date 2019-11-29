package DatabaseHandler;

import Model.Criteria;
import Model.Listing;

public class SearchCriteriaRequest extends Request{
	private Criteria criteria;
	private SearchCriteriaResponse response;
	
	public SearchCriteriaRequest(Criteria crit) {
		criteria = crit;
		response = new SearchCriteriaResponse();
	}
	@Override
	public void request() {
		
		String query = "SELECT * "
				+ "FROM user NATURAL JOIN property "
				+ "WHERE true";
		
		if (!criteria.getState().isEmpty()) {
			query += (" AND state = \"" + criteria.getState()) + "\"";
		}
		
		if (!criteria.getNumberOfBathrooms().isEmpty()) {
			query +=  (" AND bathrooms = " + criteria.getNumberOfBathrooms());
		}
		
		if (!criteria.getNumberOfBedrooms().isEmpty()) {
			query +=  (" AND bedrooms = " + criteria.getNumberOfBedrooms());
		}
		
		if (!criteria.getType().isEmpty()) {
			query += (" AND type = \"" + criteria.getType()) + "\"";
		}
		
		if (!criteria.getFurnished().isEmpty()) {
			query += (" AND furnished = " + criteria.getFurnished());
		}
		
		if (!criteria.getAddress().getCity().isEmpty()) {
			query += (" AND city = \"" + criteria.getAddress().getCity()) + "\"";
		}
		
		if (!criteria.getAddress().getProvince().isEmpty()) {
			query += (" AND province = \"" + criteria.getAddress().getProvince())+ "\"";
		}
		
		if (!criteria.getAddress().getQuadrant().isEmpty()) {
			query += (" AND quadrant = \"" + criteria.getAddress().getQuadrant()) + "\"";
		}
		
		if (!criteria.getAddress().getCountry().isEmpty()) {
			query += (" AND country = \"" + criteria.getAddress().getCountry()) + "\"";
		}
		
		RequestHandler.getInstance().queryDatabase(query, response);
	}
	
	public Listing getResponse() {
		return response.getListing();
	}

}
