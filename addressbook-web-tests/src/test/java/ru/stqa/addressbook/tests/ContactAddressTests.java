package ru.stqa.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by User on 02.04.2017.
 */
public class ContactAddressTests extends TestBase {

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
    public void testContactAddresses() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","");
    }
}
