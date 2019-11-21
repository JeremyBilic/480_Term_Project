package DatabaseHandler;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Address;
import Model.Landlord;
import Model.Listing;
import Model.Property;


public class SearchCriteriaResponse implements Response{
	Listing listing;
	
	public SearchCriteriaResponse() {
		listing = new Listing();
	}
	
	@Override
	public void parseResponse(ResultSet result) {
		while(result.next()) {
			
		    int pid = result.getInt("pid");
		    String state = result.getString("state");
		    int numberOfBathrooms = result.getInt("bathrooms");
		    int numberOfBedrooms = result.getInt("bedrooms");
		    String type = result.getString("type");
		    boolean furnished = result.getBoolean("furnished");
		    
		    String street = result.getString("type");
		    String quadrant = result.getString("type");
		    String city = result.getString("type");
		    String province = result.getString("type");
		    String country = result.getString("type");
		    
		    String fname = result.getString("fname");
		    String lname = result.getString("lname");
		    String email = result.getString("email");
		    int lid = result.getInt("lid");
		    
		    
		    Address address = new Address(street, quadrant, city, province, country);
		    Landlord landlord = new Landlord(fname, lname, email, lid);
		    
			listing.addProperty(new Property(address, landlord, pid, state, numberOfBathrooms, numberOfBedrooms,
					type, furnished));
		}
	}
	
}
