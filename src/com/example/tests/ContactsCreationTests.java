package com.example.tests;

import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {
	@Test
	public void testUntitled3() throws Exception {
		openMainPage();
		gotoAddContactPage();
		fillContactForm(new ContactData("Anya", "Bagina", "Nsk", "8111111",
				"8-000-000-00-00", "123456", "email@mail.ru",
				"sqrt2@qwerty.tld", "17", "January", "1991", "Rob", "Nsk 2",
				"Home"));
		submitContactCreation();
		returntoHomePage();
	}
}