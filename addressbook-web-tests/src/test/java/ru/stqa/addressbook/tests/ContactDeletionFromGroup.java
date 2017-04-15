package ru.stqa.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Created by User on 15.04.2017.
 */
public class ContactDeletionFromGroup extends TestBase {

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
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactDeletionFromGroup() throws InterruptedException {
        app.goTo().homePage();
        Contacts allContacts = app.db().contacts();
        ContactData contact = findSuitableContact(allContacts);
        GroupData group = contact.getGroups().iterator().next();
        app.contact().removeFromGroup(contact, group);
        Contacts contactsAfter = app.db().contacts();
        ContactData contactAfter = contactsAfter.stream().filter(c -> c.getId() == contact.getId()).findFirst().get();
        assertThat(contactAfter.getGroups(), not(hasItem(group)));

    }

    private ContactData findSuitableContact(Contacts contacts) throws InterruptedException {
        for (ContactData ct: contacts) {
            if (!ct.getGroups().isEmpty()) {
                return ct;
            }
        }
        ContactData firstContact = contacts.iterator().next();
        GroupData firstGroup = app.db().groups().iterator().next();
        app.contact().addToGroup(firstContact, firstGroup);
        app.goTo().homePage();
        return app.db().contacts().stream().filter(c -> c.getId() == firstContact.getId()).findFirst().get();
    }

}
