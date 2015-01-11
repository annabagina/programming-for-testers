package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test(dataProvider = "randomValidContactModifyGenerator")//old state we get in random
	public void modifySomeContacts(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		
		//actions
		app.getContactHelper().fillContactForm(contact);		
		app.getContactHelper().update();
		app.getContactHelper().returntoHomePage();
		
		//new state
		//app.getContactHelper().selectGroupInContactList(contact.newgroup);//select group, нерабочий
		app.getContactHelper().modifyContact(contact);//find contact by x.path //go to contact modify menu
		ContactData newContact = new ContactData();
		app.getContactHelper().saveDataToNewContact(newContact);//read data from this menu and save to new state - "newContact"
		
		//compare "contact" and "newContact"
		assertEquals(newContact, contact);
	}
}