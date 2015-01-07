package com.example.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().gotoAddContactPage();
		
		Random rnd = new Random();
		List<GroupData> grouplist = app.getContactHelper().getGroups();
		contact.newgroup = grouplist.get(rnd.nextInt(grouplist.size() - 1)).groupname;		
		
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returntoHomePage();
	}
}