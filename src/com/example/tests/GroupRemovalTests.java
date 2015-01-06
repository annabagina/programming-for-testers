package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroups() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		//actions
		app.getGroupHelper().delete(0);
		app.getGroupHelper().returntoGroupsPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		//compare states
				
		oldList.remove(0);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
