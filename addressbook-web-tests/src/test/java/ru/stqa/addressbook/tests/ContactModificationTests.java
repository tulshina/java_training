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
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastname("TestSurname").withFirstname("TestName")
                    .withAddress("Saint Petersburg").withMobilePhone("89113333333")
                    .withEmail("test@gmail.com").withGroup("test1"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        final ContactData contact = new ContactData().withId(modifiedContact.getId()).withLastname("TestSurnameModified2")
                .withFirstname("TestNameModified").withAddress("Saint Petersburg")
                .withMobilePhone("89113333333").withEmail("test@gmail.com");
        app.contact().modify(contact);
        app.goTo().homePage();
        assertThat(app.contact().getContactCount(), equalTo(before.size()));
        Contacts after = app.contact().all();
        before.remove(modifiedContact);
        before.add(contact);
//        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
//        Assert.assertEquals(before, after);
    }
}
