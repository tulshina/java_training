package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContact(new ContactData(
                "TestName",
                "TestSurname",
                "Saint Petersburg",
                "89113333333",
                "test@gmail.com",
                "test1"));
        app.getNavigationHelper().returnToHomePage();

    }

}
