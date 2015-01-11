package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().gotoAddContactPage();
		
		Random rnd = new Random();
		List<GroupData> grouplist = app.getContactHelper().getGroups();
		contact.newgroup = grouplist.get(rnd.nextInt(grouplist.size() - 1)).groupname; // "contact" is old state
		
		// actions
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returntoHomePage();
		
		//new state
		app.getContactHelper().selectGroupInContactList(contact.newgroup);//select group
		app.getContactHelper().modifyContact(contact);//find contact by x.path //go to contact modify menu
		ContactData newContact = new ContactData();
		app.getContactHelper().saveDataToNewContact(newContact);//read data from this menu and save to new state - "newContact"
		
		//compare "contact" and "newContact"
		assertEquals(newContact, contact);
		
	}
//	@Test(dataProvider = "randomInvalidContactGenerator")
	public void testInvalidContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().gotoAddContactPage();
		
		Random rnd = new Random();
		List<GroupData> grouplist = app.getContactHelper().getGroups();
		contact.newgroup = grouplist.get(rnd.nextInt(grouplist.size() - 1)).groupname; // contact is old state
		
		// actions
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returntoHomePage();
	}
	
}