package DatabaseHandler;

import Model.Property;

public class RemovePropertyStrategy implements ManagementStrategy {

	@Override
	public String createQuery(Property property) {
		String query = "DELETE FROM property WHERE pid = " + property.getId();
		return query;
	}

}
