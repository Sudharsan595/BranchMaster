package com.example.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="BranchMaster")
public class BranchBean {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchID;
@Column
	private String branchcode;
@Column	
	private String branchname;
@Column
	private String openingdate;
@Column	
	private String closingdate;
@Column	
	private String Address;
//@Column
//	private String country;
//@Column
//	private String state;
//@Column
//	private String city;
@Column	
	private String pincode;
@Column	
	private String cersaicity;
@Column	
	private String cersaidistrict;
@Column
	private String mobileno;
@Column	
	private String emailID;
@Column	
	private String website;
@Column	
	private String spokeindicator;
@Column	
	private String memberID;
//@Column	
//	private String Area;
@Column
	private String Zone;
@ManyToOne
@JoinColumn(name="Location")
private Location location;
public int getBranchID() {
	return branchID;
}
public void setBranchID(int branchID) {
	this.branchID = branchID;
}
public String getBranchcode() {
	return branchcode;
}
public void setBranchcode(String branchcode) {
	this.branchcode = branchcode;
}
public String getBranchname() {
	return branchname;
}
public void setBranchname(String branchname) {
	this.branchname = branchname;
}
public String getOpeningdate() {
	return openingdate;
}
public void setOpeningdate(String openingdate) {
	this.openingdate = openingdate;
}
public String getClosingdate() {
	return closingdate;
}
public void setClosingdate(String closingdate) {
	this.closingdate = closingdate;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getCersaicity() {
	return cersaicity;
}
public void setCersaicity(String cersaicity) {
	this.cersaicity = cersaicity;
}
public String getCersaidistrict() {
	return cersaidistrict;
}
public void setCersaidistrict(String cersaidistrict) {
	this.cersaidistrict = cersaidistrict;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getSpokeindicator() {
	return spokeindicator;
}
public void setSpokeindicator(String spokeindicator) {
	this.spokeindicator = spokeindicator;
}
public String getMemberID() {
	return memberID;
}
public void setMemberID(String memberID) {
	this.memberID = memberID;
}
//public String getArea() {
//	return Area;
//}
//public void setArea(String area) {
//	Area = area;
//}
public String getZone() {
	return Zone;
}
public void setZone(String zone) {
	Zone = zone;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}

 
}

