package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContats() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstname = "Vitaliy";
		contact.lastname = "Tsytsulin";
		app.getContactHelper().fillContactForm(contact);		
		app.getContactHelper().update();
		app.getContactHelper().returntoHomePage();
	}
}