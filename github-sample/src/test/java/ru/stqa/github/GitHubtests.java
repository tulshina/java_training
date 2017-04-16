package ru.stqa.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by User on 16.04.2017.
 */
public class GitHubtests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("fda92717aa45c271110a112e1de7573426f57c7d");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("tulshina", "java_training")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
