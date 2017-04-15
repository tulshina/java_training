package ru.stqa.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by User on 16.04.2017.
 */
public class RegistrationTests extends TestBase {

    @Test
    public void testRegistration() {
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
