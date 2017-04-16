package ru.stqa.mantis.appmanager;

import org.openqa.selenium.By;

import static java.lang.String.format;

/**
 * Created by User on 16.04.2017.
 */
public class ManageUsersHelper extends HelperBase {

    public ManageUsersHelper(ApplicationManager app) {
        super(app);
    }

    public void goToUserById(int id) {
        click(By.cssSelector(format("a[href='manage_user_edit_page.php?user_id=%s']", id)));
    }

    public void resetPassword() {
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void changeUserPassword(String confirmationLink, String newPassword) {
        wd.get(confirmationLink);
        type(By.name("password"), newPassword);
        type(By.name("password_confirm"), newPassword);
        click(By.cssSelector("input[value='Update User']"));
    }
}
