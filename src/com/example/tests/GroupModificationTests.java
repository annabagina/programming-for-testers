package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	@Test
	public void modifySomeGroups() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(3);
		GroupData group = new GroupData();
		group.groupname = "new_name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returntoGroupsPage();
	}

}