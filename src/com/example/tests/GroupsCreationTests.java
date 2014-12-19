package com.example.tests;

import org.testng.annotations.Test;

public class GroupsCreationTests extends TestBase {
	@Test
	public void testNoneEmptyGroupCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		GroupData group = new GroupData();
		group.groupname = "group 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.groupHelper.fillGroupForm(group);
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returntoGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		app.groupHelper.fillGroupForm(new GroupData("", "", ""));
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returntoGroupsPage();
	}
}
