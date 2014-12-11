package com.example.tests;

import org.testng.annotations.Test;

public class GroupsCreationTests extends TestBase {
	@Test
	public void testNoneEmptyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.groupname = "group 1";
		group.header = "header 1";
		group.footer = "footer 1";
		fillGroupForm(group);
		submitGroupCreation();
		returntoGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		fillGroupForm(new GroupData("", "", ""));
		submitGroupCreation();
		returntoGroupsPage();
	}
}
