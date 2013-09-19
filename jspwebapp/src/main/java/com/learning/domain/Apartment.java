package com.learning.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment implements Serializable {
	
	private String apartmentNumber;
	private String roomNumber;
	private String rent;
	private String numberOfBedRooms;
	private boolean isAvailable;
	private Date leaseStartDate;
	private Date leaseEndDate;
	private List<Tenant> tenants = new ArrayList<Tenant>();
	
	public Apartment() {
		
	}
	/**
	 * @return the apartmentNumber
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	/**
	 * @param apartmentNumber the apartmentNumber to set
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the rent
	 */
	public String getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(String rent) {
		this.rent = rent;
	}
	/**
	 * @return the numberOfBedRooms
	 */
	public String getNumberOfBedRooms() {
		return numberOfBedRooms;
	}
	/**
	 * @param numberOfBedRooms the numberOfBedRooms to set
	 */
	public void setNumberOfBedRooms(String numberOfBedRooms) {
		this.numberOfBedRooms = numberOfBedRooms;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * @return the leaseStartDate
	 */
	public Date getLeaseStartDate() {
		return leaseStartDate;
	}
	/**
	 * @param leaseStartDate the leaseStartDate to set
	 */
	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	/**
	 * @return the leaseEndDate
	 */
	public Date getLeaseEndDate() {
		return leaseEndDate;
	}
	/**
	 * @param leaseEndDate the leaseEndDate to set
	 */
	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}
	public List<Tenant> getTenants() {
		return tenants;
	}
	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}
	
	

}
