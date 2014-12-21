package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoAddContactPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		select(By.name("bday"), contact.bday);
		select(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
		// select(By.name("new_group"), contact.newgroup);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returntoHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int index) {
		//a[contains(@href,"edit.php?id=")]
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@title=\"Edit\"]"));
	}

	public void update() {
		click(By.xpath("//input[@type=\"submit\" and @value=\"Update\"]"));
	}
	
	public void delete() {
		click(By.xpath("//input[@type=\"submit\" and @value=\"Delete\"]"));
	}
}
