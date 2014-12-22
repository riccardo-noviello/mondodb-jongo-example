package com.riccardo.mondogb.jongo.example.model;

import java.io.StringWriter;

import org.jongo.marshall.jackson.oid.Id;

public class Address {

	@Id
	private Long addressId;
	private String houseNumber;
	private String road;
	private String town;
	private String postalCode;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

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

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		sw.append(this.getAddressId().toString());
		sw.append(this.houseNumber);
		sw.append(this.road);
		sw.append(this.town);
		sw.append(this.postalCode);
		return sw.toString();
	}

}
