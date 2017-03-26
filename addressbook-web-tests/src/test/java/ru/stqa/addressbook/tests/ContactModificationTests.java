package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().returnToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "TestSurname",
                    "TestName",
                    "Saint Petersburg",
                    "89113333333",
                    "test@gmail.com",
                    "test1"));
            app.getNavigationHelper().returnToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        final ContactData contactData = new ContactData(
                before.get(before.size() - 1).getId(),
                "TestSurnameModified2",
                "TestNameModified",
                "Saint Petersburg",
                "89113333333",
                "test@gmail.com",
                null);
        app.getContactHelper().clickEditContact(before.size() - 1);
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contactData);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Assert.assertEquals(before, after);
    }
}
