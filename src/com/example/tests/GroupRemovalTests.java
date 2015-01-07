package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroups() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);//не работает если список пуст!
		//actions
		app.getGroupHelper().delete(index);
		app.getGroupHelper().returntoGroupsPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		//compare states
				
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
