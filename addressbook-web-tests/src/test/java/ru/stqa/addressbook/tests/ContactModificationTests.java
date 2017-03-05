package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by User on 05.03.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().returnToHomePage();
        app.getContactHelper().selectContact();
    }
}
