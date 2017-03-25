package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

/**
 * Created by User on 05.03.2017.
 */
public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().returnToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "TestName",
                    "TestSurname",
                    "Saint Petersburg",
                    "89113333333",
                    "test@gmail.com",
                    "test1"));
            app.getNavigationHelper().returnToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlert();
        app.getNavigationHelper().returnToHomePage();
    }
}

