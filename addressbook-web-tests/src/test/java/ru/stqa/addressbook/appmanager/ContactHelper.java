package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.02.2017.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void gotoAddContactPage() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void clickEditContact(int index) {
        wd.findElements(By.xpath("//a/img[@title='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contactData) {
        gotoAddContactPage();
        fillContactForm(contactData, true);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return (isElementPresent(By.name("selected[]")));
    }


    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(columns.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = columns.get(1).getText();
            String firstName = columns.get(2).getText();
            String address = columns.get(3).getText();
            String mobile = columns.get(5).getText();
            String email = columns.get(4).getText();
            ContactData contact = new ContactData(id, lastName, firstName, address, mobile, email, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
