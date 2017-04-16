package ru.stqa.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.mantis.model.MailMessage;
import ru.stqa.mantis.model.UserData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by User on 16.04.2017.
 */
public class ChangingPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangingPassword() throws IOException {
        app.navigation().loginAsAdmin();
        String newUserPassword = "123";
        app.navigation().goToManageUsers();
        UserData user = app.db().users().stream().filter((u) -> !u.getName().equals("administrator")).findFirst().get();
        app.manageUsers().goToUserById(user.getId());
        app.manageUsers().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.manageUsers().changeUserPassword(confirmationLink, newUserPassword);
        assertTrue(app.newSession().login(user.getName(), newUserPassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
