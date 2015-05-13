package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String secondName;
	private String postAddress;
	private String homePhoneNum;
	private String mobilePhonNum;
	private String workPhoneNum;
	private String postPrimary;
	private String postSecondary;
	private String day;
	private String month;
	private String year;
	private String secondaryPostAddress;
	private String secondaryPhone;
	private String group;

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



	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.secondName.toLowerCase().compareTo(other.secondName.toLowerCase());
		
	}
	
	public ContactData withName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}
	
	public ContactData withPostAddress(String postAddress) {
		this.postAddress = postAddress;
		return this;
	}
	
	public ContactData withHomePhoneNum(String homePhoneNum) {
		this.homePhoneNum = homePhoneNum;
		return this;
	}
	
	public ContactData withMobilePhonNum(String mobilePhonNum) {
		this.mobilePhonNum = mobilePhonNum;
		return this;
	}
	
	public ContactData withWorkPhoneNum(String workPhoneNum) {
		this.workPhoneNum = workPhoneNum;
		return this;
	}
	
	public ContactData withPostPrimary(String postPrimary) {
		this.postPrimary = postPrimary;
		return this;
	}
	
	public ContactData withPostSecondary(String postSecondary) {
		this.postSecondary = postSecondary;
		return this;
	}
	
	public ContactData withDay(String day) {
		this.day = day;
		return this;
	}
	
	public ContactData withMonth(String month) {
		this.month = month;
		return this;
	}
	
	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}
	
	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}
	
	public ContactData withSecondaryPostAddress(String secondaryPostAddress) {
		this.secondaryPostAddress = secondaryPostAddress;
		return this;
	}
	
	public ContactData withSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
		return this;
	}
	
	//*****************************************************************
	
	public String getFirstName() {
		return  firstName;
		
	}
	
	public String getSecondName() {
		return  secondName;
		
	}
	
	public String getPostAddress() {
		return  postAddress;
		
	}
	
	public String getHomePhoneNum() {
		return  homePhoneNum;
		
	}
	
	public String getMobilePhonNum() {
		return  mobilePhonNum;
		
	}
	
	public String getWorkPhoneNum() {
		return  workPhoneNum;
		
	}
	
	public String getPostPrimary() {
		return  postPrimary;
		
	}
	
	public String getPostSecondary() {
		return  postSecondary;
		
	}
	
	public String getDay() {
		return  day;
		
	}
	
	public String getMonth() {
		return  month;
		
	}
	
	public String getYear() {
		return  year;
		
	}
	
	public String getGroup() {
		return  group;
		
	}
	
	public String getSecondaryPostAddress() {
		return  secondaryPostAddress;
		
	}
	
	public String getSecondaryPhone() {
		return  secondaryPhone;
		
	}
	
}
