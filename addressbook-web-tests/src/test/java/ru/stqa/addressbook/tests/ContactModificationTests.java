package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 05.03.2017.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withLastname("TestSurname").withFirstname("TestName")
                    .withAddress("Saint Petersburg").withMobilePhone("89113333333")
                    .withEmail("test@gmail.com"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        final ContactData contact = new ContactData().withId(modifiedContact.getId()).withLastname("TestSurnameModified2")
                .withFirstname("TestNameModified").withAddress("Saint Petersburg")
                .withMobilePhone("89113333333").withEmail("test@gmail.com");
        app.contact().modify(contact);
        app.goTo().homePage();
        assertThat(app.contact().getContactCount(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        before.remove(modifiedContact);
        before.add(contact);
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
