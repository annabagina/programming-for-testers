package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

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
		select(By.name("new_group"), contact.newgroup);

	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returntoHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int index) {
		// a[contains(@href,"edit.php?id=")]
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@title=\"Edit\"]"));
	}

	public void update() {
		click(By.xpath("//input[@type=\"submit\" and @value=\"Update\"]"));
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> options = driver.findElements(By
				.xpath("//select[@name=\"new_group\"]/option"));
		for (WebElement option : options) {
			GroupData group = new GroupData();
			group.groupname = option.getText();
			groups.add(group);
		}
		return groups;
	}

	public void delete() {
		click(By.xpath("//input[@type=\"submit\" and @value=\"Delete\"]"));
	}

	public void selectGroupInContactList(String groupname) {
		select(By.xpath("//select[@name=\"group\"]"), groupname);

	}

	public void modifyContact(ContactData contact) {
		click(By.xpath("//tr[td[3] = \"" + contact.firstname
		+ "\"  and td[2] = \"" + contact.lastname + "\"]/td[7]/a"));
	}

	public void saveDataToNewContact(ContactData newContact) {
		WebElement firstnameField = driver.findElement(By.name("firstname"));
		newContact.firstname = firstnameField.getAttribute("value");
		WebElement lastnameField = driver.findElement(By.name("lastname"));
		newContact.lastname = lastnameField.getAttribute("value");
		WebElement mobileField = driver.findElement(By.name("mobile"));
		newContact.mobile = mobileField.getAttribute("value");
		WebElement homeField = driver.findElement(By.name("home"));
		newContact.home = homeField.getAttribute("value");
		// bday
		WebElement bdayField = driver.findElement(By.name("bday"));
		newContact.bday = bdayField.getAttribute("value");
		WebElement bmonthField = driver.findElement(By.name("bmonth"));
		newContact.bmonth = bmonthField.getAttribute("value");
		WebElement byearField = driver.findElement(By.name("byear"));
		newContact.byear = byearField.getAttribute("value");
	}

	public void saveContactDataFromMainPage(ContactData contact, int index) {
		WebElement firstnameField = driver.findElement(By.xpath("//tr["
				+ (index + 1) + "]/td[3]"));
		contact.firstname = firstnameField.getText();
		WebElement lastnameField = driver.findElement(By.xpath("//tr["
				+ (index + 1) + "]/td[2]"));
		contact.lastname = lastnameField.getText();
	}

	public WebElement findTheElementAtMainPage(ContactData contact) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//когда ищем удаленный элемент ждем 5 секунд, 
		//иначе поиск идет 30 секунд по умолчанию
		List<WebElement> deletedElements = driver.findElements(By
				.xpath("//tr[td[3] = \"" + contact.firstname
						+ "\"  and td[2] = \"" + contact.lastname + "\"]"));
		if (deletedElements.size() == 0) {
			return null;
		}
		return deletedElements.get(0);

	}
}
