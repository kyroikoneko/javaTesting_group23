package com.example.tests;

public class ContactData {
	public String firstName;
	public String secondName;
	public String postAddress;
	public String homePhoneNum;
	public String mobilePhonNum;
	public String workPhoneNum;
	public String postPrimary;
	public String postSecondary;
	public String day;
	public String month;
	public String year;
	public String secondaryPostAddress;
	public String secondaryPhone;
	public String group;

	public ContactData(String firstName, String secondName, String postAddress,
			String homePhoneNum, String mobilePhonNum, String workPhoneNum,
			String postPrimary, String postSecondary, String day, String month,
			String year, String group, String secondaryPostAddress, String secondaryPhone) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.postAddress = postAddress;
		this.homePhoneNum = homePhoneNum;
		this.mobilePhonNum = mobilePhonNum;
		this.workPhoneNum = workPhoneNum;
		this.postPrimary = postPrimary;
		this.postSecondary = postSecondary;
		this.day = day;
		this.month = month;
		this.year = year;
		this.group = group;
		this.secondaryPostAddress = secondaryPostAddress;
		this.secondaryPhone = secondaryPhone;
	}
	
	public ContactData() {
	}
}