package com.example.tests;

import org.testng.annotations.Test;

public class NoneEmptyGroupCreationTest extends TestBase{
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
}
