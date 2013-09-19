package com.learning.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learning.domain.Apartment;
import com.learning.domain.Tenant;
import com.learning.exceptions.ApartmentNotFoundException;

public class ApatmentListingDAOTest {
	
	private ApartmentListingDAO apartmentListingDao;

	@Before
	public void setUp() throws Exception {
		apartmentListingDao = new ApartmentListingDAO();
		emptyDatabase();
	}

	@After
	public void tearDown() throws Exception {
		emptyDatabase();
		apartmentListingDao = null;
	}

	@Test
	public void testSaveAndGetListings() throws Exception {
		//assertEquals(apartmentListingDao.getListings().size(),0);
		apartmentListingDao.save(getTestApartment());
		assertEquals(apartmentListingDao.getListings().size(),1);
	}
	
	@Test
	public void testAddTenantToApartmentExistingInDatabase () {
		Tenant sampleTenant = new Tenant();
		sampleTenant.setFirstName("testFirstName");
		sampleTenant.setLastName("testLastName");
		apartmentListingDao.save(getTestApartment());
		apartmentListingDao.AddTenantToApartmentExistingInDatabase(getTestApartment(), sampleTenant);
		apartmentListingDao.removeApartment(getTestApartment());
	}
	
	private Date getCurrentDate(int increment) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, increment);
		return cal.getTime();
	}
	
	private Apartment getTestApartment() {
		Apartment testApartment = new Apartment();
		testApartment.setApartmentNumber("testApartment123");
		testApartment.setAvailable(false);
		testApartment.setNumberOfBedRooms("2");
		testApartment.setRent("123455");
		testApartment.setRoomNumber("4");
		testApartment.setLeaseStartDate(getCurrentDate(0));
		testApartment.setLeaseEndDate(getCurrentDate(1));
		return testApartment;
	}
	
	private void emptyDatabase() throws Exception {
		List<Apartment> apartments = apartmentListingDao.getListings();
		for(Apartment apartment : apartments) {
			apartmentListingDao.removeApartment(apartment);
		}
	}

}
