package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroups() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().delete(1);
		app.getGroupHelper().returntoGroupsPage();
	}
}
