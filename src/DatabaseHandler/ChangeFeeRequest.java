package DatabaseHandler;

import Model.Fee;
import Model.Property;

public class ChangeFeeRequest extends Request{
	private Fee newFee;
	private int pid;		// id of the property
	
	public ChangeFeeRequest(Fee newFee, Property prop) {
		this.newFee = newFee;
		pid = prop.getId();
	}
	
	@Override
	public void request() {
		String query = "UPDATE property SET fee = " + newFee.getAmount()
				+ " WHERE pid = " + pid;
		RequestHandler.getInstance().queryDatabase(query, response);
	}

}
