package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().gotoAddContactPage();
        final ContactData contactData = new ContactData(
                "TestName",
                "TestSurname",
                "Saint Petersburg",
                "89113333333",
                "test@gmail.com",
                "test1");
        app.getContactHelper().fillContactForm(contactData, true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();

    }

}
