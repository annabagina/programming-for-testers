package com.example.tests;

import org.testng.annotations.Test;

public class GroupsCreationTests extends TestBase {
	@Test
	public void testNoneEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.groupname = "group 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returntoGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returntoGroupsPage();
	}
}
