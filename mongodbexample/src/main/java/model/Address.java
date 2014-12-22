package model;

public class Address {
	private String houseNumber;
	private String road;
	private String town;
	private String postalCode;

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void print(){
		System.out.format("### Address: %s %s, %s, %s \n",this.houseNumber, this.road, this.town, this.postalCode);
	}
}
