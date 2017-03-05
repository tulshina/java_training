package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 26.02.2017.
 */
public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String password, String username) {
        type(By.name("pass"),password);
        type(By.name("user"), username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
