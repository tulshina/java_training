package ru.stqa.mantis.appmanager;

import org.openqa.selenium.By;

import static java.lang.String.format;

/**
 * Created by User on 16.04.2017.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void loginAsAdmin() {
        String adminUsername = "administrator";
        String adminPassword = "root";

        login(adminUsername, adminPassword);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void goToManageUsers() {
        click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']"));
    }
}
