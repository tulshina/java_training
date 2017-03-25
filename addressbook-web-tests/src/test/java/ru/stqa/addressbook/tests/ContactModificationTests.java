package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

/**
 * Created by User on 05.03.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        final ContactData contactData = new ContactData(
                "TestNameModified",
                "TestSurnameModified",
                "Saint Petersburg",
                "89113333333",
                "test@gmail.com",
                null);

        app.getNavigationHelper().returnToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(contactData);
            app.getNavigationHelper().returnToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();

    }
}
