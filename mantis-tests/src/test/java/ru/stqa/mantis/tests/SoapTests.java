package ru.stqa.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mantis.model.Issue;
import ru.stqa.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by User on 16.04.2017.
 */
public class SoapTests extends TestBase {

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }


    @Test
    public void testCreaetIssue() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test issue")
                .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());

    }
}
