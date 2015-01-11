package com.example.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void removeSomeContacts() throws Exception {
		app.getNavigationHelper().openMainPage();
		//save data
		ContactData contact = new ContactData();
		app.getContactHelper().saveContactDataFromMainPage(contact, 1);
		app.getContactHelper().initContactModification(1);
		
		//actions
		app.getContactHelper().delete();
		app.getContactHelper().returntoHomePage();
		//verify data is deleted
		//assertEquals(newContact, contact);
		WebElement firstnameField = app.getContactHelper().findTheElementAtMainPage(contact);//не очень хорошая проверка 
		//так как сравнивает только по фамилии и имени, а контакты с одинаковым фамилией и именем сохранять можно. 
		//в идеале сравнивать по id и вообще, создавть контакт перед удалением
		Assert.assertNull(firstnameField);
		
	}
}