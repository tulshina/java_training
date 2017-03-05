package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by User on 05.03.2017.
 */
public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().returnToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlert();
        app.getNavigationHelper().returnToHomePage();
    }
}

