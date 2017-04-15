package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 02.04.2017.
 */
public class ContactDetailTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastname("TestSurname").withFirstname("TestName")
                    .withAddress("Saint Petersburg").withMobilePhone("89113333333")
                    .withEmail("test@gmail.com"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactDetails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        String contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        app.goTo().homePage();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contactInfoFromDetailsForm), equalTo(cleaned(mergeAllData(contactInfoFromEditForm))));
    }


    private String mergeAllData(ContactData contact) {
        return Stream.of(contact.getFirstname(),
                contact.getLastname(),
                contact.getAddress(),
                addedPrefix(contact.getHomePhone(), "H"),
                addedPrefix(contact.getMobilePhone(), "M"),
                addedPrefix(contact.getWorkPhone(), "W"),
                contact.getEmail(),
                contact.getEmail2(),
                contact.getEmail3())
                .filter((s) -> !s.equals(""))
                .collect(Collectors.joining());
    }

    private static String addedPrefix(String phone, String prefix) {
        if (!phone.equals("")) {
            phone = prefix + ": " + phone;
        }
        return phone;
    }

    public static String cleaned(String allData) {
        return allData.replaceAll("\\s", "");//.replaceAll("[-()]","");
    }

}
