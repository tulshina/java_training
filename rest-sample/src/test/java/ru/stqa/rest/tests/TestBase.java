package ru.stqa.rest.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.rest.appmanager.ApplicationManager;
import ru.stqa.rest.model.Issue;

import java.io.IOException;

/**
 * Created by User on 26.02.2017.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws Exception {
    }

    protected boolean isIssueOpen(int issueId) throws IOException {
        Issue issue = app.rest().getIssueById(issueId);
        return !issue.getStateName().equals("Closed") && !issue.getStateName().equals("Resolved");
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    @AfterSuite
    public void tearDown() throws IOException {
    }

}
