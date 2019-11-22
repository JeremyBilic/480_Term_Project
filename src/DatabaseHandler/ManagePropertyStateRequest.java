package DatabaseHandler;

import Model.Property;

public class ManagePropertyStateRequest extends Request {
	private Property property;
	private String query;
	private ManagementStrategy strat;
	private int status;
	
	public ManagePropertyStateRequest(Property prop) {
		property = prop;
		strat = new AddPropertyStrategy();
		query = "";
		response = new ManagePropertyStateResponse();
	}
	
	@Override
	public void request() {
		query = strat.createQuery(property);
		status = RequestHandler.getInstance().queryDatabase(query, response);
	}
	
	public void setAdd() {
		strat = new AddPropertyStrategy();
	}
	
	public void setUpdate() {
		strat = new UpdatePropertyStrategy();
	}
	
	public void setRemove() {
		strat = new RemovePropertyStrategy();
	}
	
	public int getResponse() {
		return status;
	}
	
}
