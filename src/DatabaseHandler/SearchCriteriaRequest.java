package DatabaseHandler;

import Model.Property;

public class SearchCriteriaRequest extends Request{
	private Property property;
	private SearchCriteriaResponse response;
	
	public SearchCriteriaRequest(Property prop) {
		property = prop;
		response = new SearchCriteriaResponse();
	}
	@Override
	public void request() {
		RequestHandler.getInstance().queryDatabase(query, response);
	}

}
