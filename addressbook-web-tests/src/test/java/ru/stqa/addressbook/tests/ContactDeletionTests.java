package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Set;

/**
 * Created by User on 05.03.2017.
 */
public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastname("TestSurname").withFirstname("TestName")
                    .withAddress("Saint Petersburg").withMobile("89113333333")
                    .withEmail("test@gmail.com").withGroup("test1"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().getContactCount(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
//        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));
//        Assert.assertEquals(before, after);
    }

}

