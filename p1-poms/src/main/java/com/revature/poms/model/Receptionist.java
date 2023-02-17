 package com.revature.poms.model;

public class Receptionist {
	private String receptionistName;
	private String designation;
	private String gender;
	private String receptionistContact;
	private String address;
	private String shiftTiming;
	private int receptId;
	public int getReceptId() {
		return receptId;
	}

	public void setReceptId(int receptId) {
		this.receptId = receptId;
	}

	public Receptionist() {
		super();
	}

	public Receptionist(String receptionistName, String designation, String gender, String receptionistContact,
			String address, String shiftTiming) {
		super();
		this.receptionistName = receptionistName;
		this.designation = designation;
		this.gender = gender;
		this.receptionistContact = receptionistContact;
		this.address = address;
		this.shiftTiming = shiftTiming;
	}

	public String getReceptionistName() {
		return receptionistName;
	}

	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReceptionistContact() {
		return receptionistContact;
	}

	public void setReceptionistContact(String receptionistContact) {
		this.receptionistContact = receptionistContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShiftTiming() {
		return shiftTiming;
	}

	public void setShiftTiming(String shiftTiming) {
		this.shiftTiming = shiftTiming;
	}

	@Override
	public String toString() {
		return "Receptionist [receptionistName=" + receptionistName + ", designation=" + designation + ", gender="
				+ gender + ", receptionistContact=" + receptionistContact + ", address=" + address + ", shiftTiming="
				+ shiftTiming + "]";
	}

}
