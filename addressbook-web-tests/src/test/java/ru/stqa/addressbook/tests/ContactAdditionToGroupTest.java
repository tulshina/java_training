package ru.stqa.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 15.04.2017.
 */
public class ContactAdditionToGroupTest extends TestBase {
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
    public void testContactAdditionToGroup() throws InterruptedException {
        app.goTo().homePage();
        Contacts allContacts = app.db().contacts();
        ContactData contact = allContacts.iterator().next();
        app.goTo().groupPage();
        Groups allGroups = app.db().groups();
        GroupData group = findSuitableGroup(contact, allGroups);
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
        Contacts contactsAfter = app.db().contacts();
        ContactData contactAfter = contactsAfter.stream().filter(c -> c.getId() == contact.getId()).findFirst().get();
        assertThat(contactAfter.getGroups(), hasItem(group));
    }

    private GroupData findSuitableGroup(ContactData contactData, Groups groups) {
        for (GroupData gr: groups) {
            if (!contactData.getGroups().contains(gr)) {
                return gr;
            }
        }
        GroupData group = new GroupData().withName("test 5");
        app.goTo().groupPage();
        app.group().create(group);
        int maxId = app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt();
        return group.withId(maxId);
    }

}
