package com.learning.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learning.domain.Apartment;
import com.learning.domain.Tenant;
import com.learning.exceptions.ApartmentNotFoundException;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ApartmentListingDAO {
	private DBCollection apartmentsCollection = null;
	private BasicDBObject apartment  = null;
	
	public ApartmentListingDAO () {
		apartmentsCollection = MongoConnector.getInstance().getCollection("kendal", "apartments");
	    apartment = new BasicDBObject();
	}
	
	
	public void save(Apartment apartment) {
	    apartmentsCollection.insert(createApartmentDBObect(apartment));
	}
	
	public List<Apartment> getListings() throws ApartmentNotFoundException {
		List<Apartment> apartmentListings = new ArrayList<Apartment>();		
		DBCursor cursor = apartmentsCollection.find();
		while(cursor.hasNext()) {
			DBObject apartmentRecord = cursor.next();
			apartmentListings.add(populateApartmentBean(apartmentRecord));
		}
		return apartmentListings;
	}
	
	public Apartment findApartmentByApartmentAndRoomNumber(String apartmentNumber, String roomNumber) throws ApartmentNotFoundException {
		BasicDBObject dbObj = new BasicDBObject();
		dbObj.append("apartmentNumber", apartmentNumber);
		dbObj.append("roomNumber", roomNumber);
	    DBObject apartmentInDB = apartmentsCollection.findOne(dbObj);
	    return populateApartmentBean(apartmentInDB);
	}
	
	public void AddTenantToApartmentExistingInDatabase(Apartment apartment, Tenant tenant) {
		BasicDBObject apartmentToAddTentantTo = createApartmentDBObect(apartment);
		DBObject tenantsApartment = apartmentsCollection.findOne(apartmentToAddTentantTo);
		List<BasicDBObject> tenantsInDB = (List<BasicDBObject>) tenantsApartment.get("tenants");
		if(tenantsInDB != null) {
			//Updating existing tenants
			apartmentsCollection.update(apartmentToAddTentantTo, new BasicDBObject("$push",new BasicDBObject().append("tenants",convertTenantToDBObject(tenant)))); //new BasicDBObject(convertTenantToDBObject(tenant))
		} else {
			//Adding a tenant for the first time.
			List<BasicDBObject> dbList = new ArrayList<BasicDBObject>();
			dbList.add(convertTenantToDBObject(tenant));
			apartmentsCollection.update(apartmentToAddTentantTo, new BasicDBObject("$set", new BasicDBObject().append("tenants", dbList)));
		}
	}
	
	public void removeApartment(Apartment apartment) {
		apartmentsCollection.remove(createApartmentDBObect(apartment));
	}
	
	private BasicDBObject convertTenantToDBObject(Tenant tenant) {
		BasicDBObject tenantToAdd = new BasicDBObject();
		tenantToAdd.append("firstName", tenant.getFirstName());
		tenantToAdd.append("lastName", tenant.getLastName());
		return tenantToAdd;
	}
	
	private Apartment populateApartmentBean(DBObject apartmentRecord) throws ApartmentNotFoundException {
		if(apartmentRecord != null) {
			Apartment apartment = new Apartment();
			if(apartmentRecord.get("apartmentNumber") != null) {
				apartment.setApartmentNumber((String) apartmentRecord.get("apartmentNumber"));
			}
			if(apartmentRecord.get("isAvailable") != null) {
				apartment.setAvailable((Boolean) apartmentRecord.get("isAvailable"));
			}
			if(apartmentRecord.get("numberOfBedRooms") != null) {
				apartment.setNumberOfBedRooms((String) apartmentRecord.get("numberOfBedRooms"));
			}
			if(apartmentRecord.get("rent") != null) {
				apartment.setRent((String) apartmentRecord.get("rent"));
			}
			if(apartmentRecord.get("roomNumber") != null) {
				apartment.setRoomNumber((String) apartmentRecord.get("roomNumber"));
			}
			if(apartmentRecord.get("leaseStartDate") != null) {
				apartment.setLeaseStartDate((Date)apartmentRecord.get("leaseStartDate"));
			}
			if(apartmentRecord.get("leaseEndDate") != null) {
				apartment.setLeaseEndDate((Date)apartmentRecord.get("leaseEndDate"));
			}
			return apartment;
		} else {
			throw new ApartmentNotFoundException("Cannot find apartment in database");
		}
		
	}
	
	private BasicDBObject createApartmentDBObect(Apartment apartment) {
		BasicDBObject apartmentDBObject = new BasicDBObject();
		apartmentDBObject.append("apartmentNumber", apartment.getApartmentNumber());
		apartmentDBObject.append("roomNumber", apartment.getRoomNumber());
		apartmentDBObject.append("rent", apartment.getRent());
		apartmentDBObject.append("numberOfBedRooms", apartment.getNumberOfBedRooms());
		//apartmentDBObject.append("leaseStartDate", apartment.getLeaseStartDate());
		//apartmentDBObject.append("leaseEndDate", apartment.getLeaseEndDate());
		apartmentDBObject.append("isAvailable", apartment.isAvailable());
		return apartmentDBObject;
	}
	
	

}
