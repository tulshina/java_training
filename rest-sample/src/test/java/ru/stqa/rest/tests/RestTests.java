package ru.stqa.rest.tests;

import org.testng.annotations.Test;
import ru.stqa.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by User on 16.04.2017.
 */
public class RestTests extends TestBase{

    @Test
    public void testCreateIssue() throws IOException {
        skipIfNotFixed(7);
        Set<Issue> oldIssues = app.rest().getIssue();
        Issue newIssue = new Issue().withSubject("Test Issue").withDescription("New test issue");
        int issueId = app.rest().createIssue(newIssue);
        Set<Issue> newIssues = app.rest().getIssue();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }




}
