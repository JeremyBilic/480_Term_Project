package Model;

public class Address {
	private String street;
	private String quadrant;
	private String city;
	private String province;
	private String country;
	
	Address(String street, String quadrant, String city, 
			String province, String country)
	{
		this.street = street;
		this.quadrant = quadrant;
		this.city = city;
		this.province = province;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getQuadrant() {
		return quadrant;
	}
	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
